package mastermind;

import java.util.Scanner;
class Mastermind {
    private static Scanner scanner = new Scanner(System.in);

  /**
   * Lancement du Master-Mind(tm)
   * @param args
   */
  public static void main(String[] args) {
    mastermind(4, 6, 10);
  }

  /**
   * Tirage d'un entier au hasard entre 1 et max
   * @param max
   * @return
   */
  static int hasard(int max) {
    return (1 + (int) (Math.random() * max));
  }

  /**
   * Tire une combinaison à deviner. 
   * C'est la référence du tableau qui est passée
   * en paramètre. La méthode tirerCombinaison pourra directement
   * modifier la combinaison en mémoire.
   * @param combinaison
   * @param n
   * @param m
   */ 
  static void tirerCombinaison(int[] combinaison, int n, int m) {
    for (int i = 0; i < n; i++) {
      combinaison [i] = hasard(m);
      }
  }

  /**
   * Permet de lire la combinaison proposée
   * par le joueur
   * @param combinaison
   * @param n
   */ 
  static void demanderCoup(int[] combinaison, int n) {
    System.out.print("Entrez les ");
    System.out.print(n);
    System.out.print(" chiffres de votre proposition ");
    System.out.println("(terminés par un retour chariot) :");
    for (int i = 0; i < n; i++) {
      combinaison[i] = scanner.nextInt();
    }
  }

  /**
   * Permet de comparer la combinaison à deviner avec la 
   * combinaison proposée par le joueur.
   * Dans reponse[0] sera stocké le nombre d'éléments bien devinés 
   * et correctement placés.
   * Dans reponse[1] sera stocké le nombre d'éléments bien devinés
   * mais mal placés.
   * @param n
   * @param combinaison1
   * @param combinaison2
   * @param reponse 
   * @return true si la bonne combinaison est trouvée et false sinon
   */ 
  static boolean compare(int n, int[] combinaison1, int[] combinaison2,
    int[] reponse) {
    int nbCol = 0;
    int nbOk = 0;
    boolean [] marque = new boolean[n];
    boolean trouve = true;
    // cette première boucle sert à trouver 
    // les éléments bien devinés et correctement placés.
    // Le tableau marque permet de marquer de tels
    // éléments pour qu'ils ne soient pas considérés
    // plusieurs fois.
    for (int i = 0; i < n; i++) {
      if (combinaison1 [i] == combinaison2 [i]) {
        nbOk++;
        marque[i] = true;
      } else {
        trouve = false;
        marque[i] = false;
      }
    }
    // la deuxième boucle suivante sert à identifier les
    // éléments bien devinés mais mal placés.
    for (int i = 0; i < n; i++) {
      if (combinaison1[i] != combinaison2[i]) {
        int j = 0;
        boolean trouveMalPlace = false;
        while ((j < n) && !trouveMalPlace) {
          if (!marque[j] && (combinaison1[i] == combinaison2[j])) {
            nbCol++;
            marque[j] = true;
            trouveMalPlace = true;
          }
          j++;
        }
      }
    }

    reponse[0] = nbOk;
    reponse[1] = nbCol;
    return trouve;
  }

  /**
   * Affichage d'une combinaison
   * @param combinaison
   * @param n
   */ 
  static void afficheCombinaison(int[] combinaison, int n) {
    for (int i = 0; i < n; i++)
      System.out.print(combinaison[i]);
    System.out.println(" ");
  };

  /**
   * Affichage des indications destinées au joueur
   * @param reponse
   */ 
  static void afficheReponse(int[] reponse) {
    for (int i = 0; i < reponse[0]; i++)
      System.out.print('#');
    for (int i = 0; i < reponse[1]; i++)
      System.out.print('O');
    System.out.println();
  }

  /**
   * Affichage du texte d'acceuil
   * @param n
   * @param m
   * @param maxCoups
   */ 
  static void bienvenue(int n, int m, int maxCoups) {
    System.out.print("Pouvez vous trouver ma combinaison de ");
    System.out.print(n);
    System.out.print(" chiffres [compris entre 1 et ");
    System.out.print(m);
    System.out.print(" avec répétitions possibles]\n en moins de ");
    System.out.print(maxCoups);
    System.out.println(" coups ?");
  }

  /**
   * Jeu du Master-Mind 
   * Le programme tire une combinaison au hasard.
   * Le joueur cherche à la deviner et fait des propositions de 
   * combinaisons.
   * Le programme indique à chaque coup au joueur combien d'éléments
   * sont bien devinés et correctement placé ou bien devinés mais
   * mal placés.
   * Le jour a droit à <maxCoups> tentatives.
   * @param size
   * @param maxDigit
   * @param maxCoups
   */ 
  static void mastermind(int size, int maxDigit, int maxCoups) {
    int[] solution = new int[size];
    int[] proposition = new int[size];
    int nbCoups = 0;
    boolean trouve = false;
    int[] reponse = new int[2];

    bienvenue(size, maxDigit, maxCoups);
    tirerCombinaison(solution, size, maxDigit);

    do {
      demanderCoup(proposition, size);
      nbCoups++;
      trouve = compare(size, solution, proposition, reponse);
      afficheReponse(reponse);
    } while (!trouve && (nbCoups < maxCoups));

    if (trouve) {
      System.out.print("Bravo ! Vous avez trouvé en ");
      System.out.print(nbCoups);
      System.out.println(" coups");
    } else {
      System.out.println("Désolé vous n'avez pas trouvé...");
      System.out.println("La bonne réponse était ");
      afficheCombinaison(solution, size);
      System.out.println(".");
    }
  }

}