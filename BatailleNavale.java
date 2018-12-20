package batailleNavale;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;

public class BatailleNavale {

	private JFrame frame;
	private JTextField tailleGrille;
	private JTextField nomJ1;
	private JTextField nomJ2;
	
	private Joueur joueur1 ;
	private Joueur joueur2 ;

	private final ButtonGroup buttonGroup1 = new ButtonGroup();
	private final ButtonGroup buttonGroup2 = new ButtonGroup();
	private JRadioButton rdbtnJoueurGraphique1;
	private JRadioButton rdbtnJoueurTexte1;
	private JRadioButton rdbtnJoueurAuto1;
	private JRadioButton rdbtnJoueurGraphique2;
	private JRadioButton rdbtnJoueurTexte2;
	private JRadioButton rdbtnJoueurAuto2;

	/**
	 * Create the application.
	 */
	public BatailleNavale() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 237, 397);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelJ1 = new JPanel();
		
		JSplitPane panelTaille = new JSplitPane();
		
		JLabel lblNewLabel = new JLabel("Taille de grille :");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		panelTaille.setLeftComponent(lblNewLabel);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		
		tailleGrille = new JTextField();
		tailleGrille.setHorizontalAlignment(SwingConstants.RIGHT);
		panelTaille.setRightComponent(tailleGrille);
		tailleGrille.setColumns(10);
		
		JPanel panelJ2 = new JPanel();
		
		JButton btnNewButton = new JButton("Lancer la partie");
		
		
		// CODE A COMPLETER : QUAND ON CLIQUE SUR LE BOUTON LANCER LA PARTIE IL SE PASSE CA CEST A DIRE PAS GRAND CHOSE 
		//j'arrive pas à rentrer dans ce putain de if de merde là
		
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			
			public void mouseClicked(MouseEvent arg0) {
				int taille = Integer.parseInt(tailleGrille.getText());
				String nomJoueur1 = new String(nomJ1.getText());
				String nomJoueur2 = new String(nomJ2.getText());
				
			
					if (rdbtnJoueurGraphique1.isSelected()) {
						System.out.println("je suis là");
						FenetreJoueur fenetre1 =new FenetreJoueur(nomJoueur1,taille);
						joueur1 = new JoueurGraphique(fenetre1.getGrilleDefense(), fenetre1.getGrilleTirs(),nomJoueur1);
						fenetre1.setVisible(true);
					}
				
			}
		});
		
		
		// FIN DU CODE A COMPLETER
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panelJ2, GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
						.addComponent(panelJ1, GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(62)
							.addComponent(btnNewButton))
						.addComponent(panelTaille, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(24)
					.addComponent(panelTaille, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
					.addComponent(panelJ1, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
					.addGap(30)
					.addComponent(panelJ2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnNewButton)
					.addGap(9))
		);
		panelJ2.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("Joueur 2");
		panelJ2.add(lblNewLabel_1);
		
		JSplitPane splitPane_1 = new JSplitPane();
		panelJ2.add(splitPane_1);
		
		JLabel lblNom_1 = new JLabel("Nom :");
		splitPane_1.setLeftComponent(lblNom_1);
		
		nomJ2 = new JTextField();
		nomJ2.setText("Joueur 2");
		splitPane_1.setRightComponent(nomJ2);
		nomJ2.setColumns(10);
		
		JRadioButton rdbtnJoueurGraphique2 = new JRadioButton("Joueur graphique");
		buttonGroup2.add(rdbtnJoueurGraphique2);
		panelJ2.add(rdbtnJoueurGraphique2);
		
		JRadioButton rdbtnJoueurTexte2 = new JRadioButton("Joueur texte");
		buttonGroup2.add(rdbtnJoueurTexte2);
		panelJ2.add(rdbtnJoueurTexte2);
		
		JRadioButton rdbtnJoueurAuto2 = new JRadioButton("Joueur auto");
		buttonGroup2.add(rdbtnJoueurAuto2);
		panelJ2.add(rdbtnJoueurAuto2);
		GridBagLayout gbl_panelJ1 = new GridBagLayout();
		gbl_panelJ1.columnWidths = new int[]{216, 0};
		gbl_panelJ1.rowHeights = new int[]{25, 25, 25, 25, 25, 0};
		gbl_panelJ1.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panelJ1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelJ1.setLayout(gbl_panelJ1);
		
		JLabel lblJoueur_1 = DefaultComponentFactory.getInstance().createTitle("Joueur 1");
		GridBagConstraints gbc_lblJoueur_1 = new GridBagConstraints();
		gbc_lblJoueur_1.fill = GridBagConstraints.BOTH;
		gbc_lblJoueur_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblJoueur_1.gridx = 0;
		gbc_lblJoueur_1.gridy = 0;
		panelJ1.add(lblJoueur_1, gbc_lblJoueur_1);
		
		JSplitPane splitPane = new JSplitPane();
		GridBagConstraints gbc_splitPane = new GridBagConstraints();
		gbc_splitPane.fill = GridBagConstraints.BOTH;
		gbc_splitPane.insets = new Insets(0, 0, 5, 0);
		gbc_splitPane.gridx = 0;
		gbc_splitPane.gridy = 1;
		panelJ1.add(splitPane, gbc_splitPane);
		
		nomJ1 = new JTextField();
		splitPane.setRightComponent(nomJ1);
		nomJ1.setText("Joueur 1");
		nomJ1.setColumns(10);
		
		JLabel lblNom = new JLabel("Nom :");
		splitPane.setLeftComponent(lblNom);
		
		JRadioButton rdbtnJoueurGraphique1 = new JRadioButton("Joueur graphique");
		buttonGroup1.add(rdbtnJoueurGraphique1);
		GridBagConstraints gbc_rdbtnNewRadioButton = new GridBagConstraints();
		gbc_rdbtnNewRadioButton.fill = GridBagConstraints.BOTH;
		gbc_rdbtnNewRadioButton.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnNewRadioButton.gridx = 0;
		gbc_rdbtnNewRadioButton.gridy = 2;
		panelJ1.add(rdbtnJoueurGraphique1, gbc_rdbtnNewRadioButton);
		
		JRadioButton rdbtnJoueurTexte1 = new JRadioButton("Joueur texte");
		buttonGroup1.add(rdbtnJoueurTexte1);
		GridBagConstraints gbc_rdbtnNewRadioButton_2 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_2.fill = GridBagConstraints.BOTH;
		gbc_rdbtnNewRadioButton_2.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnNewRadioButton_2.gridx = 0;
		gbc_rdbtnNewRadioButton_2.gridy = 3;
		panelJ1.add(rdbtnJoueurTexte1, gbc_rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnJoueurAuto1 = new JRadioButton("Joueur auto");
		buttonGroup1.add(rdbtnJoueurAuto1);
		GridBagConstraints gbc_rdbtnNewRadioButton_1 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_1.fill = GridBagConstraints.BOTH;
		gbc_rdbtnNewRadioButton_1.gridx = 0;
		gbc_rdbtnNewRadioButton_1.gridy = 4;
		panelJ1.add(rdbtnJoueurAuto1, gbc_rdbtnNewRadioButton_1);
		frame.getContentPane().setLayout(groupLayout);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BatailleNavale window = new BatailleNavale();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
