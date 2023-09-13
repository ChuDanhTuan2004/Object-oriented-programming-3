package baitap1;

import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        int portNumber = 8881;

        try {
            // Mở cổng kết nối
            ServerSocket serverSocket = new ServerSocket(portNumber);
            System.out.println("Server đang lắng nghe kết nối...");

            while (true) {
                // Chấp nhận kết nối từ client
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client đã kết nối!");

                // Nhận dữ liệu từ client
                InputStream inFromClient = clientSocket.getInputStream();
                DataInputStream in = new DataInputStream(inFromClient);
                int a = in.readInt();
                int b = in.readInt();

                // Thực hiện tính toán
                int sum = a + b;

                // Gửi kết quả về cho client
                OutputStream outToClient = clientSocket.getOutputStream();
                DataOutputStream out = new DataOutputStream(outToClient);
                out.writeInt(sum);

                // Đóng kết nối với client
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
