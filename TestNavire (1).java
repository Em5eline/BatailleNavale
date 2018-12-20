package BatailleNavale;

public class TestNavire {
	
	protected static Navire n ; 


	public static void testConstructeurs() {
		try {
			System.out.println("Test constructeur, si le placement ou la longueur dépassent la grille...");
			Coordonnee c=new Coordonnee(24,6); 
			n= new Navire(c, 4, true) ;
			System.out.println("Ok, pas d'exception levée !");
		} catch(IllegalArgumentException e) {
			System.out.println("NON ! Exception avec message : " + e.getMessage());
		}
		
		try {
			System.out.println("Test constructeur, si le placement ou la longueur dépassent la grille...");
			Coordonnee c=new Coordonnee(6,24); 
			n= new Navire(c, 4, false) ;
			System.out.println("Ok, pas d'exception levée !");
		} catch(IllegalArgumentException e) {
			System.out.println("NON ! Exception avec message : " + e.getMessage());
		}
		
		try {
			System.out.println("Test constructeur, si le navire est composé d'une seule case...") ;
			Coordonnee c = new Coordonnee(3,4) ;
			n=new Navire(c,1, false) ;
			System.out.println("Ok, pas d'exception levée !") ;
		} catch (IllegalArgumentException e) {
			System.out.println("NON ! Exception levée : " + e.getMessage());
		}
		
		try {
			System.out.println("Test constructeur, si le navire est composé de plus de 6 cases...") ; 
			Coordonnee c = new Coordonnee(5,6) ;
			n=new Navire(c, 8, false) ;
			System.out.println("Ok, pas d'exception levée !") ;
		} catch (IllegalArgumentException e) {
			System.out.println("NON ! Exception levée : " + e.getMessage());
		}
		
		try {
			System.out.println("Test constructeur, si le navire est correct...");
			Coordonnee c = new Coordonnee (5,7);
			n=new Navire(c, 5, false) ;
			System.out.println("Ok, pas d'exception levée !");
		} catch (IllegalArgumentException e) {
			System.out.println("NON ! Exception levée : " + e.getMessage());
		}
	}
	
