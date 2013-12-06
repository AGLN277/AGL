package mastermind;


public class Jeton {
    String couleur;
    Mark marqueurAssocie;
    
    Jeton(String couleur) {    // !!!! On utilise plus la classe couleur       
        this.couleur = couleur;
    }
    
    public Mark getMarqueur(){
        return marqueurAssocie;
    }
    
    public String getColor(){
        return couleur;
    }
    
}
