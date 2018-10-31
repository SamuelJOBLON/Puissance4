import java.util.Scanner;
import java.util.regex.*;
import java.util.InputMismatchException;

public class Puissance4 {

  static Scanner saisie;
  static int largeur = 7;
  static int hauteur = 6;
  static int compteur = 0;
  static int i = 0;
  static int choix, row, col, colonne, tour, tourSuivant, temp, ligneResultante, rang;
  static char[][] grille = new char[largeur][hauteur];
  static char[][] grilleUpdated = new char[largeur][hauteur];
  static String joueurUn, joueurDeux, joueur, name;
  static char pion, pionJoueur;
  static boolean result = false;

  public static void main (String[] args) {

    saisie = new Scanner(System.in);

    NomsDesJoueurs();
    Reset(grille);
    System.out.println();
    grilleUpdated = AffichageGrille(grille);
    System.out.println();
    tour = TirageAuSort();
    joueur = Joueur(tour, joueurUn, joueurDeux);
    pion = PionJoueur(joueur);
    System.out.println(joueur + " commence !");
    System.out.println();

    while (compteur != largeur*hauteur &&
            !ScanHorizontal(grilleUpdated, ligneResultante, pion) &&
            !ScanVertical(grilleUpdated, colonne, pion)) {
      colonne = ChoixColonne(grille, joueur);
      InsertPion(grilleUpdated, colonne, joueur, pion);
      System.out.println();
      AffichageGrille(grilleUpdated);
      System.out.println();
      System.out.println();
      ScanHorizontal(grilleUpdated, ligneResultante, pion);
      ScanVertical(grilleUpdated, colonne, pion);
      tourSuivant = ChangementDeJoueur(tour);
      compteur += 1;
      System.out.println(compteur);
      joueur = Joueur(tourSuivant, joueurUn, joueurDeux);
      pion = PionJoueur(joueur);

      // System.out.println(ConditionsVictoire(grilleUpdated, joueurUn, joueurDeux));
      // ConditionsVictoire(grilleUpdated, joueurUn, joueurDeux);
    }

    if (compteur == largeur*hauteur) {
      System.out.println();
      System.out.println("**** !!!!  GRILLE PLEINE  !!!! ****");
    }
    // if (ScanHorizontal(grilleUpdated, ligneResultante, pion)) {
    //   tourSuivant = ChangementDeJoueur(tour);
    //   joueur = Joueur(tourSuivant, joueurUn, joueurDeux);
    //   pion = PionJoueur(joueur);
    //   rang = hauteur - ligneResultante;
    //   System.out.println("il y a 4 " + pion + " à l'horizontale au rang " + rang);
    //   System.out.println(joueur + " EST VAINQUEUR");
    // }
    // if (ScanVertical(grilleUpdated, colonne, pion)) {
    //   tourSuivant = ChangementDeJoueur(tour);
    //   joueur = Joueur(tourSuivant, joueurUn, joueurDeux);
    //   pion = PionJoueur(joueur);
    //   System.out.println("il y a 4 " + pion + " à la verticale à la colonne " + colonne);
    //   System.out.println(joueur + " EST VAINQUEUR");
    // }

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

  public static char[][] AffichageGrille(char[][] grille) {
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
    return tour;

  }

  public static int ChoixColonne (char[][] grilleUpdated, String nomJoueur) {

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


    if (grilleUpdated[choix][0] != '.') {
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
      while (grilleUpdated[choix][0] != '.');

    }

    return choix;

  }

  public static char PionJoueur(String nomJoueur) {
    if (nomJoueur == joueurUn) {
      pion = 'O';
    }
    else {
      pion = 'X';
    }

    return pion;
  }

  public static char[][] InsertPion(char[][] grilleUpdated, int colonne, String nomJoueur, char pionJoueur) {

    // Reset row
    row = 0;

    while (grilleUpdated[choix][row] == '.' && row < hauteur-1) {

      row += 1;
    }
    if (grilleUpdated[choix][row] != '.') {
      grilleUpdated[choix][row-1] = pionJoueur;
      ligneResultante = row-1;
    }
    if (grilleUpdated[choix][row] == '.' && hauteur-1 <= row) {
      grilleUpdated[choix][row] = pionJoueur;
      ligneResultante = row;
    }

    return grilleUpdated;

  }

  public static boolean ScanHorizontal(char[][] grilleUpdated, int rowInit, char pionJoueur) {

    // contrôle de la condition horizontale
    for (col = 0; col < largeur-1; col ++) {
      if (grilleUpdated[col][rowInit] == pionJoueur) {
        i += 1; // compteur qui à la hauteur de 4 (4 pions alignés) déclare un vainqueur
        if (i == 4) {
          result = true;
          rang = hauteur - rowInit;
          System.out.println("il y a 4 " + pion + " a l'horizontale au rang " + rang);
          System.out.println(joueur + " EST VAINQUEUR");
        }
      }
      else {
        i = 0;
      }
    }

    return result;
  }

  public static boolean ScanVertical(char[][] grilleUpdated, int colInit, char pionJoueur) {

    // contrôle de la condition horizontale
    for (row = hauteur-1; 0 < row; row --) {
      if (grilleUpdated[colInit][row] == pionJoueur) {
        i += 1; // compteur qui à la hauteur de 4 (4 pions alignés) déclare un vainqueur
        if (i == 4) {
          result = true;
          colonne += 1;
          System.out.println("il y a 4 " + pion + " a la verticale a la colonne " + colonne);
          System.out.println(joueur + " EST VAINQUEUR");
        }
      }
      else {
        i = 0;
      }
    }

    return result;
  }

  public static char[][] Reset(char[][] grille) {

    for (row = 0; row < hauteur; row++) {
      for (col = 0; col < largeur; col++) {
        grille[col][row] = '.';
      }
    }

    return grille;
  }

}
