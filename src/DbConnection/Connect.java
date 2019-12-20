/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DbConnection;


import com.mysql.jdbc.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Teshan Chathushka
 */
public class Connect {
    public static Connection connectn()
    {
        Connection conn=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/manojtyre","root","");
            
        } catch (Exception e) {
            System.out.println("Error...Connection is Down"+e);
        }
        
        return conn;
    }
}
