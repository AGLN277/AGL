
package mastermind;

import java.util.Scanner; 

public class ModeJeu {
    
    
    public static void OrdiVsOrdi(Parametre param){
        // Faire des statistiques sur plusieurs parties
        
        Ligne ligneOrdi1 = new Ligne(param, true);
        Ligne ligneOrdi2 = new Ligne(param, false);
        LigneMarqueur liMarq = new LigneMarqueur(param.getTailleLigne());
        
        String esp = param.esp(" "); // On récupère le nombre d'espace qu'il faut pour l'affichage
        int nbCoup = 1;
        Scanner sc = new Scanner(System.in);
        String rep;
        boolean continuer;
        boolean gagne = false;
        
        IA ordi2 = new IA(param);
        
        System.out.print("L'ordi 1 entre une combinaison : ");
        ligneOrdi1.afficher();
        System.out.println("\n Ordi 2 : \n");
        System.out.println("------------------------------------------------" + param.esp("---"));
        System.out.println("|      Joueur     |   "+esp+"Jeu"+esp+"   |"+esp+"Réponse"+esp+"| Coup |");
        System.out.println("------------------------------------------------" + param.esp("---"));
        
        while(!gagne && nbCoup <= param.getNbCoupMax()){
            
            System.out.print("\b\b\b| Ordi 2 entre :  | ");
            ligneOrdi2 = ordi2.jouer(liMarq); // L'ordinateur propose une combinaison, pas de souci si liMarq est vide. Tous ces éléments sont initilisés à 0
            System.out.print("   ");
            ligneOrdi2.afficher();
            liMarq = ligneOrdi1.compare(ligneOrdi2); // On compare la ligne de l'ordi avec la ligne secrète
            System.out.print("  |   ");
            liMarq.afficher();
            System.out.print(esp+"  |   "+nbCoup+ "  |\n");
            System.out.println("-------------------------------------------------" + param.esp("---"));
            
            if(liMarq.gagne()){
                System.out.println("L'ordi2 a gagné, en "+ nbCoup+" coups.");
                gagne = true;
            }
            else if(nbCoup > param.getNbCoupMax()){
                System.out.println("L'ordi2 a perdu ! le réponse était : " + ligneOrdi1.toString());
            }
            nbCoup++;
        }
    }
    
    /*Le joueur donne une combinaison au départ et l'ordinateur doit le trouver dans un certain nombre de coup*/
    public static void OrdiVsJoueur(Parametre param){
        Ligne ligneOrdi = new Ligne(param, true);
        Ligne ligneJoueur = new Ligne(param, false);
        LigneMarqueur liMarq = new LigneMarqueur(param.getTailleLigne());
        Scanner sc = new Scanner(System.in);
        
        String esp = param.esp(" "); // On récupère le nombre d'espace qu'il faut pour l'affichage
        int nbCoup = 1;
        String rep;
        boolean continuer;
        boolean gagne = false;
        
        IA ordi = new IA(param);
        
        do{
            continuer = true;
            System.out.println("Joueur : Entrez une combinaison("+ param.getTailleLigne() + " couleurs) : ");
            rep = sc.nextLine();

            if(rep.length() > param.getTailleLigne()){
                System.out.println("Vous avez entré trop de couleurs.");
                continuer = false;
            }
            else if(rep.length() < param.getTailleLigne()){
                System.out.println("Vous n'avez pas entré assez de couleurs.");
                continuer = false;
            }

        }while(!continuer);
        ligneJoueur.setLigne(rep.toCharArray()); // On met la ligne entrée dans la ligne joueur

        while(!gagne && nbCoup <=param.getNbCoupMax()){
            
            System.out.println("Ordi joue (coup "+nbCoup+"): ");
            ligneOrdi = ordi.jouer(liMarq); // L'ordinateur propose une combinaison, pas de souci si liMarq est vide. Tous ces éléments sont initilisés à 0
            ligneOrdi.afficher();
            liMarq = ligneJoueur.compare(ligneOrdi); // On compare la ligne de l'ordi avec la ligne secrète
            liMarq.afficher();
            
            if(liMarq.gagne()){
                System.out.println("L'ordinateur a gagné, en "+ nbCoup+" coups.");
                gagne = true;
            }
            else if(nbCoup > param.getNbCoupMax()){
                System.out.println("L'ordinateur a perdu !");
            }
            nbCoup++;
            System.out.println("\n");
        }
        
    }
    
    
    
