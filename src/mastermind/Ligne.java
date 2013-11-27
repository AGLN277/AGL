
public class Ligne {
 
    private Jeton[] tabJeton;
    private int nbjeton;
    private Mark[] markAssocie; //
    
    public Ligne(Jeton[] tabJeton, int nbjeton){ 
        this.nbjeton=nbjeton;
        this.tabJeton=tabJeton;
    }   
     
    public Ligne(Jeton[] tabJeton, int nbjeton, Mark[] markAssocie){ 
        this.nbjeton=nbjeton;
        this.markAssocie=markAssocie; // Constructeur si  il y a un marqueur
        this.tabJeton=tabJeton;
    }
     
            
}
