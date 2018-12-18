package batailleNavale;

public class GrilleNavale {

	private int taille;
	private Navire[] navires;
	private int nbNavires;
	private Coordonnee[] tirsRecus;
	private int nbTirsRecus;

	// Attributs

	public GrilleNavale(int taille, int[] taillesNavires) {

	}

	public GrilleNavale(int taille, int navMax) {
		this.taille = taille;
		this.nbNavires = 0;
		this.navires = new Navire[navMax];

	}

	// toString()

	public String toString() {
		StringBuffer grilleNavale = new StringBuffer("   ");
		char c = 'A';
		int l = 1;
		for (int i = 0; i < this.taille; i++) {
			grilleNavale = grilleNavale.append(c);
			grilleNavale = grilleNavale.append(' ');
			c++;
		}

		for (int j = 0; j < this.taille; j++) {

			grilleNavale = grilleNavale.append("\n");
			if (l < 10)
				grilleNavale = grilleNavale.append(' ');
			grilleNavale = grilleNavale.append(l);
			l++;
			for (int k = 0; k < this.taille; k++) {
				grilleNavale = grilleNavale.append(" .");
			}

		}

		return grilleNavale.toString();
	}

	// METHODES

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
	
	public void placementAuto(int[] taillesNavires) {
		
		// coordonnees aleatoires
		int ligne = (int)(Math.random() * this.taille);
		System.out.println(ligne);
	}

	public static void main(String[] args) {

		// TESTS
		GrilleNavale grilleTest = new GrilleNavale(26, 2);

		// toString()
		// System.out.println(grilleTest.toString());

		// ajouteNavire()
		Coordonnee coordNav1 = new Coordonnee(4, 0);
		Navire nav1 = new Navire(coordNav1, 3, true);
		// nav2 chevauche nav1
		Coordonnee coordNav2 = new Coordonnee(2, 2);
		Navire nav2 = new Navire(coordNav2, 3, false);
		// nav3 ne chevauche pas nav1
		Coordonnee coordNav3 = new Coordonnee(0, 0);
		Navire nav3 = new Navire(coordNav3, 3, false);
		// nav 4 depasse la grille
		//Coordonnee coordNav4 = new Coordonnee(25, 0);
		//Navire nav4 = new Navire(coordNav4, 3, false);

//		System.out.println(grilleTest.ajouteNavire(nav1));
//		System.out.println(grilleTest.ajouteNavire(nav2));
//		System.out.println(grilleTest.ajouteNavire(nav3));
		//System.out.println(grilleTest.ajouteNavire(nav4));
		int[] tab = {2,4} ;
		grilleTest.placementAuto(tab);
	}

}