
package Student_Management;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class View_Student implements ActionListener
{
    JFrame f;
    JTextField t;
    JLabel l1,l2;
    JButton b1,b2;
    
    View_Student()
    {
        f=new JFrame("Search..");
        f.setBackground(Color.GREEN);
        f.setLayout(null);
        
        l1=new JLabel();
        l1.setBounds(0,0,500,270);
        l1.setLayout(null);
       
        
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("Student_Management/Icon/search.jpg"));
        Image i1=img.getImage().getScaledInstance(500, 270, Image.SCALE_DEFAULT);
        ImageIcon img1= new ImageIcon(i1);
        l1.setIcon(img1);
        
        l2=new JLabel("Student ID");
        l2.setVisible(true);
        l2.setBounds(40,60,250,30);
        l2.setForeground(Color.BLACK);
        Font F1=new Font("Airal",Font.BOLD,30);
        l2.setFont(F1);
        l1.add(l2);
        f.add(l1);
        
        t= new JTextField();
        t.setBounds(240,60,220,30);
        l1.add(t);
        
        b1= new JButton("Search");
        b1.setBounds(140,150,100,30);
        b1.addActionListener(this);
        l1.add(b1);
        
        b2= new JButton("Cancel");
        b2.setBackground(Color.RED);
        b2.setForeground(Color.WHITE);
        b2.setBounds(260,150,100,30);
        b2.addActionListener(this);
        l1.add(b2);
        
        f.setSize(500,270);
        f.setLocation(450,250);
        f.setVisible(true);

        
    }
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource()==b1)
        {
            f.setVisible(false);
            new View_Student_Data(t.getText());
        }
        if(e.getSource()==b2)
        {
            f.setVisible(false);
            new HomePage();
        }
    }
    public static void main(String args[])
    {
        new View_Student();
    }   
}
