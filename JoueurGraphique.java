package batailleNavale;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;

public class JoueurGraphique extends JoueurAvecGrille {
	
	private GrilleGraphique grilleTirs;
	
	
	
	/**
	 * Permet d'obtenir un joueur graphique de nom nom qui effectue des tirs en cliquant sur
	   grilleTirs et dont la flotte est placée sur grilleDefense.
	 * @param grilleDefense : Ma grille
	 * @param grilleTirs : La grille à détruire
	 * @param nom
	 */
	
	public JoueurGraphique(GrilleNavaleGraphique grilleDefense, GrilleGraphique grilleTirs, String nom) {
		super(grilleDefense,nom);
		this.grilleTirs = grilleTirs;
		
	}
	
	
	
	/**
	 * Permet d'obtenir un joueur graphique qui effectue des tirs en cliquant sur grilleTirs et
	   dont la flotte est placée sur grilleDefense.
	 * @param grilleDefense : Ma grille
	 * @param grilleTirs : La grille à détruire
	 */
	
	public JoueurGraphique(GrilleNavaleGraphique grilleDefense, GrilleGraphique grilleTirs) {
		super(grilleDefense);
		this.grilleTirs = grilleTirs;
	}
	
	
	
	/**
	 * Consiste à récupérer la coordonnée choisie depuis grilleTirs.
	 */
	
	public Coordonnee choisirAttaque() {
		return this.grilleTirs.getCoordonneeSelectionnee();
	}
	
	
	
	/**
	 * Affichage d'un JOptionPane lorsque le tir a touché ou coulé un navire, ou lorsque la partie
	   est perdue.
	 */
	
	protected void retourDefense(Coordonnee c, int etat) {
		JOptionPane message = new JOptionPane();
		switch(etat) {
		case TOUCHE :
			JOptionPane.showMessageDialog(message, "Touché en : "+c, " Pas cool ", JOptionPane.WARNING_MESSAGE);
			break;
	
		case COULE: 
			
			JOptionPane.showMessageDialog(message, "Navire coulé !"," J'aurais les boules à ta place ", JOptionPane.WARNING_MESSAGE);
			break;
		
		case GAMEOVER:
			try {
		        Clip clip = AudioSystem.getClip();
		        clip.open(AudioSystem.getAudioInputStream(new File("titanic.wav")));
		        clip.start();
		    }
		    catch (Exception exc) {
		        exc.printStackTrace(System.out);
		    }
			JOptionPane.showMessageDialog(message, "Tu as perdu !"," Goodbye my lover, goodbye my friend ", JOptionPane.WARNING_MESSAGE);
			break;
		
		}
	}
	
	
	
	/**
	 * Affichage d'un JOptionPane lorsque mon tir a touché ou coulé un navire adverse, ou lorsque la partie
	   est gagnée.
	 */
	
	protected void retourAttaque(Coordonnee c, int etat) {
		Color couleur = etat == A_L_EAU ? Color.BLUE : Color.RED;
		grilleTirs.colorie(c, couleur);
		switch (etat) {
			case TOUCHE:
				try {
			        Clip clip = AudioSystem.getClip();
			        clip.open(AudioSystem.getAudioInputStream(new File("explosion.wav")));
			        clip.start();
			    }
			    catch (Exception exc) {
			        exc.printStackTrace(System.out);
			    }
				JOptionPane.showMessageDialog(grilleTirs, "Un vrai sniper ! Tu as touché un navire en " + c);
				break;
			case COULE:
				try {
			        Clip clip = AudioSystem.getClip();
			        clip.open(AudioSystem.getAudioInputStream(new File("bravo.wav")));
			        clip.start();
			    }
			    catch (Exception exc) {
			        exc.printStackTrace(System.out);
			    }
				JOptionPane.showMessageDialog(grilleTirs, "Tu es un machine de guerre ! Tu as coulé un navire en " + c);
				break;
			case GAMEOVER:
				try {
			        Clip clip = AudioSystem.getClip();
			        clip.open(AudioSystem.getAudioInputStream(new File("gagne.wav")));
			        clip.start();
			    }
			    catch (Exception exc) {
			        exc.printStackTrace(System.out);
			    }
				JOptionPane.showMessageDialog(grilleTirs, "Tu as gagné !" + "\n" + "Et accessoirement tué 357 marins..."+"\n"+
																				  "(Non je n'exagère pas, c'est un massacre)");
				break;
			case A_L_EAU:
				try {
			        Clip clip = AudioSystem.getClip();
			        clip.open(AudioSystem.getAudioInputStream(new File("ah.wav")));
			        clip.start();
			    }
			    catch (Exception exc) {
			        exc.printStackTrace(System.out);
			    }
break;
				
				
		}
	}
	
	
	
	
	
	public static void main(String[] args) {
												//Test de Main\\
		GrilleNavaleGraphique HomeSweetHome = new GrilleNavaleGraphique(10); // La oÃ¹ sont placÃ©s les bÃ¢teaux
		GrilleGraphique Hell = new GrilleGraphique(10); // LÃ  oÃ¹ l'attaquant clique
		GrilleNavaleGraphique Lautre = new GrilleNavaleGraphique(10);
		int[] mesBébés = {2,4,3,3};
		int[] sesMioches = {2,4,3,3};
		FenetreJoueur hublot;
		FenetreJoueur velux;
		String nom = "PartieDeLaMort";
		String nom1 = "LaPremiereFois";

		hublot = new FenetreJoueur(nom, 10);
		velux = new FenetreJoueur(nom1, 10);
		hublot.setVisible(true);	
		velux.setVisible(true);
		
		JoueurGraphique JackSparrow = new JoueurGraphique(hublot.getGrilleDefense(), hublot.getGrilleTirs(), nom);
		JoueurIdiot Teubé = new JoueurIdiot(Lautre,"JeSuisBete");
		
		hublot.getGrilleDefense().placementAuto(mesBébés);
		velux.getGrilleDefense().placementAuto(sesMioches);
		JackSparrow.jouerAvec(Teubé);
	}
}


