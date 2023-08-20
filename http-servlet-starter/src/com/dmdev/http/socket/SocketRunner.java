package com.dmdev.http.socket;

import java.io.*;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.Socket;

public class SocketRunner {

    public static void main(String[] args) throws IOException {
//        default ports
//        http - 80
//        https - 443
//        tcp

        InetAddress inetAddress = Inet4Address.getByName("google.com");
        try (Socket socket = new Socket(inetAddress , 80);
             var outputStream = new DataOutputStream(socket.getOutputStream());
             var inputStream = new DataInputStream(socket.getInputStream())) {

            //send request to server
            outputStream.writeUTF("Hello world!");

            //response from server
            byte[] response = inputStream.readAllBytes();
            System.out.println(response.length);
        }
    }
}
