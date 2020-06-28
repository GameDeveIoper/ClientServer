package com.hitcounter.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class HitCounterServer {
    private static final int PORT_NUMBER = 63457;
    private ServerSocket serverSocket;
    private Socket socket;
    private int count = 0;



    public HitCounterServer(){
        System.out.println("Server is running...");
        try{
            serverSocket = new ServerSocket(PORT_NUMBER);
            socket = serverSocket.accept();
            System.out.println("New connections");
            PrintWriter toCilent = new PrintWriter(socket.getOutputStream(), true);
            count++;
            toCilent.println(""+count);

        }catch(IOException e){

        }
    }

    public static void main(String[] args) {
        new HitCounterServer();
    }
}
