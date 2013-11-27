

public class Mark extends Piece {
    
    private int position;
    private Jeton jetonAssocie;
    Mark(Couleur coul, Jeton jetonAssocie) {            
        super(coul);
        this.position=jetonAssocie.getPosition();
        this.jetonAssocie=jetonAssocie;
   
    }
}