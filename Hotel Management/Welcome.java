import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class Welcome implements ActionListener
{
	  JFrame f1;
	  JLabel l1,l2,l3,l4;
	  JPanel p1;
	  JButton b1;
	  Container c;
	  
     Welcome()
      {
    	f1=new JFrame("WELCOME");   
    	
    	l1=new JLabel("WELCOME");
    	l1.setBounds(200,60,700,150);
    	f1.add(l1);
    	Font ft1=new Font("Arial",Font.BOLD,120);
    	l1.setFont(ft1);
    	l1.setForeground(Color.BLUE);
    	
    	l2=new JLabel("TO");
    	l2.setBounds(390,270,300,100);
    	f1.add(l2);
        Font ft2=new Font("Arial",Font.BOLD,120);
    	l2.setFont(ft2);
    	l2.setForeground(Color.BLUE);
    	
    	l3=new JLabel("KRISHNA HOTEL");
    	l3.setBounds(15,450,990,100);
    	f1.add(l3);
        Font ft3=new Font("Arial",Font.BOLD,120);
    	l3.setFont(ft3);
    	l3.setForeground(Color.BLUE);
    	
    	b1=new JButton("NEXT>>");
    	b1.setBounds(15,620,1000,30);
    	f1.add(b1);
    	
    	p1=new JPanel();
    	p1.setBounds(0,0,1050,30);
    	f1.add(p1);
    	p1.setBackground(Color.YELLOW);
    	
    	f1.setSize(1050,700);
    	f1.setLayout(null);
    	f1.setVisible(true);
    	
    	 f1.setLocationRelativeTo(null);
    	 c=f1.getContentPane();
         c.setBackground(Color.WHITE);
    	 b1.addActionListener(this);
    }
       public void actionPerformed(ActionEvent t)
       {
    	   new Login();
    	   f1.setVisible(false);
       }
       public static void main(String []args)
       {
    	   new Welcome();
       }
}
