package com.dmdev.http.socket;

import java.io.IOException;
import java.net.*;

public class DatagramRunner {

    public static void main(String[] args) throws IOException {

        // UDP
        InetAddress inetAddress = Inet4Address.getByName("localhost");
        try (DatagramSocket datagramSocket = new DatagramSocket();) {
//            -----> [buffer] <-----
//           byte[] bytes = new byte[512];
            byte[] bytes = "Hello from UDP client".getBytes();
            DatagramPacket packet = new DatagramPacket(bytes, bytes.length, inetAddress, 7777);
            datagramSocket.send(packet);
        }


    }

}
