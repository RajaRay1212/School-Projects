import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
class Login implements ActionListener
{
	JFrame f1,f2;
	JPanel p1;
	JLabel l1,l2,l3,l4,l5,l6,l7;
	JTextField tf1,tf2,tf3,tf4;
	JPasswordField pf,pf2,pf3;
	JButton b1,b2,b3,b4,b5,see;
	String s1,s2;
	Connection con;
	PreparedStatement stmt;
	 Statement stmt2;
	Container c;
   Login()
   {
	f1=new JFrame();
	
	p1=new JPanel();
	p1.setBounds(0,0,500,80);
	f1.add(p1);
	p1.setBackground(Color.BLUE);
	
	l1=new JLabel("USER LOGIN");
	l1.setBounds(200,30,200,100);
	p1.add(l1);
	Font ft1=new Font("Arial",Font.BOLD,40);
	l1.setFont(ft1);
	l1.setForeground(Color.YELLOW);
	
	l2=new JLabel("USER NAME");
	l2.setBounds(80,100,300,100);
	f1.add(l2);
	Font ft2=new Font("Arial",Font.BOLD,20);
	l2.setFont(ft2);
    tf1=new JTextField();
	tf1.setBounds(80,160,320,50);
	f1.add(tf1);
	
	l3=new JLabel("PASSWORD");
	l3.setBounds(80,200,300,100);
	f1.add(l3);
	Font ft3=new Font("Arial",Font.BOLD,20);
	l3.setFont(ft3);
	
	pf=new JPasswordField();
	pf.setBounds(80,260,320,50);
	f1.add(pf);
	
	//see=new JButton("*");
	//see.setBounds(380,260,19,50);
	//f1.add(see);
	
	b1=new JButton("Submit");
	b1.setBounds(80,350,320,30);
	f1.add(b1);
	
	b2=new JButton("Clear");
	b2.setBounds(80,390,320,30);
	f1.add(b2);
	
     b3=new JButton("Forgat Password ?");
     b3.setBounds(20,480,150,20);
     f1.add(b3);
	 b3.setBackground(Color.WHITE);
     b3.setForeground(Color.BLUE);
     
	c=f1.getContentPane();
	c.setBackground(Color.WHITE);
	
	f1.setSize(500,550);
	f1.setLayout(null);
	f1.setVisible(true);
	f1.setLocationRelativeTo(null);
	//f1.setResizable(false);
	
	b3.addActionListener(new ActionListener()
	{
		    public void actionPerformed(ActionEvent e)
		    {
		      	 change();
		    }
	});
	
	      b1.addActionListener(this);
	      b2.addActionListener(this);
	}
   public void actionPerformed(ActionEvent e)
   {
	   if(e.getSource()==b1)
	   {
		   if(tf1.getText().equals("")&&pf.getText().equals(""))
		   {
			   JOptionPane.showMessageDialog(null,"Enter User Name And Password");
		   }
		   else if(tf1.getText().equals(""))
		   {
			   JOptionPane.showMessageDialog(null,"Enter User Name");
		   }
		   else if(pf.getText().equals(""))
		   {
			   JOptionPane.showMessageDialog(null,"Enter Password");
		   }
		   else
		   {
	            fun();
		   }
	  }
	   else if(e.getSource()==b2)
	   {
		   tf1.setText("");
		   pf.setText("");
	   }
	  
  }
  void fun()
  {
	    String s1=tf1.getText();
		String s2=pf.getText();
	
		 try
		  {
			  Class.forName("com.mysql.jdbc.Driver");
	        	  con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Krishna_hotel2","root","123456a#");
	        	  System.out.println("ConnectonCreate2");
	        	  
	        	  stmt2=con.createStatement();
	        	  ResultSet rs=stmt2.executeQuery("Select password from pass  where password='"+pf.getText()+"'");
	             if(rs.next()==true||s1.equals("Krishna"))
	              {
	            	 	
	            		 if(s1.equals("Krishna"))
	            		 {
	            
	            			try
	            			{
	            				 stmt2=con.createStatement();
	           	        	     ResultSet rs2=stmt2.executeQuery("Select password from pass  where password='"+pf.getText()+"'");
	           	        	     if(rs2.next()==true)
	           	        	     {
	           	        	    	 new CustomerDetails();
	           	        	    	 f1.setVisible(false);
	           	        	     }
	           	        	     else
	           	        	     {
	           	        	    	 JOptionPane.showMessageDialog(null,"Invalid Password !","Message",JOptionPane.WARNING_MESSAGE);
	           	        	     }
	            			}
	            			catch(Exception ee)
	            			{
	            				JOptionPane.showMessageDialog(null,ee);
	            			}
	            		 }
	            		 else
	            		 {
	            			 JOptionPane.showMessageDialog(null,"User Name Is Invalid !","Message",JOptionPane.WARNING_MESSAGE);
	            		 }
	              }
	             else
	             {
	            	 JOptionPane.showMessageDialog(null,"User Name And Password is Invalid !","Message",JOptionPane.WARNING_MESSAGE);
	             }
	      }
		  catch(Exception c)
		  {
			  JOptionPane.showMessageDialog(null,c);
		  }
   }
   void change()
   {   
	   JLabel ll=new JLabel("FORGAT PASSWORD");
	   ll.setBounds(150,20,200,70);
	   Font ftt=new Font("Arial",Font.BOLD,25);
	   ll.setFont(ftt);
	   ll.setForeground(Color.YELLOW);
	   
       f2=new JFrame();
       JPanel p1=new JPanel();
       p1.setBounds(0,2,400,60);
       f2.add(p1);
       p1.setBackground(Color.PINK);
       p1.add(ll);
       
       
	   l4=new JLabel("Enter User Name");
	   l4.setBounds(40,100,300,100);
	   f2.add(l4);
	   tf2=new JTextField();
	   tf2.setBounds(40,160,300,30);
	   f2.add(tf2);
	   
	   l5=new JLabel("Enter Old Password");
	   l5.setBounds(40,160,300,100);
	   f2.add(l5);
	   pf2=new JPasswordField();
	   pf2.setBounds(40,220,300,30);
	   f2.add(pf2);
	   
	   l6=new JLabel("Enter New Password");
	   l6.setBounds(40,220,200,100);
	   f2.add(l6);
	   pf3=new JPasswordField();
	   pf3.setBounds(40,280,300,30);
	   f2.add(pf3);
	   
	   b4=new JButton("Submit");
	   b4.setBounds(40,340,300,30);
	   f2.add(b4);
	   b5=new JButton("Clear");
	   b5.setBounds(40,380,300,30);
	   f2.add(b5);
	   
	   c=f2.getContentPane();
	   c.setBackground(Color.WHITE);
	  
	   f2.setSize(400,500);
	   f2.setLayout(null);
	   f2.setVisible(true);
	   f2.setLocationRelativeTo(null);
	  
	   b4.addActionListener(new ActionListener()
	   {
		        public void actionPerformed(ActionEvent e)
		        {
		        	
		        	System.out.println("CHANGE");
		        	
		        	  String s1=tf2.getText();
		              String s2=pf2.getText();
		              
		        	  if(tf2.getText().equals("")&&pf2.getText().equals("")&&pf3.getText().equals(""))
	                  {
		               JOptionPane.showMessageDialog(null,"Fill All Enteries");
	                  }
		        	  else if(tf2.getText().equals(""))
		        	  {
		        		  JOptionPane.showMessageDialog(null,"Enter User Name");
		        	  }
		        	  else if(pf2.getText().equals(""))
		        	  {
		        		  JOptionPane.showMessageDialog(null,"Enter Old Password");
		        	  }
		        	  else if(pf3.getText().equals(""))
		        	  {
		        		  JOptionPane.showMessageDialog(null,"Enter New Password");
		        	  }
		        	 else 
		        	  {
		        		  try
		        		  {
		        			  Class.forName("com.mysql.jdbc.Driver");
		  		        	  con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Krishna_hotel2","root","123456a#");
		  		        	  System.out.println("ConnectonCreate2");
		  		        	  
		  		        	  stmt2=con.createStatement();
		  		        	  ResultSet rs=stmt2.executeQuery("Select password from pass where password='"+pf2.getText()+"'");
		  		              if(rs.next()==true||s1.equals("Krishna"))
		  		              {
		  		            	  if(s1.equals("Krishna"))
		  		            	  {
		  		            		  try
		  		            		  { 
		  		            		      stmt2=con.createStatement();
		  		            		      ResultSet rs2=stmt2.executeQuery("Select password from pass where password='"+pf2.getText()+"'");
		  		            		      if(rs2.next()==true)
		  		            		      {
		  		            		    	  stmt=con.prepareStatement("update pass set password=? where password='"+pf2.getText()+"'");
		  		            		    	  stmt.setString(1,pf3.getText());
		  		            		    	  int i=stmt.executeUpdate();
		  		            		    	  JOptionPane.showMessageDialog(null,"Scussfull Update");
		  		            		      }
		  		            		      else
		  		            		      {
		  		            		    	 JOptionPane.showMessageDialog(null,"Invalid Password !");
		  		            		      }
		  		            		  }
		  		            		  catch(Exception ee)
		  		            		  {
		  		            		         JOptionPane.showMessageDialog(null,ee);
		  		            		  }
		  		                  }
		  		            	  else
		  		            	  {
		  		            		 JOptionPane.showMessageDialog(null," User Name is Invalid..!");
		  		            	  }
		  		              }
		  		              else
		  		              {
		  		            	 JOptionPane.showMessageDialog(null,"User Name and Password Is Invalid..!");
		  		              }
		  		          }
		        		  catch(Exception c)
		        		  {
		        			  JOptionPane.showMessageDialog(null,c);
		        		  }
		        	  }
		        	
		        }
	   });
	   b5.addActionListener(new ActionListener()
			  {
				  public void actionPerformed(ActionEvent ee)
				  {
					     if(ee.getSource()==b5)
	  		             {
	  		            	 tf2.setText("");
	  		            	 pf2.setText("");
	  		            	 pf3.setText("");
	  		             }
				  }
			   });
   }
   public static void main(String []args)
   {
	   new Login();
   }
}
