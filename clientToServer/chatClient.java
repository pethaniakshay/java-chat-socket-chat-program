package com.codepuran.chatApp.clientToServer;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class chatClient {

  public static void main(String args[]) throws Exception
  {
    Socket sock = new Socket("127.0.0.1", 5000);
    String message1 = "Accept Best Wishes, Serverji";
    OutputStream ostream = sock.getOutputStream();
    DataOutputStream dos = new DataOutputStream(ostream);
    dos.writeBytes(message1);
    dos.close();
    ostream.close();
    sock.close();
  }
}
