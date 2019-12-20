/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PurchasingPackage;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 *
 * @author dilshani
 */
public class Pvalidate {
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author Pushpitha
 */
    
    public static boolean isValidNum(String id){
        
          String idPattern="^[0-9]{2,10}$";
          
          Pattern pattern=Pattern.compile(idPattern);
          Matcher Regexmatcher=pattern.matcher(id);
          
          if(!Regexmatcher.matches())
          {
              return false;
          }
          else
          {
              return true;
          }
    }
    
    //validate name
    public static boolean isValidName(String name) {
        
        if(!name.matches("[a-zA-Z ]+")){
            return false;
        }
        else
            return true;
    }

    //date validation
    public static boolean isvaliddate(String date)
    {
        DateFormat df = new SimpleDateFormat("dd/mm/yyyy");
        Date D=null;
        df.setLenient(false);
        try {
            D=df.parse(date);
            return true;
        } catch (Exception e) {
            return false;
        }
    
    }
    
   
    
    


    
}
