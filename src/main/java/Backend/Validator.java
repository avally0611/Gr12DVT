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
import javax.swing.JOptionPane;

/**
 *
 * @author aaminahv
 */
public class Validator 
{
   
    public static boolean idExists(String id)
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
            JOptionPane.showMessageDialog(null, "The file being read from could not be found", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        return exists;
    }
    
    public static boolean idLength(String id)
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
        
        for (int i = 0; i < name.length(); i++) 
        {
            char let = name.charAt(i);
            
            if (!Character.isLetter(let) && let != '-' && !Character.isWhitespace(let))
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
    
    //logic test
    public static boolean dobVerify(LocalDate dt, String id)
    {
        String idDob = id.substring(0,6);
        DateTimeFormatter inputdt = DateTimeFormatter.ofPattern("yyMMdd");
        
        LocalDate idDt = LocalDate.parse(idDob, inputdt);
        
        if (idDt.equals(dt))
        {
            return true;
        }
        
        return false;
    }
    
    
    
}
