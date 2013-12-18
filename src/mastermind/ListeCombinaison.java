package mastermind;

import java.util.ArrayList;
import java.util.Iterator;
import java.lang.ArrayIndexOutOfBoundsException;
import java.util.Random;

public class ListeCombinaison {
    private ArrayList<Ligne> listeCombi; // Liste des combinaisons de type Ligne
    private char[] listeCouleur; // Les couleurs possibles

    ListeCombinaison(Parametre param){
        listeCouleur = param.getListeCouleur();
        if(param.getNbCouleurs() > listeCouleur.length){
            throw new ArrayIndexOutOfBoundsException("Erreur : Le nombre de couleurs est trop grand.");
        }
        else{
            listeCombi = new ArrayList(); // On réserve la taille pour nbCouleur puissance nombre de boules
            int[] indice = new int[param.getTailleLigne()];
            char[] combinaison; // Permettra d'entrer chaque combinaison

            for(int i=0; i < param.getTailleLigne(); i++){ // On initialise les indices à zéro
                indice[i] = 0;
            }
            
            while(indice[0] < param.getNbCouleurs()){
                combinaison = new char[param.getTailleLigne()];
                for(int i=0; i < param.getTailleLigne(); i++){
                    combinaison[i] = listeCouleur[indice[i]]; // Pas très optimisé !! : Il faudrait laisser la chaîne et changer suelement les éléments qui changent
                }

                indice[param.getTailleLigne()-1]++;
                for(int i=param.getTailleLigne()-1; i > 0; i--){
                    if(indice[i] > param.getNbCouleurs()-1){ // Dès que l'indice n-1 a mit toutes les couleurs, il recommence et met l'incdice n-2 à +1, ... ect
                        indice[i] = 0;
                        indice[i-1]++;
                    }
                }
                listeCombi.add(new Ligne(param, combinaison));
            }
        }
    }
    
    /* Supprime les combinaisons impossibles
    Compare la proposition, avec la liste des combinaisons et supprime celles qui n'ont pas les mêmes marqueurs */ 
    public void supprimeCombiImp(Ligne proposition, LigneMarqueur marqueurVerif){ 
        Iterator<Ligne> it = listeCombi.iterator();
        Ligne tmpLigne; // Variable tempororaire qui récupèra une lgne pour la comparée
        
        for(int i=0; it.hasNext(); i++){
           tmpLigne = it.next();
           if(!marqueurVerif.equals(tmpLigne.compare(proposition))){ // Si la combinaison ne correspond pas à la proposition, on la suporime
               it.remove(); // On supprime avec l'iterateur, car c'est plus rapide
           }
        }
    }
    
    /*Choisi une combinaison au hasard dans la liste de combinaison restantes */
    public Ligne choixCombi(){
        Random rand = new Random();
        int indiceAleatoire = rand.nextInt((listeCombi.size()-1)+ 1);
        return listeCombi.get(indiceAleatoire); // On prend une combinaison aléatoire dans la liste
    }
}
