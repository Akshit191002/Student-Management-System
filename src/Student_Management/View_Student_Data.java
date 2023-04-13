
package Student_Management;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class View_Student_Data implements ActionListener
{
    JFrame f;
    JLabel id,aid,id1,aid1,id2,aid2,id3,aid3,id4,aid4,id5,aid5,id6,aid6,id7,aid7,id8,id9,id10,aid10;
    JButton b1,b2;
    String sid,name,f_name,address,phn,eid,Dep,yr,adh,dob;
    
        
    View_Student_Data(String std_id)
    {
        try
        {
            ConnectionClass obj=new ConnectionClass();
            String s="select * from Student where sid='"+std_id+"'";
            ResultSet rs= obj.stm.executeQuery(s);
            
            while(rs.next())
            {
                name=rs.getString("name");
                f_name=rs.getString("fname");
                dob=rs.getString("dob");
                address=rs.getString("address");
                Dep=rs.getString("dep");
                yr=rs.getString("yr");
                phn=rs.getString("phn");
                sid=rs.getString("sid");
                eid=rs.getString("eid");
                
                adh=rs.getString("adh");

            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        f=new JFrame("Display");
        f.setVisible(true);
        f.setSize(650,700);
        f.setLocation(450,200);
        f.setBackground(Color.WHITE);
        f.setLayout(null);
        
        id9=new JLabel();
        id9.setBounds(0,0,650,700);
        id9.setLayout(null);
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("Student_Management/Icon/details.jpg"));
        id9.setIcon(img);
        
        id8=new JLabel("Student Details");
        id8.setBounds(170,10,250,40);
        id8.setForeground(Color.BLACK);
        id8.setFont(new Font("Airal",Font.BOLD,28));
        f.add(id8);
        id9.add(id8);
        f.add(id9);
        
        id=new JLabel("Student ID : ");
        id.setBounds(150,70,120,30);
        id.setFont(new Font("serif",Font.BOLD,20));
        id9.add(id);
        aid=new JLabel(sid);
        aid.setBounds(330,70,200,30);
        aid.setFont(new Font("serif",Font.BOLD,20));
        id9.add(aid);
        
        id1=new JLabel("Name : ");
        id1.setBounds(150,120,100,30);
        id1.setFont(new Font("serif",Font.BOLD,20));
        id9.add(id1);
        aid1=new JLabel(name);
        aid1.setBounds(330,120,300,30);
        aid1.setFont(new Font("serif",Font.BOLD,20));
        id9.add(aid1);
        
        id2=new JLabel("Date of Birth : ");
        id2.setBounds(150,170,200,30);
        id2.setFont(new Font("serif",Font.BOLD,20));
        id9.add(id2); 
        aid2=new JLabel(dob);
        aid2.setBounds(330,170,300,30);
        aid2.setFont(new Font("serif",Font.BOLD,20));
        id9.add(aid2);
        
        id3=new JLabel("Father Name : ");
        id3.setBounds(150,220,200,30);
        id3.setFont(new Font("serif",Font.BOLD,20));
        id9.add(id3);
        aid3=new JLabel(f_name);
        aid3.setBounds(330,220,200,30);
        aid3.setFont(new Font("serif",Font.BOLD,20));
        id9.add(aid3);
        
        id4=new JLabel("Address : ");
        id4.setBounds(150,270,200,30);
        id4.setFont(new Font("serif",Font.BOLD,20));
        id9.add(id4);
        aid4=new JLabel(address);
        aid4.setBounds(330,270,200,30);
        aid4.setFont(new Font("serif",Font.BOLD,20));
        id9.add(aid4);
        
        id5=new JLabel("Phone No. : ");
        id5.setBounds(150,320,200,30);
        id5.setFont(new Font("serif",Font.BOLD,20));
        id9.add(id5);  
        aid5=new JLabel(phn);
        aid5.setBounds(330,320,200,30);
        aid5.setFont(new Font("serif",Font.BOLD,20));
        id9.add(aid5);
        
        id6=new JLabel("Department : ");
        id6.setBounds(150,370,120,30);
        id6.setFont(new Font("serif",Font.BOLD,20));
        id9.add(id6);
        aid6=new JLabel(Dep);
        aid6.setBounds(330,370,200,30);
        aid6.setFont(new Font("serif",Font.BOLD,20));
        id9.add(aid6);
        
        id7=new JLabel("Email ID : ");
        id7.setBounds(150,420,120,30);
        id7.setFont(new Font("serif",Font.BOLD,20));
        id9.add(id7);
        aid7=new JLabel(eid);
        aid7.setBounds(330,420,200,30);
        aid7.setFont(new Font("serif",Font.BOLD,20));
        id9.add(aid7);
        
        id10=new JLabel("Aadhar : ");
        id10.setBounds(150,470,120,30);
        id10.setFont(new Font("serif",Font.BOLD,20));
        id9.add(id10);
        aid10=new JLabel(adh);
        aid10.setBounds(330,470,200,30);
        aid10.setFont(new Font("serif",Font.BOLD,20));
        id9.add(aid10);
        
        b1=new JButton("Print");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(160,520,100,30);
        b1.addActionListener(this);
        id9.add(b1);
        
        b2=new JButton("Cancel");
        b2.setBackground(Color.RED);
        b2.setForeground(Color.WHITE);
        b2.setBounds(350,520,100,30);
        b2.addActionListener(this);
        id9.add(b2);
    }
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource()==b1)
        {
            JOptionPane.showMessageDialog(null, "Successfully");
            f.setVisible(false);
            new HomePage();
        }
        if(e.getSource()==b2)
        {
            f.setVisible(false);
            new View_Student();
        }
    }
}
