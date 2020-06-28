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
            serverSocket = new ServerSocket(PORT_NUMBER); // Создаем обект ServerSocket

            // Создаем новый сокет для приема и отправки данных
            socket = serverSocket.accept(); // Слушаем порт на наличие новых входящих подключений
            System.out.println("Starting new connection"); // Оповещаем о новом подключении после того как ктото подключится

            // Получаем выходной поток и сохраняем его в обьект c типом PrintWriter
            PrintWriter toCilent = new PrintWriter(socket.getOutputStream(), true);
            count++; // Счетчик посетителей сервера

            // Пишем в поток увеличенный счетчик , оповещая о новом посетителе
            toCilent.println(""+count);

        }catch(IOException e){
            System.out.println("Exception caught when trying to listen on port " + PORT_NUMBER + " or when listening for a connection");
        }finally {
            try{
                // Освобождаем ресурсы после закрытия сервера
                if(serverSocket != null && serverSocket.isClosed()){
                    serverSocket.close();
                }
                if(socket != null){
                    socket.close();
                }
            }catch (Exception e){

            }
        }
    }
    // Запуск сервера
    public static void main(String[] args) {
        new HitCounterServer();
    }
}
