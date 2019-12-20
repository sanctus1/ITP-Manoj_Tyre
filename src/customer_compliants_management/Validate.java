/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customer_compliants_management;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Pushpitha
 */
public class Validate {
    
    public static boolean isValidNum(String id){
        
          String idPattern="^[0-9]{1,2}$";
          
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
    
        public static boolean isValidComId(String id){
        
          String idPattern="^[0-9]{1,20}$";
          
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
       
       public static boolean isValidFloat(String name) {
        
        if(!name.matches("[0-9]*\\.[0-9]{2}")){
            return false;
        }
        else
            return true;
    }
       
        public static boolean isValidTyreDepth(String name) {
        
        if(!name.matches("[0-9]*\\.?[0-9]+")){
            return false;
        }
        else
            return true;
    }
        
       public static boolean isValidCost(String name) {
        
        if(!name.matches("[0-9]*\\.[0-9]{2}")){
            return false;
        }
        else
            return true;
    }
    
    //validate String
    public static boolean isValidName(String name) {
        
        if(!name.matches("[a-zA-Z ]+")){
            return false;
        }
        else
            return true;
    }

     public static boolean isValidNameNum(String name) {
        
        if(!name.matches("[a-zA-Z0-9]+")){
            return false;
        }
        else
            return true;
    }
  
}
