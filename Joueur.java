package batailleNavale;

public abstract class Joueur {
	public final static int TOUCHE = 1;
	public final static int COULE = 2;
	public final static int A_L_EAU = 3;
	public final static int GAMEOVER = 4;
	private Joueur adversaire;
	private int tailleGrille;
	private String nom;

	/**
	 * permet d'obtenir un joueur de nom nom et jouant sur une grille de taille
	 * taillegrille
	 * 
	 * @param tailleGrille
	 * @param nom
	 */

	public Joueur(int tailleGrille, String nom) {
		this(tailleGrille);
		this.nom = nom;
	}

	/**
	 * permet d'obtenir un joueur jouant sur une grille de taille taillegrille.
	 * 
	 * @param tailleGrille
	 */

	public Joueur(int tailleGrille) {
		this.tailleGrille = tailleGrille;
	}

	/**
	 * Accesseur en lecture pour tailleGrille.
	 * 
	 * @return tailleGrille
	 */

	public int getTailleGrille() {
		return tailleGrille;
	}

	/**
	 * Accesse ur en lecture pour nom .
	 * 
	 * @return nom
	 */

	public String getNom() {
		return nom;
	}

	/**
	 * Démarre une partie contre j . Avant de lancer le déroulement du jeu, il faut
	 * veiller à établir le lien entre les 2 joueurs et bien entendu vérifier qu’il
	 * puisse être établi
	 * 
	 * @param j
	 */

	public void jouerAvec(Joueur j) {
		if (this.adversaire != null || j.adversaire != null) { // vérification que les 2 joueurs ne sont pas utilisé
			System.out.println("Un des joueurs joue déjà avec quelqu'un d'autre !");
			return;
		} else {
			System.out.println("Début de la partie, que le sort puisse vous être favorable");
		}
		this.adversaire = j;
		j.adversaire = this;
		deroulementJeu(this, j);
		this.adversaire = null; // si la partie est finie on réinitialise les joueurs à null
		j.adversaire = null;
	}

	private static void deroulementJeu(Joueur attaquant, Joueur defenseur) {
		int res = 0;
		while (res != GAMEOVER) {
			Coordonnee c = attaquant.choisirAttaque();
			res = defenseur.defendre(c);
			attaquant.retourAttaque(c, res);
			defenseur.retourDefense(c, res);
			Joueur x = attaquant;
			attaquant = defenseur;
			defenseur = x;
		}
	}

	/**
	 * Cette méthode est invoquée sur le joueur attaquant à la fin d’un tour de jeu
	 * . c est la coordonnée à laquelle le tir a eu lieu et etat le résultat de
	 * l'attaque. etat ne peut être que TOUCHE , COULE , A_L_EAU , ou GAMEOVER .
	 * 
	 * @param c
	 * @param etat
	 */

	protected abstract void retourAttaque(Coordonnee c, int etat);

	/**
	 * Cette méthode est invoquée sur le joueur défenseur à la fin d’un tour de jeu
	 * . c est la coordonnée à laquelle le tir a eu lieu et etat le résultat de ce
	 * tir. etat ne peut être que TOUCHE , COULE , A_L_EAU , ou GAMEOVER .
	 * 
	 * @param c
	 * @param etat
	 */

	protected abstract void retourDefense(Coordonnee c, int etat);

	/**
	 * Cette méthode est invoquée sur le joueur attaquant au début d’un tour de jeu.
	 * Elle retourne la coordonnée cible du tir effectué par l’attaquant .
	 * 
	 */

	public abstract Coordonnee choisirAttaque();

	/**
	 * Cette méthode est invoquée sur le joueur défenseu r après le choix de
	 * l’attaquant, c est la coordonnée à laquelle l’attaquant a choisi d’effectuer
	 * un tir . Elle retourne le résultat du tir qui ne peut être que TOUCHE , COULE
	 * , A_L_EAU , ou GAMEOVER .
	 * 
	 * @param c
	 * @return
	 */

	public abstract int defendre(Coordonnee c);
}
