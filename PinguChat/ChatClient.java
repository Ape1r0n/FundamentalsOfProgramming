package PinguChat;

import java.io.*;
import java.net.Socket;
import java.time.LocalTime;
import java.util.Scanner;

public class ChatClient {
    private Socket socket;
    private BufferedWriter bufferedWriter;
    private BufferedReader bufferedReader;
    private String username;
    private LocalTime registerTime;

    public void closeEverything(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter){
        try {
            if(bufferedReader != null) bufferedReader.close();
            if(bufferedWriter != null)bufferedWriter.close();
            if(socket != null) socket.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public ChatClient(Socket socket, String username) {
        try {
            this.socket = socket;
            this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.username = username;
            this.registerTime = LocalTime.now();
        } catch (IOException e) {
            closeEverything(socket, bufferedReader, bufferedWriter);
        }
    }

    public void sendMessage(){
        try {
            bufferedWriter.write(username + "\n");
            bufferedWriter.flush();

            Scanner scn = new Scanner(System.in);
            while (socket.isConnected()){
                String msg = scn.nextLine();
                bufferedWriter.write(msg + "\n");
                bufferedWriter.flush();
            }
        } catch (IOException e) {
            closeEverything(socket, bufferedReader, bufferedWriter);
        }
    }

    public void listenForMsg(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                String msg;

                while(socket.isConnected()){
                    try {
                        msg = bufferedReader.readLine();
                        System.out.println(msg);
                    } catch (IOException e) {
                        closeEverything(socket, bufferedReader, bufferedWriter);
                    }
                }
            }
        }).start();
    }

    public static void main(String[] args) throws IOException {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter your username: ");
        String username = scn.nextLine();
        int port = ( (args.length != 0) ? Integer.parseInt(args[0]) : 3000);
        String host = ( (args.length > 1) ? args[1] : "localhost");
        Socket socket1 = new Socket(host,port);
        ChatClient client = new ChatClient(socket1, username);
        client.listenForMsg();
        client.sendMessage();
    }
}