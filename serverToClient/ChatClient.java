package com.codepuran.chatApp.serverToClient;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ChatClient {
  public static void main(String args[]) throws Exception
  {
    Socket sock = new Socket("127.0.0.1", 7000);

    InputStream istream = sock.getInputStream();
    BufferedReader br1 = new BufferedReader(new InputStreamReader(istream));

    String s1 = br1.readLine();
    System.out.println(s1);

    br1.close();    istream.close();   sock.close( );
  }
}

