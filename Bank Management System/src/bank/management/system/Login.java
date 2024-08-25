package bank.management.system;
 
import java.awt.Image;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

//using the concept of inheritence
public class Login extends JFrame implements ActionListener
{
    JButton login, signup, clear; //i defined these buttons globally because i have to access this in other classes also
    JTextField cardTextField;
    JPasswordField pinTextField;

    Login()
    {
        setTitle("Automated Teller Machine");
        setLayout(null); //by using this we can use custom layout on the frame


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg")); //we use imageIcon class to add image to the frame
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3); //we cannot place aj image or icon directly on the frame so for that we put the image on the JLabel first and the use its object.
        label.setBounds(120, 10, 100, 100);
        add(label);

        //Add text using JLabel
        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward", Font.BOLD, 38));
        text.setBounds(240, 40, 400, 40);
        add(text);


        //card label
        JLabel cardno = new JLabel("Card No:");
        cardno.setFont(new Font("Raleway", Font.BOLD, 28));
        cardno.setBounds(120, 150, 150, 40);
        add(cardno);
        
        cardTextField = new JTextField();
        cardTextField.setBounds(260, 150, 250, 30);
        cardTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(cardTextField);

        
        //pin label
        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD, 28));
        pin.setBounds(150, 220, 400, 40);
        add(pin);

        pinTextField = new JPasswordField();
        pinTextField.setBounds(260, 220, 250, 30);
        pinTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(pinTextField);

        login = new JButton("SIGN IN");
        login.setBounds(260, 300, 100, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        clear = new JButton("CLEAR");
        clear.setBounds(410, 300, 100, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

        signup = new JButton("SIGN UP");
        signup.setBounds(260, 350, 250, 30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);

        //set the bg color of the frame
        getContentPane().setBackground(Color.WHITE);

        //creting frame by using setSize()
        setSize(700, 500); //frame is created but it is corrently hidden
        setVisible(true); //now it makes the frame visible
        setLocation(350, 200); //this helps the frame to open on the specified location on the screen

    }

    //the class ActionListner has a abstract method calleds actionPerformed and to avoide error we are overriding this.
    public void actionPerformed(ActionEvent ae)
    {
        //now we define what action we need to performe after click of function.
        if(ae.getSource() == clear)
        {
            //checking for which buttonn has been clicked
            cardTextField.setText("");
            pinTextField.setText("");
        }
        else if (ae.getSource() == login) 
        {
            Conn conn = new Conn();
            String cardNumber = cardTextField.getText();
            String pinNumber = new String(pinTextField.getPassword());
            String query = "Select * from Login where cardNumber = '"+cardNumber+"' and pinNumber = '"+pinNumber+"' ";
        
            try
            {
                ResultSet rs = conn.s.executeQuery(query);

                if(rs.next())
                {
                    setVisible(false);
                    new Transactions(pinNumber).setVisible(true);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin");
                }
            }
            catch (Exception e)
            {
                System.out.println(e);
            }
        }

        else if(ae.getSource() == signup)
        {
            setVisible(false);
            new SignupOne().setVisible(true);
        }
    }

    public static void main(String[] args) 
    {
        new Login();   //i want that if i run the code then the code should first show to UI part so for that i am creating an object and then creating the constructor because the moment we create an object the constrctor call was made.
    }
}
