package batailleNavale;

public class JoueurAuto extends JoueurAvecGrille {
	
	//public final static int TOUCHE = 1;
	//public final static int COULE = 2;
	//public final static int A_L_EAU = 3;
	//public final static int GAMEOVER = 4;
	private Coordonnee dernierTir;
	private boolean navireTouche = false;
	private Coordonnee tirChoisi;
	private boolean navireCoule = false;
	
	
	public JoueurAuto(GrilleNavale g, String nom) {
		super(g,nom);
		
	}
	
	
	public JoueurAuto(GrilleNavale g) {
		super(g, "Jack Sparrow");
	}
	
	
	protected void retourAttaque(Coordonnee c, int etat) { //But : faire le bon choix pour le prochain tir
		if (etat == 1)
			dernierTir = c;
			navireTouche = true;
			System.out.println("Navire affaibli ! Il est touché en "+c);
		if(etat == 2)
			dernierTir = c;
			navireCoule = true;
			System.out.println("T'as défoncé son navire, GG");
		if(etat == 4)
			dernierTir = null;
			System.out.println("T'as tout défoncé fréro, t'es un vrai !");
			
	}
	
	
	protected void retourDefense(Coordonnee c, int etat) { //
		super.getGrille().recoitTir(c);

	}
	
	
	/**
	 * Cette méthode est invoquée sur le joueur attaquant au début d’un tour de jeu. Elle retourne
	   la coordonnée cible du tir effectué par l’attaquant. 
	 */
	public Coordonnee choisirAttaque() {
		int ligne = (int) (Math.random() * super.getGrille().getTaille());
		int colonne = (int) (Math.random() * super.getGrille().getTaille());
		//if (navireTouche == false)
		tirChoisi = new Coordonnee(colonne,ligne);
		
		//if (navireTouche == true)
		//	if (est)
		//	tirChoisi = new Coordonnee()
		return tirChoisi;
			
	}
	

	
	
	public static void main(String[] args) {
		

	}

}
