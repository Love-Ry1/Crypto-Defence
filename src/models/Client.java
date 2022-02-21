package models;

import java.io.DataInputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    private Socket socket = null;
    private DataInputStream input = null;
    private OutputStream output = null;
    private String adress;   //The Ip adress
    private int portnumber;  //The portnumber to use

    private boolean connected = false;




    public Client(){


    }



    private void connectToTarget(){


    }
}
