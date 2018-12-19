# Navire 
```java
public void placementAuto(int[] taillesNavires) {
		if (taillesNavires.length > navires.length)
			throw new IllegalArgumentException("Trop de bâteaux pour cette grille");
		else {
			for (int i = 0; i < taillesNavires.length; i++) {
				int col = (int) (Math.random() * taille);
				int lig = (int) (Math.random() * taille);

				Coordonnee coord = new Coordonnee(col, lig);
				double orient = Math.random() + 0.05;
				boolean verticalitude;
				if (orient > 0.5)
					verticalitude = true;
				else
					verticalitude = false;
				Navire nav = new Navire(coord, taillesNavires[i], verticalitude);
				System.out.println(nav);
				if (ajouteNavire(nav) == false) {
					System.out.println("ca marche pas...");
					i -= 1;
				}

			}

		}

	}
```
```java

	public boolean touche(Navire n) {
		Coordonnee parcoursThis = this.debut;
		Coordonnee parcoursN = n.debut;
		int colonneThis = this.fin.getColonne() - this.debut.getColonne();
		int ligneThis = this.fin.getLigne() - this.debut.getLigne();
		int colonneN = n.fin.getColonne() - n.debut.getColonne();
		int ligneN = n.fin.getLigne() - n.debut.getLigne();

		if (colonneThis == 0) { // Si this est verticale
			for (int i = 0; i < ligneThis + 1; i++) { // pour chaque ligne de this
				parcoursN = n.debut;

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

						if (parcoursThis.voisine(parcoursN) == true) {// on vérifie voisinage
							return true;
						} else {
							parcoursN = new Coordonnee(parcoursN.getColonne() + 1, parcoursN.getLigne());
						} // sinon on
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
			for (int i = 0; i < colonneThis + 1 + 1; i++) { // pour chaque colonne de this
				parcoursN = n.debut;
				if (colonneN == 0) { // et que n est verticale
					for (int j = 0; j < ligneN + 1 + 1; j++) { // pour chaque ligne de n
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
	
```
Nouveau constructeur : 
```java
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

```
Nouvelle méthode touche(Navire n) :
```java
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
```

# Coordonnee
CompareTo de coordonnee : 

```java
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
```




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

recoitTir de GrilleNavale OK :
```java
public boolean recoitTir(Coordonnee c) {

	for (int i = 0; i < nbNavires; i++) {
		if (navires[i].contient(c)) {
			ajouteDansTirsRecus(c);
			navires[i].recoitTir(c);
			return true;
		}
	}
	ajouteDansTirsRecus(c);
	return false;
}
```
estTouche OK
```java
public boolean estTouche(Coordonnee c) {
		for (int i = 0; i < nbNavires; i++) {
			if (navires[i].recoitTir(c)) {
				return true;
			}
		}
		return false;
	}
```

Nouvelle méthode estALEau(Coordonnee c) :
```java
public boolean estALEau(Coordonnee c) {
	return !(this.estTouche(c));
}
``` 
Estcoule
```java
public boolean estCoule(Coordonnee c) {
	// pour chaque navire
	for (int i = 0; i < nbNavires ; i++) {

		// s'il est touché a cette coordonnée
		if (this.estTouche(c)) {

			// on récupère ses données
			Coordonnee deb = navires[i].getDebut();
			Coordonnee fin = navires[i].getFin();
			int lgr;
			int count = 0;

			// on prend sa longueur : navire est vertical si colonne deb == colonne fin
			if ((deb.getColonne() == fin.getColonne())) {
				lgr = fin.getLigne() - deb.getLigne()+1;
			// sinon il est horizontal
			} else {
				lgr = fin.getColonne() - deb.getColonne()+1;

			}
			// pour chaque tir recu dans la grille
			for (int j = 0; j < nbTirsRecus; j++) {
				// on compte le nombre de tirs recus par le navire
				if (navires[i].contient(tirsRecus[j]))
					count++;
			} // fin for

			if (count+1 == lgr)
				return true;

		} // fin if
	}

	return false;
}
```

Nouvelle méthode perdu() : 
```java
public boolean perdu() {
	// pour chaque navire
	for (int i = 0; i < nbNavires ; i++) {
		// on récupère ses données
		Coordonnee deb = navires[i].getDebut();
		Coordonnee fin = navires[i].getFin();
		int lgr;
		int count = 0;

		// on prend sa longueur : navire est vertical si colonne deb == colonne fin
		if ((deb.getColonne() == fin.getColonne())) {
			lgr = fin.getLigne() - deb.getLigne()+1;
		// sinon il est horizontal
		} else {
			lgr = fin.getColonne() - deb.getColonne()+1;

		}
		// pour chaque tir recu dans la grille
		for (int j = 0; j < nbTirsRecus; j++) {
			// on compte le nombre de tirs recus par le navire
			if (navires[i].contient(tirsRecus[j]))
				count++;
		} // fin for

		if (count+1 != lgr)
			return false;

	} // fin if

	return true;
}
```
TODO LIST:
