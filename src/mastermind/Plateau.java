package mastermind;

public class Plateau {
    private int x;
    private int y;
    private char[][] matrice = new char[10][4];
    
    Plateau(){
        
        for( int i=0; i<10; i++){
            for (int j=0; j<4; j++ ){
                matrice[i][j]='.';
            }
        }
    }
    
    public void remplir(char mat[][]){
        for( int i=0; i<10; i++){
            for (int j=0; j<4; j++ ){
                matrice[i][j]='.';
            }
        }
    }
    
    public void affichage(){
        for( int i=0; i<10; i++){
            for (int j=0; j<4; j++ ){
                System.out.print(matrice[i][j]);
            }
            System.out.print("\n");
        }
    
    }
    
}
