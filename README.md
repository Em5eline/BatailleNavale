# BatailleNavale
Projet programmation Java.

Constructeur 2 coordonnées : 

public Coordonnee(String s) {
		
		int l = Integer.parseInt(s.substring(1, s.length())) - 1;
		
		
		if(s.length() != 2 && s.length() != 3) {
			throw new IllegalArgumentException("Longueur incorrecte");
		}
		
		if ( l < 0 || l > 25) {
			throw new IllegalArgumentException("La ligne doit être comprise entre 0 et 25");
		}
		
		if (s.equals("")) {
			throw new IllegalArgumentException("Erreur chaîne vide");
		}
			
		this.colonne = s.charAt(0) - 'A';
		this.ligne = Integer.parseInt(s.substring(1, s.length())) - 1;
		
}




TODO LIST:
