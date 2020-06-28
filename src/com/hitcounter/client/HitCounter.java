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
            socket = new Socket("127.0.0.1", PORT_NUMBER); // Создаем сокет с адресом сервера и порта для сервера
            // Подключаемся к сервера и получаем ответ в виде потока входного сохраняем данные в in
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // Почучаем данные из обьекта in и сохраняем их в переменную с типом String
            String s = in.readLine();
            System.out.println("New visitor " + s); // Вываодим полученный count увеличенный на 1 на сервере
        }catch (IOException e){
            System.out.println("");
        }finally {
            try{
                // Освобождаем ресурсы
                if(socket != null){
                    socket.close();
                }
            }catch (Exception e){

            }
        }
    }
}
