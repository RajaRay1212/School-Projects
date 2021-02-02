import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
class RoomBooking extends JFrame implements ActionListener,KeyListener
{
	JLabel searchl,otherSerbices,l,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17,l18;
	JTextField searcht,tf1,tf2,tf3,tf4,tf6,tf7,tf8,tf9,tf10,tf11,tf12,tf13,tf14,tf15,tf16,tf17;
	JRadioButton rb1,rb2;
	ButtonGroup g;
	JButton searchb,b1,b2,b3,b4,b5,b6;
	Date date;
    SimpleDateFormat ftt;
	Container c;
	Statement stmt2;
	 JTable tb;
     JScrollPane sp;
     DefaultTableModel model;
     Object col[]= {"Customer_ID","Name","Father_Name","Mother_Name","Gender","Address","State","Phone_No","In_Date","Out_Date","Time","Room_No","Ac_NonAc","Totel_Person","Day_Night","Distt","Pin_Code"};
     Object row[]=new Object[17];
     JPanel p1;
     Connection con;
     
	RoomBooking()
	{
		l=new JLabel("ROOM BOOKING");
		l.setBounds(300,5,300,80);
		Font ft=new Font("Arial",Font.BOLD,35);
		l.setFont(ft);
	   
		p1=new JPanel();
		p1.setBounds(0,2,900,80);
		add(p1);
		p1.setBackground(Color.BLUE);
		
		l1=new JLabel("Cus_Id");
		l1.setBounds(30,100,150,40);
		Font ft1=new Font("Arial",Font.BOLD,20);
		l1.setFont(ft1);
		
		l2=new JLabel("Name");
		l2.setBounds(30,150,150,40);
		Font ft2=new Font("Arial",Font.BOLD,20);
		l2.setFont(ft2);
		
		l3=new JLabel("Father Name");
		l3.setBounds(30,200,200,40);
		Font ft3=new Font("Arial",Font.BOLD,20);
		l3.setFont(ft3);
		
	    l4=new JLabel("Mother Name");
		l4.setBounds(30,250,200,40);
		Font ft4=new Font("Arial",Font.BOLD,20);
		l4.setFont(ft4);
		
		l5=new JLabel("Gender");
		l5.setBounds(30,300,200,40);
		Font ft5=new Font("Arial",Font.BOLD,20);
		l5.setFont(ft5);
		
		l6=new JLabel("Address");
		l6.setBounds(30,350,200,40);
		Font ft6=new Font("Arial",Font.BOLD,20);
		l6.setFont(ft6);
		
        l7=new JLabel("State");
		l7.setBounds(30,400,200,40);
		Font ft7=new Font("Arial",Font.BOLD,20);
		l7.setFont(ft7);
		
		l8=new JLabel("Phone No");
		l8.setBounds(450,150,150,40);
		Font ft8=new Font("Arial",Font.BOLD,20);
		l8.setFont(ft8);
		add(l8);
		
		l9=new JLabel("In-Date");
		l9.setBounds(450,200,150,40);
		Font ft9=new Font("Arial",Font.BOLD,20);
		l9.setFont(ft9);
		add(l9);
	
		
		l10=new JLabel("Out-Date");
		l10.setBounds(450,250,150,40);
		Font ft10=new Font("Arial",Font.BOLD,20);
		l10.setFont(ft10);
		add(l10);
		
		l11=new JLabel("Time");
		l11.setBounds(450,300,150,40);
		Font ft11=new Font("Arial",Font.BOLD,20);
		l11.setFont(ft11);
		add(l11);
		
	    l12=new JLabel("Room No");
		l12.setBounds(450,350,150,40);
		Font ft12=new Font("Arial",Font.BOLD,20);
		l12.setFont(ft12);
		add(l12);
		
	    l13=new JLabel("Ac/Non Ac");
		l13.setBounds(450,400,250,40);
		Font ft13=new Font("Arial",Font.BOLD,20);
		l13.setFont(ft13);
		add(l13);
		
		l14=new JLabel("Total Person");
		l14.setBounds(30,480,150,40);
		Font ft14=new Font("Arial",Font.BOLD,20);
		l14.setFont(ft14);
		add(l14);
		
		l15=new JLabel("Day/Night");
		l15.setBounds(30,530,150,40);
		Font ft15=new Font("Arial",Font.BOLD,20);
		l15.setFont(ft15);
		add(l15);
		
		l16=new JLabel("Distt");
		l16.setBounds(450,480,100,40);
		
		Font ft16=new Font("Arial",Font.BOLD,20);
		l16.setFont(ft16);
		
		l17=new JLabel("Pin-Code");
		l17.setBounds(450,530,150,40);

		Font ft17=new Font("Arial",Font.BOLD,20);
		l17.setFont(ft17);
		
		otherSerbices=new JLabel("Other Services");
		otherSerbices.setBounds(350,360,300,200);
		add(otherSerbices);
		Font otherSerbicesfont=new Font("Arial",Font.BOLD,30);
		otherSerbices.setFont(otherSerbicesfont);
		
		tf1=new JTextField();
		tf1.setBounds(220,100,200,27);
		add(tf1);

		
	    tf2=new JTextField();
		tf2.setBounds(220,150,200,27);
		add(tf2);
		
		tf3=new JTextField();
		tf3.setBounds(220,200,200,27);
		add(tf3);
		
	    tf4=new JTextField();
		tf4.setBounds(220,250,200,27);
		add(tf4);
		
		rb1=new JRadioButton("Male");
		rb1.setBounds(220,280,100,70);
		add(rb1);
		rb2=new JRadioButton("Female");
		rb2.setBounds(320,280,100,70);
		add(rb2);
		g=new ButtonGroup();
		g.add(rb1);
		g.add(rb2);
		
	    tf6=new JTextField();
		tf6.setBounds(220,350,200,27);
		add(tf6);
		
		tf7=new JTextField();
		tf7.setBounds(220,400,200,27);
		add(tf7);
	
		
	    tf8=new JTextField();
		tf8.setBounds(600,150,200,27);
		add(tf8);
		
		date=new Date();
		ftt=new SimpleDateFormat("dd/MM/YYYY");
	    tf9=new JTextField();             
		tf9.setBounds(600,200,200,27);
		add(tf9);
		tf9.setText(ftt.format(date));
		
		tf10=new JTextField();
		tf10.setBounds(600,250,200,27);
		add(tf10);
		
	    tf11=new JTextField();
		tf11.setBounds(600,300,200,27);
		add(tf11);
		
		tf12=new JTextField();
		tf12.setBounds(600,350,200,27);
		add(tf12);
		
		tf13=new JTextField();
		tf13.setBounds(600,400,200,27);
		add(tf13);
		
		tf14=new JTextField();
		tf14.setBounds(220,480,200,27);
		add(tf14);
		
	    tf15=new JTextField();
		tf15.setBounds(220,530,200,27);
		add(tf15);
		
	    tf16=new JTextField();
		tf16.setBounds(600,480,200,27);
	    add(tf16);
		
		tf17=new JTextField();
		tf17.setBounds(600,530,200,27);
		add(tf17);
		
		b1=new JButton("<Back");
		b1.setBounds(10,600,120,30);
		add(b1);
		
		b2=new JButton("Insert");
		b2.setBounds(160,600,120,30);
		add(b2);
		
		b3=new JButton("Update");
		b3.setBounds(310,600,120,30);
		add(b3);
		
		b4=new JButton("Delete");
		b4.setBounds(460,600,120,30);
		add(b4);
		
		b5=new JButton("Clear");
		b5.setBounds(620,600,120,30);
        add(b5);  
        
		b6=new JButton("Next>");
		b6.setBounds(760,600,120,30);
		add(b6);
        p1.add(l);
       
		add(l1);
		add(l2);
		add(l3);
		add(l4);
		add(l5);
		add(l6);
		add(l7);
	    add(l16);
		add(l17);
        searchl=new JLabel("Search");
	    searchl.setBounds(450,100,150,40);
		add(searchl);
		
		searcht=new JTextField();
		searcht.setBounds(600,100,200,30);
		add(searcht);
	    searchb=new JButton("OK");
		searchb.setBounds(800,100,70,30);
		add(searchb);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		searchb.addActionListener(this);
		
	    setSize(900,700);
		setLayout(null);
		setVisible(true);
		setLocationRelativeTo(null);
	
		 tf1.setEditable(false);
		 tf1.setBackground(Color.WHITE);
		  
	     c=this.getContentPane();
		 c.setBackground(Color.WHITE);
		
		tf2.addKeyListener(this);
		tf3.addKeyListener(this);
		tf4.addKeyListener(this);
		rb1.addKeyListener(this);
		rb2.addKeyListener(this);
		tf6.addKeyListener(this);
	    tf7.addKeyListener(this);
		tf8.addKeyListener(this);
		tf9.addKeyListener(this);
		tf10.addKeyListener(this);
		tf11.addKeyListener(this);
		tf12.addKeyListener(this);
		tf13.addKeyListener(this);
		tf14.addKeyListener(this);
		tf15.addKeyListener(this);
		tf16.addKeyListener(this);
		
		try
	     {
			  Class.forName("com.mysql.jdbc.Driver");
			  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Krishna_hotel2","root","123456a#");
			  System.out.println("DataBase Connect");
			 
			  stmt2=con.createStatement();
			  ResultSet rs=stmt2.executeQuery("Select Customer_ID from roombooing where In_date='"+tf9.getText()+"'");  
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
    }
	
	// CODE FOR ENTER KEY USED
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
				tf4.requestFocus();
			}
		}
		if(k1.getSource()==tf4)
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
				tf6.requestFocus();
			}
		}
		if(k1.getSource()==tf6)
		{
			if(k1.getKeyChar()==KeyEvent.VK_ENTER)
			{
				tf7.requestFocus();
			}
		}
		if(k1.getSource()==tf7)
		{
			if(k1.getKeyChar()==KeyEvent.VK_ENTER)
			{
				tf8.requestFocus();
			}
		}
		if(k1.getSource()==tf8)
		{
			if(k1.getKeyChar()==KeyEvent.VK_ENTER)
			{
				tf10.requestFocus();
			}
		}
	   if(k1.getSource()==tf10)
		{
			if(k1.getKeyChar()==KeyEvent.VK_ENTER)
			{
				tf11.requestFocus();
			}
		}
		if(k1.getSource()==tf11)
		{
			if(k1.getKeyChar()==KeyEvent.VK_ENTER)
			{
				tf12.requestFocus();
			}
		}
		if(k1.getSource()==tf12)
		{
			if(k1.getKeyChar()==KeyEvent.VK_ENTER)
			{
				tf13.requestFocus();
			}
		}
		if(k1.getSource()==tf13)
		{
			if(k1.getKeyChar()==KeyEvent.VK_ENTER)
			{
				tf14.requestFocus();
			}
		}
		if(k1.getSource()==tf14)
		{
			if(k1.getKeyChar()==KeyEvent.VK_ENTER)
			{
				tf15.requestFocus();
			}
		}
		if(k1.getSource()==tf15)
		{
			if(k1.getKeyChar()==KeyEvent.VK_ENTER)
			{
				tf16.requestFocus();
			}
		}
		if(k1.getSource()==tf16)
	    {
			if(k1.getKeyChar()==KeyEvent.VK_ENTER)
			{
				tf17.requestFocus();
			}
		}
		if(k1.getSource()==tf9)
		{
			if(k1.getKeyChar()==KeyEvent.VK_ENTER)
			{
				try
				{
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Krishna_hotel2","root","123456a#");
				System.out.println("WOW DATABASE CONNECTED");
				
				stmt2=con.createStatement();
				ResultSet rs=stmt2.executeQuery("Select Customer_ID from roombooing where in_date='"+tf9.getText()+"'");
				tf1.setText("1");
					while(rs.next())
					{
						String s1=rs.getString(1);
						Integer i1=Integer.parseInt(s1);
						i1++;
						tf1.setText(i1.toString());
					}
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
				}
				
			}
		}
	}
	public void keyTyped(KeyEvent k2)
	{
	}
	public void keyReleased(KeyEvent k3)
	{
	}
	
	/**** CODE FOR SAVE UPDATE SEARCH AND DELETE DATE IN DATABASE***********/
	
	public void actionPerformed(ActionEvent e)
	{
		
				  if(e.getSource()==b2)
				  {
					  if(tf2.getText().equals("")||tf3.getText().equals("")||tf4.getText().equals("")||tf6.getText().equals("")||tf7.getText().equals("")||tf8.getText().equals("")||tf9.getText().equals("")||tf10.getText().equals("")||tf11.getText().equals("")||tf12.getText().equals("")||tf13.getText().equals("")||tf14.getText().equals("")||tf15.getText().equals("")||tf16.getText().equals(""))
					  {
						  		JOptionPane.showMessageDialog(null,"Fill All Enteries");
					  }
					  else
					  {
					       		save();
					  }
				  }
				  else if(e.getSource()==b3)
				  {
					  if(tf2.getText().equals("")||tf3.getText().equals("")||tf4.getText().equals("")||tf6.getText().equals("")||tf7.getText().equals("")||tf8.getText().equals("")||tf9.getText().equals("")||tf10.getText().equals("")||tf11.getText().equals("")||tf12.getText().equals("")||tf13.getText().equals("")||tf14.getText().equals("")||tf15.getText().equals("")||tf16.getText().equals(""))
					  {
						  		JOptionPane.showMessageDialog(null,"Fill Update Enteries");
					  }
					  else
					  {
						  		update();	
					  }
				  }
				  else if(e.getSource()==b4)
				  {
					  delete();
				  }
				 else if(e.getSource()==b5)
				  {
					  tf2.setText("");
					  tf3.setText("");
					  tf4.setText("");
					  tf6.setText("");
					  tf7.setText("");
					  tf8.setText("");
					 // tf9.setText("");
					  tf10.setText("");
					  tf11.setText("");
					  tf12.setText("");
					  tf13.setText("");
					  tf14.setText("");
					  tf15.setText("");
					  tf16.setText("");
					  tf17.setText("");
				  }
				  else if(e.getSource()==searchb)
				  {
					  if(searcht.getText().equals(""))
					  {
						  JOptionPane.showMessageDialog(null,"Enter Search Date");
					  }
					  else
					  {
						 System.out.println("OOOOO1");
						  try
						  {
						          Class.forName("com.mysql.jdbc.Driver");
						          con=DriverManager.getConnection("jdbc:mysql://localhost:3306/krishna_hotel2","root","123456a#");
						          System.out.print("DateBASWE DATE");
						          Statement stmt=con.createStatement();
								  ResultSet rs=stmt.executeQuery("Select in_date from roombooing where In_Date='"+searcht.getText()+"'");
								  if(rs.next()==true)
								  {
									  select();
								  }
								  else
								  {
									  JOptionPane.showMessageDialog(null,"No Date Found");
								  }
						  }
						  catch(Exception ee)
						  {
							  JOptionPane.showMessageDialog(null,ee,"Alert",JOptionPane.WARNING_MESSAGE);
						  }
						  
					  }
				  }
				  else if(e.getSource()==b1)
				  {
					  new CustomerDetails();
					  setVisible(false);
				  }
			     else if(e.getSource()==b6)
				 {
					setVisible(false);
				 }
		}
		
	void save()
	{
		try
		{
			  Class.forName("com.mysql.jdbc.Driver");
			  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/krishna_hotel2","root","123456a#");
			  System.out.println("DataBase Connect");
			  
			      stmt2=con.createStatement();
			      ResultSet rs=stmt2.executeQuery("Select Customer_ID in_date from roombooing where in_date='"+tf9.getText()+"'");
			      tf1.setText("1");
			      	while(rs.next())
			      	{
			      		Integer i1=Integer.parseInt(rs.getString(1));
			      		i1++;
			      		tf1.setText(i1.toString());
			      	}
			      Integer st1=Integer.parseInt(tf1.getText());
				  String st2=tf2.getText();
				  String st3=tf3.getText();
				  String st4=tf4.getText();
				  String st6=tf6.getText();
				  String st7=tf7.getText();
				  String st8=String.valueOf(tf8.getText());
				  String st9=String.valueOf(tf9.getText());
		          String st10=String.valueOf(tf10.getText());
				  String st11=String.valueOf(tf11.getText());
			      int st12=Integer.parseInt(tf12.getText());
				  String st13=tf13.getText();
				  int st14=Integer.parseInt(tf14.getText());
				  String st15=tf15.getText();
				  String st16=tf16.getText();
				  String st17=String.valueOf(tf17.getText());
				  
				  PreparedStatement stmt=con.prepareStatement("Insert into Roombooing value(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
				  stmt.setInt(1,st1);
				  stmt.setString(2,st2);
				  stmt.setString(3,st3);
				  stmt.setString(4,st4);
				  if(rb1.isSelected())
				  {
					  stmt.setString(5,"Male");
				  }
				  else if(rb2.isSelected())
				  {
					  stmt.setString(5,"Female");
				  }
				  stmt.setString(6,st6);
				  stmt.setString(7,st7);
				  stmt.setString(8,st8);
				  stmt.setString(9,st9);
				  stmt.setString(10,st10);
				  stmt.setString(11,st11);
				  stmt.setInt(12,st12);
				  stmt.setString(13,st13);
				  stmt.setInt(14,st14);
				  stmt.setString(15,st15);
				  stmt.setString(16,st16);
				  stmt.setString(17,st17);
				  
				  int i=stmt.executeUpdate();
			      JOptionPane.showMessageDialog(null,"Save Successful"+" "+i);
			      
			      st1++;
			      tf1.setText(st1.toString());
		}
		catch(Exception ee)
		{
			System.out.println(ee.getMessage());
		}
	}
	void update()
	{
		try
		{
			  Class.forName("com.mysql.jdbc.Driver");
			  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/krishna_hotel2","root","123456a#");
			  System.out.println("DataBase Connect");
			  int st1=Integer.parseInt(tf1.getText());
						String st2=tf2.getText();
						String st3=tf3.getText();
						String st4=tf4.getText();
						String st6=tf6.getText();
						String st7=tf7.getText();
						String st8=String.valueOf(tf8.getText());
						String st9=String.valueOf(tf9.getText());
						String st10=String.valueOf(tf10.getText());
						String st11=String.valueOf(tf11.getText());
						int st12=Integer.parseInt(tf12.getText());
						String st13=tf13.getText();
						int st14=Integer.parseInt(tf14.getText());
						String st15=tf15.getText();
						String st16=tf16.getText();
						String st17=String.valueOf(tf17.getText());
				  
				  
				      PreparedStatement stmt=con.prepareStatement("update Roombooing set Customer_Id=?,Name=?,Father_Name=?,Mother_Name=?,Gender=?,Address=?,State=?,Phone_No=?,In_Date=?,Out_Date=?,Time=?,Room_No=?,Ac_NonAc=?,Totel_Person=?,Day_Night=?,Dist=?,Pin_Code=? where Customer_ID='"+tf1.getText()+"'&& In_Date='"+searcht.getText()+"'");
					  stmt.setInt(1,st1);
					  stmt.setString(2,st2);
					  stmt.setString(3,st3);
					  stmt.setString(4,st4);
					  if(rb1.isSelected())
					  {
						  stmt.setString(5,"Male");
					  }
					  else if(rb2.isSelected())
					  {
						  stmt.setString(5,"Female");
					  }
				     stmt.setString(6,st6);
					 stmt.setString(7,st7);
					 stmt.setString(8,st8);
					 stmt.setString(9,st9);
				  
					 stmt.setString(10,st10);
					 stmt.setString(11,st11);
					 stmt.setInt(12,st12);
					 stmt.setString(13,st13);
					 stmt.setInt(14,st14);
				     stmt.setString(15,st15);
					 stmt.setString(16,st16);
					 stmt.setString(17,st17);
				     
					 int i=stmt.executeUpdate();
					 JOptionPane.showMessageDialog(null,"UPDATE"+" "+i);
		}
		catch(Exception up)
		{
			System.out.println(up.getMessage());
			JOptionPane.showMessageDialog(null,up.getMessage());
		}
	}
	void select()
	{
		   JFrame f2=new JFrame();
    	 
	 		sp=new JScrollPane();
	 		sp.setBounds(5,5,1350,100);
	 		f2.add(sp);
	 		
	 		tb=new JTable();
	 		tb.setBounds(5,5,1150,300);
	 		f2.add(tb);
	 		
	 		model=new DefaultTableModel();
	 		model.setColumnIdentifiers(col);
	 		tb.setModel(model);
	 		sp.setViewportView(tb);
	 		
	 	try
		 {
			  Class.forName("com.mysql.jdbc.Driver");
			  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/krishna_hotel2","root","123456a#");
			  Statement stmt=con.createStatement();
			  ResultSet rs=stmt.executeQuery("Select*from roombooing where In_Date='"+searcht.getText()+"'");
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
					           String s9=rs.getString(9);
					           String s10=rs.getString(10);
					           String s11=rs.getString(11);
					           String s12=rs.getString(12);
					           String s13=rs.getString(13);
					           String s14=rs.getString(14);
					           String s15=rs.getString(15);
					           String s16=rs.getString(16);
					           String s17=rs.getString(17);
					           
					           row[0]=s1;
					           row[1]=s2;
					           row[2]=s3;
					           row[3]=s4;
					           if(s5.equals("Male"))
					           {
					        	   row[4]="Male";
					           }
					           else if(s5.equals("Female"))
					           {
					        	   row[4]="Female";
					           }
					           row[5]=s6;
					           row[6]=s7;
					           row[7]=s8;
					           row[8]=s9;
					           row[9]=s10;
					           row[10]=s11;
					           row[11]=s12;
					           row[12]=s13;
					           row[13]=s14;
					           row[14]=s15;
					           row[15]=s16;
					           row[16]=s17;
					           model.addRow(row);
					      } 
		}
		catch(Exception se)
		{
			System.out.println(se.getMessage());
		}
		 tb.addMouseListener(new MouseAdapter()
    	 {
    	            public void mousePressed(MouseEvent e)
    	            {
    	            	int i=tb.getSelectedRow();
    	            	tf1.setText(model.getValueAt(i,0).toString());
    	            	tf2.setText(model.getValueAt(i,1).toString());
    	            	tf3.setText(model.getValueAt(i,2).toString());
    	            	tf4.setText(model.getValueAt(i,3).toString());
    	                if(model.getValueAt(i,4).toString().equals("Male"))
    	                {
    	                       rb1.setSelected(true);	
    	                }
    	                else if(model.getValueAt(i,4).toString().equals("Female"))
    	                {
    	                	rb2.setSelected(true);
    	                }
    	                tf6.setText(model.getValueAt(i,5).toString());
    	                tf7.setText(model.getValueAt(i,6).toString());
    	                tf8.setText(model.getValueAt(i,7).toString());

    	                tf9.setText(model.getValueAt(i,8).toString());
    	                tf10.setText(model.getValueAt(i,9).toString());
    	                tf11.setText(model.getValueAt(i,10).toString());
    	                tf12.setText(model.getValueAt(i,11).toString());
    	                tf13.setText(model.getValueAt(i,12).toString());
    	                tf14.setText(model.getValueAt(i,13).toString());
    	                
    	                tf15.setText(model.getValueAt(i,14).toString());
    	                tf16.setText(model.getValueAt(i,15).toString());
    	                tf17.setText(model.getValueAt(i,16).toString());
    	           }
    	 });
		 f2.setSize(1380,400);
    	 f2.setVisible(true);
    	 f2.setLayout(null);
	}
	void delete()
	{
		 try
		 {
			    Class.forName("com.mysql.jdbc.Driver");
			    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/krishna_hotel2","root","123456a#");
			    System.out.println("DataBase Connect");
			  
			    PreparedStatement stmt=con.prepareStatement("Delete from roombooing where Customer_ID='"+tf1.getText()+"'&& In_Date='"+searcht.getText()+"'");
		        int i=stmt.executeUpdate();
			    JOptionPane.showMessageDialog(null,"DELETED"+" "+i);
		 }
		 catch(Exception de)
		 {
			      System.out.println(de.getMessage());
		 }
	}
	public static void main(String []args)
	{
		new RoomBooking();
	}
}