import java.util.Scanner;

public class Puissance4 {

  static Scanner saisie;
  static int largeur = 7;
  static int hauteur = 6;
  static int choix, row, col;
  static String[][] grille = new String[largeur][hauteur];
  static String joueurUn, joueurDeux, name, pion;

  public static void main (String[] args) {

    saisie = new Scanner(System.in);

    NomsDesJoueurs();
    Reset(grille);
    System.out.println();
    AffichageGrille(grille);
    System.out.println();
    Jeux(grille, QuelJoueurCommence(joueurUn, joueurDeux));

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

  public static  {
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

  public static String QuelJoueurCommence(String nomUn, String nomDeux) {
    int nombreAleatoire = ((int) (Math.random() * (100-0))%2);
    if (nombreAleatoire == 0) {
      name = nomUn;
    }
    else {
      name = nomDeux;
    }

    return name;
    // jeux() ;
  }

  public static void Jeux(String[][] grilleUpdated, String nomJoueur) {
    System.out.println(nomJoueur + " commence !");
    System.out.println();
    System.out.print(nomJoueur + ", choisis une colonne :  ");
    choix = saisie.nextInt();
    if (choix <= 0 || 7 < choix) {
      do {
        System.out.println();
        System.out.print("Attention " + nomJoueur + " ! choisis un chiffre entre 1 et 7 :  ");
        choix = saisie.nextInt();
      }
      while (choix <= 0 || 7 < choix);
    }

    if (nomJoueur == joueurUn) {
      pion = "O";
    }
    else {
      pion = "X";
    }

    grilleUpdated[choix-1][hauteur-1] = "A";
    for (row = 0; row < hauteur; row++) {

      // Teste si la colonne est pleine
      // if (grilleUpdated[choix-1][0] != ".") {
      //   System.out.println("La colonne est pleine, choisissez-en une autre : ");
      // }
      // Teste si la colonne est pleine
      if (grilleUpdated[choix-1][row] == ".") {
        grilleUpdated[choix-1][row] = pion;
      }
      else {
        grilleUpdated[choix-1][row] = "B";
      }
      // Teste si la colonne est pleine
      // if (grilleUpdated[choix-1][row+1] != ".") {
      //   grilleUpdated[choix-1][row] = pion;
      // }

    }

    // grilleUpdated[choix-1][hauteur-1] = pion;

    AffichageGrille(grilleUpdated);




    // return grilleUpdated;

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
