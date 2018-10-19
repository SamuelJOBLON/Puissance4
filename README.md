# Puissance4

Le  jeu se présente sous la forme d'une grille de longueur 7 et de hauteur 6.
Il se joue à deux joueurs, qui vont glisser tour à tour un pion (de la couleur du joueur) dans une colonne de leur choix.
Les pions tombent jusqu'à la dernière place libre de la colonne. 
Si après le tour d'un joueur, 4 de ses pions forment une ligne horizontale, verticale, ou en diagonale, le joueur gagne.

Difficultés technique: 

-Assurer l'alternance de jeu entre les deux joueurs, et mettre en jeu les pions qui correspondent.
-Faire en sorte que le pion aille à la bonne place sans écraser d'autres pions.
-Faire en sorte que le jeu n'essaie pas de compter des jetons en dehors des limites de la grille lorsqu'il vérifie
si des suites de 4 pions existent.




Déroulement du code du jeu:


1) Affichage de l'introduction
2) Input des noms des deux joueurs
3) Selection au hasard de qui commence le jeu
4) Affichage de la grille
5) Choix de la colonne dans laquelle poser le pion
	5bis) Le pion descend à la dernière place libre de la colonne
	5ter) le jeu controle si des conditions de victoires sont remplies
6) Le jeu passe la main au deuxième joueur --> Etapes 5, 5bis, 5ter
7) Si une condition de victoire est remplie, le jeu met fin à la partie et affiche le gagnant.
	7bis)Si le tableau est plein sans gagnant, le jeu met fin à la partie.
8) Le jeu Propose de recommencer --> Si oui, Reset de la grille et Retour à l'étape 3.



Proposition d'évolution du jeu: 

Tenir un décompte des scores de victoires lors d'une session de plusieurs parties entre les deux joueurs.
Donner la possibilité de mettre des handicaps pour un joueur confiant, et permettre à l'autre de jouer ses deux premiers tours d'affilée.
Créer une IA qui pourrait jouer contre le joueur (de manière aléatoire ou en essayant de calculer le meilleur coup pour gagner)
Permettre aux deux joueurs de se connecter en LAN / Network
Inclure des leaderboards en base de donnée distante.
Etendre les supports d'execution pour bénéficier d'une meilleure finition en terme d'expérience utilisateur (graphismes, sons, animations)








