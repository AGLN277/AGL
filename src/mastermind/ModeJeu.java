
package mastermind;

import java.util.Scanner; 

public class ModeJeu {
    
    
    public static void OrdiVsOrdi(){
        //Algo en cours :D
        
    }
    
    
     public static void JoueurVsOrdi(){
        int taille = 4;
         Ligne ligne = new Ligne(taille,true);
        Ligne ligneJoueur = new Ligne(taille,false);
        
        int nbCoup = 15;
        
        LigneMarqueur liMarq; // récupère la liste des marqueurs après la comparaison
        
        Scanner sc = new Scanner(System.in);
        String rep;
        
        boolean continuer; // Utilisée pour voir si il y a eu une erreur de saisie
        boolean gagne = false; // On met cette variable true si le joueur gagne
        
        
        while ( nbCoup > 0 || gagne == true){

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
            
            liMarq = ligneJoueur.compare(ligne);
            
            nbCoup--;
            if ( liMarq.gagne()){
                System.out.println("Bravo ! Vous avez trouvé !");
                gagne = true;
            }
            else if(nbCoup > 0){
                System.out.println("Il vous reste " + nbCoup +"coups");
            }
            else{
                System.out.println("Perdu !");
            }
        }
        // Ici il va falloir clear l'affichage et appeler le menu
     }
     
     // C'est la même méthode que JoueurVsOrdi sauf qu'on demande d'entrée une
     // ligne manuellement 
      public static void JoueurVsJoueur(){
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
      
    
}
