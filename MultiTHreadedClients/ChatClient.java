package com.codepuran.chatApp.MultiTHreadedClients;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ChatClient {

  final static int ServerPort = 1234;

  public static void main(String args[]) {

    try {
      InetAddress ip = InetAddress.getByName("localhost");
      Socket s = new Socket(ip, ServerPort);
      final Scanner scanner = new Scanner(System.in);

      final DataOutputStream dos = new DataOutputStream(s.getOutputStream());
      final DataInputStream dis = new DataInputStream(s.getInputStream());

      Thread sendMessage = new Thread(new Runnable() {

        public void run() {
          while(true) {
            String message = scanner.nextLine();
            try {
              dos.writeUTF(message);
            } catch (IOException e) {
              e.printStackTrace();
            }
          }
        }
      });

      Thread readMessage = new Thread(new Runnable() {

        public void run() {
          String message;
          try {
            message = dis.readUTF();
            System.out.println(message);
          } catch (IOException e) {
            e.printStackTrace();
          }
        }
      });

      sendMessage.start();
      readMessage.start();

    } catch (UnknownHostException e) {
      e.printStackTrace();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
