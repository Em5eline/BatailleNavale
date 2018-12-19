package batailleNavale;

import java.util.Scanner;

public class JoueurTexte extends JoueurAvecGrille{
	
	private Scanner sc;

	public JoueurTexte(GrilleNavale g, String nom) {
		super(g, nom);
	}
	
	public JoueurTexte(GrilleNavale g) {
		super(g);
	}
	
	protected void retourAttaque(Coordonnee c, int etat) {
		if (etat == super.GAMEOVER)
			System.out.println("Bravo" + this.getNom() + " t'as gagné");
		else if (etat == super.COULE)
			System.out.println(this.getNom() + " Tu as coulé un bateau");
		else if (etat == super.TOUCHE)
			System.out.println(this.getNom() + " Tu as touché un bateau en " + c);
		else 
			System.out.println("Plouf");
	}

	protected void retourDefense(Coordonnee c, int etat) {
		if (etat == super.GAMEOVER)
			System.out.println("T'as perdu!" + this.getNom() + " déso :/");
		else if (etat == super.COULE)
			System.out.println("Ton bateau a coulé ");
		else if (etat == super.TOUCHE)
			System.out.println("Ressaisis toi " + this.getNom() + " ton bateau est touché !!!");
		else 
			System.out.println("Plouf");
	}
	
	public Coordonnee choisirAttaque() {
		Scanner sc = new Scanner(System.in);
		String attaque = new String();
		System.out.println(this.getNom() + " tu peux choisir ton attaque :");
		attaque = sc.nextLine();
		Coordonnee c = new Coordonnee(attaque);
		return c;
	}
	
	public static void main(String[] args) {
		int[] mesnavires1 = {2};
		int[] mesnavires2 = {2,3};
		GrilleNavale grille1 = new GrilleNavale(10, mesnavires1);
		GrilleNavale grille2 = new GrilleNavale(10, mesnavires2);
		System.out.println(grille1);
		System.out.println(grille2);
		
		JoueurTexte cha = new JoueurTexte(grille1, "Cha");
		JoueurTexte vic = new JoueurTexte(grille2, "Vic");
		cha.jouerAvec(vic);
		

		
	}
	
}
