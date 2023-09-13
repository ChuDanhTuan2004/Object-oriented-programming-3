package baitap3;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            System.out.println("Server đang chờ kết nối...");

            // Chấp nhận kết nối từ client
            Socket clientSocket = serverSocket.accept();
            System.out.println("Kết nối đã được thiết lập!");

            // Nhận dữ liệu từ client
            InputStream inputStream = clientSocket.getInputStream();
            byte[] buffer = new byte[1024];
            int len = inputStream.read(buffer);
            String message = new String(buffer, 0, len);
            System.out.println("Đã nhận tin nhắn từ client: " + message);

            // Gửi phản hồi đến client
            OutputStream outputStream = clientSocket.getOutputStream();
            String response = "Đã nhận được tin nhắn của bạn!";
            outputStream.write(response.getBytes());

            // Đóng kết nối
            inputStream.close();
            outputStream.close();
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
