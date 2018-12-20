package batailleNavale;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;

public class FenetreJoueur extends JFrame {

	private JPanel contentPane;
	private GrilleGraphique grilleTirs;
	private GrilleNavaleGraphique grilleDefense;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetreJoueur frame = new FenetreJoueur();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FenetreJoueur() {
		this("Nom du joueur", 10);
		/*setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		*/
	}

	
	
	/**
	 * permet d'obtenir une fenêtre pour un joueur de nom nom avec des grilles de taille taille.
	   Un placement de navires automatique sur grilleDefense peut être réalisé.
	 * @param nom : nom de la fenêtre
	 * @param taille : taille des grilles
	 */
	
	public FenetreJoueur(String nom, int taille) {
		this.setTitle(nom);
		getContentPane().setLayout(new GridLayout(1, 0, 0, 0));		
		grilleTirs = new GrilleGraphique(taille);
		grilleDefense = new GrilleNavaleGraphique(taille);
		getContentPane().add(grilleTirs);
		getContentPane().add(grilleDefense.getGrilleGraphique());
		//int[]lesBateaux = {2,4,3,3};
		//grilleDefense.placementAuto(lesBateaux);

	}
	
	public GrilleGraphique getGrilleTirs() {
		return grilleTirs;
		
	}
	
	public GrilleNavaleGraphique getGrilleDefense() {
		return grilleDefense;
		
	}
	
}
