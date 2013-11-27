
public class Jeton extends Piece {
    
    private int position;
       
    Jeton(Couleur coul, int position) {            
        super(coul);
        this.position=position;
       }
    
    public int getPosition() {
    return position;
    }
    
}
