package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class PinChange extends JFrame implements ActionListener
{

    JPasswordField pin, rePin;
    JButton back, change;
    String pinNumber;
    
    PinChange(String pinNumber)
    {
        this.pinNumber = pinNumber;


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setForeground(Color.WHITE);
        text.setBounds(270, 280,500, 35);
        image.add(text);

        JLabel pinText = new JLabel("New PIN: ");
        pinText.setForeground(Color.WHITE);
        pinText.setFont(new Font("System", Font.BOLD, 16));
        pinText.setBounds(165, 320,180, 25);
        image.add(pinText);

        pin = new JPasswordField();
        pin.setFont(new Font("Raleway", Font.BOLD, 25));
        pin.setBounds(330, 320, 180, 25);
        image.add(pin);

        JLabel rePinText = new JLabel("Re--Enter New PIN: ");
        rePinText.setForeground(Color.WHITE);
        rePinText.setFont(new Font("Raleway", Font.BOLD, 16));
        rePinText.setBounds(165, 360,180, 25);
        image.add(rePinText);

        rePin = new JPasswordField();
        rePin.setFont(new Font("Raleway", Font.BOLD, 25));
        rePin.setBounds(330, 360, 180, 25);
        image.add(rePin);

        change = new JButton("CHANGE");
        change.setBounds(355, 485, 150, 30);
        change.addActionListener(this);
        image.add(change);

        back = new JButton("BACK");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);

        setSize(900, 900);
        setLocation(300, 0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == change)
        {
            try
            {   
                String npin = new String(pin.getPassword());
                String rpin = new String(rePin.getPassword());

                if(!npin.equals(rpin))
                {
                    JOptionPane.showMessageDialog(null, "Entered PIN dose not match.");
                    return;
                }

                if(npin.equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Please Enter new PIN.");
                    return;
                }

                if(rpin.equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Please re-enter new PIN.");
                    return;
                }

                Conn conn = new Conn();
                //String query1 = "Update bank set Pin = '"+rpin+"' where pin = '"+pinNumber+"' ";
                String query2 = "Update Login set PinNumber = '"+rpin+"' where PinNumber = '"+pinNumber+"' ";
                String query3 = "Update SignUpThree set PinNumber = '"+rpin+"' where PinNumber = '"+pinNumber+"' ";

                //conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null, "PIN Changed successfully.");

                setVisible(false);
                new Transactions(rpin).setVisible(true);

            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }

    }


    public static void main(String[] args)
    {
        new PinChange(" ").setVisible(true);
    }
}
