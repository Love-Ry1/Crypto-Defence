package models;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
     Socket socket ;
    DataInputStream input ;
    DataOutputStream output ;
     String adress;   //The Ip adress comes here


    /**
     *Here we save the information about a certain server target
     * @param
     * @param
     *
     */
    public Client(){

        try
        {
            socket=new Socket("localhost",10);
            System.out.println(socket);
            input= new DataInputStream(socket.getInputStream());
            output= new DataOutputStream(socket.getOutputStream());

        }
        catch(Exception e)
        {
            System.out.println(e);
        }

    }







}
