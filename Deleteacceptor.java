import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;



public class Deleteacceptor
{
    JFrame frame = new JFrame("DELETING ACCEPTOR ");

    JLabel heading = new JLabel("ENTER DETAILS");

    JLabel ph_no = new JLabel("Enter mobile number : ");
    JLabel name = new JLabel("Enter name : ");
    JLabel pid = new JLabel("Enter patient id : ");
    JLabel bloodgroup = new JLabel("Enter bloodgroup : ");
    JLabel go_to = new JLabel("GOTO");


    List ids = new List(15);

    JTextField aph_no = new JTextField();
    JTextField aname = new JTextField();
    JTextField apid = new JTextField();
    JTextField abloodgroup = new JTextField();
    
    JTextArea resultText = new JTextArea();
    
    JButton home = new JButton("Home");
    JButton delete = new JButton("DELETE");
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

    public void loadProducts(){

        try 
        {
          ResultSet rs;
          rs = stmt.executeQuery("SELECT PATIENT_ID FROM ACCEPTOR");
          while (rs.next()) 
          {
            ids.add(rs.getString(1));
          }
        } 
        catch (SQLException e) 
        { 
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

    public Deleteacceptor(){
    	
    	connDb();
        loadProducts();

        ids.setBounds(250,310,100,125);
        heading.setBounds(50, 50, 200, 20);
        ph_no.setBounds(50, 100, 100, 30);
        name.setBounds(50, 150, 200, 30);
        pid.setBounds(50, 200, 150, 30);
       	aname.setBounds(250, 150, 150, 30);
        aph_no.setBounds(250, 100, 150, 30);
        apid.setBounds(250, 200, 150, 30);
        bloodgroup.setBounds(50, 250, 150, 30);
        abloodgroup.setBounds(250, 250,150, 30);
        
        
        delete.setBounds(50, 300, 100, 30);
        go_to.setBounds(50, 350, 100, 30);
        home.setBounds(50, 400, 100, 30);
        back.setBounds(50, 450, 100, 30);
        resultText.setBounds(250, 450, 200, 150);
        
        frame.getContentPane().setBackground(Color.gray);
        delete.setBackground(Color.white);
        home.setBackground(Color.white);
        back.setBackground(Color.white);
        

        frame.add(ids);
        frame.add(heading);
        frame.add(ph_no);
        frame.add(name);
        frame.add(aph_no);
        frame.add(aname);
        frame.add(pid);
        frame.add(apid);
        frame.add(bloodgroup);
        frame.add(abloodgroup);
        frame.add(delete);
        frame.add(go_to);
        frame.add(home); 
        frame.add(resultText);
        frame.add(back);
        
        frame.setLayout(null);  
        frame.setVisible(true);
        frame.setBounds(400, 10, 700, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);  

        ids.addItemListener(new ItemListener() {
		public void itemStateChanged(ItemEvent ae) {
            
            try     
            {
            	    ResultSet rs;
                    rs = stmt.executeQuery("SELECT * FROM acceptor where PATIENT_ID ='"+ids.getSelectedItem()+"'");
                    rs.next();
                    aph_no.setText(rs.getString(1));
                    aname.setText(rs.getString(2));
                    apid.setText(rs.getString(3));
                    abloodgroup.setText(rs.getString(4));
                    

                } 
                catch (SQLException selectException) 
                {
                    displaySQLErrors(selectException);
                }
        }});

        delete.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent ae) {
            try 
                {   
                    int i = stmt.executeUpdate("DELETE FROM acceptor WHERE PATIENT_ID = " + ids.getSelectedItem());                  
                    resultText.append("\nDeleted " + i + " row successfully");
                    System.out.println("hello");
                    ids.removeAll();
                    loadProducts();
                } 
                catch (SQLException insertException) 
                {
                    displaySQLErrors(insertException);
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