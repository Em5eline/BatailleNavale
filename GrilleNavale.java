package batailleNavale;

public class GrilleNavale {

	private Navire[] navires;
	private int nbNavires;
	private int taille;
	private Coordonnee[] tirsRecus;
	private int nbTirsRecus;

	/**
	 * permet d'obtenir une grille navale de taille taille dans laquelle ont été placés
	   automatiquement taillesNavires.length navires dont les tailles sont données dans
	   taillesNavires.
	 * @param taille : taille de la grille (entre 0 et 25).
	 * @param taillesNavires : tableau contenant les tailles des taillesNavires.length navires à placer dans la grille.
	 */
	
	public GrilleNavale(int taille, int[] taillesNavires) {
		this(taille, taillesNavires.length);
		placementAuto(taillesNavires);
	}
	
	/**
	 * permet d'obtenir une grille navale vide de taille taille pouvant accueillir jusqu'à
	   nbNavires.
	 * @param taille : taille de la grille (entre 0 et 25).
	 * @param navMax : capacité d'accueil de la grille (en terme de navires).
	 */
	
	public GrilleNavale(int taille, int navMax) {
		this.taille = taille;
		nbNavires = 0;
		this.navires = new Navire[navMax];
		tirsRecus = new Coordonnee[taille * taille];
		nbTirsRecus = 0;
	}

	
	public int getTaille() {
		return this.taille;
	}
	
	
	/**
	 * Retourne une String représentant this. On souhaite obtenir une représentation
s'affichant sur la console de la façon suivante :
					 A B C D E F G H I J
					1 . . . . . . . . . .
					2 . . . # # # . . . .
					3 . . . . . . # X # .
					4 . . O . . . . O . .
					5 . . . . . # . . . .
					6 . . . O . # . . . .
					7 . # # . . # . . . .
					8 . . . . . # . . . .
					9 . . . . . . . O . .
				   10 . . . . . . . . . .
	 */

	public String toString() {
		StringBuffer grilleNavale = new StringBuffer("  ");
		char c = 'A';
		int l = 1;
		for (int i = 0; i < this.taille; i++) { // On crée la 1ère ligne
			grilleNavale = grilleNavale.append(' ');
			grilleNavale = grilleNavale.append(c);

			c++;
		}

		for (int j = 0; j < this.taille; j++) { // on ajoute les autres lignes

			grilleNavale = grilleNavale.append("\n");
			if (l < 10)
				grilleNavale = grilleNavale.append(' ');
			grilleNavale = grilleNavale.append(l);
			l++;
			for (int k = 0; k < this.taille; k++) {
				grilleNavale = grilleNavale.append(" .");
			}
		}

		for (int z = 0; z < tirsRecus.length; z++) { // On ajoute les tirs reçus
			if (tirsRecus[z] != null) {
				// grilleNavale.replace(((2+2*taille+4)+(2*taille +3)*getLigne())+colonne*2,
				// ((2+2*taille+5)+(2*taille +3)*ligne)+colonne*2, "#");
				grilleNavale.replace(
						((2 + 2 * taille + 4) + (2 * taille + 3) * tirsRecus[z].getLigne())
								+ tirsRecus[z].getColonne() * 2,
						((2 + 2 * taille + 5) + (2 * taille + 3) * tirsRecus[z].getLigne())
								+ tirsRecus[z].getColonne() * 2,
						"O");
			}

		}

		for (int y = 0; y < navires.length; y++) {// On ajute les bateaux
			if (navires[y] != null) {
				int colonne = navires[y].getFin().getColonne() - navires[y].getDebut().getColonne();
				int ligne = navires[y].getFin().getLigne() - navires[y].getDebut().getLigne();
				if (colonne == 0) {
					for (int k = 0; k < ligne + 1; k++)
						grilleNavale.replace(
								(((2 + 2 * taille + 4) + (2 * taille + 3) * navires[y].getDebut().getLigne())
										+ navires[y].getDebut().getColonne() * 2) + k * (2 * taille + 3),
								((2 + 2 * taille + 5) + (2 * taille + 3) * navires[y].getDebut().getLigne())
										+ navires[y].getDebut().getColonne() * 2 + k * (2 * taille + 3),
								"#");
				}
				if (ligne == 0) {
					for (int k = 0; k < colonne + 1; k++)
						grilleNavale.replace(
								(((2 + 2 * taille + 4) + (2 * taille + 3) * navires[y].getDebut().getLigne())
										+ navires[y].getDebut().getColonne() * 2) + k * 2,
								((2 + 2 * taille + 5) + (2 * taille + 3) * navires[y].getDebut().getLigne())
										+ navires[y].getDebut().getColonne() * 2 + k * 2,
								"#");
				}
			}
		}
		
		for (int i=0;i<navires.length;i++) {
			for (int j=0;j<tirsRecus.length;j++) {
				if (navires[i] != null) {
					if (tirsRecus[j] != null) {


				if (navires[i].contient(tirsRecus[j]))
					grilleNavale.replace(
							((2 + 2 * taille + 4) + (2 * taille + 3) * tirsRecus[j].getLigne())
									+ tirsRecus[j].getColonne() * 2,
							((2 + 2 * taille + 5) + (2 * taille + 3) * tirsRecus[j].getLigne())
									+ tirsRecus[j].getColonne() * 2,
							"X");
			}
				}
			}
		}

		return grilleNavale.toString();
	}
	
