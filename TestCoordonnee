package batailleNavale;

public class TestCoordonnee {
	private static Coordonnee c;
	
	public static void testConstructeurs() {
		try {
			System.out.println("Test constructeur 1 avec -6 et 0 : ");
			c=new Coordonnee(-6,0);
			System.out.println("Non : pas d'exception levée");
		} catch(IllegalArgumentException e) {
			System.out.println("Ok (exception avec message : " + e.getMessage() + '}');
		}
		
		try {
			System.out.println("Test constructeur 1 avec 0 et -2 : ");
			c=new Coordonnee(0,-2);
			System.out.println("Non : pas d'exception levée");
		} catch(IllegalArgumentException e) {
			System.out.println("Ok (exception avec message : " + e.getMessage() + '}');
		}
		
		try {
			System.out.println("Test constructeur 1 avec 0 et 30 : ");
			c=new Coordonnee(0,30);
			System.out.println("Non : pas d'exception levée");
		} catch(IllegalArgumentException e) {
			System.out.println("Ok (exception avec message : " + e.getMessage() + '}');
		}
		
		try {
			System.out.println("Test constructeur 1 avec 30 et 0 : ");
			c=new Coordonnee(30,0);
			System.out.println("Non : pas d'exception levée");
		} catch(IllegalArgumentException e) {
			System.out.println("Ok (exception avec message : " + e.getMessage() + '}');
		}
		
		try {
			System.out.println("Test constructeur 2 avec chaîne vide : ");
			c=new Coordonnee("");
			System.out.println("Non : pas d'exception levée");
		} catch(IllegalArgumentException e) {
			System.out.println("Ok (exception avec message : " + e.getMessage() + '}');
		}
		
		try {
			System.out.println("Test constructeur 2 avec A : ");
			c=new Coordonnee("A");
			System.out.println("Non : pas d'exception levée");
		} catch(IllegalArgumentException e) {
			System.out.println("Ok (exception avec message : " + e.getMessage() + '}');
		}
		
		try {
			System.out.println("Test constructeur 2 avec a : ");
			c=new Coordonnee("a");
			System.out.println("Non : pas d'exception levée");
		} catch(IllegalArgumentException e) {
			System.out.println("Ok (exception avec message : " + e.getMessage() + '}');
		}
		
		try {
			System.out.println("Test constructeur 2 avec A0 : ");
			c=new Coordonnee("A0");
			System.out.println("Non : pas d'exception levée");
		} catch(IllegalArgumentException e) {
			System.out.println("Ok (exception avec message : " + e.getMessage() + '}');
		}
		
		try {
			System.out.println("Test constructeur 2 avec 11 : ");
			c=new Coordonnee("11");
			System.out.println("Non : pas d'exception levée");
		} catch(IllegalArgumentException e) {
			System.out.println("Ok (exception avec message : " + e.getMessage() + '}');
		}
		
		try {
			System.out.println("Test constructeur 2 avec 1A : ");
			c=new Coordonnee("1A");
			System.out.println("Non : pas d'exception levée");
		} catch(IllegalArgumentException e) {
			System.out.println("Ok (exception avec message : " + e.getMessage() + '}');
		}
		
		try {
			System.out.println("Test constructeur 2 avec GH : ");
			c=new Coordonnee("GH");
			System.out.println("Non : pas d'exception levée");
		} catch(IllegalArgumentException e) {
			System.out.println("Ok (exception avec message : " + e.getMessage() + '}');
		}
		
		try {
			System.out.println("Test constructeur 2 avec G27 : ");
			c=new Coordonnee("G27");
			System.out.println("Non : pas d'exception levée");
		} catch(IllegalArgumentException e) {
			System.out.println("Ok (exception avec message : " + e.getMessage() + '}');
		}
		
		try {
			System.out.println("Test constructeur 2 avec G270 : ");
			c=new Coordonnee("G270");
			System.out.println("Non : pas d'exception levée");
		} catch(IllegalArgumentException e) {
			System.out.println("Ok (exception avec message : " + e.getMessage() + '}');
		}
		
	}
	
	public static void testEquals() {
		System.out.println("Test de faux négatif avec A2 : ");
		if(!new Coordonnee("A2").equals(new Coordonnee("A2")))
			System.out.println("NON : A2.equals(A2) doit renvoyer true");
		else System.out.println("Ok");
		
		System.out.println("Test de faux négatif avec A2 : ");
		Object d=new Coordonnee("A2");
		if(!new Coordonnee("A2").equals(d))
			System.out.println("NON : A2.equals(A2) doit renvoyer true");
		else System.out.println("Ok");
		
		System.out.println("Test de faux positif avec A2 et Y5 : ");
		if(new Coordonnee("A2").equals(new Coordonnee("Y5")))
			System.out.println("NON : A2.equals(Y5) doit renvoyer false");
		else System.out.println("Ok");
		
		System.out.println("Test de faux négatif avec A2 et Y5 : ");
		d=new Coordonnee("Y5");
		if(new Coordonnee("A2").equals(d))
			System.out.println("NON : A2.equals(A2) doit renvoyer true");
		else System.out.println("Ok");
	}
	
