package batailleNavale;

public class TestNavire {
	private static Coordonnee rocher;
	private static Navire costaConcordia;

	public static void testConstructeur() {
		try {
			System.out.println("Test du constructeur avec longueur = -3 :");
			rocher = new Coordonnee(2,5);
			costaConcordia = new Navire(rocher,-3,true);
			System.out.println("You lose, try again");
		} catch(IllegalArgumentException e) {
			System.out.println("You win");
		}
		
		try {
			System.out.println("Test du constructeur avec longueur = 0 :");
			rocher = new Coordonnee(5,3);
			costaConcordia = new Navire(rocher,0,false);
			System.out.println("You lose, try again");
		} catch(IllegalArgumentException e) {
			System.out.println("You win");
		}
		
		try {
			System.out.println("Test du constructeur avec longueur = 6 :");
			rocher = new Coordonnee(5,3);
			costaConcordia = new Navire(rocher,6,false);
			System.out.println("You lose, try again");
		} catch(IllegalArgumentException e) {
			System.out.println("You win");
		}
		
		try {
			System.out.println("Test du constructeur avec longueur = 1 :");
			rocher = new Coordonnee(5,3);
			costaConcordia = new Navire(rocher,1,false);
			System.out.println("You lose, try again");
		} catch(IllegalArgumentException e) {
			System.out.println("You win");
		}
		
		try {
			System.out.println("Test du constructeur avec navire vertical dépasssant la grille : ligne 22, longueur 4 :");
			rocher = new Coordonnee(2,22);
			costaConcordia = new Navire(rocher,4,true);
			System.out.println("You lose, try again");
		} catch(IllegalArgumentException e) {
			System.out.println("You win");
		}
		
		try {
			System.out.println("Test du constructeur avec navire horizontal dépasssant la grille : colonne 22, longueur 4 :");
			rocher = new Coordonnee(22,2);
			costaConcordia = new Navire(rocher,4,false);
			System.out.println("You lose, try again");
		} catch(IllegalArgumentException e) {
			System.out.println("You win");
		}
		
		
	}
	
	public static void testContient() {
		
		try {
			System.out.println("Test de contient(Coordonnee c) == null");
			rocher = new Coordonnee(20,2);
			Coordonnee iceberg = null;
			costaConcordia = new Navire(rocher,4,false);
			if(costaConcordia.contient(iceberg)==true)
			System.out.println("You lose, try again");
		
		} catch (IllegalArgumentException e){ 
			System.out.println("You win");
		}
		
		
			System.out.println("Test de contient(Coordonnee c) :");
			rocher = new Coordonnee(22,2);
			Coordonnee glacon = new Coordonnee(21,2);
			costaConcordia = new Navire(rocher,4,true);
			if(costaConcordia.contient(glacon)==true)
				System.out.println("You lose, try again");
			else 
				System.out.println("You win");
			
			System.out.println("Test de contient(Coordonnee c) :");
			rocher = new Coordonnee(20,2);
			glacon = new Coordonnee(21,2);
			costaConcordia = new Navire(rocher,4,false);
			if(costaConcordia.contient(glacon)==false)
				System.out.println("You lose, try again");
			else 
				System.out.println("You win");

	}
	
