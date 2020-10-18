/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlphanumericDifferentiation;

/**
 *
 * @author ErayC
 */
import java.util.*;
public class AlphanumericDifferentiator {
    
    public static void differentiate(String line1, String line2) {
        
        ArrayList<Character> differentiatedArrayList = new ArrayList<Character>();
        
        for (int i = 0; i < line1.length(); i++) {
            
            if (!line2.contains(Character.toString(line1.charAt(i)))) differentiatedArrayList.add(line1.charAt(i));
            
        }
        
        Collections.sort(differentiatedArrayList);
        
        System.out.println(fromStringArrayListToString(differentiatedArrayList));
            
    }
    
    public static String fromStringArrayListToString(ArrayList<Character> stringArrayList) {
        
        String convertedString = "";
        
        for (int i = 0; i < stringArrayList.size() ; i++) {
            
            convertedString += (stringArrayList.get(i) + " ");
            
        }
        
        return convertedString;
        
    }
}
