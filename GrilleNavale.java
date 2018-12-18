public class GrilleNavale {


	private Navire[] navires;
	private int nbNavires;
	private int taille;
	private Coordonnee[] tirsRecus;
	private int nbTirsRecus;
	
	public GrilleNavale(int taille, int[]taillesNavires) {
		
	}
	
	public GrilleNavale(int taille, int navMax) {
		this.taille = taille;
		this.nbNavires = 0;
		this.navires = new Navire[navMax];

	}
	
	public String toString() {
		StringBuffer grilleNavale=new StringBuffer ("   ");
		char c='A';
		int l=1;
		for (int i=0;i<this.taille;i++) {
			grilleNavale = grilleNavale.append(c);
			grilleNavale = grilleNavale.append(' ');
			c++;	
		}
		
		for (int j=0;j<this.taille;j++) {
			
			grilleNavale = grilleNavale.append("\n");
			if (l<10)
				grilleNavale = grilleNavale.append(' ');
			grilleNavale = grilleNavale.append(l);
			l++;
			for (int k=0; k<this.taille;k++) {
				grilleNavale=grilleNavale.append(" .");
			}
		}
			return grilleNavale.toString();
	}
	
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
		
		// sinon on l'ajoute !
		this.navires[this.nbNavires] = n;
		// on incrémente le nombre de navires
		this.nbNavires++;
		return true;
	}

}
