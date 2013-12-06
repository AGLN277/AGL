package mastermind;


public class Ligne {
 
    private Jeton[] tabJeton;
    private int nbjeton;
    private Mark[] markAssocie; //
    
    public Ligne(Jeton[] tabJeton){ // Constructeur par défaut
        this.nbjeton=tabJeton.length;
        this.tabJeton=tabJeton;
    }   
     
    public Ligne(Jeton[] tabJeton, Mark[] markAssocie){  // Constructeur si  il y a un marqueur
        this.nbjeton=nbjeton;
        this.markAssocie=markAssocie; 
        this.tabJeton=tabJeton;
    }
    
    public int getNbJeton(){
        return this.nbjeton;
    }
    
    public Jeton getJetons(int indice){
        return this.tabJeton[indice];
    }
            
}
