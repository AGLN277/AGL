package mastermind;


public class Ligne {
 
    private Jeton[] tabJeton;
    private int nbjeton;
    private Mark[] markAssocie; //
    
    public Ligne(Jeton[] tabJeton, int nbjeton){ // Constructeur par défaut
        this.nbjeton=nbjeton;
        this.tabJeton=tabJeton;
    }   
     
    public Ligne(Jeton[] tabJeton, int nbjeton, Mark[] markAssocie){  // Constructeur si  il y a un marqueur
        this.nbjeton=nbjeton;
        this.markAssocie=markAssocie; 
        this.tabJeton=tabJeton;
    }
     
            
}
