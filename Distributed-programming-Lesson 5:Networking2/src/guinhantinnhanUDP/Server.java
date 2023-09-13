package guinhantinnhanUDP;

import org.w3c.dom.ls.LSOutput;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Server {
    public static void main(String[] args) throws IOException {
        //tao cong port
        int serverPort = 12345;

        //tao doi tuong lien ket voi cong port
        DatagramSocket serverSocket = new DatagramSocket(serverPort);
        System.out.println("Server is running and waiting for client ...");

        //tao mang de nhan du lieu
        byte[] reiceiveData = new byte[1024];
        //tao doi tuong datagramPacket de nhan goi tin tu client
        DatagramPacket receivePacket = new DatagramPacket(reiceiveData, reiceiveData.length);

        //nhan goi tin tu client
        serverSocket.receive(receivePacket);

        //lay dia chi ip  cua cong client
        InetAddress clientAddress = receivePacket.getAddress();
        int clientPort = receivePacket.getPort();

        //chuyen doi du lieu thanh dang chuoi
        String message = new String(receivePacket.getData(), 0, receivePacket.getLength());
        System.out.println("Received from client: " + message);

        //chuan bi du lieu de gui di
        String responseMessage = "Hello, client!";
        byte[] sendData = responseMessage.getBytes();

        //tao datapacket de gui goi tin den client
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
        //gui goi tin den client
        serverSocket.send(sendPacket);

        serverSocket.close();
    }
}
