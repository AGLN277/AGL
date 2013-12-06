
package mastermind;

public class Ligne {
    private char[] ligne;
    private int taille; 
    private final char[] couleur={'R','V','J','B','O','G','M','P','C','T'};
    
    public Ligne (){
        generationLigne();
    }
    
    public Ligne( int taille ){
        ligne = new char[taille];
    }
    
    public void setLigne( char[] tab){
        ligne = tab;
    }
    
    public boolean[] compare ( Ligne ligne){
        
        return ligne;
    }
    
    private void generationLigne(){
        
    }
    
}
