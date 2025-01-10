package org.example;

import java.io.*;
import java.net.*;
import java.util.*;

public class Servidor {
    private static final int PORT = 12345;
//    private static Set<PrintWriter> clientWriters = new HashSet<>();

    public static void main(String[] args) {
        System.out.println("El servidor está corriendo...");
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                Socket cliente = serverSocket.accept();
                System.out.println("Cliente conectado.");
                new Thread(new ClientHandler(cliente)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket socket;
        private PrintWriter out;
        private BufferedReader in;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);

//                synchronized (clientWriters) {
//                    clientWriters.add(out);
//                }

                String message;
                out.println("Ya puedes hablar con este usuario, intenta enviarle mensaje");
                while ((message = in.readLine()) != null) {
                    System.out.println(message);
                    out.println(message);
//                    synchronized (clientWriters) {
//                        for (PrintWriter writer : clientWriters) {
//                            writer.println(message);
//                        }
//                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
//                synchronized (clientWriters) {
//                    clientWriters.remove(out);
//                }
            }
        }
    }
}

