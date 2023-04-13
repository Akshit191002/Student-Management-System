
package Student_Management;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Update_Student extends JFrame implements ActionListener
{
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13;
    JButton b1,b2;
    JPanel p1,p2,p3;
    JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10;
    Choice ch;
    Font f,f1;
    
    Update_Student()
    {
        super("Update Students");
        setLocation(450,50);
        setSize(950,750);
        
        f= new Font("Arial",Font.BOLD,25);
        f1= new Font("Arial",Font.BOLD,18);
        
        ch=new Choice();
        
        try
        {
            ConnectionClass obj=new ConnectionClass();
            String q="select sid from Student ";
            ResultSet rest= obj.stm.executeQuery(q);
            while(rest.next())
            {
                ch.add(rest.getString("sid"));
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        
        l1=new JLabel("Update Student");
        l2=new JLabel("First Name");
        l3=new JLabel("Last Name");
        l4=new JLabel("Father Name");
        l5=new JLabel("Date of Birth");
        l6=new JLabel("Address");
        l7=new JLabel("Email ID");
        l8=new JLabel("Aadhar");
        l9=new JLabel("Phone");
        l10=new JLabel("Department");
        l11=new JLabel("Year");
        l12=new JLabel("Student ID");
        
        t1=new JTextField();
        t2=new JTextField();
        t3=new JTextField();
        t4=new JTextField();
        t5=new JTextField();
        t6=new JTextField();
        t7=new JTextField();
        t8=new JTextField();
        t9=new JTextField();
        t10=new JTextField();
       
        b1=new JButton("Update");
        b2=new JButton("Back");

        l1.setHorizontalAlignment(JLabel.CENTER);
        
        b1.addActionListener(this);
        b2.addActionListener(this);

        l1.setFont(f);
        l2.setFont(f1);
        l3.setFont(f1);
        l4.setFont(f1);
        l5.setFont(f1);
        l6.setFont(f1);
        l7.setFont(f1);
        l8.setFont(f1);
        l9.setFont(f1);
        l10.setFont(f1);
        l11.setFont(f1);
        l12.setFont(f1);
        
        t1.setFont(f1);
        t2.setFont(f1);
        t3.setFont(f1);
        t4.setFont(f1);
        t5.setFont(f1);
        t6.setFont(f1);
        t7.setFont(f1);
        t8.setFont(f1);
        t9.setFont(f1);
        t10.setFont(f1);
        
        b1.setFont(f1);
        b2.setFont(f1);
        b1.setBackground(Color.BLACK);
        b2.setBackground(Color.RED);
        b1.setForeground(Color.WHITE);
        b2.setForeground(Color.WHITE);
        
        p1=new JPanel();
        p1.setLayout(new GridLayout(1,1,10,10));
        p1.add(l1); 
        
        p2=new JPanel();
        p2.setLayout(new GridLayout(12,2,10,10));
        p2.add(l12); 
        p2.add(ch);
        p2.add(l2);
        p2.add(t1);
        p2.add(l3);
        p2.add(t2);
        p2.add(l4);
        p2.add(t3);
        p2.add(l5);
        p2.add(t4);
        p2.add(l6);
        p2.add(t5);
        p2.add(l7);
        p2.add(t6);
        p2.add(l8);
        p2.add(t7);
        p2.add(l9);
        p2.add(t8);
        p2.add(l10);
        p2.add(t9);
        p2.add(l11);
        p2.add(t10);
        p2.add(b1);
        p2.add(b2);
        
        p3=new JPanel();
        p3.setLayout(new GridLayout(1,1,10,10));
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("Student_Management/Icon/update.jpg"));
        Image img1=img.getImage().getScaledInstance(400, 600, Image.SCALE_DEFAULT);
        ImageIcon ic1= new ImageIcon(img1);
        l13=new JLabel(ic1);
        p3.add(l13); 

        setLayout(new BorderLayout(10,10));
        add(p1,"North");
        add(p2,"Center");
        add(p3,"West");
        
        ch.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent arg0)
            {
                try
                {
                    ConnectionClass obj2=new ConnectionClass();
                    String sid=ch.getSelectedItem();
                    String q1="select * from Student where sid='"+sid+"'";
                    ResultSet rest1= obj2.stm.executeQuery(q1);
                    while(rest1.next())
                    {
                        t1.setText(rest1.getString("name"));
                        t2.setText(rest1.getString("lname"));
                        t3.setText(rest1.getString("fname"));
                        t4.setText(rest1.getString("dob"));
                        t5.setText(rest1.getString("address"));
                        t6.setText(rest1.getString("eid"));
                        t7.setText(rest1.getString("adh"));
                        t8.setText(rest1.getString("phn"));
                        t9.setText(rest1.getString("dep"));
                        t10.setText(rest1.getString("yr"));

                    }
                    
                }
                catch(Exception eex)
                {
                    eex.printStackTrace();
                }
            }
        });
    }
    public void actionPerformed(ActionEvent e)
    {
        String sid=ch.getSelectedItem();
        String name =t1.getText();
        String lname =t2.getText();
        String fname =t3.getText();
        String dob =t4.getText();
        String address =t5.getText();
        String eid =t6.getText();
        String adh =t7.getText();
        String phn =t8.getText();
        String dep =t9.getText();
        String yr =t10.getText();
        
        if(e.getSource()==b1)
        {
            try
            {
                ConnectionClass obj3=new ConnectionClass();
                String q1="update Student set name='"+name+"',lname='"+lname+"',fname='"+fname+"',dob='"+dob+"',address='"+address+"',eid='"+eid+"',adh='"+adh+"',phn='"+phn+"',dep='"+dep+"',yr='"+yr+"' where sid='"+sid+"'";
                int aa=obj3.stm.executeUpdate(q1);
                if(aa==1)
                {
                    JOptionPane.showMessageDialog(null, "Successfully");
                    this.setVisible(false);
                    new Update_Student();
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "please! enter full detail");

                }
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
        if(e.getSource()==b2)
        {
            this.setVisible(false);
        }

    }
    public static void main(String args[])
    {
        new Update_Student().setVisible(true);
    }
}
