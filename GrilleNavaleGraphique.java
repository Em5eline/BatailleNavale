package batailleNavale;

import java.awt.Color;

public class GrilleNavaleGraphique extends GrilleNavale {
	
	private GrilleGraphique grille;
	
	
	/**
	 * CONSTRUCTEUR
	 * permet d'obtenir une grille de taille taille.
	 * @param taille
	 */
	
	public GrilleNavaleGraphique(int taille) {
		// là j'ai bêtement copié "5" l'ancien projet de Cha car je savais pas quoi mettre en 2e argument
		super(taille, 5);
		this.grille = new GrilleGraphique(taille);
	}
	
	/**
	 * Accesseur en lecture pour grille.
	 * @return GrilleGraphique
	 */
	
	public GrilleGraphique getGrilleGraphique() {
		return grille;
	}
	
	/**
	 * Spécialisation de la méthode héritée de GrilleNavale.
	 * Les cases correspondant au navire ajouté doivent être coloriées 
	 * en Color.GREEN.
	 * 
	 * @param Navire n
	 * @return boolean
	 */
	
	public boolean ajouteNavire(Navire n) {
		if (super.ajouteNavire(n)) {
			grille.colorie(n.getDebut(), n.getFin(), Color.GREEN);
			return true;
		}
		return false;
	}
	
	/**
	 * Spécialisation de la méthode héritée de GrilleNavale. 
	 * La case correspondant au tir doit être coloriée en Color.RED 
	 * si le tir a touché un navire ou en Color.BLUE s'il est à l'eau.
	 * @param Coordonnee c
	 * @return boolean
	 */
	
	public boolean recoitTir(Coordonnee c) {
		if (super.recoitTir(c)) {
			grille.colorie(c, Color.RED);
			//System.out.println("est touche");
			return true;
		} else if (super.estALEau(c)) {
			grille.colorie(c, Color.BLUE);
			//System.out.println("est a l'eau");
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		GrilleNavaleGraphique g1 = new GrilleNavaleGraphique(5);
		
		// TEST getGrilleGraphique
		System.out.println(g1.getGrilleGraphique());
		
		// TEST ajouteNavire OK
		Coordonnee c1 = new Coordonnee(0,0);
		Navire n1 = new Navire(c1,3,false);
		System.out.println(g1.ajouteNavire(n1));
		
		// TEST recoitTir
		// estTouche
		System.out.println(g1.recoitTir(c1));
		// estALEau
		Coordonnee c2 = new Coordonnee(0,1);
		System.out.println(g1.recoitTir(c2));
		
	}

}
