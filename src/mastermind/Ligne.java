
package mastermind;

import java.util.Random;

public class Ligne {
    private char[] ligne;
    private int taille;
    private int nbCouleurs;
    
    private char[] listeCouleur;
    
    public Ligne(Parametre param, boolean generation){
        this.ligne = new char[param.getTailleLigne()];
        this.taille = param.getTailleLigne();
        this.nbCouleurs = param.getNbCouleurs();
        this.listeCouleur = param.getListeCouleur();
        if(generation)
            generationLigne();
    }
    
    public Ligne(Parametre param, char[] tab){
        this.ligne = tab;
        this.taille = param.getTailleLigne();
        this.nbCouleurs = param.getNbCouleurs();
        this.listeCouleur = param.getListeCouleur();
    }
    
    public void setLigne( char[] tab){
        ligne = tab;
    }
    
    public char getPion(int indice){
        return ligne[indice];
    }
    
    @Override
    public String toString(){
        String str = "";
        for(int i=0; i < taille; i++){
            str += ligne[i]+" ";
        }
        return str;
    }
    
    public void afficher(){
        for(char elem : ligne){
            System.out.print(elem + " ");
        }
    }
    
    public LigneMarqueur compare ( Ligne comparant){
        LigneMarqueur liMarq = new LigneMarqueur(taille); // On déclare une liste de marqueurs correspondant à la ligne
        boolean[] existeTab = new boolean[taille]; // Ce tableau mettra true si la case correspondant à cet indice est présente. Ce tableau permet de ne pas compter plusieurs fois 
        
        
        for(int i=0; i < taille; i++){ // Initialise le tableaux
            existeTab[i] = false;
        }
        liMarq.initialise();
        
        
        for (int i=0; i < taille; i++){ // On test d'abord si les pions sont bien placés
            if ( ligne[i] == comparant.ligne[i] ){
                liMarq.setMarq(i, 1);// Si la pièce est bien placée et de bonne couleur on met à 1
                existeTab[i] = true;
            }
        }
        
        
        // On regarde les éléments existant et mal placés
        for(int i=0; i < taille; i++){
            if(liMarq.getMarq(i) != 1){ // Si la pièce n'est pas déjà bien placée
                for(int j=0; j < taille && liMarq.getMarq(i) != 2; j++){ // Tant que le tableau n'est pas fini et qu'on a pas trouvé cette couleur dans le tableau 
                    if(comparant.ligne[i] == ligne[j] && existeTab[j] == false){ // Si une couleur est la même dans les 2 lignes et qu'elle n'a pas déjà été donné
                        existeTab[j] = true;
                        liMarq.setMarq(i, 2); // On dit que la pièce existe mais mal placée
                    }
                }
            }
        }
        return liMarq;
    }
    
    
   
   /**
   * Permet de générer une ligne aléatoire.
   * @return true si la bonne combinaison est trouvée et false sinon
   */ 
     private void generationLigne() {
        for (int i= 0; i<taille; i++){
            Random rand = new Random();
            int nombreAleatoire = rand.nextInt(nbCouleurs); // On met directement nbCouleurs, car on commence à l'indice 0
            try {
                ligne[i] = listeCouleur[nombreAleatoire];
            }
            catch (ArrayIndexOutOfBoundsException e){
                System.out.println(e.getMessage());
            }
            
        }
    }
}
    

   
 
