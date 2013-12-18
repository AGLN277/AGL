package mastermind;

import java.io.*;
import java.util.*;

public class main {
    public static void main(String arv[]){
        boolean continuer = true;
        String choix;
        Parametre param = new Parametre();
        
        Scanner sc = new Scanner(System.in);
        
        
        do{
            System.out.println("======= MasterMind ======= ");
            System.out.println("1. Ordi vs Ordi");
            System.out.println("2. Joueur vs Ordi(L'ordi entre une combinaison)");
            System.out.println("3. Ordi vs Joueur(Vous entrez une combinaison)");
            System.out.println("4. Joueur vs Joueur");
            System.out.println("5. Paramètres");
            System.out.println("6. Quitter\n");
            
            choix = sc.nextLine();
            switch(choix){
                case "1":
                    ModeJeu.OrdiVsOrdi(param);
                    break;
                    
                case "2":
                    ModeJeu.JoueurVsOrdi(param);
                    break;
                    
                case "3":
                    ModeJeu.OrdiVsJoueur(param);
                    break;
                    
                case "4":
                    
                    break;
                case "5":                   
                    break;
                    
                case "6":
                    continuer = false;
                    break;
                default:
                    System.out.println("Erreur de saisie, le choix que vous demandez n'existe pas.\n");
                    break;
                
            }
            
        }while(continuer);
        
    }
}