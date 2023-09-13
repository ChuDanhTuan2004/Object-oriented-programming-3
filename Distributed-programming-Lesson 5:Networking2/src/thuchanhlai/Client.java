package thuchanhlai;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {
    public static void main(String[] args) throws IOException {
        String serverIP = "localhost";
        int serverPort = 8888;

        DatagramSocket clientSocket = new DatagramSocket();
        String message = " Hello Server !";
        byte[] sendData = message.getBytes();

        InetAddress serverAddress = InetAddress.getByName(serverIP);
        DatagramPacket sendPacket = new DatagramPacket(sendData,sendData.length,serverAddress,serverPort);
        clientSocket.send(sendPacket);

        //nhan du lieu
        byte[] receiveData = new byte[1024];
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        clientSocket.receive(receivePacket);

        //hienthi
        String responseMessage = new String(receivePacket.getData(),0,receivePacket.getLength());
        System.out.println("Response from server: "+responseMessage);

        clientSocket.close();
    }
}
