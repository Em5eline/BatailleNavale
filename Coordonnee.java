package batailleNavale;

public class Coordonnee implements Comparable<Coordonnee> {
				
	//ATRIBUTS
	
	private int ligne;
	private int colonne;
	
	//CONSTRUCTEURS
	
	/**
	 * Initialise les attributs d'instance à partir de 2 entiers compris entre 0 et 25
	 * @param colonne
	 * @param ligne
	 */
	
	public Coordonnee(int colonne, int ligne) {
		if ((ligne<0) || (ligne >25))
			throw new IllegalArgumentException ("Il faut revoir votre ligne !");
		if ((colonne<0) || (colonne>25))
			throw new IllegalArgumentException ("Les colonnes c'est n'importe quoi là !");
		this.ligne = ligne;
		this.colonne = colonne;
	}
	
	/**
	 * Initialise les attributs d'instance à partir d'une String s de la forme "X00"
	 * @param s
	 */
	
	public Coordonnee(String s) {
		if (s.equals("")) {
			throw new IllegalArgumentException("Erreur chaîne vide");
		}
		
		int l = Integer.parseInt(s.substring(1, s.length())) - 1;
		
		
		if(s.length() != 2 && s.length() != 3) {
			throw new IllegalArgumentException("Longueur incorrecte");
		}
		
		if ( l < 0 || l > 25) {
			throw new IllegalArgumentException("La ligne doit être comprise entre 0 et 25");
		}
			
		this.colonne = s.charAt(0) - 'A';
		this.ligne = Integer.parseInt(s.substring(1, s.length())) - 1;
	}
	
	//METHODES
	
	/** Retourne une String exprimant this
	 * 
	 */
	
	public String toString() {
		return String.valueOf((char)(this.colonne + 'A') + String.valueOf(this.ligne + 1)); 
	}
	
	/** à ton avis ?
	 * 
	 * @return
	 */
	
	public int getColonne() {
		return this.colonne;
	}
	
	/** à ton avis ?
	 * 
	 * @return
	 */
	
	public int getLigne() {
		return this.ligne;
	}
	
	/** Retourne vrai si this et obj sont équivalent
	 */
	
	public boolean equals(Object obj) {
		return (obj instanceof Coordonnee) && (this.ligne == ((Coordonnee)obj).ligne && this.colonne == ((Coordonnee)obj).colonne);
	}
	
	/**
	 * Retourne vrai si this est une coordonnée voisine de c (verticalement ou horizontalement)
	 * @param c
	 * @return
	 */
	
	public boolean voisine (Coordonnee c) {
		return (((c.ligne == this.ligne + 1 || c.ligne == this.ligne - 1) && (c.colonne == this.colonne)) ^ ((c.colonne == this.colonne + 1 || c.colonne == this.colonne - 1) && (c.ligne == this.ligne)));
	}
	
	/**
	 * Retourne le résultat de la comparaison de this et de c . Une coordonnée est
	 * considérée inférieure à une autre, si elle se trouve sur une ligne inférieure
	 * ou si elle se trouve sur la même ligne mais sur une colonne infé rieure
	 * 
	 */
	
	
	public int compareTo (Coordonnee c) {
		if (this.ligne == c.ligne && this.colonne == c.colonne)
			return 0;

		if (this.ligne > c.ligne) {
			return 1;
		} else if (this.ligne < c.ligne) {
			return -1;
		} else
			return this.colonne > c.colonne ? 1 : -1;
	}
	
	
	public static void main(String[] args) {
		Coordonnee test1 = new Coordonnee(2,5);
		Coordonnee test2 = new Coordonnee("C4");
		System.out.println(test1);
	}

}