	public static void testTouche() {
		
		try {
			System.out.println("Test touche(Navire n) avec n == null :");
			Coordonnee c1 = new Coordonnee(2,5);
			Navire petitBateau = new Navire(c1,4,true);
			Navire fantome = null;
			petitBateau.touche(fantome);
			System.out.println("You lose, try again");		
		} catch (IllegalArgumentException e) {
			System.out.println("You win");
		}
		
		System.out.println("Test touche(Navire n) en dessous à gauche (horizontal et vertical) :");
		Coordonnee c2 = new Coordonnee ("B2");
		Coordonnee c3 = new Coordonnee ("B3");
		Navire n1 = new Navire(c2,3,false);
		Navire n2 = new Navire(c3,3,true);
		System.out.println("n1 touche n2 = "+ n1.touche(n2) + " TRUE ");
		System.out.println("n2 touche n1 = "+ n2.touche(n1) + " TRUE ");
		
		System.out.println("Test touche(Navire n) cote à cote horizontaux :");
		Coordonnee c4 = new Coordonnee ("B2");
		Coordonnee c5 = new Coordonnee ("E2");
		Navire n3 = new Navire(c4,3,false);
		Navire n4 = new Navire(c5,3,false);
		System.out.println("n3 touche n4 = "+ n3.touche(n4) + " TRUE ");
		System.out.println("n4 touche n3 = "+ n4.touche(n3) + " TRUE ");
		
		System.out.println("Test touche(Navire n) en desous à droite (horizontal et vertical) :");
		Coordonnee c6 = new Coordonnee ("B2");
		Coordonnee c7 = new Coordonnee ("D3");
		Navire n5 = new Navire(c6,3,false);
		Navire n6 = new Navire(c7,3,true);
		System.out.println("n5 touche n6 = "+ n5.touche(n6) + " TRUE ");
		System.out.println("n6 touche n5 = "+ n6.touche(n5) + " TRUE ");
		
		System.out.println("Test touche(Navire n) alignés horizontaux :");
		Coordonnee c8 = new Coordonnee ("B2");
		Coordonnee c9 = new Coordonnee ("B5");
		Navire n7 = new Navire(c8,3,true);
		Navire n8 = new Navire(c9,3,true);
		System.out.println("n7 touche n8 = "+ n7.touche(n8) + " TRUE ");
		System.out.println("n8 touche n7 = "+ n8.touche(n7) + " TRUE ");
		
		System.out.println("Test touche(Navire n) se touchent en diagonale (horizontal et vertical) :");
		Coordonnee c10 = new Coordonnee ("B2");
		Coordonnee c11 = new Coordonnee ("E3");
		Navire n9 = new Navire(c10,3,false);
		Navire n10 = new Navire(c11,3,true);
		System.out.println("n9 touche n10 = "+ n9.touche(n10) + " FALSE ");
		System.out.println("n10 touche n9 = "+ n10.touche(n9) + " FALSE ");
		
		
	}
	
	public static void testChevauche() {
		
		try {
			System.out.println("Test chevauche(Navire n) avec n == null :");
			Coordonnee c1 = new Coordonnee(2,5);
			Navire petitBateau = new Navire(c1,4,true);
			Navire fantome = null;
			petitBateau.chevauche(fantome);
			System.out.println("You lose, try again");		
		} catch (IllegalArgumentException e) {
			System.out.println("You win");
		}
		
		System.out.println("Test de chevauche(Navire n) :");
		rocher = new Coordonnee(5,2);
		Coordonnee iceberg = new Coordonnee(4,3);
		costaConcordia = new Navire(rocher,4,true);
		Navire titanic = new Navire(iceberg,4,false);
		if(costaConcordia.chevauche(titanic)==false)
			System.out.println("You lose, try again");
		else 
			System.out.println("You win");
		
		System.out.println("Test chevauche(Navire n) se chevauchent en bas à gauche (horizontal et vertical) :");
		Coordonnee c1 = new Coordonnee ("B2");
		Coordonnee c2 = new Coordonnee ("B2");
		Navire n1 = new Navire(c1,3,false);
		Navire n2 = new Navire(c2,3,true);
		System.out.println("n9 chevauche n10 = "+ n1.chevauche(n2) + " TRUE ");
		System.out.println("n10 chevauche n9 = "+ n2.chevauche(n1) + " TRUE ");
		
		System.out.println("Test chevauche(Navire n) se chevauchent en haut à gauche (horizontal et vertical) :");
		Coordonnee c3 = new Coordonnee ("B2");
		Coordonnee c4 = new Coordonnee ("B4");
		Navire n3 = new Navire(c3,3,true);
		Navire n4 = new Navire(c4,3,false);
		System.out.println("n9 chevauche n10 = "+ n3.chevauche(n4) + " TRUE ");
		System.out.println("n10 chevauche n9 = "+ n4.chevauche(n3) + " TRUE ");
		
		System.out.println("Test chevauche(Navire n) se chevauchent en haut à droite (horizontal et vertical) :");
		Coordonnee c5 = new Coordonnee ("B5");
		Coordonnee c6 = new Coordonnee ("D3");
		Navire n5 = new Navire(c5,3,false);
		Navire n6 = new Navire(c6,3,true);
		System.out.println("n9 chevauche n10 = "+ n5.chevauche(n6) + " TRUE ");
		System.out.println("n10 chevauche n9 = "+ n6.chevauche(n5) + " TRUE ");
		
		System.out.println("Test chevauche(Navire n) se chevauchent au milieu (horizontal et vertical) :");
		Coordonnee c7 = new Coordonnee ("B3");
		Coordonnee c8 = new Coordonnee ("C2");
		Navire n7 = new Navire(c7,3,false);
		Navire n8 = new Navire(c8,3,true);
		System.out.println("n9 chevauche n10 = "+ n7.chevauche(n8) + " TRUE ");
		System.out.println("n10 chevauche n9 = "+ n8.chevauche(n7) + " TRUE ");
		
	}
	
