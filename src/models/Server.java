package models;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    ServerSocket ss;
    Socket s;
    DataInputStream dis;
    DataOutputStream dos;

    public Server(){

        try
        {
            System.out.println("Connection Established");
            ss=new ServerSocket(10);
            s=ss.accept();
            System.out.println(s);
            System.out.println("Client has been connected");
            dis= new DataInputStream(s.getInputStream());
            dos= new DataOutputStream(s.getOutputStream());

        }
        catch(Exception e)
        {
            System.out.println(e);
        }

    }

    public static void main (String[] as)
    {
        new Server();
    }


}
