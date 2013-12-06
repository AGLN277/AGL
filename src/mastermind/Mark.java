package mastermind;

public class Mark{
    String couleur;
    
    
    Mark(String couleur, Jeton jetonAssocie) {            
        this.couleur = couleur;
    }
    
    public String getCoulor(){
        return couleur;
    }
    
}