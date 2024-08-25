package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener //the moment we do this we have to override a method of ActionListener
{

    //declaring all this variable objects globally because for storing the data in the data base we need to make these variables global. If we don't do this then the data values will not be stored because the values associated to these variables will only be accessable to the given class.
    
    JTextField aadharTextField, panTextField;
    JButton next;
    JRadioButton eNo, eYes, sNo, sYes;
    JRadioButton male, female, other, married, unmarried;
    JComboBox religions, categorys, incomes, education, occupations;
    static String formno;
    

    SignupTwo(String formno)
    {
        this.formno = formno;
        setLayout(null);

        setTitle("New Account Application Form - Page-2");
      
        JLabel additionalDetails = new JLabel("Page-2: Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 38));
        additionalDetails.setBounds(180, 20, 600, 40);
        add(additionalDetails);

        JLabel religion = new JLabel("Religion: ");
        religion.setFont(new Font("Raleway", Font.BOLD, 20));
        religion.setBounds(100, 140, 100, 30);
        add(religion);

        String valReligion[] = {"Hindu", "Muslim", "Sikh", "Christian", "Other"};
        religions = new JComboBox(valReligion);
        religions.setBounds(300, 140, 400, 30);
        religions.setBackground(Color.WHITE);
        add(religions);

        JLabel category = new JLabel("Category: ");
        category.setFont(new Font("Raleway", Font.BOLD, 20));
        category.setBounds(100, 190, 200, 30);
        add(category);

        String valCategory[] = {"General", "OBC", "SC", "ST", "EWS", "Others"};
        categorys = new JComboBox(valCategory);
        categorys.setBounds(300, 190, 400, 30);
        categorys.setBackground(Color.WHITE);
        add(categorys);

        JLabel income = new JLabel("Income: ");
        income.setFont(new Font("Raleway", Font.BOLD, 20));
        income.setBounds(100, 240, 200, 30);
        add(income);

        String valIncome[] = {"Null", "< 1,50,000", "< 2,50,000", "< 5,00,000", "Upto 10,00,000"};
        incomes = new JComboBox(valIncome);
        incomes.setBounds(300, 240, 400, 30);
        incomes.setBackground(Color.WHITE);
        add(incomes);

        JLabel educational = new JLabel("Educational/ ");
        educational.setFont(new Font("Raleway", Font.BOLD, 20));
        educational.setBounds(100, 290, 200, 30);
        add(educational);

        JLabel qualification = new JLabel("Qualification: ");
        qualification.setFont(new Font("Raleway", Font.BOLD, 20));
        qualification.setBounds(100, 315, 200, 30);
        add(qualification);
        
        String valEduaction[] = {"Primary Education", "Secondary Education", "Higher Secondary Education", "Bachelor of Arts (B.A.)", "Bachelor of Science (B.Sc.)", "Bachelor of Commerce (B.Com.)", "Bachelor of Technology (B.Tech.)", "Bachelor of Engineering (B.E.)", "Bachelor of Computer Applications (B.C.A.)", "Bachelor of Business Administration (B.B.A.)", "Bachelor of Fine Arts (B.F.A.)", "Bachelor of Design (B.Des.)", "Bachelor of Architecture (B.Arch.)", "Bachelor of Medicine, Bachelor of Surgery (M.B.B.S.)", "Bachelor of Dental Surgery (B.D.S.)", "Bachelor of Ayurvedic Medicine and Surgery (B.A.M.S.)", "Bachelor of Homeopathic Medicine and Surgery (B.H.M.S.)", "Bachelor of Pharmacy (B.Pharm.)", "Bachelor of Physiotherapy (B.P.T.)", "Bachelor of Law (L.L.B.)", "Master of Arts (M.A.)", "Master of Science (M.Sc.)", "Master of Commerce (M.Com.)", "Master of Technology (M.Tech.)", "Master of Engineering (M.E.)", "Master of Computer Applications (M.C.A.)", "Master of Business Administration (M.B.A.)", "Master of Fine Arts (M.F.A.)", "Master of Design (M.Des.)", "Master of Architecture (M.Arch.)", "Master of Dental Surgery (M.D.S.)", "Master of Pharmacy (M.Pharm.)", "Master of Physiotherapy (M.P.T.)", "Master of Law (L.L.M.)", "Doctor of Philosophy (Ph.D.)", "Doctor of Science (D.Sc.)", "Postgraduate Diploma", "Diploma in Engineering", "Diploma in Education", "Diploma in Nursing", "Diploma in Pharmacy", "Certificate Course", "Vocational Training", "ITI (Industrial Training Institute)", "Polytechnic Diploma", "Chartered Accountant (C.A.)", "Company Secretary (C.S.)", "Cost and Management Accountant (C.M.A.)"};
          
        education = new JComboBox(valEduaction);
        education.setBounds(300, 303, 400, 30);
        education.setBackground(Color.WHITE);
        add(education);

        JLabel occupation = new JLabel("Occupation: ");
        occupation.setFont(new Font("Raleway", Font.BOLD, 20));
        occupation.setBounds(100, 390, 200, 30);
        add(occupation);

        String valOccupation[] = {"Business Man", "Software Engineer", "Doctor", "Teacher", "Housewife", "Househusband", "Lawyer", "Accountant", "Architect", "Civil Engineer", "Mechanical Engineer", "Electrical Engineer", "Nurse", "Pharmacist", "Police Officer", "Firefighter", "Soldier", "Journalist", "Photographer", "Chef", "Artist", "Musician", "Actor", "Dancer", "Writer", "Editor", "Scientist", "Researcher", "Professor", "Lecturer", "Banker", "Clerk", "Driver", "Pilot", "Flight Attendant", "Tour Guide", "Event Planner", "Interior Designer", "Fashion Designer", "Graphic Designer", "Web Developer", "Digital Marketer", "Data Scientist", "Statistician", "Economist", "Financial Analyst", "Investment Banker", "Stock Broker", "Insurance Agent", "Real Estate Agent", "Social Worker", "NGO Worker", "Government Employee", "Consultant", "Entrepreneur", "Freelancer", "Content Writer", "Translator", "Customer Service Representative", "IT Support Specialist", "Electrician", "Plumber", "Carpenter", "Mechanic", "Farmer", "Fisherman", "Construction Worker", "Tailor", "Beautician", "Hair Stylist", "Makeup Artist", "Barber", "Waiter", "Bartender", "Receptionist", "Salesperson", "Store Manager", "Marketing Manager", "Project Manager", "Product Manager", "Quality Analyst", "Health Inspector", "Veterinarian", "Librarian", "Yoga Instructor", "Fitness Trainer", "Dietitian", "Physiotherapist", "Chiropractor", "Psychologist", "Psychiatrist", "Radiologist", "Dentist", "Optometrist", "Speech Therapist", "Occupational Therapist"};  
        occupations = new JComboBox(valOccupation);
        occupations.setBounds(300, 390, 400, 30);
        occupations.setBackground(Color.WHITE);
        add(occupations);

        JLabel panno = new JLabel("PAN No: ");
        panno.setFont(new Font("Raleway", Font.BOLD, 20));
        panno.setBounds(100, 440, 200, 30);
        add(panno);

        panTextField = new JTextField();
        panTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        panTextField.setBounds(300, 440, 400, 30);
        add(panTextField);

        JLabel aadharno = new JLabel("Aadhar No: ");
        aadharno.setFont(new Font("Raleway", Font.BOLD, 20));
        aadharno.setBounds(100, 490, 200, 30);  
        add(aadharno);

        aadharTextField = new JTextField();
        aadharTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        aadharTextField.setBounds(300, 490, 400, 30);
        add(aadharTextField);

        JLabel seniorCitizen = new JLabel("Senior Citizen: ");
        seniorCitizen.setFont(new Font("Raleway", Font.BOLD, 20));
        seniorCitizen.setBounds(100, 540, 200, 30);
        add(seniorCitizen);

        sYes = new JRadioButton("Yes");
        sYes.setBounds(300, 540, 100, 30);
        sYes.setBackground(Color.WHITE);
        add(sYes);

        sNo = new JRadioButton("No");
        sNo.setBounds(450, 540, 100, 30);
        sNo.setBackground(Color.WHITE);
        add(sNo);

        ButtonGroup sGroup = new ButtonGroup();
        sGroup.add(sYes);
        sGroup.add(sNo);

        JLabel existingAccount = new JLabel("Existing Account: ");
        existingAccount.setFont(new Font("Raleway", Font.BOLD, 20));
        existingAccount.setBounds(100, 590, 400, 30);
        add(existingAccount);

        eYes = new JRadioButton("Yes");
        eYes.setBounds(300, 590, 100, 30);
        eYes.setBackground(Color.WHITE);
        add(eYes);

        eNo = new JRadioButton("No");
        eNo.setBounds(450, 590, 100, 30);
        eNo.setBackground(Color.WHITE);
        add(eNo);

        ButtonGroup eGroup = new ButtonGroup();
        eGroup.add(eYes);
        eGroup.add(eNo);

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        add(next);

        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);
    }

    public void actionPerformed(ActionEvent ae)
    {
         //the variable randon generates a long value so to cinvert it into stirng we just did this "", this automatically converts it into string.
        String religion = (String) religions.getSelectedItem();
        String category = (String) categorys.getSelectedItem();
        String income = (String) incomes.getSelectedItem();
        String qualification = (String) education.getSelectedItem();
        String occupation = (String) occupations.getSelectedItem();
        
        String seniorCitizen = null;
        if(sYes.isSelected())
        {
            seniorCitizen = "Yes";
        }
        else if(sNo.isSelected())
        {
            seniorCitizen = "No";
        }

        String existAccount = null;
        if(eYes.isSelected())
        {
            existAccount = "Yes";
        }
        else if(eNo.isSelected())
        {
            existAccount = "No";
        }

        String panno = panTextField.getText();
        String aadharno = aadharTextField.getText();

        try
        {
            Conn c = new Conn();
            String query = "insert into signupTwo values('"+formno+"', '"+religion+"', '"+category+"', '"+income+"', '"+qualification+"', '"+occupation+"', '"+panno+"', '"+aadharno+"', '"+seniorCitizen+"', '"+existAccount+"')";
            c.s.executeUpdate(query);

            //signup3 Object
            setVisible(false);
            new SignupThree(formno).setVisible(true);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    public static void main(String[] args) 
    {
        new SignupTwo("");
    }    
}
