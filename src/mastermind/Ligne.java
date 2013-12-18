
package mastermind;

import java.util.Random;


/**
 * <p>Ligne est un tableau de caractères, un caractère correspond à une couleur. 
 * Une ligne contient :</p>
 * <ul>
 *     <li>Une taille qui est le nombre de caractère</li>
 *     <li>Un nombre de couleur qui est le choix des couleurs </li>
 * </ul>
 * 
 * 
 */
public class Ligne {
    private char[] ligne;
    private int taille;
    private int nbCouleurs;
    
    private char[] listeCouleur;
    
    /**<p>Construit une Ligne en récupèrant les paramètres taille, et nombre de 
     * couleurs provenant d'un objet de type Parametre.
     * Vous pouvez décider de constuire une ligne remplie aléatoirement
     * ou  de construire une ligne vide.</p>
     *
     * @param param paramètres pour générer la ligne
     * @param generation génération d'une ligne aléatoirement :
     * <ul>
     *      <li> true : la ligne crée est remplie aléatoirement
     *      <li> false : la ligne crée est vide
     * </ul>
     * 
     * @see Ligne
     * @see Parametre
     * @see generationLigne()
     */
    
    public Ligne(Parametre param, boolean generation){
        this.ligne = new char[param.getTailleLigne()];
        this.taille = param.getNbCouleurs();
        this.nbCouleurs = param.getNbCouleurs();
        this.listeCouleur = param.getListeCouleur();
        if(generation)
            generationLigne();
    }
    
    /** <p>Construit une ligne avec les paramètres provenant d'un objet Parametre.
     * La ligne prend ensuite la valeur du tableau de caractères entré en paramètre</p>
     * 
     * @param param paramètres pour générer la ligne
     * @param tab tableau de caractère
     * 
     * @see Ligne
     * @see Parametre
     */
    public Ligne(Parametre param, char[] tab){
        this.ligne = tab;
        this.taille = param.getNbCouleurs();
        this.nbCouleurs = param.getNbCouleurs();
        this.listeCouleur = param.getListeCouleur();
    }
    
    
    /**
     * Met à jour une ligne.
     * @param tab les nouvelles couleurs
     * 
     * @see Ligne
     */
    public void setLigne( char[] tab){
        ligne = tab;
    }
    
    /** <p> Retourne la couleur d'une ligne selon l'indice entré en paramètre. </p>
     * 
     * @param indice position d'une couleur dans une ligne
     * @return un caractère correspondant à une couleur
     * 
     * @see Ligne
     */
    public char getPion(int indice){
        return ligne[indice];
    }
    
    /** Retourne le contenu d'une Ligne sous forme d'un String.
     * 
     * @return le contenu d'une ligne en String
     * 
     * @see Ligne
     * @see String
     */
    @Override
    public String toString(){
        String str = "";
        for(int i=0; i < taille; i++){
            str += ligne[i]+" ";
        }
        return str;
    }
    
    /**
     *  Affiche le contenu d'une ligne.
     */
    public void afficher(){
        for(char elem : ligne){
            System.out.print(elem + " ");
        }
    }
    
    
    
    
    /**
   * <p>Compare la Ligne appelant méthode avec une Ligne passée en paramètre, 
   * la fonction retourne un tableau de marqueur de type LigneMarqueur qui va 
   * contenir les valeurs 0, 1 ou 2 selont l'existence et le placement d'une 
   * couleur.</p>
   * 
   * @param comparant une Ligne comparée avec la ligne appelant la méthode
   * 
   * @return Retourne un tableau de type LigneMarqueur qui est composé de
   *    plusieurs valeurs :
   * <ul>
   *    <li>0 si cette couleur n'existe pas dans la ligne</li>
   *    <li>1 si cette couleur existe et est bien placée dans la ligne </li>
   *    <li>2 si cette couleur exite mais est mal placée dans la ligne </li>
   * </ul>
   * @see LigneMarqueur
   * @see Ligne
   */
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
   * <p> Permet de générer une ligne aléatoire. </p>
   * 
   * @see Ligne
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
    

   
 
