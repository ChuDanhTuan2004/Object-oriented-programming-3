package baitap1;

import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        String hostName = "localhost";
        int portNumber = 8881;

        try {
            // Kết nối đến server
            Socket clientSocket = new Socket(hostName, portNumber);

            // Nhận dữ liệu từ user
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Nhập số a:");
            int a = Integer.parseInt(userInput.readLine());
            System.out.println("Nhập số b:");
            int b = Integer.parseInt(userInput.readLine());

            // Gửi dữ liệu lên server
            OutputStream outToServer = clientSocket.getOutputStream();
            DataOutputStream out = new DataOutputStream(outToServer);
            out.writeInt(a);
            out.writeInt(b);

            // Nhận kết quả từ server và hiển thị
            InputStream inFromServer = clientSocket.getInputStream();
            DataInputStream in = new DataInputStream(inFromServer);
            int sum = in.readInt();
            System.out.println("Tổng của " + a + " và " + b + " là: " + sum);

            // Đóng kết nối
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
