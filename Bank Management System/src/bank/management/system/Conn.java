package bank.management.system;

import java.sql.*;

public class Conn 
{
     //this class is used for connecting to the database.
     //for connecting to the data base we need to follow some steps.
     
     /*
      * 1. Register the Driver.
      * 2. Create Connection
      * 3. Create Statement
      * 4. Execute Query
      * 5. Close Connection
      */

      Connection c; //declaring a global variable to connect to the data base.
      Statement s;
      public Conn()
      {
        //Since SQL is an external entity so we will use try catch block
        try
        {
          //1. Register the Driver 

          //Class.forName(com.mysql.cj.jdbc.Driver);
          /*Ye uper wala line me mein notice kiye ki possible nahi hai esa error ko resolve krna so esliye by taking a reference from a yt video they suggested to import a javasql library
           * since the library dosent comes with the java default package so i have to import it explicitly and then put it inside the libary of the folloeing project
           */

          c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "0309"); // See jdbc:mysql:/// etna to likhna padega hr baar program me aur eske baad hum log apna data base ka naame enter kenge.
          s = c.createStatement();

        }catch (Exception e)
        {
          System.out.println("Unable to Connect/Save data to Database.");
        }
      }
}
