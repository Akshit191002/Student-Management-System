
package Student_Management;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class HomePage extends JFrame implements ActionListener
{
    JLabel l1;
    Font f,f1;
    //JPanel p1;
    
    HomePage()
    {
        super("Student Management System");
        setLocation(10,10);
        setSize(1600,800);
        
        f=new Font("Lucida Fax",Font.BOLD,20);
        f1=new Font("Gadugi",Font.BOLD,35);
        //f2=new Font("MS UI Gothic",Font.BOLD,18);
        
        ImageIcon ic=new ImageIcon(ClassLoader.getSystemResource("Student_Management/Icon/HomePage.jpg"));
        Image img=ic.getImage().getScaledInstance(1600, 800, Image.SCALE_DEFAULT);
        ImageIcon ic1= new ImageIcon(img);
        l1=new JLabel(ic1);
        
        JMenuBar m= new JMenuBar();
        JMenu m1=new JMenu("Student");
        JMenuItem mt1=new JMenuItem("New Student");
        JMenuItem mt2=new JMenuItem("View List");
        
        JMenu m2=new JMenu("Modify");
        JMenuItem mt3=new JMenuItem("Update Student");
        
        JMenu m3=new JMenu("Fees");
        JMenuItem mt4=new JMenuItem("Update Fees");
        JMenuItem mt5=new JMenuItem("View Fees");
        
        JMenu m5=new JMenu("Delete");
        JMenuItem mt8=new JMenuItem("Delete Student");
        
        JMenu m6=new JMenu("Exit");
        JMenuItem mt9=new JMenuItem("LogOut");
        
        m1.add(mt1);
        m1.add(mt2);
        m2.add(mt3);
        m3.add(mt4);
        m3.add(mt5);
        m5.add(mt8);
        m6.add(mt9);
        
        m.add(m1);
        m.add(m2);
        m.add(m3);
        m.add(m5);
        m.add(m6);
        
        m1.setFont(f);
        m2.setFont(f);
        m3.setFont(f);
        m5.setFont(f);
        m6.setFont(f);
        
        mt1.setFont(f1);
        mt2.setFont(f1);
        mt3.setFont(f1);
        mt4.setFont(f1);
        mt5.setFont(f1);
        mt8.setFont(f1);
        mt9.setFont(f1);
        
        m1.setForeground(Color.WHITE);
        m2.setForeground(Color.WHITE);
        m3.setForeground(Color.WHITE);
        m5.setForeground(Color.WHITE);
        m6.setForeground(Color.WHITE);
        
        mt1.setForeground(Color.GRAY);
        mt2.setForeground(Color.GRAY);
        mt3.setForeground(Color.GRAY);
        mt4.setForeground(Color.GRAY);
        mt5.setForeground(Color.GRAY);
        mt8.setForeground(Color.GRAY);
        mt9.setForeground(Color.GRAY);
        
        m.setBackground(Color.BLACK);
        
        mt1.setBackground(Color.BLACK);
        mt2.setBackground(Color.BLACK);
        mt3.setBackground(Color.BLACK);
        mt4.setBackground(Color.BLACK);
        mt5.setBackground(Color.BLACK);
        mt8.setBackground(Color.BLACK);
        mt9.setBackground(Color.BLACK);
        
        mt1.addActionListener(this);
        mt2.addActionListener(this);
        mt3.addActionListener(this);
        mt4.addActionListener(this);
        mt5.addActionListener(this);
        mt8.addActionListener(this);
        mt9.addActionListener(this);

       
        setJMenuBar(m);
        add(l1);
    }
    public void actionPerformed(ActionEvent e) 
    {
        String c=e.getActionCommand();
        if(c.equals("New Student"))
        {
            new Add_Student();
        }
        else if(c.equals("View List"))
        {
            new View_Student();  
        }
        else if(c.equals("Update Student"))
        {
            new Update_Student().setVisible(true);  
        } 
        else if(c.equals("Update Fees"))
        {
            new Update_Fees().setVisible(true);  
        }
        else if(c.equals("View Fees"))
        {
            new View_Fees().setVisible(true);  
        } 
        
        else if(c.equals("Delete Student"))
        {
            new Delete_Student().setVisible(true);  
        }
        else if(c.equals("LogOut"))
        {
            System.exit(0);
        }
        
    }
    public static void main(String[] args)
    {
        new HomePage().setVisible(true);
    }
    
}
