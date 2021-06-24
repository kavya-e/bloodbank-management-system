import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;


public class Insertdonor
{
    JFrame frame = new JFrame("ADDING DONOR");

    JLabel heading = new JLabel("ENTER DONOR DETAILS");

    JLabel dId = new JLabel("Enter donor id : ");
    JLabel Name = new JLabel("Enter name :");
    JLabel ph_no = new JLabel("Enter contact number : ");
    JLabel gender = new JLabel("Enter gender : ");
    JLabel dob = new JLabel("Enter date of birth : ");
    JLabel bloodgroup = new JLabel("Enter bloodgroup : ");
    
    JLabel heading1 = new JLabel("ENTER ADDRESS");
    
    JLabel street = new JLabel("Enter street : ");
    JLabel city = new JLabel("Enter city : ");
    JLabel pincode = new JLabel("Enter pincode : ");
    JLabel state = new JLabel("Enter state : ");
    JLabel age = new JLabel("Enter age : ");
    JLabel go_to = new JLabel("GOTO");

    JTextField ddId = new JTextField();
    JTextField dName = new JTextField();
    JTextField dph_no = new JTextField();
    JTextField dgender = new JTextField();
    JTextField ddob = new JTextField();
    JTextField dbloodgroup = new JTextField();
    JTextField dstreet = new JTextField();
    JTextField dcity = new JTextField();
    JTextField dpincode = new JTextField();
    JTextField dstate = new JTextField();
    JTextField dage = new JTextField();
    JTextArea resultText = new JTextArea();
    
    
  
    JButton home = new JButton("Home");
    JButton insert = new JButton("Insert");
    JButton back = new JButton("Back");
    
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
        	displaySQLErrors(e);
        }
    }
    
    private void displaySQLErrors(SQLException e) 
    {
        JOptionPane.showMessageDialog(frame,"Enter valid data types");  
        resultText.append("\nSQLException: " + e.getMessage() + "\n");
        resultText.append("SQLState:     " + e.getSQLState() + "\n");
        resultText.append("VendorError:  " + e.getErrorCode() + "\n");
    }

    public Insertdonor(){
    	
    	connDb();

        heading.setBounds(50, 25, 200, 20);
        dId.setBounds(50, 75, 100, 30);
        Name.setBounds(50, 125, 200, 30);
        ddId.setBounds(250, 75, 150, 30);
       	dName.setBounds(250, 125, 150, 30);
        ph_no.setBounds(50, 175, 150, 30);
        dph_no.setBounds(250, 175, 150, 30);
        gender.setBounds(50, 225, 150, 30);
        dgender.setBounds(250, 225,150, 30);
        dob.setBounds(50, 275, 150, 30);
        ddob.setBounds(250, 275, 150, 30);
        bloodgroup.setBounds(50, 325, 150, 30);
        dbloodgroup.setBounds(250, 325, 150, 30);
        
        heading1.setBounds(50,375, 100, 20);
        
        street.setBounds(50, 425, 150, 30);
        dstreet.setBounds(250, 425, 150, 30);
        city.setBounds(50, 475, 150, 30);
        dcity.setBounds(250, 475, 150, 30);
        pincode.setBounds(50, 525, 150, 30);
        dpincode.setBounds(250, 525, 150, 30);
        state.setBounds(50, 575, 150, 30);
        dstate.setBounds(250, 575, 150, 30);
        age.setBounds(50, 625, 150, 30);
        dage.setBounds(250, 625, 150, 30);
        resultText.setBounds(450, 425, 200, 150);
        
        insert.setBounds(450, 225, 100, 30);
        go_to.setBounds(450, 275, 100, 30);
        home.setBounds(450, 325, 100, 30);
        back.setBounds(450, 375, 100, 30);
        
        frame.getContentPane().setBackground(Color.gray);
        insert.setBackground(Color.white);
        home.setBackground(Color.white);
        back.setBackground(Color.white);
        
         
        frame.setSize(500,700);  
        frame.setLayout(null);  
        frame.setVisible(true); 

        frame.add(heading);
        frame.add(dId);
        frame.add(Name);
        frame.add(ddId);
        frame.add(dName);
        frame.add(ph_no);
        frame.add(dph_no);
        frame.add(gender);
        frame.add(dgender);
        frame.add(dob);
        frame.add(ddob);
        frame.add(bloodgroup);
        frame.add(dbloodgroup);
        frame.add(heading1);
        frame.add(street);
        frame.add(dstreet);
        frame.add(city);
        frame.add(dcity);
        frame.add(pincode);
        frame.add(dpincode);
        frame.add(state);
        frame.add(dstate);
        frame.add(age);
        frame.add(dage);
        frame.add(insert);
        frame.add(go_to);
        frame.add(home); 
        frame.add(resultText);
        frame.add(back);
        
        frame.setLayout(null);  
        frame.setVisible(true);
        frame.setBounds(400, 10, 700, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);  

        insert.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent ae) {
            
            try {
            	
            				  
				  String query= "INSERT INTO donors VALUES(" + ddId.getText() + ",'" + dName.getText() + "'," + dph_no.getText() + ",'" + dgender.getText() + "','" + ddob.getText() + "','" + dbloodgroup.getText() + "','" + dstreet.getText() +"','" +dcity.getText() +"'," + dpincode.getText() +",'" + dstate.getText() +"'," +dage.getText()+ " )"; 
				  int i = stmt.executeUpdate(query);
				  resultText.append("\nInserted " + i + " row successfully");

            }
            catch(SQLException e){
            	displaySQLErrors(e);
            }
            

        }});

        home.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent ae) {
            frame.dispose();
            new Gui();
           
         
        }});
        
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
               frame.dispose();
               new Donorchoice();
               
            
           }});
   
    }   
}