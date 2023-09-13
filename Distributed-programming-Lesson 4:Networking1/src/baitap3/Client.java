package baitap3;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            // Kết nối đến server
            Socket socket = new Socket("localhost", 8888);
            System.out.println("Đã kết nối đến server!");

            // Gửi tin nhắn đến server
            OutputStream outputStream = socket.getOutputStream();
            String message = "Xin chào, đây là tin nhắn từ client!";
            outputStream.write(message.getBytes());

            // Nhận phản hồi từ server
            InputStream inputStream = socket.getInputStream();
            byte[] buffer = new byte[1024];
            int len = inputStream.read(buffer);
            String response = new String(buffer, 0, len);
            System.out.println("Đã nhận phản hồi từ server: " + response);

            // Đóng kết nối
            inputStream.close();
            outputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
