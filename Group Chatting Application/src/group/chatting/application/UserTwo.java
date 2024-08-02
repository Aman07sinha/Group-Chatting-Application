//// client folder
//package group.chatting.application;
//
//import javax.swing.*;
//import javax.swing.border.*;
//import java.awt.*;
//import java.awt.event.*;
//// calendar package ke liye
//import java.util.*;
//// text msg ke liye
//import java.text.*;
//// socket ke liye 
//import java.net.*;
//// for DataInputStream ke liye
//import java.io.*;
// 
//    // JFrame extend ko es liye hataye h 
//    // simple extend nhi kr skta esko statically extend krna pde ga
//    // public class Server extends JFrame implements ActionListener
//    // runnable interafce implement
//    // multiple class not implement but multiple interfaces implement
//    public class UserTwo implements ActionListener, Runnable {
//        
//        //JTextFeild text -> globally declare, constructor ke aandar bhi use kr paye
//        JTextField text;
//        
//        //globally declare kr diya
//        JPanel a1;
//        
//        // msg ko ek ke niche nixhe place krna h
//        static Box vertical = Box.createVerticalBox();
//        static JFrame f = new JFrame();
//        static DataOutputStream dout;
//        
//        // globally object banane h, eska bahar bhi kaam h phir
//        BufferedReader reader;
//        BufferedWriter writer;
//        String name = "Chinnar";
//        
//        // Constructor
//        UserTwo() {
//           f.setLayout(null);
//           
//           JPanel p1 = new JPanel();
//           p1.setBackground(new Color(7,94,84));
//           p1.setBounds(0, 0, 450, 70);
//           p1.setLayout(null);
//           f.add(p1);
//           
//           // file is much from inside the directory - 
//           ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/3.png"));
//           Image i2 = i1.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
//           ImageIcon i3 = new ImageIcon(i2);          
//           JLabel back = new JLabel(i3);
//           back.setBounds(5, 20, 25, 25);
//           p1.add(back);
//           
//           //back button ke click pe action chaiyea
//           //mujhe fame se back hone ke liye
//           back.addMouseListener(new MouseAdapter() {
//               public void mouseClicked(MouseEvent ae) {
//                   System.exit(0);
//               }
//           });
//           
//           ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/mirzapur.png"));
//           Image i5 = i4.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
//           ImageIcon i6 = new ImageIcon(i5);          
//           JLabel profile = new JLabel(i6);
//           profile.setBounds(40,10,50,50);
//           p1.add(profile);
//           
//           ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("icons/video.png"));
//           Image i8 = i7.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
//           ImageIcon i9 = new ImageIcon(i8);          
//           JLabel video = new JLabel(i9);
//           video.setBounds(300, 20, 30, 30);
//           p1.add(video);
//           
//           ImageIcon i10 = new ImageIcon(ClassLoader.getSystemResource("icons/phone.png"));
//           Image i11 = i10.getImage().getScaledInstance(35, 30, Image.SCALE_DEFAULT);
//           ImageIcon i12 = new ImageIcon(i11);          
//           JLabel phone = new JLabel(i12);
//           phone.setBounds(360, 20, 30, 30);
//           p1.add(phone);
//           
//           ImageIcon i13 = new ImageIcon(ClassLoader.getSystemResource("icons/3icon.png"));
//           Image i14 = i13.getImage().getScaledInstance(10, 25, Image.SCALE_DEFAULT);
//           ImageIcon i15 = new ImageIcon(i14);          
//           JLabel morevert = new JLabel(i15);
//           morevert.setBounds(420, 20, 10, 25);
//           p1.add(morevert);
//           
//           JLabel name = new JLabel("Kuch to chl rha h");
//           name.setBounds(110, 15, 150, 18);
//           name.setForeground(Color.WHITE);
//           name.setFont(new Font("SAN_SERIF", Font.BOLD, 18));
//           p1.add(name);
//           
//           JLabel status = new JLabel("Chinnar, Pandu, Chapri, Bewda");
//           status.setBounds(110, 35, 160, 18);
//           status.setForeground(Color.WHITE);
//           status.setFont(new Font("SAN_SERIF", Font.BOLD, 14));
//           p1.add(status);
//           
//           // ye ek alag panel h it means Chatting box
//           a1 = new JPanel();
//           a1.setBounds(5, 75, 440, 530);
//           a1.setBackground(Color.WHITE);
//           f.add(a1);
//                  
//           text = new JTextField();
//           text.setBounds(5, 615, 310, 40);
//           text.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
//           f.add(text);
//           
//           JButton send = new JButton("Send");
//           send.setBounds(320, 615, 123, 40);
//           send.setBackground(new Color(7, 94, 84));
//           send.setForeground(Color.WHITE);
//           
//           //send button pe click pe action chaiyea
//           send.addActionListener(this);
//           text.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
//           f.add(send);
//           
//           // frame ka header htane ke liye - undecorated used
//           f.setUndecorated(true);                                 
//           f.setSize(450, 660);
//           f.setLocation(490,50);
//           f.getContentPane().setBackground(Color.WHITE);
//           
//           f.setVisible(true);
//           
//           try {
//               Socket socket = new Socket("localhost", 2003);
//               // reader writer class object bna diya
//               writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
//               reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//           } catch (Exception e) {
//               e.printStackTrace();
//           }
//        }
//        
//        public void actionPerformed(ActionEvent ae) {
//            
//            try { 
//                //text feild ke aandar se value nikalna h
//                 String out = "<html><p>" + name + "</p><p>" + text.getText() + "<p></html>";
//
//                // eske jarurat nhi h->  JLabel output = new JLabel(out);
//
//                 // yaha pe sidhe formatLabel le skta huit means cl kr skta hu
//                 // eske jagah
//                 // JPanel p2 = new JPanel();
//                 JPanel p2 = formatLabel(out);
//
//                 // border layout works on elements place krta h
//                 // top bottom left right center
//                 a1.setLayout(new BorderLayout());
//
//                 JPanel right = new JPanel(new BorderLayout());
//
//                 // p2 ke jagah hm String nhi le skte eseliye p2 liye h
//                 // so p2 ko ab declare krna h
//                 right.add(p2, BorderLayout.LINE_END);
//                 right.setBackground(Color.WHITE);
//
//                 //vertical msg h tb ek ke niche ek
//                 vertical.add(right);
//
//                // Strut -> components are separated by a fixed amount of space, without relying on margins, padding
//                // space 15
//                 vertical.add(Box.createVerticalStrut(15));
//
//                // page strt me msg strt hoga
//                a1.add(vertical, BorderLayout.PAGE_START);
//                
//                // read UTF or write UTF ka use nhi kr rha hu -> dout.writeUTF(out);
//                // yaha pe buffer reader ka use kr rha hu
//                // yaha pe msg ko bheja h it means write kiya h
//                try {
//                    writer.write(out);
//                    writer.write("\r\n");
//                    writer.flush();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//                
//
//                // text feild empty ho jae ga type krna ke baad
//                text.setText("");
//
//                // repaint means frame ko cl kre ga
//                f.repaint();
//                f.invalidate();
//                f.validate();   
//            } catch (Exception e) {
//                e.printStackTrace();
//            }   
//        }
//        
//        // JPanel ko return kra rha hu
//        public static JPanel formatLabel(String out) {
//            JPanel panel = new JPanel();
//            panel.setBackground(Color.WHITE);
//            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
//
//            JLabel output = new JLabel("<html><p style=\"width: 150px\">" + out + "</p></html>");
//            output.setFont(new Font("Tahoma", Font.PLAIN, 16));
//            output.setBackground(new Color(37, 211, 102));
//            output.setOpaque(true);
//            output.setBorder(new EmptyBorder(0, 15, 0, 50));
//
//            panel.add(output);
//            
//            Calendar cal = Calendar.getInstance();
//            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
//            
//            // frame ke aandar kuch likhna h tb JLabel ke aandar
//            JLabel time = new JLabel();
//            time.setText(sdf.format(cal.getTime()));
//            
//            panel.add(time);
//            
//            return panel;
//        }
//        
//        // run method apko runnable method se aata h
//        // yaha pe msg ko read krna h jo server se aae ga 
//        public void run() {
//            try {
//                String msg = "";
//                // sabhi msg ko lene ke liye -> infinite loop chalaya
//                while(true) {
//                    // msg nikalne ke liye -> buffer Reader object
//                    msg = reader.readLine();
//                    if(msg.contains(name)) {
//                        continue;
//                    }
//                    
//                    // msg set krne ke liye
//                    JPanel panel = formatLabel(msg);
//                    
//                    // msg left side dikhane ke liye
//                    JPanel left = new JPanel(new BorderLayout());
//                    left.setBackground(Color.WHITE);
//                    
//                    // panel ko add krna h - line jaha se strt krna h waha pe
//                    left.add(panel, BorderLayout.LINE_START);
//                    vertical.add(left);
//                    a1.add(vertical, BorderLayout.PAGE_START);
//                    
//                    // frame ko reload krna h
//                    f.repaint();
//                    f.invalidate();
//                    f.validate(); 
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        
//        // main method
//        // server se connect krne ke liye -> thread class ka object bnae h  
//        public static void main(String[] args){
//           UserTwo two = new UserTwo();
//           Thread t1 = new Thread(two);
//           t1.start();
//           
//        }
//    }