	/**
	 * Retourne true après avoir ajouté n à this si cet ajout est possible. L'ajout est impossible si
       n touche ou chevauche un navire déjà présent dans this, ou encore si n dépasse les limites
	   de this.
	 * @param n : Navire à placer dans la grille.
	 * @return : true ou false.
	 */
	
	public boolean ajouteNavire(Navire n) {
		
		// si le nouveau navire depasse la grille
		if (n.getDebut().getLigne() >= this.taille || n.getDebut().getLigne() < 0 || n.getDebut().getColonne() >= this.taille
				|| n.getFin().getColonne() < 0 || n.getFin().getLigne() >= this.taille || n.getFin().getColonne() >= this.taille) {
			return false;
		}
		
		// on parcourt le tableau de navires
		for (int c = 0 ; c < this.navires.length; c++) {
			// si navire présent
			if (this.navires[c] != null) {
				// si un navire est touché ou chevauché alors false
				if (this.navires[c].touche(n) || this.navires[c].chevauche(n))
					return false;
			} 
		}// end for
		
		// si tableau plein impossible de rajouter un navire
		if (nbNavires == this.navires.length)
			return false;
		
		this.navires[this.nbNavires] = n;
		// on incrémente le nombre de navires
		this.nbNavires++;
		return true;
	}
	

	/**
	 * Place automatiquement et aléatoirement taillesNavires.length navires dont les
	   tailles sont données dans taillesNavire.
	 * @param taillesNavires : tableau contenant les tailles des taillesNavires.length navires à placer dans la grille.
	 */
	
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
				if (ajouteNavire(nav) == false) {
					i -= 1;
				}

			}

		}

	}


	/**
	 * Retourne true si et seulement si c est dans this.
	 * @param c : coordonnee.
	 * @return : true si c est dans la grille, et false si c n'est pas dans la grille.
	 */
	
	private boolean estDansGrille(Coordonnee c) {
		if (c.getColonne() >= 0 && c.getColonne() < this.taille && c.getLigne() >= 0 && c.getLigne() < this.taille)
			return true;
		else
			return false;
	}
	
	/**
	 * Retourne true si et seulement si c correspond à un tir reçu par this.
	 * @param c : coordonnee.
	 * @return : true si c est dans tirsRecus, et false si c n'est pas dans tirsRecus.
	 */
	
	private boolean estDansTirsRecus(Coordonnee c) {
		for (int i = 0; i < nbTirsRecus; i++)
			if (tirsRecus[i].equals(c))
				return true;
		return false;
	}
	
	/**
	 * Ajoute c aux tirs reçus de this si nécessaire. Retourne true si et seulement si this est
	   modifié.
	 * @param c : coordonnee.
	 * @return : true si c est ajoutée dans tirsRecus, et false si c n'est pas ajoutée dans tirsRecus.
	 */
	
	private boolean ajouteDansTirsRecus(Coordonnee c) {
		if (c == null)
			throw new IllegalArgumentException("Null interdit");
		if (estDansTirsRecus(c))
			return false;
		tirsRecus[nbTirsRecus] = c;
		nbTirsRecus += 1;
		return true;
	}

	/**
	 * Affiche le tableau tirsRecus
	 * @return : tirsRecus.
	 */
	
	public String afficherTirs() { // POur afficher en string le []partiesTouchees
		String strTirsRecus = "";

		for (int j = 0; j < tirsRecus.length; j++) {
			if (tirsRecus[j] != null) {
				strTirsRecus = strTirsRecus + "[" + tirsRecus[j].getColonne() + "-" + tirsRecus[j].getLigne() + "]";
			}

		}
		return strTirsRecus;
	}
	

		/**
		 * Ajoute c aux tirs reçus de this si nécessaire. Retourne true si et seulement si c ne
	       correspondait pas déjà à un tir reçu et a permis de toucher un navire de this.
		 * @param c : coordonnee.
		 * @return : true ou false.
		 */
	
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

		/**
		 * Retourne true si et seulement si un des navires présents dans this a été touché en c.
		 * @param c
		 * @return
		 */
		
	public boolean estTouche(Coordonnee c) {
		for (int i = 0; i < nbNavires; i++) {
			if (navires[i].estTouche(c)) {
				return true;
			}
		}
		return false;
	}

		/**
		 * 
		 * @param c
		 * @return
		 */
		
		public boolean estALEau(Coordonnee c) {
			return !(this.estTouche(c)); 
		}

		/**
		 * 
		 * @param c
		 * @return
		 */
		
		public boolean estCoule(Coordonnee c) {
			// pour chaque navire
			for (int i = 0; i < nbNavires ; i++) {

				if (navires[i].estTouche(c)) {
					navires[i].recoitTir(c);
					if (navires[i].estCoule())
						return true;
				} 
			}
			return false;
		}

		/**
		 * 
		 * @return
		 */
		
		public boolean perdu() {
			for (int i = 0; i < navires.length; i++)
				if (!(navires[i].estCoule()))
					return false;
				return true;

		}


	public static void main(String[] args) {
		GrilleNavale laGrille = new GrilleNavale(23, 5);
		Coordonnee c = new Coordonnee(4, 2);
		Navire titanic = new Navire(c, 2, false);
		
	}

}
