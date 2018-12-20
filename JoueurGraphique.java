package batailleNavale;

import java.awt.Color;

import javax.swing.JOptionPane;

public class JoueurGraphique extends JoueurAvecGrille {
	
	private GrilleGraphique grilleTirs;
	
	public JoueurGraphique(GrilleNavaleGraphique grilleDefense, GrilleGraphique grilleTirs, String nom) {
		super(grilleDefense,nom);
		this.grilleTirs = grilleTirs;
	}
	
	public JoueurGraphique(GrilleNavaleGraphique grilleDefense, GrilleGraphique grilleTirs) {
		super(grilleDefense);
		this.grilleTirs = grilleTirs;
	}
	
	public Coordonnee choisirAttaque() {
		return this.grilleTirs.getCoordonneeSelectionnee();
	}
	
	protected void retourDefense(Coordonnee c, int etat) {
		JOptionPane message = new JOptionPane();
		if (etat == TOUCHE) {
			JOptionPane.showMessageDialog(message, "Touché en : "+c, " Pas cool ", JOptionPane.WARNING_MESSAGE);
		}
		if (etat == COULE) {
			JOptionPane.showMessageDialog(message, "Navire coulé !"," J'aurais les boules à ta place ", JOptionPane.WARNING_MESSAGE);
		}
		if (etat == GAMEOVER) {
			JOptionPane.showMessageDialog(message, "Tu as perdu !"," Goodbye my lover, goodbye my friend ", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	protected void retourAttaque(Coordonnee c, int etat) {
		Color couleur = etat == A_L_EAU ? Color.BLUE : Color.RED;
		grilleTirs.colorie(c, couleur);
		switch (etat) {
			case TOUCHE:
				JOptionPane.showMessageDialog(grilleTirs, "Vous avez touché un navire en " + c);
				break;
			case COULE:
				JOptionPane.showMessageDialog(grilleTirs, "Vous avez coulé un navire en " + c);
				break;
			case GAMEOVER:
				JOptionPane.showMessageDialog(grilleTirs, "Vous avez gagné!!!");
		}
	}
	

}
