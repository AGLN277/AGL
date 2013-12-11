package mastermind;

import java.io.*;
import java.util.*;

public class main {
    public static void main(String arv[]){
        boolean continuer = true;
        String choix;
        
        Scanner sc = new Scanner(System.in);
        Ligne li1 = new Ligne(4, false);
        char[] dd = {'R', 'V', 'J', 'B'};
        li1.setLigne(dd);
        Ligne li2 = new Ligne(4, true);
        int[] cmp = li1.compare(li2);
        li1.afficher();

        for(int elem : cmp){
            System.out.print(elem + " ");
        }
        
        
        do{
            System.out.println("======= MasterMind ======= ");
            System.out.println("1. Ordi vs Ordi");
            System.out.println("2. Joueur vs Ordi");
            System.out.println("3. Joueur vs Joueur");
            System.out.println("4. Paramètres");
            System.out.println("5. Quitter\n");
            
            choix = sc.nextLine();
            switch(choix){
                case "1":
                    
                    break;
                    
                case "2":      
                    break;
                    
                case "3":
                    break;
                    
                case "4":                   
                    break;
                    
                case "5":
                    continuer = false;
                    break;
            }
            
        }while(continuer);
        
    }
}