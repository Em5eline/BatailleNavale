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

public class BatailleNavaleBis {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BatailleNavaleBis window = new BatailleNavaleBis();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
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
		frame = new JFrame();
		frame.setBounds(100, 100, 335, 360);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel haut = new JPanel();
		panel.add(haut, BorderLayout.NORTH);
		
		JLabel lblTailleGrille = new JLabel("Taille de grille");
		haut.add(lblTailleGrille);
		
		textField = new JTextField();
		haut.add(textField);
		textField.setColumns(10);
		
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
		
		textField_1 = new JTextField();
		nom1.add(textField_1);
		textField_1.setColumns(10);
		
		JPanel choix1 = new JPanel();
		joueur_1.add(choix1, BorderLayout.SOUTH);
		choix1.setLayout(new BorderLayout(0, 0));
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("New radio button");
		rdbtnNewRadioButton.setVerticalAlignment(SwingConstants.BOTTOM);
		choix1.add(rdbtnNewRadioButton, BorderLayout.NORTH);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("New radio button");
		choix1.add(rdbtnNewRadioButton_1, BorderLayout.CENTER);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("New radio button");
		choix1.add(rdbtnNewRadioButton_2, BorderLayout.SOUTH);
		
		JPanel joueur_2 = new JPanel();
		joueur_2.setBorder(new TitledBorder(null, "Joueur 2", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		milieu.add(joueur_2, BorderLayout.SOUTH);
		joueur_2.setLayout(new BorderLayout(0, 0));
		
		JPanel nom2 = new JPanel();
		joueur_2.add(nom2, BorderLayout.NORTH);
		
		JLabel lblNom_1 = new JLabel("Nom : ");
		nom2.add(lblNom_1);
		
		textField_2 = new JTextField();
		nom2.add(textField_2);
		textField_2.setColumns(10);
		
		JPanel choix2 = new JPanel();
		joueur_2.add(choix2, BorderLayout.SOUTH);
		choix2.setLayout(new BorderLayout(0, 0));
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("New radio button");
		choix2.add(rdbtnNewRadioButton_3, BorderLayout.NORTH);
		
		JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("New radio button");
		choix2.add(rdbtnNewRadioButton_4, BorderLayout.CENTER);
		
		JRadioButton rdbtnNewRadioButton_5 = new JRadioButton("New radio button");
		choix2.add(rdbtnNewRadioButton_5, BorderLayout.SOUTH);
		
		JPanel bas = new JPanel();
		panel.add(bas, BorderLayout.SOUTH);
		
		JButton btnCommencerLaPartie = new JButton("Commencer la partie");
		bas.add(btnCommencerLaPartie);
	}

}
