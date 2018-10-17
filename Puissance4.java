import java.util.Scanner;

public class Puissance4 {

  static Scanner saisie;

  public static void main (String[] args) {

    saisie = new Scanner(System.in);

    int largeur = 7;
    int hauteur = 5;
    String[][] grille = new String[largeur][hauteur];

    for (int col = 0; col < largeur; col++) {
      System.out.print("  " + (col+1) + " ");
    }
    System.out.println();
    // System.out.println(Reset(grille));
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

  }

  // public static String[][] Reset(String[][] grille) {
  //
  //   for (int row = 0; row < hauteur; row++) {
  //     for (int col = 0; col < largeur; col++) {
  //       grille[col][row] = ".";
  //
  //       if (col == largeur - 1) {
  //         System.out.print("| " + grille[col][row] + " |");
  //       }
  //       else {
  //         System.out.print("| " + grille[col][row] + " ");
  //       }
  //
  //     }
  //
  //     System.out.println();
  //   }
  //
  //   return grille;
  //
  // }

}
