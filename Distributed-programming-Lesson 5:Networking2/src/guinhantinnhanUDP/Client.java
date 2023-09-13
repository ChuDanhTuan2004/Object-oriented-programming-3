package guinhantinnhanUDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {
    public static void main(String[] args) throws IOException {
        // tao ip va port cua server
        String serverIp = "localhost";
        int serverPort = 12345;

        // tao doi tuong datagramSocket de ket noi voi may chu
        DatagramSocket clientSocket = new DatagramSocket();

        // tao mang byte chua du lieu tin nhan can gui
        String message = "Hello, server!";
        byte[] sendData = message.getBytes();

        // gui goi tin den server
        InetAddress serverAddress = InetAddress.getByName(serverIp);
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, serverPort);
        clientSocket.send(sendPacket);

        // chuan bi mang byte de nhan du lieu tu server
        byte[] receiveData = new byte[1024];
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

        // nhan du lieu tu server
        clientSocket.receive(receivePacket);

        // chuyen doi du lieu thanh dang chuoi va hien thi
        String responseMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
        System.out.println("Received from server: " + responseMessage);

        // dong ket noi
        clientSocket.close();
    }
}
