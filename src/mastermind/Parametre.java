/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package mastermind;
import java.util.*;
import java.io.*;

/**
 *
 * @author Sylvio
 */
public class Parametre {
    public static final int MIN_TAILLE = 2, MAX_TAILLE = 6;
    public static final int MIN_NB_COULEURS = 2, MAX_NB_COULEURS = 10;
    public static final int MIN_NB_COUPS = 2, MAX_NB_COUPS = 20;
    
    private Properties propriete;
    private String nomFichier = "config.cfg";
    
    /*Fichier contient le chemin du fichier des paramétres*/
    Parametre() throws IOException{
        propriete = new Properties();
        if(!charger()){ // Si on à pas pu charger, on prend les parmamètres par défaut
            this.defaut();
        }
    }
    
    Parametre(String fichier) throws IOException{
           nomFichier = fichier;
           propriete = new Properties();
        if(!charger()){ // Si on à pas pu charger, on prend les parmamètres par défaut
            this.defaut();
        }
    }
    
    
    
    
    /*Met les paramètres par défaut*/
    public void defaut(){
        setTailleLigne(4);
        setNbCouleurs(6);
        setNbCoupMax(10);
        propriete.setProperty("couleur", "RVJBOGMPCTPN");
    }
    
    /*Retourne le nombre de caractère qu'il faut pour l'affichage */
    public String esp(String entree){
        String str = new String();
        int nbCar = 0;
        int taille = getTailleLigne();
        if(taille % 2 == 1){
            nbCar = (taille / 2)+1;
        }
        else{
            nbCar = taille / 2;
        }
        
        for(int i=0; i < nbCar; i++){
            str += entree;
        }
        return str;
    }
    
    // Getters 
    
    public int getTailleLigne(){
        return Integer.parseInt(propriete.getProperty("taille"));
    }
    
    public int getNbCouleurs(){
        return Integer.parseInt(propriete.getProperty("nb_couleur"));
    }
    
    public int getNbCoupMax(){
        return Integer.parseInt(propriete.getProperty("nb_coups"));
    }
    
    public char[] getListeCouleur(){
        return propriete.getProperty("couleur").toCharArray();
    }
    
    // Setters
    // Les setters renvoient false quand la nouvelle variable envoyée ne correspnd pas aux limites, l'attribut correspondant n'est donc pas modifié
    public boolean setTailleLigne(int nvTaille){
        if(nvTaille >= MIN_TAILLE && nvTaille <= MAX_TAILLE){
            Integer taille = nvTaille;
            propriete.setProperty("taille", taille.toString());
            return true;
        }
        else{
            return false;
        }
    }
    
    public boolean setNbCouleurs(int nvNbCouleurs){
        if(nvNbCouleurs >= MIN_NB_COULEURS && nvNbCouleurs <= MAX_NB_COULEURS){
            Integer nbCouleur = nvNbCouleurs;
            propriete.setProperty("nb_couleur", nbCouleur.toString());
            return true;
        }
        else{
            return false;
        }
    }
    
    public boolean setNbCoupMax(int nvNbCoupMax){
        if(nvNbCoupMax >= MIN_NB_COUPS && nvNbCoupMax <= MAX_NB_COUPS){
            Integer coupMax = nvNbCoupMax;
            propriete.setProperty("nb_coups", coupMax.toString());
            return true;
        }
        else{
            return false;
        }
    }
    
    
    public void afficher(){
        System.out.println("Taille :\t " + getTailleLigne());
        System.out.println("Nb couleurs:\t" + getNbCouleurs());
        System.out.println("Nb coups:\t" + getNbCoupMax());
        System.out.print("Liste couleurs : ");
        char[] listeCoul = getListeCouleur();
        for(int i=0; i < getTailleLigne(); i++){
            System.out.print(" "+ listeCoul[i]);
        }
    }
    
    
    /*Enregistre les config dans le fichier*/
    public boolean enregistrer() throws IOException{
        try{
            FileOutputStream fichier = new FileOutputStream(this.nomFichier);
            propriete.store(fichier, "-Enregistrement config-");
            fichier.close();
            return true;
        }
        catch(FileNotFoundException e){
            System.out.println("Erreur "+e.getMessage()+" : Chargement impossible du fichier config.");
            return false;
        }
}

    public boolean charger() throws IOException
      {
        try {
            FileInputStream fichier = new FileInputStream(this.nomFichier);
            propriete.load(fichier);
            fichier.close();
            return true;
        } catch (FileNotFoundException e) {
            System.out.println("Erreur " + e.getMessage() + " : Chargement impossible du fichier config.");
            return false;
        }
      }
}
