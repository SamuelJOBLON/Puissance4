import java.util.Scanner;

public class Puissance4 {

  static Scanner saisie;
  static int largeur = 7;
  static int hauteur = 6;
  static int choix, row, col, colonne;
  static String[][] grille = new String[largeur][hauteur];
  static String[][] grilleUpdated = new String[largeur][hauteur];
  static String joueurUn, joueurDeux, premierJoueur, name, pion;

  public static void main (String[] args) {

    saisie = new Scanner(System.in);

    NomsDesJoueurs();
    Reset(grille);
    System.out.println();
    grilleUpdated = AffichageGrille(grille);
    System.out.println();
    premierJoueur = PremierJoueur(joueurUn, joueurDeux);
    System.out.println(premierJoueur + " commence !");
    System.out.println();
    colonne = ChoixColonne(grille, premierJoueur);
    Jeux(grilleUpdated, colonne, premierJoueur);


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

  public static String PremierJoueur(String nomUn, String nomDeux) {
    int nombreAleatoire = ((int) (Math.random() * (100-0))%2);
    if (nombreAleatoire == 0) {
      name = nomUn;
    }
    else {
      name = nomDeux;
    }

    return name;

  }

  public static int ChoixColonne(String[][] grilleUpdated, String nomJoueur) {

    System.out.print(nomJoueur + ", choisis une colonne :  ");
    int temp = saisie.nextInt();
    choix = temp - 1;
    System.out.println(choix);
    if (choix < 0 || 6 < choix) {
      do {
        System.out.println();
        System.out.print("Attention " + nomJoueur + " ! choisis un chiffre entre 1 et 7 :  ");
        choix = saisie.nextInt();
      }
      while (choix < 0 || 6 < choix);
    }

    // if (grilleUpdated[choix][0].indexOf('.') == 0) {
    //
    //   do {
    //     System.out.println();
    //     System.out.print("Attention " + nomJoueur + " ! La colonne est pleine, choisis-en une autre :  ");
    //     choix = saisie.nextInt();
    //   }
    //   while (choixRef == choix);
    // }

    return choix;

  }

  public static void Jeux(String[][] grilleUpdated, int colonne, String nomJoueur) {

    // Reset row
    row = 0;
    System.out.println(colonne);
    System.out.println(nomJoueur);
    System.out.println(choix);
    System.out.println(row);
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

    AffichageGrille(grilleUpdated);








    // row += 1;
    // System.out.println(choix);
    // System.out.println(row);
    // grilleUpdated[choix-1][row] = pion;
    // AffichageGrille(grilleUpdated);

  }

  public static String[][] Reset(String[][] grille) {

    for (row = 0; row < hauteur; row++) {
      for (col = 0; col < largeur; col++) {
        grille[col][row] = ".";
      }
    }

    grille[0][5] = "A";
    grille[1][5] = "A";
    grille[2][5] = "A";
    grille[3][5] = "A";
    grille[4][5] = "A";
    grille[5][5] = "A";
    // grille[6][5] = "A";

    return grille;
  }

}
