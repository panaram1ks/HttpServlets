package com.dmdev.http.client;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class UrlExample {

    public static void main(String[] args) throws IOException {
        URL url = new URL("file:/home/parom/IdeaProjects/HttpServlets/http-servlet-starter/src/com/dmdev/http/socket/DatagramRunner.java");
        URLConnection urlConnection = url.openConnection();
        System.out.println(new String(urlConnection.getInputStream().readAllBytes()));
    }

    private static void checkGoogle() throws IOException {
        URL url = new URL("https://www.google.com");
        // GET method
        URLConnection urlConnection = url.openConnection();
        // POST method
        urlConnection.setDoOutput(true);
        try (OutputStream outputStream = urlConnection.getOutputStream()) {
            outputStream.write(new byte[512]);
        }
        Map<String, List<String>> headerFields = urlConnection.getHeaderFields();
        Object content = urlConnection.getContent();
        System.out.println(new String(urlConnection.getInputStream().readAllBytes()));
    }
}
