import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.*;

 

public class home{
   public static void main(String[] args) {
      new Gui();
   }
}

class Gui
{
   
   public Gui(){
      JFrame frame = new JFrame("Home");
     

      JLabel heading = new JLabel("BLOODBANK MANAGEMENT SYSTEM");
      heading.setBounds(30,20,250,30);
      
      JLabel lb = new JLabel("Do you want to login : ");
      lb.setBounds(70, 50,350,30);

      JButton button1 = new JButton("YES");
      button1.setBounds(90,100,80,30);    
      
      
      
      
      Color gray = new Color(164, 206, 237);
      Color white = new Color(52, 158, 235); 


      frame.add(heading); 
      frame.add(lb);
      frame.add(button1);
      
      frame.getContentPane().setBackground(Color.gray);
      heading.setBackground(Color.gray);
      lb.setBackground(Color.gray);
      button1.setBackground(Color.white);
    
      
    

      button1.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent ae) {
             frame.dispose();
             new SecondFrame();
          }
       });

  
      frame.setLayout(null);

      frame.setBounds(500,200,300, 300);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }


}
