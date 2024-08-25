package bank.management.system;

import javax.swing.*;  //JFrame is in the extended package of java swing
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener
{

    JButton deposit, withdrawl, fastCash, miniStatement, pinChange, balanceEnquiry, exit;
    String pinNumber; 

    FastCash(String pinNumber)
    {
        this.pinNumber = pinNumber; 

        //this line is used to remove all the default layouts because we need to make our own layout so thats why we have used this function
        setLayout(null);
        
        //these codes are for importing the image into the screen and these include with some image styling attributes.
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        //This is used to dislay the label on the screen it will act like a short msg which will guide the user how to and what to do here.
        JLabel text = new JLabel("Select Withdrawl Amount.");
        text.setBounds(215, 300, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text); //ye esliye kiye kyunki humlog ko image ke uper me text dikhana tha agar ese nahi krte to text image ke niche show hota joki user keliye available nahi hota.


        //all these are the JButtons on these we will apply the actionListner.
        deposit = new JButton("Rs. 100");
        deposit.setBounds(170, 415, 150, 30);
        deposit.addActionListener(this);
        image.add(deposit);

        withdrawl = new JButton("Rs. 500");
        withdrawl.setBounds(355, 415, 150, 30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);

        fastCash = new JButton("Rs. 1000");
        fastCash.setBounds(170, 450, 150, 30);
        fastCash.addActionListener(this);
        image.add(fastCash);

        miniStatement = new JButton("Rs. 2000");
        miniStatement.setBounds(355, 450, 150, 30);
        miniStatement.addActionListener(this);
        image.add(miniStatement);

        pinChange = new JButton("Rs. 5000");
        pinChange.setBounds(170, 485, 150, 30);
        pinChange.addActionListener(this);
        image.add(pinChange);

        balanceEnquiry = new JButton("Rs. 10000");
        balanceEnquiry.setBounds(355, 485, 150, 30);
        balanceEnquiry.addActionListener(this);
        image.add(balanceEnquiry);

        exit = new JButton("BACK");
        exit.setBounds(355, 520, 150, 30);
        exit.addActionListener(this);
        image.add(exit);

        //bellow lines are to define the view window size, location, and visibility.
        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);   //this will remove the top bar of your application.
        setVisible(true);

    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == exit)
        {
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }
        else
        {
            //The line ((JButton)ae.getSource()).getText() will give the Text of the button but it is Rs 500 the first three char of the string is not needed so now we will do one thing we will trim that perticular part by using .substring(3);
            String amount = ((JButton)ae.getSource()).getText().substring(4);
            Conn c = new Conn();

            try
            {
                ResultSet rs = c.s.executeQuery("Select * From bank where pin = '"+pinNumber+"'");
                int balance = 0;

                while(rs.next())    //rs.next()  this function will retrun the result set from the database.
                {
                    if(rs.getString("type").equals("Deposit")) // sb row me dekh rahe hai ki type agar deposit hai to wahan se amount utha dena hai.
                        balance += Integer.parseInt(rs.getString("amount"));

                    else
                        balance -= Integer.parseInt(rs.getString("amount"));
                }

                if(ae.getSource() != exit && balance < Integer.parseInt(amount))
                {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }

                Date date = new Date();
                String query = "Insert into bank values('"+pinNumber+"', '"+date+"', 'Withdrawl', '"+amount+"')" ;
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs "+amount+" Debited Successfully");

                setVisible(false);
                new Transactions(pinNumber).setVisible(true);

            }catch (Exception e)
            {
                System.out.println(e);
            }
        }


    }
    public static void main(String [] args)
    {
        new FastCash("");
    }    
}



/*
    else if(ae.getSource() == deposit)
        {
            setVisible(false);
            new Deposit(pinNumber).setVisible(true);
        }
        else if(ae.getSource() == withdrawl)
        {
            setVisible(false);
            new Withdrawl(pinNumber).setVisible(true);
        }
 */