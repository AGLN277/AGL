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
public class Verif {
    private Ligne solution; // La ligne contenant la réponse : Les jetons entrés au debut de la partie
    
    public Verif(Ligne solution){
        this.solution = solution;
    }
    
    public void verifier(Ligne entree){ // Permet de voir la ligne et met à jour les marqueeurs en fonction
        for(int i=0; i < solution.getNbJeton(); i++){
            if(entree.getJetons(i).getColor().equals(solution.getJetons(i).getColor())){
                
            }
        }
    }
    
}
