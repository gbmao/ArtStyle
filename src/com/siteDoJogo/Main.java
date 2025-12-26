package com.siteDoJogo;

import com.siteDoJogo.controller.StartingPageController;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class Main {
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(
                new InetSocketAddress(8080), 0
        );

        server.createContext("/hello", new StartingPageController() {
        });

        server.start();
        System.out.println("Servidor rodando porta 8080");
    }
}
