/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Employee_AttendanceMng_Package;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Roshli
 */
public class Validate {
    
    private boolean s4;
    
     public static boolean validateEmail(String email) 
      {                 
	boolean status=false;    
       	String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
       	Pattern pattern = Pattern.compile(EMAIL_PATTERN);
       	Matcher matcher=pattern.matcher(email);
       	if(matcher.matches())
       	{
           status=true;
       	}
       	else
	{
           status=false;
       	}
           return status;
            
    }
     public static boolean validateNic(String Nic)
     {
         boolean status2 = false;
         if((Nic.length()==10)&&(Nic.charAt(9)=='V'||Nic.charAt(9)=='v'))
         {
             for(int i = 0; i< 10; i++)
             {
                 if(Character.isDigit(Nic.charAt(i)))
                     status2 = true;
             }
             
         }
         else
                status2 = false;
         
         return status2;
     }
     public static boolean validateName(String name)
     {
         boolean status = false;
         for(int i = 0; i< name.length(); i++)
         {
             if(Character.isAlphabetic(name.charAt(i)))
                 status = true;
             else 
                 status  = false;
         }
         return status;
     }
     
     public static boolean validateTpNo(String tp)
     {
         boolean status3 = false;
         
         
             for(int i = 0; i< tp.length(); i++)
             {
                 if(Character.isDigit(tp.charAt(i)) && tp.length()==10)
                     status3 = true;
                 else 
                     status3 =false;
             }
         
         return status3;
     }
     
     public static boolean validateDate(String date)
     {
         boolean status=false;    
//       	String DATE_PATTERN = "\\d{3}-\\d{1}-\\d{4}";;
//       	Pattern pattern = Pattern.compile(DATE_PATTERN);
//       	Matcher matcher=pattern.matcher(date);
//       	if(matcher.matches())
//       	{
//           status=true;
//       	}
//       	else
//	{
//           status=false;
//       	}
//           return status;
         
         if(date=="")
         {
             return true;
         }
         else 
             return false;
     }
     
     public static boolean check_Null(String field)
     {
         boolean status = true;
         if(field.isEmpty())
             return status = false;
         else
             return status;
     }
     public static boolean validate_EmpID(String Emp_ID)
     {
         boolean status2 = false;
         int size=9;
         if((Emp_ID.length()>= size)&&(Emp_ID.charAt(1)=='W'||Emp_ID.charAt(1)=='w') && (Emp_ID.charAt(2)=='A'||Emp_ID.charAt(2)=='a'))
         {
             for(int i = 0; i< 10; i++)
             {
                 if(Character.isDigit(Emp_ID.charAt(i)))
                     status2 = true;
             }
             
         }
         else if((Emp_ID.length() >= size)&&(Emp_ID.charAt(1)=='O'||Emp_ID.charAt(1)=='o') && (Emp_ID.charAt(2)=='E'||Emp_ID.charAt(2)=='e')){
             
             for(int i = 0; i< 10; i++)
             {
                 if(Character.isDigit(Emp_ID.charAt(i)))
                     status2 = true;
             }
         }
         else if((Emp_ID.length() >= size)&&(Emp_ID.charAt(1)=='M'||Emp_ID.charAt(1)=='m') && (Emp_ID.charAt(2)=='N'||Emp_ID.charAt(2)=='n')){
             for(int i = 0; i< 10; i++)
             {
                 if(Character.isDigit(Emp_ID.charAt(i)))
                     status2 = true;
             }
         }
         else
                status2 = false;
         
         return status2;
     }
     
     

}
