
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.*;
import java.sql.*;

class CustomerDetails implements ActionListener,KeyListener 
{
	JFrame f1,f2;
	JButton b1,b2,b3,b4,b5,search,clear,beck,next;
	JLabel l1,l2,l3,l4,l5,l6,l7,hadi,date,line;
	JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,datee;
	JScrollPane sp1;
    Font ft1,ft2,ft3,ft4,ft5,ft6,ft7,had;
    JRadioButton rb1,rb2;
    ButtonGroup bg;
    Panel p1;
    Date d1;
    Container c;
    SimpleDateFormat ft;
    Connection con;
     PreparedStatement stmt;
     JTable tb;
     JScrollPane sp;
     DefaultTableModel model;
     Object col[]= {"Customer_ID","Name","Father_Name","Gender","Address","Mobile","DOB","Date"};
     Object row[]=new Object[8];
     Statement stmt2;
     CustomerDetails()
     {
    	 f1=new JFrame();
    	
    	 p1=new Panel();
    	 p1.setBounds(0,1,850,70);
    	 f1.add(p1);
    	 p1.setBackground(Color.BLUE);
    	 
         hadi=new JLabel("CUSTOMER DETAIL");
    	 hadi.setBounds(220,10,500,80);
    	 p1.add(hadi);
    	 had=new Font("Arial",Font.BOLD,40);
    	 hadi.setFont(had);
    	 hadi.setForeground(Color.YELLOW);
    	 
    	 l1=new JLabel("Cus_ID");
    	 l1.setBounds(90,140,100,30);
    	 f1.add(l1);
    	 ft1=new Font("Arial",Font.BOLD,22);
    	 l1.setFont(ft1);
    	 tf1=new JTextField();
    	 tf1.setBounds(260,140,250,25);
    	 f1.add(tf1);
    	 
    	 tf1.setEditable(false);
    	 tf1.setBackground(Color.WHITE);
    	 
    	 l2=new JLabel("Name");
    	 l2.setBounds(90,200,100,30);
    	 f1.add(l2);
    	 ft2=new Font("Arial",Font.BOLD,22);
    	 l2.setFont(ft2);
    	 tf2=new JTextField();
    	 tf2.setBounds(260,200,250,25);
    	 f1.add(tf2);
    	 
    	 l3=new JLabel("Father_Name");
    	 l3.setBounds(90,260,150,30);
    	 f1.add(l3);
    	 ft3=new Font("Arial",Font.BOLD,22);
    	 l3.setFont(ft3);
    	 tf3=new JTextField();
    	 tf3.setBounds(260,260,250,25);
    	 f1.add(tf3);
    	 
    	 l4=new JLabel("Gender");
    	 l4.setBounds(90,320,150,30);
    	 f1.add(l4);
    	 ft4=new Font("Arial",Font.BOLD,22);
    	 l4.setFont(ft4);
    	 
    	rb1=new JRadioButton("Male");
    	rb1.setBounds(260,310,100,50);
    	f1.add(rb1);
    	rb2=new JRadioButton("Female");
    	rb2.setBounds(410,310,100,50);
    	f1.add(rb2);
    	
    	bg=new ButtonGroup();
    	bg.add(rb1);
    	bg.add(rb2);
    	 
    	l5=new JLabel("Address");
    	l5.setBounds(90,380,150,30);
    	f1.add(l5);
    	ft5=new Font("Arial",Font.BOLD,22);
    	l5.setFont(ft5);
    	tf4=new JTextField();
    	tf4.setBounds(260,380,250,25);
    	f1.add(tf4);
    	
    	l6=new JLabel("Mobile");
    	l6.setBounds(90,440,100,30);
    	f1.add(l6);
    	ft6=new Font("Arial",Font.BOLD,22);
    	l6.setFont(ft6);
    	tf5=new JTextField();
    	tf5.setBounds(260,440,250,25);
    	f1.add(tf5);
    	
    	l7=new JLabel("DOB");
    	l7.setBounds(90,500,100,30);
    	f1.add(l7);
    	ft7=new Font("Arial",Font.BOLD,22);
    	l7.setFont(ft7);
    	
    	 tf6=new JTextField();
    	 tf6.setBounds(260,500,250,25);
    	 f1.add(tf6);
    	
    	 
         tf7=new JTextField();
    	 tf7.setBounds(90,550,480,25);
    	 f1.add(tf7);
    	 
    	 search=new JButton("Search");
    	 search.setBounds(600,550,170,25);
    	 f1.add(search);
    	 
    	 date=new JLabel("Date");
    	 date.setBounds(600,100,100,20);
    	 f1.add(date);
    	 
    	 datee=new JTextField();
    	 datee.setBounds(630,100,130,22);
    	 f1.add(datee);
    	 
    	 d1=new Date();
	 ft=new SimpleDateFormat("dd/MM/yyyy");
	 datee.setText(ft.format(d1));
    	 
    	 b1=new JButton("Save");
    	 b1.setBounds(600,140,170,25);
    	 f1.add(b1);
    	 
    	 b2=new JButton("Update");
    	 b2.setBounds(600,200,170,25);
    	 f1.add(b2);
    	 
    	 b3=new JButton("Delete");
    	 b3.setBounds(600,260,170,25);
    	 f1.add(b3);
    	 
    	 clear=new JButton("Clear");
    	 clear.setBounds(600,320,170,25);
    	 f1.add(clear);
    	 
    	 next=new JButton("Next");
    	 next.setBounds(600,380,170,25);
    	 f1.add(next);
    	 
    	 
    	 c=f1.getContentPane();
    	 c.setBackground(Color.WHITE);
    	 
    	 b1.addActionListener(this);
    	 b2.addActionListener(this);
    	 search.addActionListener(this);
    	 b3.addActionListener(this);
    	 clear.addActionListener(this);
    	 next.addActionListener(this);
    
    	 tf2.addKeyListener(this);
    	 tf3.addKeyListener(this);
    	 rb1.addKeyListener(this);
    	 rb2.addKeyListener(this);
    	 tf4.addKeyListener(this);
    	 tf5.addKeyListener(this);
    	 tf6.addKeyListener(this);
    	
 	try
 	     {
		  Class.forName("com.mysql.jdbc.Driver");
		 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Krishna_hotel2","root","123456a#");
			 
 		 stmt2=con.createStatement();
 		 ResultSet rs=stmt2.executeQuery("Select Customer_ID,date from customerdetails1 where date='"+datee.getText()+"'");  
 		 tf1.setText("1");
 		 while(rs.next())
 		  {
 		         String s=String.valueOf(rs.getInt(1));
 			 Integer iv=Integer.parseInt(s);
 			 iv++;
                        tf1.setText(String.valueOf(iv));
                   }
            }
 	    catch(Exception e2)
 	    {
 		        JOptionPane.showMessageDialog(null,e2);
 	    }
 		 datee.addKeyListener(new KeyAdapter()
 	     {
 		    public void keyPressed(KeyEvent ke)
 		    {
 		    	 if(ke.getKeyChar()==KeyEvent.VK_ENTER)
 			 {
 						 
 				  try
 				   {
 					  Class.forName("com.mysql.jdbc.Driver");
 					  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Krishna_hotel2","root","123456a#");
 					  stmt2=con.createStatement();
 					  ResultSet rs=stmt2.executeQuery("Select Customer_ID,date from customerdetails1 where date='"+datee.getText()+"'");
 					    tf1.setText("1");
 					     while(rs.next())
 					     {
 					   	     String s=String.valueOf(rs.getInt(1));
 					   	     String s1=rs.getString(2);
 					             Integer iv=Integer.parseInt(s);
 					   	     iv++;
 					             tf1.setText(String.valueOf(iv));
 					    }
 				   }
 				   catch(Exception e2)
 				  {
 					            JOptionPane.showMessageDialog(null,e2);
 			          }
 			   }
 		       }
 	    } );
 		 f1.setSize(850,650);
    	         f1.setLayout(null);
    	         f1.setVisible(true);
    	        f1.setLocationRelativeTo(null);
      }
      /*****CODE FOR ENTER KEY USED*****/
     public void keyPressed(KeyEvent k1)
     {
            if(k1.getSource()==tf2)
            {
                if(k1.getKeyChar()==KeyEvent.VK_ENTER)
                {
                	tf3.requestFocus();
                }
            }
            if(k1.getSource()==tf3)
            {
            	if(k1.getKeyChar()==KeyEvent.VK_ENTER)
            	{
            	       rb1.requestFocus();
            	}
            }
            if(k1.getSource()==rb1)
            {
            	if(k1.getKeyChar()==KeyEvent.VK_ENTER)
            	{
            		rb2.requestFocus();
            	}
            }
            if(k1.getSource()==rb2)
            {
            	if(k1.getKeyChar()==KeyEvent.VK_ENTER)
            	{
            		tf4.requestFocus();
            	}
            }
            if(k1.getSource()==tf4)
            {
            	if(k1.getKeyChar()==KeyEvent.VK_ENTER)
            	{
            		tf5.requestFocus();
            	}
            }
            if(k1.getSource()==tf5)
            {
            	if(k1.getKeyChar()==KeyEvent.VK_ENTER)
            	{
            		tf6.requestFocus();
            	}
            }
     }
     public void keyTyped(KeyEvent k2)
     {
     }
     public void keyReleased(KeyEvent k3)
     {
     }
     public void actionPerformed(ActionEvent e1)
     {
    	if(e1.getSource()==b1)
    	 {
    		 if(tf2.getText().equals("")||tf3.getText().equals("")||tf4.getText().equals("")||tf5.getText().equals("")||tf6.getText().equals(""))
    		 {
    		        JOptionPane.showMessageDialog(null,"Fill All Enteries");
    		 }
    		 else
    		 {
    			 save();
    		 }
    	 }
    	 else if(e1.getSource()==b2)
    	 {
    		 if(tf2.getText().equals("")||tf3.getText().equals("")||tf4.getText().equals("")||tf5.getText().equals("")||tf6.getText().equals(""))
    		 {
    		        JOptionPane.showMessageDialog(null,"Fill Update Enteries");
    		 }
    		 else
    		 {  
    		       update();
    		 }
    	 }
    	 else if(e1.getSource()==search)
    	 {
    		 if(tf7.getText().equals(""))
    		 {
    			JOptionPane.showMessageDialog(null,"Enter Search Date"); 
    		 }
    		 else
    		 {
    			 try
    			 {
    				     Class.forName("com.mysql.jdbc.Driver");
    				     con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Krishna_hotel2","root","123456a#");
    				     Statement stmt2=con.createStatement();
    				     ResultSet rs=stmt2.executeQuery("Select*from customerDetails1 where Date='"+tf7.getText()+"'");
    		             if(rs.next()==true)
    		             {
    		            	 select();
    		             }
    		             else
    		             {
    		            	 JOptionPane.showMessageDialog(null,"Date Not Found","Error",JOptionPane.WARNING_MESSAGE);
    		             }
    			 }
    			 catch(Exception e)
    			 {
    	           	 JOptionPane.showMessageDialog(null,e);
    			 }
    		 }
    	 }
    	 else if(e1.getSource()==b3)
    	 {
    		 delete();
    	 }
    	 else if(e1.getSource()==clear)
    	 {
    		 tf2.setText("");
    		 tf3.setText("");
    		 tf4.setText("");
    		 tf5.setText("");
    		 tf6.setText("");
    	 }
    	 else if(e1.getSource()==next)
    	 {
    		new RoomBooking();
    		f1.setVisible(false);
    	 }
     }
     void save()
     {
    	 try
    	 {
    		Class.forName("com.mysql.jdbc.Driver");
    		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Krishna_hotel2","root","123456a#");
    	        stmt2=con.createStatement();
	        ResultSet rs=stmt2.executeQuery("Select Customer_ID,date from customerdetails1  where date='"+datee.getText()+"'");
	        tf1.setText("1");
	        while(rs.next())
	        {
	  		  Integer it=Integer.parseInt(rs.getString(1));
	  		  it++;
	  		  tf1.setText(String.valueOf(it));
	         }
	         Integer s1=Integer.parseInt(tf1.getText());
	         String s2=tf2.getText();
	    	 String s3=tf3.getText();
	    	 String s4=tf4.getText();
	    	 String s5=tf5.getText();
	    	 String s6=tf6.getText();
	    	 String s7=datee.getText();
    		
    	  	  stmt=con.prepareStatement("insert into customerdetails1 values(?,?,?,?,?,?,?,?)");
    	 	  stmt.setInt(1,s1);
    	   	  stmt.setString(2,s2);
    	    	  stmt.setString(3,s3);
    	         if(rb1.isSelected())
    	         {
    	         	stmt.setString(4,"Male");
    	         }
    	        else if(rb2.isSelected())
    	        {
    	                stmt.setString(4,"Female");	
    	        }
    	         stmt.setString(5,s4);
    	         stmt.setString(6,s5 );
    	         stmt.setString(7,s6);
    	         stmt.setString(8,s7);
    	    
    	    int i=stmt.executeUpdate();
    	    JOptionPane.showMessageDialog(null,"Successful"+" "+i);
    	    s1++;
    	    tf1.setText(s1.toString());
    	 }
    	 catch(Exception e)
    	 {
    		 System.out.println(e.getMessage());
    	 }
     }
     void update()
     {
    	 try
	    {
		    Class.forName("com.mysql.jdbc.Driver");
		    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Krishna_hotel2","root","123456a#");
		    System.out.println("Connection Create UPDAE");
		    
		    stmt=con.prepareStatement("update customerdetails1 set Customer_ID=?,Name=?,Father_Name=?,Gender=?,Address=?,Mobile=?,DOB=?,Date=? where Customer_ID='"+tf1.getText()+"'&& date='"+tf7.getText()+"'");
		    stmt.setString(1,tf1.getText());
		    stmt.setString(2,tf2.getText());
		    stmt.setString(3,tf3.getText());
		    if(rb1.isSelected())
		    {
		    	stmt.setString(4,"Male");
		    }
		    else if(rb2.isSelected())
		    {
		    	stmt.setString(4,"Female");
		    }
		    stmt.setString(5,tf4.getText());
		    stmt.setString(6,tf5.getText());
		    stmt.setString(7,tf6.getText());
		    stmt.setString(8,tf7.getText());
		    
		    int i=stmt.executeUpdate();
		    JOptionPane.showMessageDialog(null,"Successful Update"+" "+i);
		 }
		 catch(Exception u)
		 {
			 System.out.println(u.getMessage());
		 }
     }
     void select()
     {
    	 f2=new JFrame();
    	 
 		sp=new JScrollPane();
 		sp.setBounds(5,5,800,100);
 		f2.add(sp);
 		
 		tb=new JTable();
 		tb.setBounds(5,5,800,300);
 		f2.add(tb);
 		
 		model=new DefaultTableModel();
 		model.setColumnIdentifiers(col);
 		tb.setModel(model);
 		sp.setViewportView(tb);
 		
 		try
		{
			Class.forName("com.mysql.jdbc.Driver");
		        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Krishna_hotel2","root","123456a#");
			
			 Statement stmt2=con.createStatement();
		        ResultSet rs=stmt2.executeQuery("Select*from customerDetails1 where Date='"+tf7.getText()+"'");
      
		      while(rs.next())
		     	{
		     		String s1=rs.getString(1);
		     		String s2=rs.getString(2);
		     		String s3=rs.getString(3);
		     		String s4=rs.getString(4);
		     		String s5=rs.getString(5);
		     		String s6=rs.getString(6);
		     		String s7=rs.getString(7);
		     		String s8=rs.getString(8);
			
		     		row[0]=s1;
		     		row[1]=s2;
		     		row[2]=s3;
		     		if(s4.equals("Male"))
		     		{
		     			row[3]="Male";
		     		}
		     		else if(s4.equals("Female"))
		     		{
		     			row[3]="Female";
		     		}
		     		row[4]=s5;
		     		row[5]=s6;
		     		row[6]=s7;
		     		row[7]=s8;
		     		model.addRow(row);
		     	}
		}
		catch(Exception te)
		{
			 JOptionPane.showMessageDialog(null,te.getMessage());
		}
		 tb.addMouseListener(new MouseAdapter()
    	 {
    	            public void mousePressed(MouseEvent e)
    	            {
    	            		int i=tb.getSelectedRow();
    	            		tf1.setText(model.getValueAt(i,0).toString());
    	            		tf2.setText(model.getValueAt(i,1).toString());
    	            		tf3.setText(model.getValueAt(i,2).toString());
    	            	
    	            	if((model.getValueAt(i,3).toString()).equals("Male"))
    	            	{
    	            	         rb1.setSelected(true);  
    	            	}
    	            	else if((model.getValueAt(i,3).toString()).equals("Female"))
    	            	{
    	            		     rb2.setSelected(true);  
    	            	}
    	            		tf4.setText(model.getValueAt(i,4).toString());
    	            		tf5.setText(model.getValueAt(i,5).toString());
    	            		tf6.setText(model.getValueAt(i,6).toString());
    	            		datee.setText(model.getValueAt(i,7).toString());
    	                }
    	 });
         f2.setSize(830,400);
    	 f2.setVisible(true);
    	 f2.setLayout(null);
     }
     void delete()
     {
    	 int i1=tb.getSelectedRow();
    	 model.removeRow(i1);
    	 try
    	 {
    		 Class.forName("com.mysql.jdbc.Driver");
 		  con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Krishna_hotel2","root","123456a#");
 			 
 		   stmt=con.prepareStatement("delete from customerdetails1 where customer_ID='"+tf1.getText()+"'&& date='"+tf7.getText()+"'");
 		   int i=stmt.executeUpdate();
 		    JOptionPane.showMessageDialog(null,"Delete"+" "+i);
 	}
    	 catch(Exception e)
    	 {
    		 JOptionPane.showMessageDialog(null,e);
    	 }
     }
     public static void main(String []args)
     {
    	 new CustomerDetails();
     }
}


