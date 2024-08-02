//package group.chatting.application;
//import java.net.*;
//import java.io.*;
//import java.util.*;
//
//// Multithread concept use
//public class Server implements Runnable {
//    // ye globally bna h
//    Socket socket;
//    
//    public static Vector client = new Vector();
//    
//    public Server (Socket socket) {
//        try {
//            this.socket = socket;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//    
//    public void run() {
//        try {
//            // read krna h msg ko jo client bheje ga
//            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
//            
//            client.add(writer);
//            
//            //broadcast krne ke liye -> infinite loop chalaya
//            while(true) {
//            // trim ->  It does not remove whitespace characters from the middle of the string.
//               String data = reader.readLine().trim();
//               System.out.println("Received " + data);
//               
//               for(int i=0; i< client.size(); i++) {
//                   try {
//                       BufferedWriter bw = (BufferedWriter) client.get(i);
//                       bw.write(data);
//                       // carriage return ->
//                    // \r It is a control character used to reset the position of the cursor to the beginning of the line  
//                    // \n This is different from the newline character (\n), which moves the cursor to the beginning of the next line.
//                       bw.write("\r\n");
//                       bw.flush();
//                   } catch (Exception e) {
//                       e.printStackTrace();
//                   }
//               }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//    
//    public static void main(String args[]) throws Exception {
//        ServerSocket s = new ServerSocket(2003);
//        while(true) {
//            Socket socket = s.accept();
//            Server server = new Server(socket);
//            Thread thread = new Thread(server);
//            thread.start();
//        }
//    }
//}

//GitHub
package group.chatting.application;

import java.net.*;
import java.io.*;
import java.util.*;

public class Server implements Runnable {
    
    Socket socket;
    
    public static Vector client = new Vector();
    
    public Server (Socket socket) {
        try {
            this.socket = socket;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            
            client.add(writer);
            
            while(true) {
                String data = reader.readLine().trim();
                System.out.println("Received " + data);
                
                for (int i = 0; i < client.size(); i++) {
                    try {
                        BufferedWriter bw = (BufferedWriter) client.get(i);
                        bw.write(data);
                        bw.write("\r\n");
                        bw.flush();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws Exception {
        ServerSocket s = new ServerSocket(2003);
        while(true) {
            Socket socket = s.accept();
            Server server = new Server(socket);
            Thread thread = new Thread(server);
            thread.start();
        }
    }
}
