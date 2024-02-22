/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aaminahv
 */
public class Validator 
{
   
    public static boolean IDExists(String id)
    {
        boolean exists = false;
        
        try {
            Scanner sc = new Scanner(new File("data/Students"));
            
            while (sc.hasNext())
            {
                String ID = sc.nextLine();
                
                if (id.equals(ID))
                {
                    exists = true;
                }
            }
       
        } 
        catch (FileNotFoundException ex) 
        {
            Logger.getLogger(Validator.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return exists;
    }
    
    public static boolean IDLength(String id)
    {
        if (id.length() == 13)
        {
            return true;
        }
        
        return false;
    }
    
    public static boolean hasSpecialChar(String name)
    {
        boolean hasSpecialChar = false;
        String specChars = "!@#$%^&*()";
        
        for (int i = 0; i < name.length(); i++) 
        {
            char let = name.charAt(i);
            
            if (!Character.isLetter(let))
            {
                hasSpecialChar = true;
            }
            
        }
        
        return hasSpecialChar;
    }
    
    public static boolean validRHBEmail(String email)
    {
        if (email.contains("@reddam.house"))
        {
            return true;
        }
        
        return false;
    }
    
    public static boolean dobVerify(LocalDate dt, String id)
    {
        String idDob = id.substring(0,7);
        DateTimeFormatter inputdt = DateTimeFormatter.ofPattern("yyMMdd");
        
        LocalDate idDt = LocalDate.parse(idDob, inputdt);
        
        if (idDt.equals(dt))
        {
            return true;
        }
        
        return false;
    }
    
}
