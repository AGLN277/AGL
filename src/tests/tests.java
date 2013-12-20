//Rentrer une combinaison de taille n au lieu d'une combinaison de taille m avec n>m
// Coucou !

package tests;

import static junit.framework.Assert.assertEquals;
import junit.framework.TestCase;
import mastermind.Ligne;
import mastermind.Parametre;
import mastermind.LigneMarqueur;


public class tests {
  Parametre param;
  char[] chaine1= new char[] {'V','V','R'};
  char[] chaine2= new char[] {'V','R','R'};
  int[] tabTest = new int[] {1,2,3};
  Ligne ligne1 = new Ligne(param, chaine1);
  Ligne ligne2 = new Ligne(param, chaine2);
  LigneMarqueur liMarq1 = new LigneMarqueur(param.getTailleLigne());
  LigneMarqueur liMarq2 = new LigneMarqueur(tabTest);
  
 public void testCompare (){
  
  liMarq1 = ligne1.compare(ligne2);  
  assertEquals(liMarq1,liMarq2);
  
 }
  
   
}

