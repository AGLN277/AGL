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
        for(int i=0; i < taille; i++){ // On initialise le tableau
            this.tabMarq[i] = 0;
        }
    }
    
}
