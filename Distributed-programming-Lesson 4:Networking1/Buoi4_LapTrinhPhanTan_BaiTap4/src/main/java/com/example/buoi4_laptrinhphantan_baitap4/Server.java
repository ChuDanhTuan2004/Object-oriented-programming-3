package com.example.buoi4_laptrinhphantan_baitap4;

import java.io.*;
import java.net.*;
import java.util.*;

public class Server {
    // Lưu trữ danh sách các Client đã kết nối
    private static List<ClientHandler> clients = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8890);
        System.out.println("Server đã bắt đầu chạy...");

        while (true) {
            // Chấp nhận kết nối từ Client mới
            Socket socket = serverSocket.accept();
            System.out.println("Đã kết nối một Client mới.");

            // Tạo một luồng mới để xử lý kết nối của Client
            ClientHandler clientHandler = new ClientHandler(socket);

            // Thêm Client mới vào danh sách
            clients.add(clientHandler);

            // Bắt đầu chạy luồng để xử lý kết nối của Client
            clientHandler.start();
        }
    }

    // Gửi tin nhắn đến tất cả các Client
    public static void broadcast(String message, ClientHandler excludeClient) {
        for (ClientHandler client : clients) {
            if (client != excludeClient) {
                client.sendMessage(message);
            }
        }
    }

    // Xử lý kết nối từng Client
    private static class ClientHandler extends Thread {
        private Socket socket;
        private BufferedReader reader;
        private PrintWriter writer;

        public ClientHandler(Socket socket) throws IOException {
            this.socket = socket;
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(), true);
        }

        @Override
        public void run() {
            try {
                while (true) {
                    // Đọc tin nhắn từ Client và gửi đến tất cả các Client
                    String message = reader.readLine();
                    broadcast(message, this);
                }
            } catch (IOException e) {
                System.out.println("Một Client đã ngắt kết nối.");
            }
        }

        // Gửi tin nhắn đến Client hiện tại
        public void sendMessage(String message) {
            writer.println(message);
        }
    }
}
