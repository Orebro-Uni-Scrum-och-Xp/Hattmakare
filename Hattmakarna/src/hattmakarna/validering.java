/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hattmakarna;

import java.util.regex.Pattern;

/**
 *
 * @author minna
 */
    public class validering {        

        // Validerar en e-postadress.
    public static boolean isValidePost(String ePost) {
        String ePostRegex = "^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,}$";
        return Pattern.matches(ePostRegex, ePost);
}

        // Validerar ett datum i formatet YYYY-MM-DD.
    public static boolean isValidDatum(String datum) {
        String datumRegex = "^\\d{4}-\\d{2}-\\d{2}$";
        return Pattern.matches(datumRegex, datum);
    }

        // Validerar lösenord för exakt 11 tecken, minst en stor bokstav, en liten bokstav och en siffra
    public static boolean isValidLosenord(String losenord) { 
        String losenordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{11}$";
        return losenord != null && Pattern.matches(losenordRegex, losenord);
    }

        //Validerar telefonnummer
    public static boolean isValidTelefonnummer(String telefonnummer) {
    return telefonnummer != null && telefonnummer.trim().matches("^[0-9]{7,15}$");
    }

        //Validerar adress. 
    public static boolean isValidAdress(String adress) {
        String adressRegex = "^[a-zA-ZåäöÅÄÖ0-9\\s,'-]{2,}$";
        return adress != null && Pattern.matches(adressRegex, adress);
    }

        // Validerar ett namn. Endast bokstäver och minst två tecken långt.
    public static boolean isValidNamn(String namn) {
        String namnRegex = "^[a-zA-ZåäöÅÄÖ\\s'-]{2,}$";
        return Pattern.matches(namnRegex, namn);
    }
        
        //Validerar att inmatningen antingen är ett numeriskt värde eller tomt.
        public static boolean isNumeriskEllerTom(String nummerInString) {
    String numeriskEllerTomRegex = "^(\\d+(\\.\\d*)?)?$";
    return Pattern.matches(numeriskEllerTomRegex, nummerInString);
    }
        
        //Validerar att textruta inte är tom eller endast består av mellanslag
    public static boolean isNotEmpty(String input) {
    return input != null && !input.trim().isEmpty();
    }
    
     // Validerar en numerisk inmatning ().
    public static boolean isNumerisk(String nummerInString) {
        String numeriskRegex = "^\\d+(\\.\\d+)?$";
        return Pattern.matches(numeriskRegex, nummerInString);
    }
}
