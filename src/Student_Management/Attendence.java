package Student_Management;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Attendence extends JFrame implements ActionListener
{
    JLabel l1,l2,l3,l4,l5,l6;
    Choice c1,c2,c3;
    JButton bt1,bt2;
    JTextField tf1,tf2,tf3;
    Font f;
    JPanel p;
    
    Attendence()
    {
        super("Attandance");
        setLocation(300,200);
        setSize(550,500);
        f= new Font("Arial",Font.BOLD,15);
        setResizable(false);
        
        l1=new JLabel("     Select Student ID");
        l2=new JLabel("     Before Recess");
        l3=new JLabel("     After Recess");
        l4=new JLabel("     Name");
        l5=new JLabel("     Department");
        l6=new JLabel("     Email ID");
        
        l1.setFont(f);
        l2.setFont(f);
        l3.setFont(f);
        l4.setFont(f);
        l5.setFont(f);
        l6.setFont(f);
        
        tf1=new JTextField();
        tf2=new JTextField();
        tf3=new JTextField();

        tf1.setFont(f);
        tf2.setFont(f);        
        tf3.setFont(f);

        tf1.setEditable(false);        
        tf2.setEditable(false);        
        tf3.setEditable(false);        

        c2= new Choice();
        c2.add("Present");
        c2.add("Absent"); 
        
        c3= new Choice();
        c3.add("Present");
        c3.add("Absent");
        c2.setFont(f);
        c3.setFont(f);
        
        bt1=new JButton("Submit");
        bt2=new JButton("Back");

        bt1.setBackground(Color.WHITE);
        bt2.setBackground(Color.WHITE);
        
        bt1.setFont(f);
        bt2.setFont(f);
        
        bt1.addActionListener(this);
        bt2.addActionListener(this);
        
        c1= new Choice();
        try
        {
            ConnectionClass obj=new ConnectionClass();
            String q="select * from Student";
            ResultSet rest= obj.stm.executeQuery(q);
            while(rest.next())
            {
                c1.add(rest.getString("sid"));
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        
        p=new JPanel();
        p.setLayout(new GridLayout(7,2,15,15));
        p.add(l1);
        p.add(c1);
        p.add(l4);
        p.add(tf1);
        p.add(l5);
        p.add(tf2);
        p.add(l6);
        p.add(tf3);
        p.add(l2);
        p.add(c2);
        p.add(l3);
        p.add(c3);
        p.add(bt1);
        p.add(bt2);
        
        add(p);
        
        c1.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent arg0)
            {
                try
                {
                    ConnectionClass obj2=new ConnectionClass();
                    String sid=c1.getSelectedItem();
                    String q2="select * from Student where sid='"+sid+"'";
                    ResultSet rest1= obj2.stm.executeQuery(q2);
                    while(rest1.next())
                    {
                        tf1.setText(rest1.getString("name"));
                        tf2.setText(rest1.getString("dep"));
                        tf3.setText(rest1.getString("eid"));

                    }
                    
                }
                catch(Exception eex)
                {
                    eex.printStackTrace();
                }
            }
        });
       
    }
    public void actionPerformed(ActionEvent ev)
    {
        if(ev.getSource()==bt1)
        {
            String sid=c1.getSelectedItem();
            String after_rec=c3.getSelectedItem();
            String before_rec=c2.getSelectedItem();
            String name=tf1.getText();
            String dep=tf2.getText();
            String eid=tf3.getText();
            String date=new java.util.Date().toString();

            try
            {
                ConnectionClass obj1=new ConnectionClass();
                String q1="insert into attendence value('"+sid+"','"+name+"','"+dep+"','"+eid+"','"+before_rec+"','"+after_rec+"''"+date+"')";
                int aa=obj1.stm.executeUpdate(q1);
                if(aa==1)
                {
                    JOptionPane.showMessageDialog(null, "Data inserted");
                    setVisible(false);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "please! enter full detail");
                    this.setVisible(false);
                    this.setVisible(true);
                }
                
            }
            catch(Exception eex)
            {
                eex.printStackTrace();
            }
        }
        if(ev.getSource()==bt2)
        {
            JOptionPane.showMessageDialog(null, "Are you sure to CLOSE ?");
            setVisible(false);
        }
        
    }
    public static void main(String [] args)
    {
        new Attendence().setVisible(true);
    }
}