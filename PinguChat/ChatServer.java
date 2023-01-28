package PinguChat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalTime;

public class ChatServer {
    private ServerSocket serverSocket;
    public ChatServer(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    public void startServer(){
        try {
            while (!serverSocket.isClosed()){
                Socket socket = serverSocket.accept();
                ClientHandler clientHandler = new ClientHandler(socket);
                System.out.println(LocalTime.now() + "*** " + clientHandler.getUsername() + " has joined the chat room. ***");
                Thread thread = new Thread(clientHandler);
                thread.start();

            }
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    public void closeServerSocket(){
        try {
            if(serverSocket != null) serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws IOException {
        int port = ( (args.length != 0) ? Integer.parseInt(args[0]) : 3000);
        ServerSocket serverSocket1 = new ServerSocket(port);
        ChatServer server = new ChatServer(serverSocket1);
        server.startServer();
    }

}
