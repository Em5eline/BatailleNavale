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
		
			System.out.println("Test de contient(Coordonnee c) :");
			rocher = new Coordonnee(22,2);
			Coordonnee iceberg = new Coordonnee(21,2);
			costaConcordia = new Navire(rocher,4,true);
			if(costaConcordia.contient(iceberg)==true)
				System.out.println("You lose, try again");
			else 
				System.out.println("You win");
			
			System.out.println("Test de contient(Coordonnee c) :");
			rocher = new Coordonnee(20,2);
			iceberg = new Coordonnee(21,2);
			costaConcordia = new Navire(rocher,4,false);
			if(costaConcordia.contient(iceberg)==false)
				System.out.println("You lose, try again");
			else 
				System.out.println("You win");

	}
	
	public static void testTouche() {
		
		System.out.println("Test de touche(Navire n) :");
		rocher = new Coordonnee(0,0);
		Coordonnee iceberg = new Coordonnee(3,0);
		costaConcordia = new Navire(rocher,3,false);
		Navire titanic = new Navire(iceberg,2,false);
		if(costaConcordia.touche(titanic)==false)
			System.out.println("You lose, try again");
		else 
			System.out.println("You win");
		
		System.out.println("Test de touche(Navire n) :");
		rocher = new Coordonnee(23,2);
		iceberg = new Coordonnee(21,2);
		costaConcordia = new Navire(rocher,4,true);
		titanic = new Navire(iceberg,4,true);
		if(costaConcordia.touche(titanic)==true)
			System.out.println("You lose, try again");
		else 
			System.out.println("You win");
		
		
		
	}
	
	public static void testChevauche() {
		
		System.out.println("Test de touche(Navire n) :");
		rocher = new Coordonnee(5,2);
		Coordonnee iceberg = new Coordonnee(4,3);
		costaConcordia = new Navire(rocher,4,true);
		Navire titanic = new Navire(iceberg,4,false);
		if(costaConcordia.chevauche(titanic)==false)
			System.out.println("You lose, try again");
		else 
			System.out.println("You win");
		
	}
	
	
	
	public static void main(String[] args) {
		testConstructeur();
		//testContient();
		//testChevauche();
		testTouche();

	}

}