	public static void testContient() {
		//Retourne true si et seulement si this occupe c.
		// Si les coordonnées ne sont pas initilisées
		try {
			System.out.println("Test, si les coordonnées (contenues) sont null...");
			Coordonnee c1 = null ;
			Navire n1 = new Navire(c1, 5, false ) ;
			n1.contient(c1) ;
			System.out.println("Ok, pas d'exception levée !");
		} catch (NullPointerException e) {
			System.out.println("NON ! Exception levée : " + e.getMessage());
		}
		
		System.out.println("Test, si les coordonnées (contenues) sont au format ligne, colonne...") ; 
		Coordonnee c5 = new Coordonnee(5,6) ;
		Coordonnee c7 = new Coordonnee(6,6) ;
		Navire n5 = new Navire(c5, 4, true) ;
		System.out.println("Normalement, c'est bon = " + n5.contient(c7)) ;
		Coordonnee c6 = new Coordonnee(6,7) ; 
		System.out.println("Normalement, c'est faux = " + n5.contient(c6)) ;
		
		System.out.println("Test, si les coordonnées (contenues) sont au format texte...");
		Coordonnee c11 = new Coordonnee("D4") ;
		Coordonnee c12 = new Coordonnee("D5") ; 
		Coordonnee c13 = new Coordonnee("E8") ;
		Navire n10 = new Navire(c11, 3, true) ;
		System.out.println("Normalement, c'est bon = " + n10.contient(c12)) ;
		System.out.println("Normalement, c'est faux = " + n10.contient(c13)) ;	
	}
	
	
	public static void testTouche() {
		//Retourne true si et seulement si this est adjacent à n.
		try {
			System.out.println("Test, si le Navire (adjacent) est null...");
			Coordonnee c1 = new Coordonnee (6,8) ;
			Navire n1 = new Navire(c1, 5, false ) ;
			Navire n2 = null ;
			n1.touche(n2) ;
			System.out.println("Non : pas d'exception levée");
		} catch (NullPointerException e) {
			System.out.println("Ok, exception levée : " + e.getMessage());
		}
		
		System.out.println("Test, si le navire (adjacent) est bien adjacent en dessous à gauche...") ; 
		Coordonnee c5 = new Coordonnee("B3") ;
		Coordonnee c7 = new Coordonnee("B4") ;
		Navire n5 = new Navire(c5, 4, false) ;
		Navire n6 = new Navire(c7, 3, true) ;
		System.out.println("Dans un sens = " + n5.touche(n6)) ;
		System.out.println("Dans l'autre sens =  " + n6.touche(n5));
		
		
		System.out.println("Test, si le navire (adjacent) est bien adjacent en dessous à droite...");
		Coordonnee c11 = new Coordonnee("B3") ;
		Coordonnee c12 = new Coordonnee("E4") ; 
		Navire n10 = new Navire(c11, 3, false) ;
		Navire n11 = new Navire(c12, 4, true) ;
		System.out.println("Dans un sens = " + n10.touche(n11)) ;
		System.out.println("Dans l'autre = " + n11.touche(n10));
		
		System.out.println("Test, si le navire (adjacent) est bien adjacent au dessus à gauche...");
		Coordonnee c21 = new Coordonnee("B7") ;
		Coordonnee c22 = new Coordonnee("B3") ; 
		Navire n21 = new Navire(c21, 3, false) ;
		Navire n22 = new Navire(c22, 4, true) ;
		System.out.println("Dans un sens = " + n21.touche(n22)) ;
		System.out.println("Dans l'autre = " + n22.touche(n21));
		
		System.out.println("Test, si le navire (adjacent) est bien adjacent au dessus à droite...");
		Coordonnee c31 = new Coordonnee("B7") ;
		Coordonnee c32 = new Coordonnee("D3") ; 
		Navire n31 = new Navire(c31, 3, false) ;
		Navire n32 = new Navire(c32, 4, true) ;
		System.out.println("Dans un sens = " + n31.touche(n32)) ;
		System.out.println("Dans l'autre = " + n32.touche(n31));
		
		System.out.println("Test, si le navire (adjacent) est bien adjacent à droite...");
		Coordonnee c41 = new Coordonnee("B7") ;
		Coordonnee c42 = new Coordonnee("E3") ; 
		Navire n41 = new Navire(c41, 3, false) ;
		Navire n42 = new Navire(c42, 4, true) ;
		System.out.println("Dans un sens = " + n41.touche(n42)) ;
		System.out.println("Dans l'autre = " + n42.touche(n41));
		
		System.out.println("Test, si le navire (adjacent) est bien adjacent à gauche...");
		Coordonnee c51 = new Coordonnee("B7") ;
		Coordonnee c52 = new Coordonnee("A4") ; 
		Navire n51 = new Navire(c51, 3, false) ;
		Navire n52 = new Navire(c52, 4, true) ;
		System.out.println("Dans un sens = " + n51.touche(n52)) ;
		System.out.println("Dans l'autre = " + n52.touche(n51));
	}
	
	
	public static void testChevauche() {
		/*Retourne true si et seulement si this chevauche n, 
		 * c'est-à-dire que this et n occupent au moins une coordonnée en commun.
		 */
		try {
			System.out.println("Test, si le Navire (chevauchant) en paramètre est null...");
			Coordonnee c1 = new Coordonnee (6,8) ;
			Navire n1 = new Navire(c1, 5, false) ;
			Navire n2 = null ;
			n1.chevauche(n2) ;
			System.out.println("Non : pas d'exception levée");
		} catch (NullPointerException e) {
			System.out.println("Ok, exception levée : " + e.getMessage());
		}
		
		System.out.println("Test, si le navire (chevauchant) est bien chevauchant en partant du haut à gauche...");
		Coordonnee c31 = new Coordonnee("B7") ;
		Coordonnee c32 = new Coordonnee("B4") ; 
		Navire n31 = new Navire(c31, 3, false) ;
		Navire n32 = new Navire(c32, 4, true) ;
		System.out.println("Dans un sens = " + n31.chevauche(n32)) ;
		System.out.println("Dans l'autre = " + n32.chevauche(n31)) ;
		
		System.out.println("Test, si le navire (chevauchant) est bien chevauchant en partant du haut à droite...");
		Coordonnee c61 = new Coordonnee("B7") ;
		Coordonnee c62 = new Coordonnee("D4") ; 
		Navire n61 = new Navire(c61, 3, false) ;
		Navire n62 = new Navire(c62, 4, true) ;
		System.out.println("Dans un sens = " + n61.chevauche(n62)) ;
		System.out.println("Dans l'autre = " + n62.chevauche(n61)) ;
		
		System.out.println("Test, si le navire (chevauchant) est bien chevauchant en partant du bas à gauche...");
		Coordonnee c11 = new Coordonnee("B7") ;
		Coordonnee c12 = new Coordonnee("B7") ; 
		Navire n11 = new Navire(c11, 3, false) ;
		Navire n12 = new Navire(c12, 4, true) ;
		System.out.println("Dans un sens = " + n11.chevauche(n12)) ;
		System.out.println("Dans l'autre = " + n12.chevauche(n11)) ;
		
		System.out.println("Test, si le navire (chevauchant) est bien chevauchant en partant du bas à droite...");
		Coordonnee c21 = new Coordonnee("B7") ;
		Coordonnee c22 = new Coordonnee("D7") ; 
		Navire n21 = new Navire(c21, 3, false) ;
		Navire n22 = new Navire(c22, 4, true) ;
		System.out.println("Dans un sens = " + n21.chevauche(n22)) ;
		System.out.println("Dans l'autre = " + n22.chevauche(n21)) ;
	}
	
	
	public static void testRecoitTir() {
		// Retourne true si et seulement si this contient c. Dans ce cas, c est ajoutée aux parties touchées si nécessaire.
		try {
			System.out.println("Test, si les coordonnées (reçevant les tirs) sont null...");
			Coordonnee c1 = null ;
			Navire n1 = new Navire(c1, 5, false) ;
			n1.recoitTir(c1) ;
			System.out.println("Non : pas d'exception levée");
		} catch (NullPointerException e) {
			System.out.println("Ok, exception levée : " + e.getMessage());
		}
		
		System.out.println("Test, si les coordonnées (réceptionnant le tir) apppartiennent à un navire, format ligne/colonne...") ; 
		Coordonnee c5 = new Coordonnee(5,6) ;
		Coordonnee c7 = new Coordonnee(6,6) ;
		Navire n5 = new Navire(c5, 4, true) ;
		System.out.println("Normalement, c'est bon = " + n5.recoitTir(c7)) ;
		Coordonnee c6 = new Coordonnee(6,7) ; 
		System.out.println("Normalement, c'est faux = " + n5.recoitTir(c6)) ;
		
		System.out.println("Test, si les coordonnées (réceptionnant le tir) appartiennent à un navire, format texte...");
		Coordonnee c31 = new Coordonnee("B7") ;
		Coordonnee c32 = new Coordonnee("C7") ; 
		Coordonnee c33 = new Coordonnee("D5") ;
		Navire n31 = new Navire(c31, 3, false) ;
		System.out.println("Normalement, c'est bon = " + n31.recoitTir(c32)) ;
		System.out.println("Normalement, c'est faux = " + n31.recoitTir(c33));
		
		try {
		System.out.println("Test, si les coordonnées (réceptionnant le tir) appartiennent à un navire, format texte...");
		// Coordonnee c41 = new Coordonnee("B7") ;
		Navire n41 = new Navire(c31, 3, false) ;
		Coordonnee c42 = new Coordonnee("C7") ; 
		Coordonnee c43 = new Coordonnee("D6") ;
		System.out.println("Normalement, c'est bon = " + n41.recoitTir(c42)) ;
		System.out.println("Normalement, c'est faux = " + n41.recoitTir(c43));
		} catch (IllegalArgumentException e ) {
			System.out.println("Ok, exception levée : " + e.getMessage());
		}
		
		
	}
	
