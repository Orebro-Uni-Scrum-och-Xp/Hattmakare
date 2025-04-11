/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hattmakarna;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author diyar
 */
public class Hattmakarna {
private static InfDB idb;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            idb = new InfDB("hattmakaren", "3306", "dbHattAdmin", "dbHattAdminPW");
            System.out.println("Funkar");
            new Inloggning(idb).setVisible(true);
            
        } catch (InfException ex) {
            System.out.println(ex.getMessage());
        }

        // TODO code application logic here
    }
    
}
//Uppdatering