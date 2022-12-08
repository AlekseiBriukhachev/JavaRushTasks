package com.javarush.task.jdk13.task40.task4002;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpClient {

    private final DatagramSocket socket;
    private final InetAddress serverAddress;
    private final int serverPort;

    public UdpClient(int port) throws IOException {
        socket = new DatagramSocket(port);
        serverAddress = InetAddress.getByName("localhost");
        serverPort = 4445;
    }

    public String sendReceive(String message) throws IOException {
        //напишите тут ваш код
        byte[] data = message.getBytes();
        DatagramPacket packSend = new DatagramPacket(data, data.length, serverAddress, serverPort);
        DatagramSocket datagramSocket = new DatagramSocket();
        datagramSocket.send(packSend);
        DatagramPacket packReceive = new DatagramPacket(new byte[1024], 1024);
        datagramSocket.receive(packReceive);
        datagramSocket.close();

        return new String(packReceive.getData());
    }

    public void close() {
        socket.close();
    }
}
