
package Student_Management;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Delete_Student extends JFrame implements ActionListener 
{
    JTable t;
    JButton b1;
    JTextField t1;
    JPanel p1,p2,p3;
    String x[]={"Student ID","Name","Last Name","Email","Department","Year"};
    String y[][]=new String [20][6];
    int i=0,j=0;
    Font f,f1;
    JLabel l1,l2;
    
    Delete_Student()
    {
       super("Records Of Student");
       setSize(1480,400);
       setLocation(0,10);
       f= new Font("MS UI Gothic",Font.BOLD,17);
       
       try
        {
            ConnectionClass obj=new ConnectionClass();
            String s="select * from Student ";
            ResultSet rs= obj.stm.executeQuery(s);
            
            while(rs.next())
            {
                y[i][j++]=rs.getString("sid");
                y[i][j++]=rs.getString("name");
                y[i][j++]=rs.getString("lname");
                y[i][j++]=rs.getString("eid");
                y[i][j++]=rs.getString("dep");
                y[i][j++]=rs.getString("yr");
                i++;
                j=0;
            }
            t=new JTable(y,x);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
       t.setBackground(Color.BLACK);
       t.setForeground(Color.WHITE);
       t.setFont(f);
       JScrollPane js=new JScrollPane(t);
       
       f1= new Font("Lucida Fax",Font.BOLD,25);
       l1=new JLabel("Delete Student");
       l1.setHorizontalAlignment(JLabel.CENTER);
       l1.setFont(f);
       l1.setForeground(Color.YELLOW);
       
       l2=new JLabel("Student ID");
       l2.setFont(f1);
       l2.setForeground(Color.CYAN);
       
       t1=new JTextField();
       t1.setFont(f);
       b1=new JButton("Delete");
       b1.setFont(f);

       b1.setBackground(Color.BLACK);
       b1.setForeground(Color.WHITE);
       b1.addActionListener(this);
       
       p1=new JPanel();
       p1.setLayout(new GridLayout(1,1,10,10));
       p1.add(l1);
       
       p2=new JPanel();
       p2.setLayout(new GridLayout(1,3,10,10));
       p2.add(l2);
       p2.add(t1);
       p2.add(b1);
       
       p3=new JPanel();
       p3.setLayout(new GridLayout(2,1,10,10));
       p3.add(p1);
       p3.add(p2);
       
       p1.setBackground(Color.BLACK);
       p2.setBackground(Color.BLACK);
       p3.setBackground(Color.BLACK);

       add(p3,"South");
       add(js);
        
    }
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource()==b1)
        {
            String sid=t1.getText();
            try
            {
                ConnectionClass obj=new ConnectionClass();
                String q="delete from Student where sid='"+sid+"'";
                String q1="delete from fee where sid='"+sid+"'";
                int res= obj.stm.executeUpdate(q);
                
                if(res==1)
                {
                    obj.stm.executeUpdate(q1);
                    JOptionPane.showMessageDialog(null, "Your Data Successfully Deleted ");
                    this.setVisible(false);
                    new Delete_Student().setVisible(true);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Sorry !!!");
                    this.setVisible(false);
                    new Delete_Student().setVisible(true);
                }
                
            }
            catch(Exception exx)
            {
                exx.printStackTrace();
            }
        }
        
    }
    public static void main(String[] args)
    {
        new Delete_Student().setVisible(true);
    }
    
}
