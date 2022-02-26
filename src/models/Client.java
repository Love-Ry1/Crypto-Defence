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

    /**
     *Here we save the information about a certain server target
     * @param
     * @param
     *
     */


    public Client(){
        this.adress = adress;
        this.portnumber = portnumber;

    }



    private void connectToTarget(){

    /*    try {
            socket = new Socket(adress, portnumber);
            input = new DataInputStream(System.in);
            output = new DataOutputStream(socket.getOutputStream());
            connected = true;

        } catch (IOException e) {
            connected = false;
            e.printStackTrace();
        }

*/

    }





}
