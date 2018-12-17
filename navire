package batailleNavale;

public class Navire {
	private Coordonnee debut;
	private Coordonnee fin;
	private Coordonnee[] partiesTouchees;
	private int nbTouchees;

	/**
	 * Constructeur
	 * 
	 * @param debut       : coordonnee de debut du navire
	 * @param longueur    : longueur du navire
	 * @param estVertical : orientation du navire
	 */

	public Navire(Coordonnee debut, int longueur, boolean estVertical) {
		if (estVertical) {
			if (longueur + debut.getLigne() - 1 > 25) {
				throw new IllegalArgumentException("Le bateau dépasse de la grille !");
			} else {
				this.debut = new Coordonnee(debut.getColonne(), debut.getLigne());
				this.fin = new Coordonnee(this.debut.getColonne(), longueur + this.debut.getLigne());

			}
		} else {
			if (longueur + debut.getColonne() - 1 > 25) {
				throw new IllegalArgumentException("Le bateau dépasse de la grille !");
			} else {
				this.debut = new Coordonnee(debut.getColonne(), debut.getLigne());
				this.fin = new Coordonnee(longueur + this.debut.getColonne(), this.debut.getLigne());
			}
		}
	}

	/**
	 * Retourne une String représentant this. On souhaite obtenir une représentation de la
	   forme "Navire(B1, 4, horizontal)" (pour un navire de taille 4 placé
	   horizontalement par exemple).
	 */
	
	public String toString() {
		int colonne = fin.getColonne() - debut.getColonne();
		int ligne = fin.getLigne() - debut.getLigne();
		if (colonne == 0)
			return ("Navire(" + this.debut.toString() + ", " + ligne + ", " + " vertical)");
		else
			return ("Navire(" + this.debut.toString() + ", " + colonne + ", " + " horizontal)");
	}

	/**
	 * Accesseur en lecture des coordonnees de debut du navire
	 * 
	 * @return les valeurs des coordonnees de debut du navire
	 */

	public Coordonnee getDebut() {
		return this.debut;
	}

	/**
	 * Accesseur en lecture des coordonnees de fin du navire
	 * @return les valeurs des coordonnees de fin du navire
	 */
	
	public Coordonnee getFin() {
		return this.fin;
	}

	/**
	 * permet de savoir si un navire passe par une coordonnee c
	 * 
	 * @param c : 0 <= c.colonne <= 25 et 0<= c.ligne <= 25
	 * @return true or false
	 */

	public boolean contient(Coordonnee c) {
		int colonne = this.fin.getColonne() - this.debut.getColonne();
		int ligne = this.fin.getLigne() - this.debut.getLigne();
		if (colonne == 0 && c.getColonne() == this.debut.getColonne() && c.getLigne() >= this.debut.getLigne() && c.getLigne() <= this.fin.getLigne()) { // navire
																											// horizontal
			return true;
		} else if (ligne == 0 && c.getLigne() == this.debut.getLigne() && c.getColonne() >= this.debut.getColonne() && c.getColonne() <= this.fin.getColonne()) { // navire
																															// vertical
			return true;
		} else
			return false;

	}

	/**
	 * permet de savoir si un navire touche un autre navire
	 * 
	 * @param n Navire
	 * @return true ou false
	 */

	public boolean touche(Navire n) {
		if (this.debut.voisine(n.debut) || this.fin.voisine(n.fin))
			return true;
		else
			return false;
	}

	public boolean chevauche(Navire n) {
		boolean resultat = false;
		int colonne = this.fin.getColonne() - this.debut.getColonne();
		if (colonne == 0) {
			int i = this.debut.getLigne();
			Coordonnee coor = new Coordonnee(this.debut.getColonne(), i);
			while (i<=this.fin.getLigne() && resultat == false) {
				resultat = n.contient(coor);
				i = i+1;
			}	
		}
		else {
			int i = this.debut.getColonne();
			Coordonnee coor = new Coordonnee(i,this.debut.getLigne());
			while (i <= this.fin.getColonne() && resultat == false) {
				resultat = n.contient(coor);
				i = i+1;
			}
		}
		return resultat;
	}

	public static void main(String[] args) {
		Coordonnee depart = new Coordonnee(2, 1);
		Coordonnee depart2 = new Coordonnee(1, 3);
		Navire petitNavire = new Navire(depart, 3, true);
		Navire moyenNavire = new Navire(depart2, 3, false);
		System.out.println(petitNavire.toString());
		System.out.println(moyenNavire.toString());
		System.out.println(petitNavire.chevauche(moyenNavire));

	}

}
