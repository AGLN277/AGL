
package mastermind;

import java.util.Scanner; 

public class ModeJeu {
    
      
    public static void OrdiVsOrdi(){
        //Algo en cours :D
        
    }
    
     public static void JoueurVsOrdi(){
        Ligne ligne = new Ligne(4,true);
        Ligne ligneJoueur = new Ligne(4,false);
        
        int nbCoup = 0;
        int nbCoupMax = 15;
        
        int[] marqueur = new int[4];
        Scanner sc = new Scanner(System.in);
        String rep;
        
        while ( nbCoup < nbCoupMax){
            System.out.println("Joueur : Entrez une combinaison : ");
            rep = sc.nextLine();
            
            // On affecte la valeur entrée à la ligne du joueur
            ligneJoueur.setLigne( rep.toCharArray() );
            // On compare la ligne de départ avec la ligne du joueur et on
            // affecte les valeurs à marqueur ( un tableau de int)
            marqueur = ligneJoueur.compare(ligne);
            
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
              marqueur = ligneJoueur.compare(ligne);
              
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
