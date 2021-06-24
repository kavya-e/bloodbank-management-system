import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;


public class Choice1
{
    JFrame frame = new JFrame("CHOICE");

    JLabel heading = new JLabel("CHOICE");
    JLabel go_to = new JLabel("GOTO");
    

    JButton donorButton = new JButton("DONOR");
    JButton acceptorButton = new JButton("ACCEPTOR");
    JButton home = new JButton("Home");
 

    Color gray = new Color(164, 206, 237);
    Color white = new Color(52, 158, 235); 
     
    Statement stmt; 
    
    public Choice1(){

        heading.setBounds(150, 200, 100, 20);
        
        donorButton.setBounds(50, 300, 100, 30);
        acceptorButton.setBounds(200, 300, 100, 30);
        go_to.setBounds(50, 450, 100, 30);
        home.setBounds(50, 500, 100, 30);
            

        frame.getContentPane().setBackground(Color.gray);
        donorButton.setBackground(Color.white);
        acceptorButton.setBackground(Color.white);
        home.setBackground(Color.white);
        

        frame.add(heading);
        
        frame.add(donorButton);
        frame.add(acceptorButton); 
        frame.add(go_to);
       
        frame.add(home); 

        frame.setLayout(null);  
        frame.setVisible(true);
        frame.setBounds(450, 100, 370, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);  

       
        donorButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent ae) {
            frame.dispose();
           new Donorchoice();
           
         
        }});
        
        acceptorButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
               frame.dispose();
               new Acceptorchoice();
               
            
           }});
        
       home.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
              frame.dispose();
              new Gui();
              
            
           }});
      
    }   
}