package project1;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class MiniStatement extends JFrame implements ActionListener{
 
    JTable t1;
    JButton b1;
    String x[] = {"Name","Card Number","Address","Income","Balance"};
    String y[][] = new String[20][5];
    int i=0, j=0;
    
    MiniStatement(String p){
        super("Mini Statement");
        setSize(1200,650);
        setLocation(200,200);
        
        try{
            conn c1  = new conn();
           
            String s1 = "select s1.name,s3.cardno,s1.address,s2.income,b.balance from signup s1,signup2 s2,signup3 s3,bank b where s1.formno=s2.formno AND s2.formno=s3.formno AND s3.pin=b.pin AND b.pin='"+p+"'";
            		
            		
            
            ResultSet rs  = c1.s.executeQuery(s1);
            
            while(rs.next()){
               
                y[i][j++]=rs.getString("name");
                y[i][j++]=rs.getString("cardno");
                y[i][j++]=rs.getString("address");
                y[i][j++]=rs.getString("income");
                y[i][j++]=rs.getString("balance");
                i++;
                j=0;
            }
            t1 = new JTable(y,x);
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        b1 = new JButton("Print");
        add(b1,"South");
        JScrollPane sp = new JScrollPane(t1);
        add(sp);
        b1.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae){
        try{
            System.out.println(t1);
        }catch(Exception e){}
    }
    
    public static void main(String[] args){
        new MiniStatement("pinn").setVisible(true);
    }
    
}