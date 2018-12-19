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





TODO LIST:
