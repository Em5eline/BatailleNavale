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
			if (longueur + debut.getLigne() > 25) {
				throw new IllegalArgumentException("Le bateau dépasse de la grille !");
			} else {
				this.debut = new Coordonnee(debut.getColonne(), debut.getLigne());
				this.fin = new Coordonnee(this.debut.getColonne(), longueur + this.debut.getLigne() - 1);

			}
		} else {
			if (longueur + debut.getColonne() > 25) {
				throw new IllegalArgumentException("Le bateau dépasse de la grille !");
			} else {
				this.debut = new Coordonnee(debut.getColonne(), debut.getLigne());
				this.fin = new Coordonnee(longueur + this.debut.getColonne() - 1, this.debut.getLigne());
			}
		}
	}

	/**
	 * Retourne une String représentant this. On souhaite obtenir une représentation
	 * de la forme "Navire(B1, 4, horizontal)" (pour un navire de taille 4 placé
	 * horizontalement par exemple).
	 */

	public String toString() {
		int colonne = this.fin.getColonne() - this.debut.getColonne();
		int ligne = this.fin.getLigne() - this.debut.getLigne();
		if (colonne == 0)
			return ("Navire(" + this.debut.toString() + ", " + (ligne + 1) + ", " + " vertical)");
		else
			return ("Navire(" + this.debut.toString() + ", " + (colonne + 1) + ", " + " horizontal)");
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
	 * 
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
		int colonne = fin.getColonne() - debut.getColonne();
		int ligne = fin.getLigne() - debut.getLigne();
		if (colonne == 0 && c.getLigne() >= debut.getLigne() && c.getLigne() <= fin.getLigne()
				&& debut.getColonne() == c.getColonne()) { // si this est verticale, on vérifie que
															// this.debut.ligne<c.ligne<this.fin.ligne et que
															// this.colonne == c.colonne
			return true;
		} else if (ligne == 0 && c.getColonne() >= debut.getColonne() && c.getColonne() <= fin.getColonne()
				&& debut.getLigne() == c.getLigne()) { // si this est horizontale pareil qu'au dessus en inversant
														// lignes/colonnes
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

	/**
	 * permet de savoir si deux navires se chevauchent 
	 * @param n : navire 
	 * @return : true ou false 
	 */
	
	public boolean chevauche(Navire n) {
		Coordonnee parcours = this.debut; // coordonnée de parcours
		int colonne2 = this.fin.getColonne() - this.debut.getColonne();
		int ligne2 = this.fin.getLigne() - this.debut.getLigne();
		if (colonne2 == 0) { // Si this est verticale
			for (int i = 0; i < ligne2 + 1; i++) {
				if (n.contient(parcours)) // On check autant de fois que This a de cases si n contient cette case grace
																							// à la Coordo de parcours
						return true;
				else
					parcours = new Coordonnee(parcours.getColonne(), parcours.getLigne() + 1);

			}
		}
		if (ligne2 == 0) { // Si this est horizontale
			for (int i = 0; i < colonne2 + 1; i++) {
				if (n.contient(parcours)) // Pareil qu'au dessus
					return true;
				else
					parcours = new Coordonnee(parcours.getColonne() + 1, parcours.getLigne());
			}
		}
		return false;

	}

	/**
	 * Retourne true si et seulement si this contient c. Dans ce cas, c est ajoutée aux parties
	   touchees si necessaire.
	 * @param c : coordonnee visée par le tir
	 * @return : true ou false
	 */
	
	public boolean recoitTir(Coordonnee c) {
		if (!this.contient(c))
			return false;
		else {
			boolean dejavu = false;
			int colonne = fin.getColonne() - debut.getColonne();
			int ligne = fin.getLigne() - debut.getLigne();
			int longueur = (colonne == 0) ? ligne + 1 : colonne + 1;
			if (partiesTouchees == null) {
				partiesTouchees = new Coordonnee[longueur];
			}
			for (int i = 0; i < longueur; i++) {
				if (partiesTouchees[i] == c)
					dejavu = true;
			}
			if (!dejavu) {
				nbTouchees += 1;
				partiesTouchees[nbTouchees - 1] = c;
			}
			return true;
		}
	}
	
	/**
	 * permet d'afficher en string []partiesTouchees
	 * @return : String de []partiesTouchees
	 */
	
	public String afficherTab() { // POur afficher en string le []partiesTouchees
		String strPartiesTouchees = "";

		for (int j = 0; j < partiesTouchees.length; j++) {
			if (partiesTouchees[j] != null) {
				strPartiesTouchees = strPartiesTouchees + "[" + partiesTouchees[j].getColonne() + "-"
						+ partiesTouchees[j].getLigne() + "]";
			}

		}
		return strPartiesTouchees;
	}
	
	/**
	 * Retourne true si et seulement si this a été touché par un tir en c
	 * @param c : coordonnee visée par le tir 
	 * @return : true ou false
	 */
	
	public boolean estTouche(Coordonnee c) {
		if (partiesTouchees == null)
			return false;
		else
			for (int i = 0; i < partiesTouchees.length; i++) {
				if (partiesTouchees[i] == c)
					return true;
			}
		return false;
	}
	
	/**
	 * Retourne true si et seulement si this a au moins une partie touchee.
	 * @return : true ou false
	 */
	
	public boolean estTouche() {
		if (partiesTouchees == null)
			return false;
		else
			return true;
	}
	
	/**
	 * Retourne true si et seulement si this est coulé, c'est-à-dire que toutes ses parties ont été
	   touchées. 
	 * @return : true ou false 
	 */
	
	public boolean estCoule() {
		if (partiesTouchees == null)
			return false;
		else if ((nbTouchees) == partiesTouchees.length)
			return true;
		else
			return false;
	}
	
	public static void main(String[] args) {
		Coordonnee depart = new Coordonnee(2, 1);
		Coordonnee depart2 = new Coordonnee(1, 3);
		Navire petitNavire = new Navire(depart, 3, true);
		Navire moyenNavire = new Navire(depart2, 3, false);
		System.out.println(petitNavire.getFin());
		System.out.println(moyenNavire.getFin());
		System.out.println(petitNavire.toString());
		System.out.println(moyenNavire.toString());
		System.out.println(petitNavire.chevauche(moyenNavire));

	}

}
