package com.ettounani.Blocking_IO;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer extends  Thread{
    public static void main(String[] args) {
        new ChatServer().start();
        /*
        try {

            ServerSocket serverSocket=new ServerSocket(2001);
            System.out.println("server is running");
            Socket socket=serverSocket.accept();
           InputStream ip= socket.getInputStream();
            OutputStream op=socket.getOutputStream();
            System.out.println("waiting for data");
            int data =ip.read();
            data=data*4;
            op.write(data);
            System.out.println("by by");
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

         */
    }
    private int nbUser=0;

    @Override
    public void run() {
        try {
            System.out.println("The server is running, Enjoy Coding :)");
            ServerSocket serverSocket=new ServerSocket(2001);

            while (true){
                Socket socket=serverSocket.accept();
                ++nbUser;
                new Chat(socket,nbUser).start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    class Chat extends Thread{
        private Socket socket;
        private int userId;
        public Chat(Socket socket,int userId) {
            this.socket=socket;
            this.userId=userId;
        }

        @Override
        public void run() {
            try {
                InputStream ip=socket.getInputStream();
                InputStreamReader ips=new InputStreamReader(ip);
                BufferedReader br=new BufferedReader(ips);

                OutputStream op=socket.getOutputStream();
                PrintWriter pr=new PrintWriter(op,true);

                System.out.println("new connection=> "+userId+" ip : "+socket.getLocalSocketAddress().toString());
                System.out.println("Marhba biik "+userId);
                while (true){
                    String req=br.readLine();
                    pr.println(req+" ->size :"+req.length());
                    System.out.println(req);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
