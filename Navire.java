package batailleNavale;

public class Navire {

	/***************************************************
	 *						ATTRIBUTS
	 **************************************************/

	private Coordonnee debut;
	private Coordonnee fin;
	private Coordonnee[] partiesTouchees;
	private int nbTouchees;

	/***************************************************
	 *					CONSTRUCTEURS
	 **************************************************/

	public Navire(Coordonnee debut, int longueur, boolean estVertical) {
		if (estVertical) {
			if (longueur + debut.getLigne() > 25) {
				throw new IllegalArgumentException("Le bateau dépasse de la grille !");
			} else {
				this.debut = new Coordonnee(debut.getColonne(), debut.getLigne());
				this.fin = new Coordonnee(this.debut.getColonne(), longueur-1 + this.debut.getLigne());

			}
		} else {
			if (longueur + debut.getColonne() > 25) {
				throw new IllegalArgumentException("Le bateau dépasse de la grille !");
			} else {
				this.debut = new Coordonnee(debut.getColonne(), debut.getLigne());
				this.fin = new Coordonnee(longueur-1 + this.debut.getColonne(), this.debut.getLigne());
			}
		}
	}

	/***************************************************
	 *						METHODES
	 **************************************************/

	public String toString() {
		int colonne = fin.getColonne() - debut.getColonne();
		int ligne = fin.getLigne() - debut.getLigne();
		if (colonne == 0)
			return ("Navire(" + this.debut.toString() + ", " + ligne + ", " + " vertical)");
		else
			return ("Navire(" + this.debut.toString() + ", " + colonne + ", " + " horizontal)");
	}

	/***************************************************
	 *						GETTERS
	 **************************************************/

	public Coordonnee getDebut() {
		return this.debut;
	}

	public Coordonnee getFin() {
		return this.fin;
	}

	/***************************************************
	 *					METHODES
	 **************************************************/

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

	public boolean touche(Navire n) {
		if (this.debut.voisine(n.debut) || this.fin.voisine(n.fin))
			return true;
		else
			return false;
	}

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

	public boolean estTouche() {
		if (partiesTouchees == null)
			return false;
		else
			return true;
	}

	public boolean estCoule() {
		if (partiesTouchees == null)
			return false;
		else if ((nbTouchees) == partiesTouchees.length)
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		/*// TODO Auto-generated method stub
		Coordonnee deb1 = new Coordonnee(0, 0);
		Navire nav1 = new Navire(deb1, 2, false);
		Coordonnee deb2 = new Coordonnee(0, 0);
		Coordonnee deb3 = new Coordonnee(1, 0);
		Coordonnee deb4 = new Coordonnee(2, 0);
		Coordonnee deb5 = new Coordonnee(3, 0);
		Coordonnee deb6 = new Coordonnee(3, 0);

		Navire nav2 = new Navire(deb2, 2, true);

		// System.out.println(nav1.touche(nav2));
		// System.out.println(nav1.contient(deb2));
		// System.out.println(nav1.chevauche(nav2));
		System.out.println(nav1.recoitTir(deb2));
		// System.out.println(nav1.afficherTab());

		System.out.println(nav1.recoitTir(deb3));
		// System.out.println(nav1.afficherTab());

		System.out.println(nav1.recoitTir(deb4));
		// System.out.println(nav1.afficherTab());

		System.out.println(nav1.recoitTir(deb5));
		// System.out.println(nav1.afficherTab());

		System.out.println(nav1.estCoule());
		System.out.println(nav2.estCoule());*/
		
		// TESTS
		
		Coordonnee denavire = new Coordonnee(0,0);
		Navire navire = new Navire(denavire, 3, false);
		
		// test toString -> OK !
		System.out.println(navire.toString());
		
		// test getters -> getDebut OK !
		System.out.println(navire.getDebut());
		// getFin corrigé ! (je crois qu'Emeline l'avait fait déjà)
		System.out.println(navire.getFin());
		
		// test contient() -> OK !
		Coordonnee pourcontient = new Coordonnee(2,0);
		System.out.println(navire.contient(pourcontient));
		
		// test touche() -> OK !
		Coordonnee pourtouche = new Coordonnee(3,0);
		Navire touch = new Navire(pourtouche, 3, true);
		
		System.out.println(navire.touche(touch));
		
		// test chevauche() -> OK !
		Coordonnee pourchevauche = new Coordonnee(2,2);
		Navire chevauch = new Navire(pourchevauche,3,false);
		System.out.println(touch.chevauche(chevauch));
		
		// estTouche() estCOule() -> NIIIICCCEEEE !!!
		Coordonnee tir1 = new Coordonnee(0,0);
		Coordonnee tir2 = new Coordonnee(1,0);
		Coordonnee tir3 = new Coordonnee(2,0);
		
		System.out.println(navire.recoitTir(tir1));
		System.out.println(navire.recoitTir(tir2));
		System.out.println(navire.recoitTir(tir3));
		System.out.println(navire.estTouche(tir3));
		System.out.println(navire.estTouche());
		System.out.println(navire.estCoule());
		
	}

}