package batailleNavale;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.ButtonGroup;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BatailleNavaleBis {

	private JFrame frmBatailleNavale;
	private JTextField tailleGrille;
	private JTextField nomJoueur1;
	private JTextField nomJoueur2;
	private final ButtonGroup buttonGroup1 = new ButtonGroup();
	private final ButtonGroup buttonGroup2 = new ButtonGroup();
	Joueur J1;
	Joueur J2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BatailleNavaleBis window = new BatailleNavaleBis();
					window.frmBatailleNavale.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private void demarrerPartie() {
		new Thread() {
			public void run() {
				J1.jouerAvec(J2);
			}
		}.start();
	}

	/**
	 * Create the application.
	 */
	public BatailleNavaleBis() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBatailleNavale = new JFrame();
		frmBatailleNavale.setTitle("Bataille Navale");
		frmBatailleNavale.setBounds(100, 100, 335, 360);
		frmBatailleNavale.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frmBatailleNavale.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel haut = new JPanel();
		panel.add(haut, BorderLayout.NORTH);
		
		JLabel lblTailleGrille = new JLabel("Taille de grille");
		haut.add(lblTailleGrille);
		
		tailleGrille = new JTextField();
		haut.add(tailleGrille);
		tailleGrille.setColumns(10);
		
		JPanel milieu = new JPanel();
		panel.add(milieu, BorderLayout.CENTER);
		milieu.setLayout(new BorderLayout(0, 0));
		
		JPanel joueur_1 = new JPanel();
		joueur_1.setBorder(new TitledBorder(null, "Joueur 1", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		milieu.add(joueur_1, BorderLayout.NORTH);
		joueur_1.setLayout(new BorderLayout(0, 0));
		
		JPanel nom1 = new JPanel();
		joueur_1.add(nom1, BorderLayout.NORTH);
		
		JLabel lblNom = new JLabel("Nom : ");
		nom1.add(lblNom);
		
		nomJoueur1 = new JTextField();
		nom1.add(nomJoueur1);
		nomJoueur1.setColumns(10);
		
		JPanel choix1 = new JPanel();
		joueur_1.add(choix1, BorderLayout.SOUTH);
		choix1.setLayout(new BorderLayout(0, 0));
		
		JRadioButton rdbtnJoueurGraphique1 = new JRadioButton("Joueur Graphique");
		buttonGroup1.add(rdbtnJoueurGraphique1);
		rdbtnJoueurGraphique1.setVerticalAlignment(SwingConstants.BOTTOM);
		choix1.add(rdbtnJoueurGraphique1, BorderLayout.NORTH);
		
		JRadioButton rdbtnJoueurTexte1 = new JRadioButton("Joueur Texte");
		buttonGroup1.add(rdbtnJoueurTexte1);
		choix1.add(rdbtnJoueurTexte1, BorderLayout.CENTER);
		
		JRadioButton rdbtnJoueurAuto1 = new JRadioButton("Joueur Auto");
		buttonGroup1.add(rdbtnJoueurAuto1);
		choix1.add(rdbtnJoueurAuto1, BorderLayout.SOUTH);
		
		JPanel joueur_2 = new JPanel();
		joueur_2.setBorder(new TitledBorder(null, "Joueur 2", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		milieu.add(joueur_2, BorderLayout.SOUTH);
		joueur_2.setLayout(new BorderLayout(0, 0));
		
		JPanel nom2 = new JPanel();
		joueur_2.add(nom2, BorderLayout.NORTH);
		
		JLabel lblNom_1 = new JLabel("Nom : ");
		nom2.add(lblNom_1);
		
		nomJoueur2 = new JTextField();
		nom2.add(nomJoueur2);
		nomJoueur2.setColumns(10);
		
		JPanel choix2 = new JPanel();
		joueur_2.add(choix2, BorderLayout.SOUTH);
		choix2.setLayout(new BorderLayout(0, 0));
		
		JRadioButton rdbtnJoueurGraphique2 = new JRadioButton("Joueur Graphique");
		buttonGroup2.add(rdbtnJoueurGraphique2);
		choix2.add(rdbtnJoueurGraphique2, BorderLayout.NORTH);
		
		JRadioButton rdbtnJoueurTexte2 = new JRadioButton("Joueur Texte");
		buttonGroup2.add(rdbtnJoueurTexte2);
		choix2.add(rdbtnJoueurTexte2, BorderLayout.CENTER);
		
		JRadioButton rdbtnJoueurAuto2 = new JRadioButton("Joueur Auto");
		buttonGroup2.add(rdbtnJoueurAuto2);
		choix2.add(rdbtnJoueurAuto2, BorderLayout.SOUTH);
		
		JPanel bas = new JPanel();
		panel.add(bas, BorderLayout.SOUTH);
		
		JButton btnCommencerLaPartie = new JButton("Commencer la partie");
		btnCommencerLaPartie.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int taille = Integer.parseInt(tailleGrille.getText());
				int navires[] = {2,3,4,5};
				String nomJ1 = nomJoueur1.getText();
				String nomJ2 = nomJoueur2.getText();
				FenetreJoueur fenetre1 = new FenetreJoueur(nomJ1,taille);
				FenetreJoueur fenetre2 = new FenetreJoueur(nomJ2,taille);
				
				if(rdbtnJoueurGraphique1.isSelected()) {
					J1 = new JoueurGraphique(fenetre1.getGrilleDefense(), fenetre1.getGrilleTirs(), nomJ1);
					fenetre1.setVisible(true);
				}else if(rdbtnJoueurTexte1.isSelected()){
					J1 = new JoueurTexte(new GrilleNavale(taille,navires),nomJ1);
					fenetre1.setVisible(true);
				}else if(rdbtnJoueurAuto1.isSelected()){
					J1 = new JoueurIdiot(new GrilleNavale(taille,navires),nomJ1);
					fenetre1.setVisible(true);
				}	
				
				if(rdbtnJoueurGraphique2.isSelected()){
					J2 = new JoueurGraphique(fenetre2.getGrilleDefense(), fenetre2.getGrilleTirs(), nomJ2);
					fenetre2.setVisible(true);
				}else if(rdbtnJoueurTexte2.isSelected()){
					J2 = new JoueurTexte(new GrilleNavale(taille,navires),nomJ2);
					fenetre2.setVisible(true);
				}else if(rdbtnJoueurAuto2.isSelected()){
					J2 = new JoueurIdiot(new GrilleNavale(taille,navires),nomJ2);
					fenetre2.setVisible(true);
				}
				demarrerPartie();
			}
			
		});
		bas.add(btnCommencerLaPartie);
	}

}