	public static void testEstTouche() {
		// Retourne true si et seulement si this a été touché par un tir en c.
		try {
			System.out.println("Test, si les coordonnées (étant touchées) sont null...");
			Coordonnee c1 = null ;
			Navire n1 = new Navire(c1, 5, false) ;
			n1.estTouche(c1) ;
			System.out.println("Non : pas d'exception levée");
		} catch (NullPointerException e) {
			System.out.println("Ok, exception levée : " + e.getMessage());
		}
		
		System.out.println("Test, si les coordonnées (touchées) apppartiennent à un navire, format ligne/colonne...") ; 
		Coordonnee c5 = new Coordonnee(5,6) ;
		Coordonnee c7 = new Coordonnee(6,6) ;
		Navire n5 = new Navire(c5, 4, true) ;
		n5.recoitTir(c7) ;
		System.out.println("Normalement, c'est bon = " + n5.estTouche(c7)) ;
		Coordonnee c6 = new Coordonnee(6,7) ; 
		System.out.println("Normalement, c'est faux = " + n5.estTouche(c6)) ;
		
		System.out.println("Test, si les coordonnées (touchées) appartiennent à un navire, format texte...");
		Coordonnee c31 = new Coordonnee("B7") ;
		Coordonnee c32 = new Coordonnee("C7") ; 
		Coordonnee c33 = new Coordonnee("D5") ;
		Navire n31 = new Navire(c31, 3, false) ;
		n31.recoitTir(c32) ;
		System.out.println("Normalement, c'est bon = " + n31.estTouche(c32)) ;
		System.out.println("Normalement, c'est faux = " + n31.estTouche(c33));
	}
	
//	public static void testEstTouche1() {
//		//Retourne true si et seulement si this a au moins une partie touché́e.
//		try {
//			System.out.println("Test, si le nombre de tirs touchés est supérieur à la longueur du bâteau...");
//			Coordonnee c1 = new Coordonnee(5,2) ;
//			Navire n1 = new Navire (c1, 2, false) ;
//			Coordonnee c2 = new Coordonnee(5,3) ;
//			n1.recoitTir(c2) ;
//			System.out.println(n1.estTouche(c2)) ;
//			Coordonnee c3 = new Coordonnee(5,4);
//			n1.recoitTir(c3) ;
//			System.out.println("Non : pas d'exception levée");
//		} catch (IllegalArgumentException e) {
//			System.out.println("Ok, exception levée : " + e.getMessage());
//		}	
//	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testConstructeurs();
		testContient();
		testTouche() ;
		testChevauche();
		testRecoitTir();
		testEstTouche() ;
		// testEstTouche1();
		}
}