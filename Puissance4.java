import java.util.Scanner;

public class Puissance4 {

  static Scanner saisie;
  static int largeur = 7;
  static int hauteur = 5;
  static String[][] grille = new String[largeur][hauteur];
  static String joueurUn;
  static String joueurDeux;
  static String name;

  public static void main (String[] args) {

    saisie = new Scanner(System.in);

    NomsDesJoueurs();
    Reset(grille);
    AffichageGrille(grille);

  }

  public static String NomsDesJoueurs() {
    System.out.println();
    System.out.println("    **** ! BIENVENUE SUR PUISSANCE 4 !  ****");
    System.out.println();
    System.out.print("Joueur 1 (entrez votre nom) : ");
    joueurUn = saisie.nextLine();
    System.out.print("Joueur 2 (entrez votre nom) : ");
    joueurDeux = saisie.nextLine();

    return name;
  }

  public static String[][] AffichageGrille(String[][] grille) {
    for (int col = 0; col < largeur; col++) {
      System.out.print("  " + (col+1) + " ");
    }
    System.out.println();
    for (int row = 0; row < hauteur; row++) {
      for (int col = 0; col < largeur; col++) {

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

  public static String[][] Reset(String[][] grille) {

    for (int row = 0; row < hauteur; row++) {
      for (int col = 0; col < largeur; col++) {
        grille[col][row] = ".";

      }

    }

    return grille;
  }

}
