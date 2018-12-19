package batailleNavale;

public abstract class JoueurAuto extends JoueurAvecGrille {
	
	//public final static int TOUCHE = 1;
	//public final static int COULE = 2;
	//public final static int A_L_EAU = 3;
	//public final static int GAMEOVER = 4;
	private GrilleNavale grille;
	private Coordonnee dernierTir;
	private boolean navireTouche = false;
	private Coordonnee tirChoisi;
	private boolean navireCoule = false;

	
	public JoueurAuto(GrilleNavale g, String nom) {
		super(g,nom);
		grille=super.getGrille();
		
		
	}
		
	public JoueurAuto(GrilleNavale g) {
		super(g, "Jack Sparrow");
		grille=super.getGrille();

		
	}
	

	protected void retourAttaque(Coordonnee c, int etat) {
		if (etat == super.GAMEOVER)
			System.out.println( this.getNom() +" a gagné!");
		else if (etat == super.COULE)
			System.out.println(this.getNom() +" a coulé un bateau");
		else if (etat == super.TOUCHE)
			System.out.println(this.getNom() +" a touché un bateau");
		else 
			System.out.println(this.getNom() +" a fait plouf");
	}

	protected void retourDefense(Coordonnee c, int etat) {
		if (etat == super.GAMEOVER)
			System.out.println(this.getNom() +" a perdu!");
		else if (etat == super.COULE)
			System.out.println(this.getNom() +" a perdu un bateau");
		else if (etat == super.TOUCHE)
			System.out.println(this.getNom() +" s'est fait trouer un bateau");
		else 
			System.out.println(this.getNom() +" a esquivé");
	}
	
	
	/**
	 * Cette méthode est invoquée sur le joueur attaquant au début d’un tour de jeu. Elle retourne
	   la coordonnée cible du tir effectué par l’attaquant. 
	 */
	public Coordonnee choisirAttaque() {
		int ligne = (int) (Math.random() * super.getGrille().getTaille());
		int colonne = (int) (Math.random() * super.getGrille().getTaille());
		tirChoisi = new Coordonnee(colonne,ligne);
		
		
		System.out.println(this.getNom()+" attaque en: "+tirChoisi);
		return tirChoisi;
			
	}
	

	
	
	public static void main(String[] args) {


	}

}
