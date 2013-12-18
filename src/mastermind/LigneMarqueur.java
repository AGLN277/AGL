/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mastermind;

/**
 *
 * @author Sylvio
 */
public class LigneMarqueur {
    private int[] tabMarq; // Contient la liste des marqueurs (1 si bien placé et bonne couleur, 2 si mal placé mais existe, 0 si n'existe pas)
    
    public LigneMarqueur(int taille){
        this.tabMarq = new int[taille];
        this.initialise();
    }
    
    public void initialise(){
        for(int i=0; i < tabMarq.length; i++){ // On initialise le tableau
            this.tabMarq[i] = 0;
        }
    }
    
    public int getMarq(int indice){
        return tabMarq[indice];
    }
    
    public void setMarq(int indice, int val){
        tabMarq[indice] = val;
    }

    
    public void afficher(){ 

        for(int elem : tabMarq){ // On affiche d'abord les biens placés
            if(elem == 1)
                System.out.print("☻");
        }
        for(int elem : tabMarq){ // On affiche les mal placés
            if(elem == 2)
                System.out.print("☺");
        }
        
   }
   
    
   public boolean equals(LigneMarqueur liMarq2){
       for(int i=0; i < tabMarq.length; i++){
           if(tabMarq[i] != liMarq2.getMarq(i)){
               return false; // Si les 2 tables de marqueur ne sont pas égales
           }
       }
       return true;
   }
    
    
    // Renvoie true si tous les marqueurs sont égaux à 1
    @SuppressWarnings("empty-statement")
    public boolean gagne(){ 
        int i;
        for(i=0; i < tabMarq.length && tabMarq[i] == 1; i++);
        
        return (i >= tabMarq.length); // On à trouvé aucun false
    }
}
