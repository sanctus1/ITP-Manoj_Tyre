/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customer_compliants_management;

import java.util.Date;

//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;

/**
 *
 * @author Pushpitha
 */
public class Daycal {


    public static long DayGap(Date d1,Date d2) {

        long diff = ((d2.getTime() - d1.getTime()) / 86400000)/30;   //getTime returns the number of milliseconds that have elapsed since Jan 1st 1970

        return diff;
    }
    
    public static long ChkDay(Date d1){
        Date d2 = new Date();
        long diff = (d2.getTime() - d1.getTime()) / 86400000;
        
        return diff;
    }
    
      public static double ValidDay(Date d1){
        Date d2 = new Date();
        long diff = (d2.getTime() - d1.getTime()) / 86400000;
        
        return diff;
    }

}
