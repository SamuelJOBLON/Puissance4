
public class ConditionsVictoires{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//déclaration de la grille et de la valeur de controle
		int col =7;
		int row=6;
		int[][] truc = { 
				{0,0,0,1,1,1,1},
				{0,0,1,1,0,0,0},
				{0,0,0,0,1,0,1},
				{0,0,0,0,1,1,1},
				{0,0,0,0,1,0,1},
				{1,0,0,1,0,0,1}
		};
		
		int valeur = 1;
		int gagnant = 0;
		
		
		// impression de la grille
		for (col=0; col<truc.length; col++){
			for (row=0; row<truc[col].length; row++) {
				
					System.out.print(truc[col][row] + " ");
				
				}
			System.out.println();

			}
			
		
		// contrôle de la condition verticale
		for (col=0; col<truc.length; col++) {
			for (row = 0; row<truc[col].length; row++) {
				if (col<truc.length-3)
					if (truc[col][row] == valeur && truc[col+1][row] == valeur && truc[col+2][row] == valeur && truc[col+3][row] == valeur) {
						
							gagnant = 1;
						System.out.println("il y a 4 pions verticalement");
					}
				
			}
		}
		
		// contrôle de la condition horizontale
				for (col=0; col<truc.length; col++) {
					for (row = 0; row<truc[col].length; row++) {
						if (row<truc.length-2)
							if (truc[col][row] == valeur && truc[col][row+1] == valeur && truc[col][row+2] == valeur && truc[col][row+3] == valeur) {
								
									gagnant = 1;
									System.out.println("il y a 4 pions horizontalement");
							}
						
					}
				}
		
		
		
		
		// controle de la condition diagonale bas-droite
		
				
				for (col=0; col<truc.length; col++) {
					for (row = 0; row<truc[col].length; row++) {
						if (col<truc.length-3 && row<truc.length-2)
							if (truc[col][row] == valeur && truc[col+1][row+1] == valeur && truc[col+2][row+2] == valeur && truc[col+3][row+3] == valeur) {
								
									gagnant = 1;
									System.out.println("il y a 4 pions en diagonale bas-droite");
							}
						
					}
				}
			
				
				// controle de la condition diagonale bas-gauche
				
				
				for (col=0; col<truc.length; col++) {
					for (row = 0; row<truc[col].length; row++) {
						if (col>2 && row<4)
							if (truc[col][row] == valeur && truc[col-1][row+1] == valeur && truc[col-2][row+2] == valeur && truc[col-3][row+3] == valeur) {
								
									gagnant = 1;
									System.out.println("il y a 4 pions en diagonale bas-gauche");
							}
						
					}
				}
				
				
				
				// impression de la réussite d'une des conditions de victoire
				
		System.out.println("longueur de truc: " + truc.length);		
		if (gagnant == 1) {
			System.out.println("Victoire");
		
		
		
					
	}
}
}	


