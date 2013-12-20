package mastermind;
/*main*/
import java.io.*;
import java.util.*;

public class main{
    public static void main(String arv[]) throws IOException{
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
                    choixParametre(param);
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
    
    
    
    
    static void choixParametre(Parametre param) throws IOException{
        boolean continuer = true;
        String choix;
         boolean juste; // Variable temporaire permettant de voir si une entrée est juste
        int element; // Une variable temporaire permettant de vérifier si lentrée est correct
        Scanner sc = new Scanner(System.in);
        
        System.out.println("======= Paramètres ======= ");
        
        System.out.println("Vos paramètres");
        param.afficher();
        System.out.println("\n\n Voulez vous modifier les parmaetres ?");
        do{
            
            System.out.println("1. Taille ligne");
            System.out.println("2. Nombre de couleurs");
            System.out.println("3. Nombre de coups");
            System.out.println("4. Retour\n");
            
            choix = sc.nextLine();
            switch(choix){
                case "1":
                    do{
                        System.out.print("\n\n\nEntrez une nouvelle taille de ligne : ");
                        element = sc.nextInt();
                        if(param.setTailleLigne(element)){
                            juste = true;
                        }
                        else{
                            System.out.println("Erreur : vous devez entrer une valeur entre "+ Parametre.MIN_TAILLE + " et " + Parametre.MAX_TAILLE + ".");
                            juste = false;
                        }
                    }while(!juste);
                break;

                case "2":
                     do{
                        System.out.print("\n\n\nEntrez un nombre de couleurs : ");
                        element = sc.nextInt();
                        if(param.setTailleLigne(element)){
                            juste = true;
                        }
                        else{
                            System.out.println("Erreur : vous devez entrer une valeur entre "+ Parametre.MIN_NB_COULEURS + " et " + Parametre.MAX_NB_COULEURS + ".");
                            juste = false;
                        }
                    }while(!juste);
                break;
                    
                case "3":
                     do{
                        System.out.print("\n\n\nEntrez un nombre de coups maximum : ");
                        element = sc.nextInt();
                        if(param.setTailleLigne(element)){
                            juste = true;
                        }
                        else{
                            System.out.println("Erreur : vous devez entrer une valeur entre "+ Parametre.MIN_NB_COUPS + " et " + Parametre.MAX_NB_COUPS + ".");
                            juste = false;
                        }
                    }while(!juste);
                break;
                    
                case "4":
                    if(param.enregistrer()){
                        System.out.println("Pramètres enregistrés...");
                    }
                    else{
                        System.out.println("Impossible d'enregistrer les paramètre...");
                    }
                    continuer = false;
                break;
                default:
                    System.out.println("Entrée incorrect !");
                break;
            }
          }while(continuer);
        
    }
}