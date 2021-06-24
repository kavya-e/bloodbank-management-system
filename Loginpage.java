import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;


public class Loginpage 
{
    JFrame frame = new JFrame("BLOODBANK LOGIN");

    JLabel heading = new JLabel("LOGIN");
    JLabel userLabel = new JLabel("ID");
    JLabel passwordLabel = new JLabel("PASSWORD");
    JLabel go_to = new JLabel("GOTO");

    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();

    JButton loginButton = new JButton("LOGIN");
    JButton resetButton = new JButton("RESET");
    JButton home = new JButton("Home");

    JCheckBox showPassword = new JCheckBox("Show Password");
    
    

    Color gray = new Color(164, 206, 237);
    Color white = new Color(52, 158, 235); 
     
    Statement stmt;
    public void connDb() {
    	try{
            
        
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@218.248.0.7:1521:rdbms","it19737049","vasavi");
            stmt = con.createStatement();
            System.out.println("connection successful");           
        }
        catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public Loginpage(){
        
    	connDb();
        heading.setBounds(50, 50, 100, 20);
        userLabel.setBounds(50, 150, 100, 30);
        passwordLabel.setBounds(50, 220, 100, 30);
        userTextField.setBounds(150, 150, 150, 30);
        passwordField.setBounds(150, 220, 150, 30);
        showPassword.setBounds(150, 250, 150, 30);
        loginButton.setBounds(50, 300, 100, 30);
        resetButton.setBounds(200, 300, 100, 30);
        go_to.setBounds(60, 450, 100, 30);
        home.setBounds(50, 500, 100, 30);
        
      

        frame.getContentPane().setBackground(Color.gray);
        loginButton.setBackground(Color.white);
        resetButton.setBackground(Color.white);
        home.setBackground(Color.white);
        

        frame.add(heading);
        frame.add(userLabel);
        frame.add(passwordLabel);
        frame.add(userTextField);
        frame.add(passwordField);
        frame.add(showPassword);
        frame.add(loginButton);
        frame.add(resetButton); 
        frame.add(go_to);
        frame.add(home); 

        frame.setLayout(null);  
        frame.setVisible(true);
        frame.setBounds(450, 10, 370, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);  

        loginButton.addActionListener(new ActionListener() {
            @SuppressWarnings("deprecation")
    		public void actionPerformed(ActionEvent ae) {
                String userText;
                String pwdText;
                Boolean flag = false;
                userText = userTextField.getText();
                pwdText = passwordField.getText();

                String sql = "select bloodbank_id, password from bloodbank where bloodbank_id ="+ userText;
                try {
               	 	ResultSet rs = stmt.executeQuery(sql);
               	 	
               	 	while(rs.next()){
               	 		System.out.println(rs.getInt(1) + " " + rs.getString(2));
               	 		
               	 		if(rs.getString(2).equals(pwdText)) {
               	 			JOptionPane.showMessageDialog(frame, "Login Successful");
               	 			flag = true;              	 			
               	 			new Choice1();
               	 			frame.dispose();
               	 		}
               	 		else {
               	 			JOptionPane.showMessageDialog(frame, "Invalid Username or Password");
               	 		}
    	            	 
               	 	} 
               	 	if(!flag) {
               	 		JOptionPane.showMessageDialog(frame, "Invalid Username or Password");
               	 	}
               	 }
                catch(SQLException e){
                	JOptionPane.showMessageDialog(frame, "Invalid Username or Password");
                    System.out.println(e);
                }
                

                
            }});

        resetButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent ae) {
            userTextField.setText("");
            passwordField.setText("");
            
         
        }});

        showPassword.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent ae) {
            if (showPassword.isSelected()) {
                    passwordField.setEchoChar((char) 0);
                } else {
                    passwordField.setEchoChar('*');
                }
            
        }});

        home.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent ae) {
            frame.dispose();
            new Gui();
        }});
   
    }   
}