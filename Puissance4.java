import java.util.Scanner;

public class Puissance4 {

  static Scanner saisie;
  static int largeur = 7;
  static int hauteur = 5;
  static String[][] grille = new String[largeur][hauteur];

  public static void main (String[] args) {

    saisie = new Scanner(System.in);



    for (int col = 0; col < largeur; col++) {
      System.out.print("  " + (col+1) + " ");
    }
    System.out.println();
    Reset(grille);

  }

  public static String[][] Reset(String[][] grille) {

    for (int row = 0; row < hauteur; row++) {
      for (int col = 0; col < largeur; col++) {
        grille[col][row] = ".";

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

}
