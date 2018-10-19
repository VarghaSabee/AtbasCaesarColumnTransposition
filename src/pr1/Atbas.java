/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pr1;

/**
 *
 * @author 89502
 */
import java.util.ArrayList;
import java.util.List; 
import java.util.Scanner;
 
public class Atbas { 
 
    public  static int GROUP_SIZE = 5; 
    private   static  String PLAIN = "abcdefghijklmnopqrstuvwxyz"; 
    private   static  String CIPHER = "zyxwvutsrqponmlkjihgfedcba"; 

    public static int getGROUP_SIZE() {
        return GROUP_SIZE;
    }

    public static void setGROUP_SIZE(int GROUP_SIZE) {
        Atbas.GROUP_SIZE = GROUP_SIZE;
    }
    
    

    public static String getPLAIN() {
        return PLAIN;
    }

    public static void setPLAIN(String PLAIN) {
        Atbas.PLAIN = PLAIN;
    }

    public static String getCIPHER() {
        return CIPHER;
    }

    public static void setCIPHER(String CIPHER) {
        Atbas.CIPHER = CIPHER;
    }
    
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String msg = in.nextLine();
//        
//        applyCipher('c');
//        msg = encode(msg);
//        System.out.println(msg);
//        System.out.println(decode(msg));
//        
//    }
    
    public static String encode(String input) { 
        String encoded = stripInvalidCharacters(input).toLowerCase(); 
        String cyphered = ""; 
 
        for (char c : encoded.toCharArray()) { 
            cyphered += applyCipher(c); 
        } 
 
        return splitIntoFiveLetterWords(cyphered); 
    } 
 
    public static String decode(String input) { 
        String encoded = input;//stripInvalidCharacters(input).toLowerCase(); 
        String deciphered = ""; 
 
        for (char c : encoded.toCharArray()) { 
            deciphered += applyCipher(c); 
        } 
 
        return deciphered; 
    } 
 
    private static String stripInvalidCharacters(String input) { 
        String filteredValue = ""; 
 
        for (char c : input.toCharArray()) { 
            if (Character.isLetterOrDigit(c)) { 
                filteredValue += c; 
            } 
        } 
 
        return filteredValue; 
    } 
 
    private static char applyCipher(char input) { 
        int idx = PLAIN.indexOf(input); 
 
        return idx >= 0 ? CIPHER.toCharArray()[idx] : input; 
    } 
 
    private static String splitIntoFiveLetterWords(String value) { 
        List<String> words = new ArrayList<>(); 
 
        for (int i = 0; i < value.length(); i += GROUP_SIZE) { 
            words.add(i + GROUP_SIZE <= value.length() ? value.substring(i, i + GROUP_SIZE) : value.substring(i)); 
        } 
 
        return String.join(" ", words); 
    } 
}