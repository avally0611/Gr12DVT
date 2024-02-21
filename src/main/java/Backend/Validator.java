/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import java.io.File;
import java.io.FileNotFoundException;
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
    
}
