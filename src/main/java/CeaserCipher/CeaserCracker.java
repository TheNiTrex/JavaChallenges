/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CeaserCipher;

/**
 *
 * @author ErayC
 */
import java.util.Scanner;
public class CeaserCracker {
    
    private String s; // String obtained from user input
    
    // Used to hold the Ceaser Cipher shift value, obtained from user input, To be converted to int:
    private String inputshiftval;
    
    private int shiftval; // After coversion from String
    private int length; // Used to hold length value of s
    
    private char[] ch; // Used to convert value of s to char array
    private char c; // Used to hold a char from ch
    
    private String result; // Result of encryption/decryption
    private int castedval; // Used to convert (cast) values of ch into int (ASCII values)
    private char newcastedval; // Used to convert shifted casted value back into char
    
    Scanner keyboard = new Scanner (System.in); //Creates a new Scanner Instance
    
    public void encrypt() {
        
        System.out.println("Enter a value to encrypt"); 
        s = keyboard.nextLine();
        
        System.out.println("Enter a shift value"); 
        inputshiftval = keyboard.nextLine();
        shiftval = Integer.parseInt(inputshiftval);
        
        // Validate shift value:
        if (shiftval > 26) { 
            // If the shift value is greater than 26 (Number of letters in the English Alphabet), use modulo to
            // get the value back into bounds
            shiftval = shiftval % 26;
            
        } else if (shiftval < 0) {
            // If the shift value is less than 0, use modulo to get the value back into bounds:            
            shiftval = shiftval % 26;
            
        }   
        
        System.out.println(engine(shiftval, s));
        
    } 
    
    public void decrypt() {
        
        System.out.println("Enter your encrypted value"); 
        s = keyboard.nextLine();
        
        for (int x = 1; x < 26; x ++) {
            
            shiftval = x;   
            System.out.println(engine(shiftval, s));    
        
        }
    } 
    
    public String engine(int shiftval, String s) { // Drives Encryption/Decryption
        
        s = s.toLowerCase(); // To only deal w/ lowercase ASCII values
        s = s.replaceAll(" ", ""); // Remove all whitespace
        
        length = s.length();
        ch = s.toCharArray();
        result = "";
        
        for (int i = 0; i < length; i++) {
            
            c = ch[i];
            
            castedval = (int) c; // Casting process into integer
            castedval += shiftval;
            
            // Validate cast value, keep it within lowercase ASCII character bounds:
            if (castedval > 122) {

                castedval -= 26;
                
            } else if (castedval < 97) {
                
                castedval +=26;
                
            }
            
            newcastedval = (char) castedval; // Casting process back into character
            result += newcastedval;
            
        }   
        
        return result;
        
    }
}
