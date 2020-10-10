/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VigenereCipher;

/**
 *
 * @author ErayC
 */
import java.util.Scanner;
public class VigenereCracker {
    
    private String m; // Message obtained from user input
    private String k; // Key obtained from user input
    
    private String result; // Result of encryption/decryption
    
    Scanner keyboard = new Scanner(System.in);
    
    public void encrypt() {
        
        System.out.println("Enter a value to encrypt"); 
        m = keyboard.nextLine();
        
        System.out.println("Enter a key");
        k = keyboard.nextLine();
        
        // If the length of the key doesn't match the message, generate a matching-length key:
        if (k.length() != m.length()) k = engine(m, k); 
        
        m = m.toLowerCase(); // To only deal w/ lowercase ASCII values
        m = m.replaceAll(" ", ""); // Remove all whitespace
        
        k = k.toLowerCase();
        
        result = "";
        
        // Cast the converted ASCII value of the message and key into char:
        for (int i = 0; i < m.length(); i++) result += (char) (((m.charAt(i) + k.charAt(i)) % 26) + 'a');
        
        System.out.println(result);
        
    }
    
    public void decrypt() {
        
        System.out.println("Enter your encrypted value"); 
        m = keyboard.nextLine();
        
        System.out.println("Enter its key");
        k = keyboard.nextLine();
        
        result = "";
        
            // Cast reversed ASCII value into char:
        for (int i = 0; i < m.length(); i++) result += (char) ((((m.charAt(i) - k.charAt(i)) + 14) % 26) + 'a');
        
        System.out.println(result);
        
    }
    
    public static String engine(String m, String k) { // Drives Key Generation, if needed
        
        for (int i = 0; k.length() < m.length(); i++) { // Iterate until the length of key matches message
            // Once the value of the iterator reaches the length of the key, set the value of the iterator
            // back to 0, so it doesn't go out of bounds:
            if (k.length() == i) i = 0;
                        
            k += k.charAt(i);
                                    
        }
        
        return k;
        
    }    
}
