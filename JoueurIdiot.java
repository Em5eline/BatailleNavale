
package batailleNavale;

public class JoueurIdiot extends JoueurAuto{

	//public final static int TOUCHE = 1;
		//public final static int COULE = 2;
		//public final static int A_L_EAU = 3;
		//public final static int GAMEOVER = 4;
		private Coordonnee tirChoisi;


		
		public JoueurIdiot(GrilleNavale g, String nom) {
			super(g,nom);
			
			
		}
			
		public JoueurIdiot(GrilleNavale g) {
			super(g, "Jack Sparrow");
			
		}
		
		
		protected void retourAttaque(Coordonnee c, int etat) {
			if (etat == super.GAMEOVER)
				System.out.println( this.getNom() +" a gagné!");
			else if (etat == super.COULE)
				System.out.println(this.getNom() +" a coulé un bateau");
			else if (etat == super.TOUCHE)
				System.out.println(this.getNom() +" a touché un bateau");
			else 
				System.out.println(this.getNom() +" a fait plouf");
		}

		protected void retourDefense(Coordonnee c, int etat) {
			if (etat == super.GAMEOVER)
				System.out.println(this.getNom() +" a perdu! \nStupidBot est triste...");
			else if (etat == super.COULE)
				System.out.println(this.getNom() +" a perdu un bateau");
			else if (etat == super.TOUCHE)
				System.out.println(this.getNom() +" s'est fait trouer un bateau");
			else 
				System.out.println(this.getNom() +" a esquivé");
				System.out.println(super.getGrille().toString().replace('#','.')+"\nGRILLE DU BOT");
				


		}
		
		
		/**
		 * Cette méthode est invoquée sur le joueur attaquant au début d’un tour de jeu. Elle retourne
		   la coordonnée cible du tir effectué par l’attaquant. 
		 */
		public Coordonnee choisirAttaque() {
			int ligne = (int) (Math.random() * super.getGrille().getTaille());
			int colonne = (int) (Math.random() * super.getGrille().getTaille());
			//if (navireTouche == false)
			tirChoisi = new Coordonnee(colonne,ligne);
			
			//if (navireTouche == true)
			//	if (est)
			//	tirChoisi = new Coordonnee()
			System.out.println(this.getNom()+" attaque en: "+tirChoisi);
			return tirChoisi;
				
		}
		

		
		
		public static void main(String[] args) {
			int[] mesnavires1 = {2};
			int[] mesnavires2 = {3,3};
			GrilleNavale grille1 = new GrilleNavale(4, mesnavires1);
			GrilleNavale grille2 = new GrilleNavale(4, mesnavires2);
			
			
			System.out.println(grille2+"\n"+"GRILLE DE MOI ");
			System.out.println(grille1.toString().replace('#','.')+"\nGRILLE DU BOT");

			JoueurIdiot bot = new JoueurIdiot(grille1, "StupidBot");
			JoueurTexte THEBEST = new JoueurTexte(grille2, "toi là");
			bot.jouerAvec(THEBEST);
			

		}

	}