    /*L'ordinateur entre une combinaison au hasard et le joueur a un certain nombre de coup pour la trouver */
     public static void JoueurVsOrdi(Parametre param){
        int taille = 4;
        Ligne ligneOrdi = new Ligne(param,true);
        Ligne ligneJoueur = new Ligne(param,false);
        
        
        int nbCoup = 10;
        
        LigneMarqueur liMarq; // récupère la liste des marqueurs après la comparaison
        
        Scanner sc = new Scanner(System.in);
        String rep;
        
        boolean continuer; // Utilisée pour voir si il y a eu une erreur de saisie
        boolean gagne = false; // On met cette variable true si le joueur gagne
        
        
        while ( nbCoup > 0 && gagne == false){
            do{
                continuer = true;
                System.out.println("Joueur : Entrez une combinaison("+ taille + " couleurs) : ");
                rep = sc.nextLine();
                
                if(rep.length() > taille){
                    System.out.println("Vous avez entré trop de couleurs.");
                    continuer = false;
                }
                else if(rep.length() < taille){
                    System.out.println("Vous n'avez pas entré assez de couleurs.");
                    continuer = false;
                }
                
            }while(!continuer);
            
            // On affecte la valeur entrée à la ligne du joueur
            ligneJoueur.setLigne(rep.toCharArray());
            // On compare la ligne de départ avec la ligne du joueur et on
            // affecte les valeurs à marqueur ( un tableau de int)
            
            liMarq = ligneOrdi.compare(ligneJoueur);
            System.out.print(": ");
            liMarq.afficher();
            nbCoup--; // On décrémente le nombre de coups
            
            if (liMarq.gagne()){
                System.out.println("Bravo ! Vous avez trouvé !");
                gagne = true;
            }
            else if(nbCoup > 0){
                System.out.println("Il vous reste " + nbCoup +"coups.");
            }
            else{
                System.out.println("Perdu ! La réponse était : " + ligneOrdi.toString());
            }
            System.out.println("\n\n");
        }
        // Ici il va falloir clear l'affichage et appeler le menu
     }
     
     // C'est la même méthode que JoueurVsOrdi sauf qu'on demande d'entrée une
     // ligne manuellement 
      /*public static void JoueurVsJoueur(Parametre param){
          Ligne ligne = new Ligne(4,false);
          Ligne ligneJoueur = new Ligne(4, false);
          
          int nbCoup = 0;
          int nbCoupMax = 15;
          
          int[] marqueur = new int[4];
          Scanner sc = new Scanner(System.in);
          String rep;
          
          System.out.println("Joueur 1 : Entrez la combinaison : ");
          rep = sc.nextLine();
          System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
          ligne.setLigne(rep.toCharArray());
          
          while ( nbCoup < nbCoupMax){
              System.out.println("Joueur 2 : Entrez une combinaison : ");
              rep = sc.nextLine();
              
              // On affecte la valeur entrée à la ligne du joueur
              ligneJoueur.setLigne(rep.toCharArray());
              //marqueur = ligneJoueur.compare(ligne);
              
              if ( Ligne.tabEstVrai(marqueur) ){
                System.out.println("Bravo ! Vous avez trouvé !");
                break;
              }

              if ( nbCoup > nbCoupMax){
                    System.out.println("Perdu !");
                    break;
              }
              
              nbCoup++;      
          }
      }
      */

   
}