	public static void testRecoitTir() {
		try {
			System.out.println("Test recoitTir(Coordonnee c) avec c == null :");
			Coordonnee espritFrappeur = null;
			Navire blackPearl = new Navire(espritFrappeur,4,true);
			blackPearl.recoitTir(espritFrappeur);
			System.out.println("You lose, try again");		
		} catch (IllegalArgumentException e) {
			System.out.println("You win");
		}
		
		System.out.println("Test recoitTir(Coordonnee c) - c etant dans navire :");
		Coordonnee c1 = new Coordonnee ("B5");
		Coordonnee c2 = new Coordonnee ("B3");
		Coordonnee c4 = new Coordonnee ("B4");
		Coordonnee c5 = new Coordonnee ("B5");
		Coordonnee c6 = new Coordonnee ("B6");

		Coordonnee c3 = new Coordonnee ("C3");

		Navire n1 = new Navire(c2,3,true);
		System.out.println("n1 recoitTir c1 = "+ n1.recoitTir(c1) + " TRUE ");
		System.out.println(n1.afficherTab());
		System.out.println("n1 recoitTir c2 = "+ n1.recoitTir(c2) + " TRUE ");
		System.out.println(n1.afficherTab());

		System.out.println("n1 recoitTir c4 = "+ n1.recoitTir(c4) + " TRUE ");
		System.out.println(n1.afficherTab());

		System.out.println("n1 recoitTir c5 = "+ n1.recoitTir(c5) + " TRUE ");
		System.out.println(n1.afficherTab());

		System.out.println("n1 recoitTir c6 = "+ n1.recoitTir(c6) + " TRUE ");
		System.out.println("n1 recoitTir c3 = "+ n1.recoitTir(c3) + " FALSE ");

		System.out.println(n1.afficherTab());


		
	}
	
	public static void testEstTouche() {
		try {
			System.out.println("Test estTouche(Coordonnee c) avec c == null :");
			Coordonnee espritFrappeur = null;
			Navire blackPearl = new Navire(espritFrappeur,4,true);
			blackPearl.estTouche(espritFrappeur);
			System.out.println("You lose, try again");		
		} catch (IllegalArgumentException e) {
			System.out.println("You win");
		}
		
		System.out.println("Test estTouche(Coordonnee c) - c etant dans navire :");
		Coordonnee c1 = new Coordonnee ("B5");
		Coordonnee c2 = new Coordonnee ("B3");
		Navire n1 = new Navire(c2,3,true);
		n1.recoitTir(c1);
		System.out.println("n1 estTouche c1 = "+ n1.estTouche(c1) + " TRUE ");
		
	}
	
	public static void main(String[] args) {
		//testConstructeur();
		//testContient();
		//testChevauche();
		//testTouche();
		testRecoitTir();
		//testEstTouche();

	}

}
