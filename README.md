Main de la classe JoueurGraphique :
```java

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GrilleNavaleGraphique magrilleDefense = new GrilleNavaleGraphique(10); // La oÃ¹ sont placÃ©s les bÃ¢teaux
		GrilleGraphique magrillegraphique = new GrilleGraphique(10); // LÃ  oÃ¹ l'attaquant clique
		Navire n = new Navire(new Coordonnee(1,1),5,true);
		FenetreJoueur fenetre;
		FenetreJoueur fenetre1;
		String nom = "Jacques";
		String nom1 = "Chirac";

		fenetre = new FenetreJoueur(nom, 10);
		fenetre1 = new FenetreJoueur(nom1, 10);
		fenetre.setVisible(true);	
		fenetre1.setVisible(true);
		
		JoueurGraphique Jacques = new JoueurGraphique(fenetre.getGrilleDefense(), fenetre.getGrilleTirs(), nom);
		JoueurGraphique Chirac = new JoueurGraphique(fenetre.getGrilleDefense(), fenetre.getGrilleTirs(), nom1);
		
		fenetre.getGrilleDefense().ajouteNavire(n);
		fenetre1.getGrilleDefense().ajouteNavire(n);		
				
	}
```
