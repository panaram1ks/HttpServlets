package com.dmdev.http.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServerRunner {

    public static void main(String[] args) throws IOException {

        try (ServerSocket serverSocket = new ServerSocket(7777);
             Socket socket = serverSocket.accept();
             DataInputStream request = new DataInputStream(socket.getInputStream());
             DataOutputStream response = new DataOutputStream(socket.getOutputStream())) {

            System.out.println("Client request: " + request.readUTF());
            response.writeUTF("Hello from server!");
        }
    }
}
