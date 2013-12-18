/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mastermind;

public class IA {
    private ListeCombinaison listePossibles;
    private Ligne derniereCombiJouee; // L'IA doit se rappeler de la dernière proposition qu'elle a faite
    
    IA(Parametre param){
        this.listePossibles = new ListeCombinaison(param);
        this.derniereCombiJouee = null;
    }
    /* L'ordinateur renvoie une proposition 
    Le marq verif est la correction avec les marqueur sur la ligne précédente*/
    public Ligne jouer(LigneMarqueur marqVerif){
        if(derniereCombiJouee != null){ // Si derniereCombinaison n'a pas été initilaisé, càd si l'IA joue pour la première fois
            listePossibles.supprimeCombiImp(derniereCombiJouee, marqVerif);
        }
        derniereCombiJouee = listePossibles.choixCombi();
        return derniereCombiJouee;
    }
    
}
