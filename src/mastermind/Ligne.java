
package mastermind;

import java.util.Random;

public class Ligne {
    private char[] ligne;
    private int taille; 
    private final int MIN = 0, MAX=10;
    private final char[] couleur={'R','V','J','B','O','G','M','P','C','T'};
      
    public Ligne( int taille, boolean generation){
        ligne = new char[taille];    
        if( generation )
            generationLigne();
    }
    
    public void setLigne( char[] tab){
        ligne = tab;
    }
    
    public boolean[] compare ( Ligne comparant){
        boolean[] tab = new boolean[taille];
        for (int i=0; i< taille; i++){
            if ( ligne[i] == comparant.ligne[i] )
                tab[i] = true;
            else
                tab[i] = false;
        }
      
        return tab;
        //tableau de boolean
    }
    
  /**
   * Permet de générer une ligne aléatoire.
   * @return true si la bonne combinaison est trouvée et false sinon
   */ 
    private void generationLigne(){
        for (int i= 0; i<taille; i++){
            Random rand = new Random();
            int nombreAleatoire = rand.nextInt(MAX - MIN + 1) + MIN;
            ligne[i] = couleur[nombreAleatoire];
        }
    }
    
}
