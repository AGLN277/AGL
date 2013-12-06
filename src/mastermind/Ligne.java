
package mastermind;

public class Ligne {
    private char[] ligne;
    private int taille; 
    
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
