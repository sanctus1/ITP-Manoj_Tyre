/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Rasika
 */
public class DB {
    public static int reorder_int = 10;
    static String url = "jdbc:mysql://localhost:3306/manojtyre";//

    public static Connection con(String sql) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, "root", "");
        return con;
    }

    public ResultSet getData(String sql) throws Exception {
        Statement st = DB.con(sql).createStatement();
        ResultSet rset = st.executeQuery(sql);
        DB.con(sql).createStatement().close();
        DB.con(sql).close();
        return rset;
    }

    public boolean putData(String sql) throws Exception {
        Statement st = DB.con(sql).createStatement();
        int numRows = st.executeUpdate(sql);
        DB.con(sql).createStatement().close();
        DB.con(sql).close();
        return numRows > 0;
    } 

}