	public static void testVoisine() {
		try {
			System.out.println("Test de voisine avec A1 et une Coordonnee non initialisée : ");
			c=new Coordonnee("A1");
			c.voisine(null);
			System.out.println("NON : pas d'exception levée");
		} catch(NullPointerException e) {
			System.out.println("ok (exception avec message :"+e.getMessage()+')');
		}
		
		System.out.println('\n'+"Tests de faux positifs :");
		
		System.out.println("Test de voisine d'un faux positif avec B2 et B4 : ");
		c=new Coordonnee("B2");
		if(c.voisine(new Coordonnee("B4"))==true)
			System.out.println("NON : faux positif, B2 et B4 ne sont pas voisines !");
		else System.out.println("ok");
		
		System.out.println("Test de voisine d'un faux positif avec B4 et B2 : ");
		c=new Coordonnee("B4");
		if(c.voisine(new Coordonnee("B2"))==true)
			System.out.println("NON : faux positif, B4 et B2 ne sont pas voisines !");
		else System.out.println("ok");
		
		System.out.println("Test de voisine d'un faux positif avec B2 et D2 : ");
		c=new Coordonnee("B2");
		if(c.voisine(new Coordonnee("D2"))==true)
			System.out.println("NON : faux positif, B2 et B4 ne sont pas voisines !");
		else System.out.println("ok");
		
		System.out.println("Test de voisine d'un faux positif avec D2 et B2 : ");
		c=new Coordonnee("D2");
		if(c.voisine(new Coordonnee("B2"))==true)
			System.out.println("NON : faux positif, B2 et B4 ne sont pas voisines !");
		else System.out.println("ok");
		
		System.out.println("Test de voisine d'un faux positif avec B2 et A1 : ");
		c=new Coordonnee("B2");
		if(c.voisine(new Coordonnee("A1"))==true)
			System.out.println("NON : faux positif, B2 et B4 ne sont pas voisines !");
		else System.out.println("ok");
		
		System.out.println("Test de voisine d'un faux positif avec B2 et C1 : ");
		c=new Coordonnee("B2");
		if(c.voisine(new Coordonnee("C1"))==true)
			System.out.println("NON : faux positif, B2 et B4 ne sont pas voisines !");
		else System.out.println("ok");
		
		System.out.println("Test de voisine d'un faux positif avec B2 et A3 : ");
		c=new Coordonnee("B2");
		if(c.voisine(new Coordonnee("A3"))==true)
			System.out.println("NON : faux positif, B2 et B4 ne sont pas voisines !");
		else System.out.println("ok");
		
		System.out.println("Test de voisine d'un faux positif avec B2 et C3 : ");
		c=new Coordonnee("B2");
		if(c.voisine(new Coordonnee("A1"))==true)
			System.out.println("NON : faux positif, B2 et B4 ne sont pas voisines !");
		else System.out.println("ok");
		
		System.out.println("Test de voisine d'un faux positif avec B2 et H8 : ");
		c=new Coordonnee("B2");
		if(c.voisine(new Coordonnee("H8"))==true)
			System.out.println("NON : faux positif, B2 et B4 ne sont pas voisines !");
		else System.out.println("ok");
		
		System.out.println('\n'+"Tests de faux négatifs :");
		
		System.out.println("Test de voisine d'un faux négatif avec B2 et B3 : ");
		c=new Coordonnee("B2");
		if(c.voisine(new Coordonnee("B3"))==false)
			System.out.println("NON : faux positif, B2 et B4 ne sont pas voisines !");
		else System.out.println("ok");
		
		System.out.println("Test de voisine d'un faux négatif avec B2 et B1 : ");
		c=new Coordonnee("B2");
		if(c.voisine(new Coordonnee("B1"))==false)
			System.out.println("NON : faux positif, B2 et B4 ne sont pas voisines !");
		else System.out.println("ok");
		
		System.out.println("Test de voisine d'un faux négatif avec B2 et A2 : ");
		c=new Coordonnee("B2");
		if(c.voisine(new Coordonnee("A2"))==false)
			System.out.println("NON : faux positif, B2 et B4 ne sont pas voisines !");
		else System.out.println("ok");
		
		System.out.println("Test de voisine d'un faux négatif avec B2 et C2 : ");
		c=new Coordonnee("B2");
		if(c.voisine(new Coordonnee("C2"))==false)
			System.out.println("NON : faux positif, B2 et B4 ne sont pas voisines !");
		else System.out.println("ok");
		
	}
	
	public static void testCompareTo() {
		Coordonnee d1,d2;
		System.out.println("Test H7 compareTo H9 :");
		d1=new Coordonnee("H7");d2=new Coordonnee("H9");
		if(d1.compareTo(d2)>0)
			System.out.println("NON : H7 est inférieure à H9, résultat= "+d1.compareTo(d2));
		else System.out.println("ok");
		
		System.out.println("Test H7 compareTo D7 ");
		d1=new Coordonnee("H7");d2=new Coordonnee("D7");
		if(d1.compareTo(d2)<0)
			System.out.println("NON : H7 est supérieure à D7,résultat= "+d1.compareTo(d2));
		else System.out.println("ok");
		
		System.out.println("Test O8 compareTo Z8 ");
		d1=new Coordonnee("O8");d2=new Coordonnee("Z8");
		if(d1.compareTo(d2)>0)
			System.out.println("NON :O8 est supérieure à Z8, résultat= "+d1.compareTo(d2));
		else System.out.println("ok");
		
		System.out.println("Test 08 compareTO 010 ");
		d1=new Coordonnee("O8");d2=new Coordonnee("O10");
		if(d1.compareTo(d2)>0)
			System.out.println("NON : 08 est inférieure à 010, résultat= " +d1.compareTo(d2));
		else System.out.println("ok");
		
		System.out.println("Test T5 compareTo T5 ");
		d1=new Coordonnee("T5");d2=new Coordonnee("T5");
		if(d1.compareTo(d2)!=0)
			System.out.println("NON : T5 égale T5, résultat= "+d1.compareTo(d2));
		else System.out.println("ok");
		
	}
	
	public static void main(String[] args) {
		testConstructeurs();
		testVoisine();
		testEquals();
		testCompareTo();
		
	}

}