// GitHub
package group.chatting.application;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.text.*;
import java.net.*;
import java.io.*;

public class UserTwo implements ActionListener, Runnable {
    
    JTextField text;
    JPanel a1;
    static Box vertical = Box.createVerticalBox();
    static JFrame f = new JFrame();
    static DataOutputStream dout;
    
    BufferedReader reader;
    BufferedWriter writer;
    String name = "Guddu Bhaiya";
    
    UserTwo() {
        
        f.setLayout(null);
        
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(7, 94, 84));
        p1.setBounds(0, 0, 450, 70);
        p1.setLayout(null);
        f.add(p1);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/3.png"));
        Image i2 = i1.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel back = new JLabel(i3);
        back.setBounds(5, 20, 25, 25);
        p1.add(back);
        
        back.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent ae) {
                System.exit(0);
            }
        });
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/mirzapur.png"));
        Image i5 = i4.getImage().getScaledInstance(60,60, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel profile = new JLabel(i6);
        profile.setBounds(40, 5, 60, 60);
        p1.add(profile);
        
        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("icons/video.png"));
        Image i8 = i7.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel video = new JLabel(i9);
        video.setBounds(300, 20, 30, 30);
        p1.add(video);
        
        ImageIcon i10 = new ImageIcon(ClassLoader.getSystemResource("icons/phone.png"));
        Image i11 = i10.getImage().getScaledInstance(35, 30, Image.SCALE_DEFAULT);
        ImageIcon i12 = new ImageIcon(i11);
        JLabel phone = new JLabel(i12);
        phone.setBounds(360, 20, 35, 30);
        p1.add(phone);
        
        ImageIcon i13 = new ImageIcon(ClassLoader.getSystemResource("icons/3icon.png"));
        Image i14 = i13.getImage().getScaledInstance(10, 25, Image.SCALE_DEFAULT);
        ImageIcon i15 = new ImageIcon(i14);
        JLabel morevert = new JLabel(i15);
        morevert.setBounds(420, 20, 10, 25);
        p1.add(morevert);
        
        JLabel name = new JLabel("Mirzapur");
        name.setBounds(110, 15, 100, 18);
        name.setForeground(Color.WHITE);
        name.setFont(new Font("SAN_SERIF", Font.BOLD, 18));
        p1.add(name);
        
        JLabel status = new JLabel("Guddu, Kaleen, Bablu, Sweety, IG Dubey, Shukla");
        status.setBounds(110, 35, 160, 18);
        status.setForeground(Color.WHITE);
        status.setFont(new Font("SAN_SERIF", Font.BOLD, 14));
        p1.add(status);
        
        a1 = new JPanel();
        a1.setBounds(5, 75, 440, 570);
        a1.setBackground(Color.WHITE);
        f.add(a1);
        
        text = new JTextField();
        text.setBounds(5, 655, 310, 40);
        text.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
        f.add(text);
        
        JButton send = new JButton("Send");
        send.setBounds(320, 655, 123, 40);
        send.setBackground(new Color(7, 94, 84));
        send.setForeground(Color.WHITE);
        send.addActionListener(this);
        send.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
        f.add(send);
        
        f.setSize(450, 700);
        f.setLocation(490, 50);
        f.setUndecorated(true);
        f.getContentPane().setBackground(Color.WHITE);
        
        f.setVisible(true);
        
        try {
            Socket socket = new Socket("localhost", 2003);
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void actionPerformed(ActionEvent ae) {
        try {
            String out = "<html><p>" + name + "</p><p>" + text.getText() + "</p></html>";

            JPanel p2 = formatLabel(out);

            a1.setLayout(new BorderLayout());

            JPanel right = new JPanel(new BorderLayout());
            right.add(p2, BorderLayout.LINE_END);
            right.setBackground(Color.WHITE);
            vertical.add(right);
            vertical.add(Box.createVerticalStrut(15));

            a1.add(vertical, BorderLayout.PAGE_START);

            try {
                writer.write(out);
                writer.write("\r\n");
                writer.flush();
            } catch (Exception e) {
                e.printStackTrace();
            }

            text.setText("");

            f.repaint();
            f.invalidate();
            f.validate();   
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static JPanel formatLabel(String out) {
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        JLabel output = new JLabel("<html><p style=\"width: 150px\">" + out + "</p></html>");
        output.setFont(new Font("Tahoma", Font.PLAIN, 16));
        output.setBackground(new Color(37, 211, 102));
        output.setOpaque(true);
        output.setBorder(new EmptyBorder(0, 15, 0, 50));
        
        panel.add(output);
        
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        
        JLabel time = new JLabel();
        time.setText(sdf.format(cal.getTime()));
        
        panel.add(time);
        
        return panel;
    }
    
    public void run() {
        try {
            String msg = "";
            while(true) {
                msg = reader.readLine();
                if (msg.contains(name)) {
                    continue;
                }
                
                JPanel panel = formatLabel(msg);
                
                JPanel left = new JPanel(new BorderLayout());
                left.setBackground(Color.WHITE);
                left.add(panel, BorderLayout.LINE_START);
                vertical.add(left);
                
                a1.add(vertical, BorderLayout.PAGE_START);
                
                f.repaint();
                f.invalidate();
                f.validate();   
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        UserTwo two = new UserTwo();
        Thread t1 = new Thread(two);
        t1.start();
    }
}
