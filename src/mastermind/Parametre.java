/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mastermind;

public class Parametre {
    private int tailleLigne;
    private int nbCouleurs;
    private int nbCoupMax;
    private char[] listeCouleur;
    
    /*Fichier contient le chemin du fichier des paramétres*/
    Parametre(){
        tailleLigne = 8;
        nbCouleurs = 8;
        nbCoupMax = 10;
        listeCouleur = new char[] {'R','V','J','B','O','G','M','P','C','T','P','N'};
    }
    
    Parametre(String fichier){
        
    }
    
    /*Retourne le nombre de caractère qu'il faut pour l'affichage */
    public String esp(String entree){
        String str = new String();
        int nbCar = 0;
        if(tailleLigne % 2 == 1){
            nbCar = (tailleLigne / 2)+1;
        }
        else{
            nbCar = tailleLigne / 2; 
        }
        
        for(int i=0; i < nbCar; i++){
            str += entree;
        }
        return str;
    }
    
    // Getters 
    
    public int getTailleLigne(){
        return tailleLigne;
    }
    
    public int getNbCouleurs(){
        return nbCouleurs;
    }
    
    public int getNbCoupMax(){
        return nbCoupMax;
    }
    
    public char[] getListeCouleur(){
        return listeCouleur;
    }
    
    // Setters 
    
    public void setTailleLigne(int nvTaille){
        tailleLigne = nvTaille;
    }
    
    public void setNbCouleurs(int nvNbCouleurs){
        nbCouleurs = nvNbCouleurs;
    }
    
    public void setNbCoupMax(int nvNbCoupMax){
        nbCoupMax = nvNbCoupMax;
    }
    

}
