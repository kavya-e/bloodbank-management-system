import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.*;


public class Donorchoice 
{

    JFrame frame = new JFrame("DONOR CHOICE");

    JLabel heading = new JLabel("Welcome,\n Which operation do you want to perform?");
    JLabel go_to = new JLabel("GO TO");
           
    JButton insert = new JButton("SUBMIT");
    JButton update = new JButton("MODIFY");
    JButton delete = new JButton("DELETE");
    JButton back = new JButton("Back");
    JButton home = new JButton("Home");

    Color gray = new Color(164, 206, 237);
    Color white = new Color(52, 158, 235);  
    
    
    

    public Donorchoice(){
    	
    	// setBounds(x, y,width, height); 
	    heading.setBounds(50, 20, 1000, 100);
		insert.setBounds(100,120, 100,30);  
		update.setBounds(250,120,100,30);
		delete.setBounds(400,120, 100, 30);
		back.setBounds(300, 300, 100, 30);
		go_to.setBounds(100, 250, 50, 50);
		home.setBounds(100, 300, 80,30);


		frame.getContentPane().setBackground(Color.gray);
		insert.setBackground(Color.white);
		update.setBackground(Color.white);
		delete.setBackground(Color.white);
		home.setBackground(Color.white);
		back.setBackground(Color.white);

		frame.add(heading); 
		frame.add(insert);
		frame.add(update);
		frame.add(delete);
		frame.add(go_to);
		frame.add(home); 
		frame.add(back);
		
		frame.setLayout(null);  
        frame.setVisible(true);
        frame.setBounds(400, 10, 370, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false); 
		      


	
	
	    insert.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent ae) {
	            frame.dispose();
	            new Insertdonor();
	        }
	    });
	
	    update.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent ae) {
	            frame.dispose();
	            new Updatedonor();
	        }
	    });
	    delete.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent ae) {
	            frame.dispose();
	            new Deletedonor();
	        }
	    });
	
	    home.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent ae) {
	            frame.dispose();
	            new Gui();
	        }
	    });
	    
	    back.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent ae) {
	            frame.dispose();
	            new Choice1();
	        }
	    });
	    
	    
	    frame.setLayout(null);
	    frame.setSize(680, 400);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);
    }
    
    
      
      
}