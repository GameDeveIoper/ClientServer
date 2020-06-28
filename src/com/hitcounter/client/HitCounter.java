package com.hitcounter.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class HitCounter {
    private static final int PORT_NUMBER = 63457;
    private Socket socket;


    public static void main(String[] args) {
        new HitCounter();
    }

    public HitCounter(){
        try{
            socket = new Socket("127.0.0.1", PORT_NUMBER);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String s = in.readLine();
            System.out.println("New visitor " + s);
        }catch (IOException e){

        }
    }

}
