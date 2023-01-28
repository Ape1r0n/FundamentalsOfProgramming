package PinguChat;

import java.io.*;
import java.net.Socket;
import java.time.LocalTime;
import java.util.ArrayList;

public class ClientHandler implements Runnable{
    public static ArrayList<ClientHandler> clientHandlers = new ArrayList<>();
    private Socket socket;
    private BufferedWriter bufferedWriter;
    private BufferedReader bufferedReader;
    private String username;
    private LocalTime registerDate;

    public ClientHandler(Socket socket){
        try {
            this.socket = socket;
            this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.username = bufferedReader.readLine();
            this.registerDate = LocalTime.now();
            clientHandlers.add(this);
            this.bufferedWriter.write("Hello! Welcome to the chatroom!\n" +
                    "Instructions:\n" +
                    " - Simply type the message to send broadcast to all active clients\n" +
                    " - Type '@username<space>yourmessage' without quotes to send message to desired client\n" +
                    " - Type 'WHOIS' without quotes to see list of active clients\n" +
                    " - Type 'LOGOUT' without quotes to logoff from server\n" +
                    " - Type 'PINGU' without quotes to request a random penguin fact\n");
            this.bufferedWriter.flush();
            broadcastMessage("> " + this.registerDate + "  *** " + username + " has joined the chat. ***");
        } catch (IOException e) {
            closeEverything(socket, bufferedReader, bufferedWriter);
        }

    }

    public String getUsername() {
        return username;
    }

    public void run(){
        String msg;
        while(socket.isConnected()){
            try {
                msg = bufferedReader.readLine();
                broadcastMessage(msg);
            } catch (IOException e) {
                closeEverything(socket, bufferedReader, bufferedWriter);
                break;
            }
        }
    }

    public void broadcastMessage(String msg) {
        if (msg.equals("LOGOUT")){
            removeClientHandler();
            try {
                if(bufferedReader.readLine().equals("null")){
                    System.exit(0);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else if (msg.equals("PINGU")){
            try {
                bufferedWriter.write("Bro they are penguins, don't kill them\n");
                bufferedWriter.flush();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            //broadcastMessage("Bro they are penguins, don't kill them");
        } else if (msg.startsWith("@")) {
            String desiredUsername = msg.split(" ")[0].substring(1);
            ClientHandler target = null;
            for (ClientHandler p : clientHandlers) {
                if (p.username.equals(desiredUsername)) target = p;
            }

            if (target != null) {
                String[] newMSG = msg.split(" ");
                StringBuilder sb = new StringBuilder();
                sb.append(": ");
                for (int i = 1; i < newMSG.length; i++) sb.append(newMSG[i]).append(" ");
                try {
                    target.bufferedWriter.write(this.username + sb);
                    target.bufferedWriter.newLine();
                    target.bufferedWriter.flush();
                } catch (IOException e) {
                    closeEverything(socket, bufferedReader, bufferedWriter);
                }
            }

        } else if (msg.equals("WHOIS")) {
            try {
                int i = 1;
                for (ClientHandler p : clientHandlers) {
                    this.bufferedWriter.write(i + ") " + p.username + " since " + p.registerDate);
                    this.bufferedWriter.newLine();
                    this.bufferedWriter.flush();
                    ++i;
                }
            } catch (IOException e) {
                closeEverything(socket, bufferedReader, bufferedWriter);
            }
        }else {
            for(ClientHandler p : clientHandlers){
                try {
                    if (!p.username.equals(this.username)) {
                        p.bufferedWriter.write(this.username + ": " + msg);
                        p.bufferedWriter.newLine();
                        p.bufferedWriter.flush();
                    }
                } catch (IOException e) {
                    closeEverything(socket, bufferedReader, bufferedWriter);
                }
            };
        }
    }

    public void removeClientHandler(){
        clientHandlers.remove(this);
        broadcastMessage("> " + LocalTime.now() + " *** " + this.username + " left the chat. ***");
    }

    public void closeEverything(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter){
        removeClientHandler();
        try {
            if(bufferedReader != null) bufferedReader.close();
            if(bufferedWriter != null)bufferedWriter.close();
            if(socket != null) socket.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}