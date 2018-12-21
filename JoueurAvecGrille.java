package batailleNavale;

public abstract class JoueurAvecGrille extends Joueur{
	
	private GrilleNavale grille;
	
	public JoueurAvecGrille(GrilleNavale g, String nom) {
		super(g.getTaille(), nom);
		this.grille=g;
	}

	public JoueurAvecGrille(GrilleNavale g) {
		super(g.getTaille());
	}
	public GrilleNavale getGrille() {
		return grille;
	}

	
	public int defendre(Coordonnee c) {
		
	if(grille.recoitTir(c) && grille.estALEau(c))
		return super.A_L_EAU;
		else if(grille.recoitTir(c) && grille.perdu())
			return super.GAMEOVER;
		else if(grille.recoitTir(c) && grille.estCoule(c))
			return super.COULE;
		else 
			return super.TOUCHE;
			
		
	/*	
	if(grille.recoitTir(c)) {
		if (grille.estCoule(c)) 
			if (grille.perdu()) {
				return super.GAMEOVER;
			}else 
				return super.COULE;
		else  
			return super.TOUCHE;
			}
	else 
		return super.A_L_EAU;
*/
	}
	
	
	public static void main(String[] args) {

	}
}
