import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;


public class Insertacceptor
{
    JFrame frame = new JFrame("ADDING ACCEPTOR");

    JLabel heading = new JLabel("ENTER ACCEPTOR DETAILS");

    JLabel ph_no = new JLabel("Enter contact number : ");
    JLabel Name = new JLabel("Enter name : ");
    JLabel pid = new JLabel("Enter patient id : ");
    JLabel bloodgroup = new JLabel("Enter bloodgroup : ");
    JLabel go_to = new JLabel("GOTO");


    JTextField aph_no = new JTextField();
    JTextField aname = new JTextField();
    JTextField apid = new JTextField();
    JTextField abloodgroup = new JTextField();
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


    public Insertacceptor(){
    	
    	connDb();

        heading.setBounds(50, 50, 200, 20);
        ph_no.setBounds(50, 100, 100, 30);
        Name.setBounds(50, 150, 200, 30);
        pid.setBounds(50, 200, 150, 30);
       	aname.setBounds(250, 150, 150, 30);
        aph_no.setBounds(250, 100, 150, 30);
        apid.setBounds(250, 200, 150, 30);
        bloodgroup.setBounds(50, 250, 150, 30);
        abloodgroup.setBounds(250, 250,150, 30);
        
        
        insert.setBounds(50, 300, 100, 30);
        go_to.setBounds(50, 350, 100, 30);
        home.setBounds(50, 400, 100, 30);
        back.setBounds(50, 450, 100, 30);
        resultText.setBounds(250, 400, 200, 150);
        
        frame.getContentPane().setBackground(Color.gray);
        insert.setBackground(Color.white);
        home.setBackground(Color.white);
        back.setBackground(Color.white);

        frame.add(heading);
        frame.add(ph_no);
        frame.add(Name);
        frame.add(pid);
        frame.add(aname);
        frame.add(aph_no);
        frame.add(apid);
        frame.add(bloodgroup);
        frame.add(abloodgroup);
        frame.add(insert);
        frame.add(go_to);
        frame.add(home); 
        frame.add(resultText);
        frame.add(back);
        
        frame.setLayout(null);  
        frame.setVisible(true);
        frame.setBounds(400, 10, 500, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);  

        insert.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent ae) {
            
            try {
            	
            				  
				  String query= "INSERT INTO acceptor VALUES(" + aph_no.getText() + ",'" + aname.getText() + "'," + apid.getText() + ",'" + abloodgroup.getText() + "' )"; 
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
               new Acceptorchoice();
              
            
           }});
   
    }   
}
