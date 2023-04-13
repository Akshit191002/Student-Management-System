
package Student_Management;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Update_Fees extends JFrame implements ActionListener
{
    Font f,f1;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
    Choice c;
    JButton b1,b2;
    JPanel p1,p2,p3;
    JTextField t1,t2,t3,t4,t5,t6,t7;
    
    Update_Fees()
    {
        super("Fees");
        setSize(950,700);
        setLocation(100,100);
        setResizable(false);
        
        
        f=new Font("Arial",Font.BOLD,18);
        f1=new Font("Arial",Font.BOLD,25);
        
        l1=new JLabel("Select Student ID");
        l2=new JLabel("Name");
        l3=new JLabel("Department");
        l4=new JLabel("Year");
        l5=new JLabel("Email");
        l6=new JLabel("Fees");
        l7=new JLabel("Pending Fees");
        l8=new JLabel("Date of Submition");
        l9=new JLabel("Student Fees");
        l9.setHorizontalAlignment(JLabel.CENTER);
        
        c=new Choice();
         try
        {
            ConnectionClass obj=new ConnectionClass();
            String q="select sid from Student ";
            ResultSet rest= obj.stm.executeQuery(q);
            while(rest.next())
            {
                c.add(rest.getString("sid"));
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        l1.setFont(f);
        l2.setFont(f);
        l3.setFont(f);
        l4.setFont(f);
        l5.setFont(f);
        l6.setFont(f);
        l7.setFont(f);
        l8.setFont(f);
        l9.setFont(f1);
        c.setFont(f);
        
        t1=new JTextField();
        t2=new JTextField();
        t3=new JTextField();
        t4=new JTextField();
        t5=new JTextField();
        t6=new JTextField();
        t7=new JTextField();
        
        t1.setFont(f);
        t2.setFont(f);
        t3.setFont(f);
        t4.setFont(f);
        t5.setFont(f);
        t6.setFont(f);
        t7.setFont(f);
        
        t1.setEditable(false);
        t2.setEditable(false);
        t3.setEditable(false);
        t4.setEditable(false);
        
        ImageIcon ic=new ImageIcon(ClassLoader.getSystemResource("Student_Management/Icon/update.jpg"));
        Image img=ic.getImage().getScaledInstance(400, 650, Image.SCALE_DEFAULT);
        ImageIcon ic1= new ImageIcon(img);
        l10=new JLabel(ic1);
        
        b1=new JButton("Submit");
        b2=new JButton("Close");
        b1.setFont(f);
        b2.setFont(f);
        b1.setBackground(Color.BLACK);
        b2.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b2.setForeground(Color.WHITE);
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        p1=new JPanel();
        p1.setLayout(new GridLayout(11,2,10,10));
        p1.add(l1); 
        p1.add(c); 
        p1.add(l2); 
        p1.add(t1); 
        p1.add(l3); 
        p1.add(t2); 
        p1.add(l4); 
        p1.add(t3); 
        p1.add(l5); 
        p1.add(t4); 
        p1.add(l6); 
        p1.add(t5); 
        p1.add(l7); 
        p1.add(t6); 
        p1.add(l8); 
        p1.add(t7); 
        p1.add(b1); 
        p1.add(b2); 
         
        p2=new JPanel();
        p2.setLayout(new GridLayout(1,1,10,10));
        p2.add(l10);
        
        p3=new JPanel();
        p3.setLayout(new GridLayout(1,1,10,10));
        p3.add(l9);
        
        setLayout(new BorderLayout(30,30));
        
        add(p1,"Center");
        add(p2,"West");
        add(p3,"North");

        c.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent arg0)
            {
                try
                {
                    ConnectionClass obj2=new ConnectionClass();
                    String sid=c.getSelectedItem();
                    String q1="select * from Student where sid='"+sid+"'";
                    ResultSet rest1= obj2.stm.executeQuery(q1);
                    while(rest1.next())
                    {
                        t1.setText(rest1.getString("name"));
                        t2.setText(rest1.getString("dep"));
                        t3.setText(rest1.getString("yr"));
                        t4.setText(rest1.getString("eid"));
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
        if(e.getSource()==b1)
        {
            String sid=c.getSelectedItem();
            String name=t1.getText();
            String dep=t2.getText();
            String yr=t3.getText();
            String eid=t4.getText();
            String fees=t5.getText();
            String pen=t6.getText();
            String sub=t7.getText();
            try
            {
                ConnectionClass obj1=new ConnectionClass();
                String q1="insert into fee values('"+0+"','"+sid+"','"+name+"','"+dep+"','"+yr+"','"+eid+"','"+fees+"','"+pen+"','"+sub+"')";
                int aa=obj1.stm.executeUpdate(q1);
                if(aa==1)
                {
                    JOptionPane.showMessageDialog(null, "Successfully");
                    this.setVisible(false);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "please! enter full detail");
                    this.setVisible(false);
                    this.setVisible(true);
                }
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
        if(e.getSource()==b2)
        {
            JOptionPane.showMessageDialog(null, "Are you Sure ?");
            this.setVisible(false);
        }

    }
    public static void main(String[] args)
    {
        new Update_Fees().setVisible(true);
    }
    
}
