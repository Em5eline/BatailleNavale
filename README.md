# Navire 
Nouveau constructeur : 

public Navire(Coordonnee debut, int longueur, boolean estVertical) {

	if (longueur <= 0)
		throw new IllegalArgumentException("Ton navire n'existe pas. La honte !");
	if (longueur > 5)
		throw new IllegalArgumentException("Folie des grandeurs : pas de navire de plus de 5 cases !");
	if (longueur == 1)
		throw new IllegalArgumentException("Quel timide ! Un navire doit faire plus d'une case !");
		
	if (estVertical) {
		if (longueur + debut.getLigne() > 25) {
			throw new IllegalArgumentException("Folie des grandeurs : le navire dépasse de la grille ! ");
		} else {
			this.debut = new Coordonnee(debut.getColonne(), debut.getLigne());
			this.fin = new Coordonnee(this.debut.getColonne(), longueur + this.debut.getLigne() - 1);
		}
	} else {
		if (longueur + debut.getColonne() > 25) {
			throw new IllegalArgumentException("Folie des grandeurs : le navire dépasse de la grille !");
		} else {
			this.debut = new Coordonnee(debut.getColonne(), debut.getLigne());
			this.fin = new Coordonnee(longueur + this.debut.getColonne() - 1, this.debut.getLigne());
		}
	}
}

# Navire : 
Nouvelle méthode touche(Navire n) :

public boolean touche(Navire n) {
		Coordonnee parcoursThis = this.debut;
		Coordonnee parcoursN = n.debut;
		int colonneThis = this.fin.getColonne() - this.debut.getColonne();
		int ligneThis = this.fin.getLigne() - this.debut.getLigne();
		int colonneN = n.fin.getColonne() - n.debut.getColonne();
		int ligneN = n.fin.getLigne() - n.debut.getLigne();
		if (colonneThis == 0) { // Si this est verticale
			for (int i = 0; i < ligneThis + 1; i++) { // pour chaque ligne de this
				if (colonneN == 0) { // et que n est verticale
					for (int j = 0; j < ligneN + 1; j++) { // pour chaque ligne de n
						if (parcoursThis.voisine(parcoursN)) // on vérifie le voisinage
							return true;
						else
							parcoursN = new Coordonnee(parcoursN.getColonne(), parcoursN.getLigne() + 1); // sinon on
																											// augmente
																											// la
																											// ligne de
																											// n 
					}
				} else { // Si N est horizontale
					for (int j = 0; j < colonneN + 1; j++) { // Pour chaque colonne de N
						if (parcoursThis.voisine(parcoursN))// on vérifie voisinage
							return true;
						else
							parcoursN = new Coordonnee(parcoursN.getColonne() + 1, parcoursN.getLigne()); // sinon on
																											// augmente
																											// la
																											// colonne
																											// de n

					}

				}
				parcoursThis = new Coordonnee(parcoursThis.getColonne(), parcoursThis.getLigne() + 1); // On incrément
																										// la ligne de
																										// this
			}
		} else { // Si this est horizontale
			for (int i = 0; i < colonneThis + 1; i++) { // pour chaque colonne de this
				if (colonneN == 0) { // et que n est verticale
					for (int j = 0; j < ligneN + 1; j++) { // pour chaque ligne de n
						if (parcoursThis.voisine(parcoursN)) // on vérifie le voisinage
							return true;
						else
							parcoursN = new Coordonnee(parcoursN.getColonne(), parcoursN.getLigne() + 1); // sinon on
																											// augmente
																											// la
																											// ligne de
																											// n // de
																											// //
																											// aprcoursThis
					}
				} else { // Si N est horizontale
					for (int j = 0; j < colonneN + 1; j++) { // Pour chaque colonne de N
						if (parcoursThis.voisine(parcoursN))// on vérifie voisinage
							return true;
						else
							parcoursN = new Coordonnee(parcoursN.getColonne() + 1, parcoursN.getLigne()); // sinon on
																											// augmente
																											// la
																											// colonne
																											// de n

					}

				}
				parcoursThis = new Coordonnee(parcoursThis.getColonne() + 1, parcoursThis.getLigne()); // On incrément
																										// la ligne de
																										// parcoursThis

			}
		}
			return false;
		
	}


# BatailleNavale
Projet programmation Java.

CompareTo de coordonnee : 

	
	public int compareTo (Coordonnee c) {

		
		if (this.ligne == c.ligne && this.colonne == c.colonne)
			return 0;

		if (this.ligne > c.ligne) {
			return 1;
		} else if (this.ligne < c.ligne) {
			return -1;
		} else
			return this.colonne > c.colonne ? 1 : -1;
	}





## Grille Navale


```java
private boolean ajouteDansTirsRecus(Coordonnee c) {
	if (c == null)
		throw new IllegalArgumentException("Null interdit");
	if (estDansTirsRecus(c))
		return false;

	this.nbTirsRecus++;

	// on crée un nouveau tableau intermed avec nbTirsRecus+1
	Coordonnee intermed[] = new Coordonnee[nbTirsRecus];

	// on copie ce qui avait dans le tableau précédent
	for (int i = 0; i < nbTirsRecus-1; i++) {
		intermed[i] = this.tirsRecus[i];
	}

	// on ajoute le dernier tir recu et met a jour le tableau 
	intermed[nbTirsRecus-1] = c;

	// on met a jour la taille de tirsRecus et on copie intermed dedans
	this.tirsRecus = new Coordonnee[nbTirsRecus];
	this.tirsRecus = intermed;

	// dans ces deux cas
	return true;
}
```

TODO LIST:
