
package mastermind;

import java.util.Random;

public class Ligne {
    private char[] ligne;
    private int taille; 
    private final int MIN = 0, MAX=10;
    private final char[] couleur={'R','V','J','B','O','G','M','P','C','T'};
      
    public Ligne( int taille, boolean generation){
        ligne = new char[taille];    
        if(generation)
            generationLigne();
        this.taille = taille;
    }
    
    public void setLigne( char[] tab){
        ligne = tab;
    }
    
    public char getPion(int indice){
        return ligne[indice];
    }
    
    public void afficher(){
        for(char elem : ligne){
            System.out.print(elem + " ");
        }
        System.out.print("\n");
    }
    
    public int[] compare ( Ligne comparant){
        int[] verifTab = new int[taille]; // Ce tableau Si tab[i] = 1 : Bon et bien placé; Si tab[i] = 2 : Bon et mal placé; Si tab[i] = 0 : N'existe pas dans cette ligne
        boolean[] existeTab = new boolean[taille]; // Ce tableau mettra true si la case correspondant à cet indice est présente. Ce tableau permet de ne pas compter plusieurs fois 
        
        
        for(int i=0; i < taille; i++){ // Initialise les tableaux
            existeTab[i] = false;
            verifTab[i] = 0;
        }
        
        
        for (int i=0; i < taille; i++){ // On test d'abord si les pions sont bien placés
            if ( ligne[i] == comparant.ligne[i] ){
                verifTab[i] = 1; // Si la pièce est bien placée et de bonne couleur
                existeTab[i] = true;
            }
        }
        
        for(int elem : verifTab){
            System.out.print(elem + " ");
        }
        
        // On regarde les éléments existant et mal placés
        for(int i=0; i < taille; i++){
            if(verifTab[i] != 1){ // Si la pièce n'est pas déjà bien placée
                for(int j=0; j < taille && verifTab[i] != 2; j++){ // Tant que le tableau n'est pas fini et qu'on a pas trouvé cette couleur dans le tableau 
                    if(comparant.ligne[i] == ligne[j] && existeTab[j] == false){ // Si une couleur est la même dans les 2 lignes et qu'elle n'a pas déjà été donné
                        existeTab[j] = true;
                        verifTab[i] = 2; // On dit que la pièce existe mais mal placée
                    }
                }
            }
        }
        System.out.print(verifTab.length);
        return verifTab;
    }
    
    
    // Renvoie true si le tableau contient que des 1
    // Attention, c'est une méthode statique
    @SuppressWarnings("empty-statement")
    public static boolean tabEstVrai(int[] tab){
        int i;
        for(i=0; i < tab.length && tab[i] == 1; i++);
        
        return (i >= tab.length); // On à trouvé aucun false
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
    

   
 
