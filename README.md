# Puissance4

Le  jeu se pr�sente sous la forme d'une grille de longueur 7 et de hauteur 6.
Il se joue � deux joueurs, qui vont glisser tour � tour un pion (de la couleur du joueur) dans une colonne de leur choix.
Les pions tombent jusqu'� la derni�re place libre de la colonne. 
Si apr�s le tour d'un joueur, 4 de ses pions forment une ligne horizontale, verticale, ou en diagonale, le joueur gagne.

Difficult�s technique: 

-Assurer l'alternance de jeu entre les deux joueurs, et mettre en jeu les pions qui correspondent.
-Faire en sorte que le pion aille � la bonne place sans �craser d'autres pions.
-Faire en sorte que le jeu n'essaie pas de compter des jetons en dehors des limites de la grille lorsqu'il v�rifie
si des suites de 4 pions existent.




D�roulement du code du jeu:


1) Affichage de l'introduction
2) Input des noms des deux joueurs
3) Selection au hasard de qui commence le jeu
4) Affichage de la grille
5) Choix de la colonne dans laquelle poser le pion
	5bis) Le pion descend � la derni�re place libre de la colonne
	5ter) le jeu controle si des conditions de victoires sont remplies
6) Le jeu passe la main au deuxi�me joueur --> Etapes 5, 5bis, 5ter
7) Si une condition de victoire est remplie, le jeu met fin � la partie et affiche le gagnant.
	7bis)Si le tableau est plein sans gagnant, le jeu met fin � la partie.
8) Le jeu Propose de recommencer --> Si oui, Reset de la grille et Retour � l'�tape 3.



Proposition d'�volution du jeu: 

Tenir un d�compte des scores de victoires lors d'une session de plusieurs parties entre les deux joueurs.
Donner la possibilit� de mettre des handicaps pour un joueur confiant, et permettre � l'autre de jouer ses deux premiers tours d'affil�e.
Cr�er une IA qui pourrait jouer contre le joueur (de mani�re al�atoire ou en essayant de calculer le meilleur coup pour gagner)
Permettre aux deux joueurs de se connecter en LAN / Network
Inclure des leaderboards en base de donn�e distante.
Etendre les supports d'execution pour b�n�ficier d'une meilleure finition en terme d'exp�rience utilisateur (graphismes, sons, animations)








