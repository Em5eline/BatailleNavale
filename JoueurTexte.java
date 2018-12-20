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
			System.out.println("T'as gagné!");
		else if (etat == super.COULE)
			System.out.println("Tu as coulé un bateau");
		else if (etat == super.TOUCHE)
			System.out.println("Tu as touché un bateau");
		else 
			System.out.println("Plouf");
	}

	protected void retourDefense(Coordonnee c, int etat) {
		if (etat == super.GAMEOVER)
			System.out.println("T'as perdu!");
		else if (etat == super.COULE)
			System.out.println("Ton bateau a coulé");
		else if (etat == super.TOUCHE)
			System.out.println("Ton bateau est touché");
		else 
			System.out.println("Plouf");
		System.out.println(this.getGrille()+"\nGRILLE DE MOI");
	}
	
	public Coordonnee choisirAttaque() {
		Scanner sc = new Scanner(System.in);
		String attaque;
		System.out.println(this.getNom() + " choisis ton attaque :");
		attaque = sc.nextLine();
		if (attaque.length()!=2 && attaque.length()!=3) {
			while (attaque.length()!=2 && attaque.length()!=3) {
				System.out.println("Veuillez entrez une case au format 'A4' svp");
			attaque = sc.nextLine();
		}}
		Coordonnee c = new Coordonnee(attaque);
		if (c.getColonne()>=this.getTailleGrille() || c.getLigne()>=this.getTailleGrille()) {
			System.out.println("veuillez entrez une case de la grille");
			this.choisirAttaque();}
		
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
