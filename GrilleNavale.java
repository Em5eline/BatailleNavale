package batailleNavale;

public class GrilleNavale {

	// ATTRIBUTS

	private Navire[] navires;
	private int nbNavires;
	private int taille;
	private Coordonnee[] tirsRecus;
	private int nbTirsRecus;

	// CONSTRUCTEURS

	public GrilleNavale(int taille, int[] taillesNavires) {

	}

	public GrilleNavale(int taille, int nbNavires) {
		this.taille = taille;
		this.nbNavires = nbNavires;
	}

	// METHODES

	public String toString() {
		String Newligne = System.getProperty("line.separator");
		String s = "   ";
		int l = 1;
		char car = 'A';

		for (int i = 0; i < taille; i++) {
			s = s + car + " ";
			car++;
		}

		for (int i = 0; i < taille; i++) {
			if (l < 10)
				s = s + System.getProperty("line.separator") + " " + l;
			else
				s = s + System.getProperty("line.separator") + l;
			l++;
			for (int j = 0; j < taille; j++) {
				s = s + " .";
			}
		}

		return s;
	}

	public boolean ajouteNavire(Navire n) {
		// si il n'y a rien dans le tableau alors true
		if (this.navires == null) {
			this.navires = new Navire[1];
			this.navires[0] = n;
			return true;
		// sinon si navire touche ou chevauche un autre alors false
		} else {
			// on parcourt la liste
			for (int c = 0; c < this.navires.length; c++) {
				// si un navire est touché ou chevauché alors false
				if (this.navires[c].touche(n) || this.navires[c].chevauche(n))
					return false;
			} // end for
			
			// si depassement de la grille
			Coordonnee deb = n.getDebut();
	        Coordonnee fin = n.getFin();
	        if (deb.getLigne() >= this.taille || deb.getLigne() < 0 || deb.getColonne() >= this.taille || deb.getColonne() < 0 || fin.getLigne() >= this.taille || fin.getColonne() >= this.taille)
	        	return false;
			
	        // dans tous les autres cas on l'ajoute
			else {
	        	int l = this.navires.length;
	        	Navire[] intermed = new Navire[l+1];
				intermed[l] = n;
				this.navires = intermed;
				return true;
	        }
		}
	}

	public static void main(String[] args) {

		// TESTS
		GrilleNavale grilleTest = new GrilleNavale(26, 0);

		// toString()
		//System.out.println(grilleTest.toString());

		// ajouteNavire()

		Coordonnee coordNav1 = new Coordonnee(3, 0);
		Navire nav1 = new Navire(coordNav1, 3, true);
		// nav2 chevauche nav1
		Coordonnee coordNav2 = new Coordonnee(2, 2);
		Navire nav2 = new Navire(coordNav2, 3, false);
		// nav3 ne chevauche pas nav1
		Coordonnee coordNav3 = new Coordonnee(0, 0);
		Navire nav3 = new Navire(coordNav3, 3, false);

		System.out.println(grilleTest.ajouteNavire(nav1));
		System.out.println(grilleTest.ajouteNavire(nav2));
		System.out.println(grilleTest.ajouteNavire(nav3));
	}
}
