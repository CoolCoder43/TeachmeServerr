package Serversocketapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThreads extends Thread{

  private Socket clientSocket;

  public ServerThreads(Socket clientSocket){
    super();
    this.clientSocket = clientSocket;
  }

  public void run(){
      System.out.println("thread started..................");

    try {
        BufferedReader inFromClient = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));

       
        Boolean communicating = true;
        String response = null;

        String myresponse = "FIRST TO CLIENT"; //debugging


        while(communicating){

            response = inFromClient.readLine();
            System.out.println(myresponse + " : " + response);

        }

        clientSocket.close();
        return;



    } catch (IOException e) {
        e.printStackTrace();


    } finally {
        try{
            clientSocket.close();
        }

        catch (IOException e){
            e.printStackTrace();
        }
    }




  }
}
