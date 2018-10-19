import java.util.Scanner;
import java.util.regex.*;
import java.util.InputMismatchException;

public class Puissance4 {

  static Scanner saisie;
  static int largeur = 7;
  static int hauteur = 6;
  static int choix, row, col, colonne, tour, tourSuivant, temp;
  static String[][] grille = new String[largeur][hauteur];
  static String[][] grilleUpdated = new String[largeur][hauteur];
  static String joueurUn, joueurDeux, joueur, name, pion;

  public static void main (String[] args) {

    saisie = new Scanner(System.in);

    NomsDesJoueurs();
    Reset(grille);
    System.out.println();
    grilleUpdated = AffichageGrille(grille);
    System.out.println();
    tour = TirageAuSort();
    joueur = Joueur(tour, joueurUn, joueurDeux);
    System.out.println(joueur + " commence !");
    System.out.println();

    while (5<8) {
      colonne = ChoixColonne(grille, joueur);
      InsertPion(grilleUpdated, colonne, joueur);
      System.out.println();
      AffichageGrille(grilleUpdated);
      System.out.println();
      // TestGrille();
      System.out.println();
      tourSuivant = ChangementDeJoueur(tour);
      joueur = Joueur(tourSuivant, joueurUn, joueurDeux);
    }

  }

  public static String NomsDesJoueurs() {
    System.out.println();
    System.out.println("    **** ! BIENVENUE SUR PUISSANCE 4 !  ****");
    System.out.println();
    System.out.println("Chaque joueur devra choisir un numero de colonne pour y glisser un pion");
    System.out.println();
    System.out.print("Joueur 1 (entrez votre nom) : ");
    joueurUn = saisie.nextLine();
    System.out.print("Joueur 2 (entrez votre nom) : ");
    joueurDeux = saisie.nextLine();

    return name;
  }

  public static String[][] AffichageGrille(String[][] grille) {
    // Numéro des colonnes
    //-----------------------------------------------
    for (col = 0; col < largeur; col++) {
      System.out.print("  " + (col+1) + " ");
    }

    System.out.println();

    // Ligne vides de séparateurs
    //-----------------------------------------------
    for (col = 0; col < largeur; col++) {
      if (col == largeur - 1) {
        System.out.print("|   |");
      }
      else {
        System.out.print("|   ");
      }
    }

    System.out.println();

    // Grille
    //-----------------------------------------------
    for (row = 0; row < hauteur; row++) {
      for (col = 0; col < largeur; col++) {

        if (col == largeur - 1) {
          System.out.print("| " + grille[col][row] + " |");
        }
        else {
          System.out.print("| " + grille[col][row] + " ");
        }

      }

      System.out.println();
    }

    return grille;
  }

  public static int TirageAuSort() {
    int nombreAleatoire = ((int) (Math.random() * (100-0))%2);

    return nombreAleatoire;

  }

  public static String Joueur(int tour, String nomUn, String nomDeux) {

    if (tour%2 == 0) {
      name = nomUn;
    }
    else {
      name = nomDeux;
    }

    return name;

  }

  public static int ChangementDeJoueur(int tourPrecedent) {

    tour += 1;

    // System.out.println(tour);

    return tour;

  }

  public static int ChoixColonne (String[][] grilleUpdated, String nomJoueur) {

    boolean isEntier = true;
    do {
      System.out.println();
      System.out.print(nomJoueur + ", choisis une colonne :  ");
      Scanner saisie = new Scanner(System.in);
      try {
        temp = saisie.nextInt();
        isEntier = true;
      } catch (InputMismatchException e)
      {
        System.out.println("Attention " + nomJoueur + " ! La valeur saisie n'est pas un entier");
        isEntier = false;
      }
    }
    while (isEntier != true);
    choix = temp - 1;


    if (choix < 0 || 6 < choix) {
      do {
        do {
          System.out.println();
          System.out.print("Attention " + nomJoueur + " ! choisis un chiffre entre 1 et 7 :  ");

          Scanner saisie = new Scanner(System.in);
          try {
            temp = saisie.nextInt();
            isEntier = true;
          } catch (InputMismatchException e)
          {
            System.out.println("Attention " + nomJoueur + " ! La valeur saisie n'est pas un entier");
            isEntier = false;
          }
        }
        while (isEntier != true);
        choix = temp - 1;
      }
      while (choix < 0 || 6 < choix);
    }


    if (grilleUpdated[choix][0].indexOf('.') == -1) {
      do {
        System.out.println();
        System.out.print("Attention " + nomJoueur + " ! La colonne est pleine, choisis-en une autre :  ");
        temp = saisie.nextInt();
        choix = temp - 1;

        if (choix < 0 || 6 < choix) {
          do {
            System.out.println();
            System.out.print("Attention " + nomJoueur + " ! choisis un chiffre entre 1 et 7 :  ");
            temp = saisie.nextInt();
            choix = temp - 1;
          }
          while (choix < 0 || 6 < choix);

        }

      }
      while (grilleUpdated[choix][0].indexOf('.') == -1);

    }

    return choix;

  }

  public static String[][] InsertPion(String[][] grilleUpdated, int colonne, String nomJoueur) {

    // Reset row
    row = 0;

    if (nomJoueur == joueurUn) {
      pion = "O";
    }
    else {
      pion = "X";
    }

    // int i = grilleUpdated[choix-1][row+1].indexOf('.');
    // int i = 22;
    while (grilleUpdated[choix][row].indexOf('.') == 0 && row<5) {

      row += 1;
    }
    if (grilleUpdated[choix][row].indexOf('.') == -1) {
      grilleUpdated[choix][row-1] = pion;
    }
    if (grilleUpdated[choix][row].indexOf('.') == 0 && 5 <= row) {
      grilleUpdated[choix][row] = pion;
    }

    // AffichageGrille(grilleUpdated);
    return grilleUpdated;

  }

  public static String[][] Reset(String[][] grille) {

    for (row = 0; row < hauteur; row++) {
      for (col = 0; col < largeur; col++) {
        grille[col][row] = ".";
      }
    }

    return grille;
  }

}
