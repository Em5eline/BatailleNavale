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
