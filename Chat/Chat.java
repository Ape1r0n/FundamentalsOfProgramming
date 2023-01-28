package Chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Chat extends MiniJava {
    public static void main(String[] args) {
        Socket sock = null;
        boolean started = false;
        while (true) {
            String input = readString(
                    "Enter <port> in order to start the chat server "
                            + "or <host>:<port> in order to connect to a running server. "
                            + "Enter exit for exiting the chat.\n");
            if (input.equals("exit")) {
                System.out.println("Exiting.");
                return;
            }
            // TODO
            int posColumn = input.indexOf(':');
            try{
                if(posColumn != -1){
                    InetAddress host = InetAddress.getByName(input.substring(0,posColumn));
                    int port = Integer.parseInt(input.substring(posColumn+1,input.length()-1));
                    sock = new Socket(host,port);
                    break;
                }else{
                    int port = Integer.parseInt(input);
                    ServerSocket ss = new ServerSocket(port);
                    sock = ss.accept();
                    started = true;
                    System.out.println("Server is started, expecting connections");
                    ss.close();
                    break;
                }
            }catch (UnknownHostException e){
                System.out.println("WHO DAT??!!!");
            }catch (ConnectException e){
                System.out.println("Can't connect bro");
            }catch (NumberFormatException e){
                System.out.println("WHO'S LITTLE LIAR??!");
            }catch (IOException e){
                System.out.println("stop playing around");
            }
        }

        // TODO
        try(BufferedReader br = new BufferedReader(new InputStreamReader(sock.getInputStream())); PrintWriter writer = new PrintWriter(sock.getOutputStream(),true);){
            boolean running = true;
            if(started){
                System.out.println("Connection established! You may send something.");
                String input = readString(">");
                if(input.equals("exit")) running = false;
                else writer.println(input);

                while(running){
                    if(br.readLine().equals("exit")) {
                        System.out.println("Exit received");
                        break;
                    }else{
                        System.out.println(br.readLine());
                        input = readString(">");
                        if(input.equals("exit")) running = false;
                        writer.println(input);
                    }
                }
                System.out.println("exiting...");
            }
    } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                sock.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}