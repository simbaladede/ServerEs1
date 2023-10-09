package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {
            System.out.println("Server Avviato");
            ServerSocket server = new ServerSocket(3000);

            Socket s = server.accept();
            System.out.println("Un cliente si è connesso");

            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            DataOutputStream out =  new DataOutputStream(s.getOutputStream());

            String stringaRicevuta = in.readLine();
            System.out.println("Il client ha inviato " + stringaRicevuta);

            String stringaModificata = stringaRicevuta.toUpperCase();
            out.writeBytes(stringaModificata + "\n");

            server.close();
            s.close();

        } catch (Exception e) {
            System.out.println("Qualcosa è andato storto");
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }
}