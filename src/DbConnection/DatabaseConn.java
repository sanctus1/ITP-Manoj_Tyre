/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DbConnection;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Roshli
 */
public class DatabaseConn {
    
    
    public static Connection connect()
    {
       Connection cnct =null; 
       
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cnct = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/manojtyre","root","");
        } catch (Exception e) {
            System.out.println("No connection to the database");
            System.out.println(e);
        }
        
        return cnct;
    }
        
}
