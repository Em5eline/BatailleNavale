package batailleNavale;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JSeparator;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JSplitPane;
import javax.swing.JRadioButton;
import java.awt.Insets;
import javax.swing.JButton;

public class InterfaceGraphiqueBatailleNavale {

	private JFrame frame;
	private JTextField tailleGrille;
	private JTextField txtJoueur;
	private JTextField txtJoueur_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceGraphiqueBatailleNavale window = new InterfaceGraphiqueBatailleNavale();
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
	public InterfaceGraphiqueBatailleNavale() {
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
		panelTaille.setLeftComponent(lblNewLabel);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		
		tailleGrille = new JTextField();
		panelTaille.setRightComponent(tailleGrille);
		tailleGrille.setColumns(10);
		
		JPanel panelJ2 = new JPanel();
		
		JButton btnNewButton = new JButton("Lancer la partie");
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panelJ2, GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panelTaille)
							.addGap(52))
						.addComponent(panelJ1, GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE))
					.addGap(5))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(62)
					.addComponent(btnNewButton)
					.addContainerGap(70, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panelTaille, GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
					.addGap(18)
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
		
		txtJoueur_1 = new JTextField();
		txtJoueur_1.setText("Joueur 2");
		splitPane_1.setRightComponent(txtJoueur_1);
		txtJoueur_1.setColumns(10);
		
		JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("New radio button");
		panelJ2.add(rdbtnNewRadioButton_4);
		
		JRadioButton rdbtnNewRadioButton_5 = new JRadioButton("New radio button");
		panelJ2.add(rdbtnNewRadioButton_5);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("New radio button");
		panelJ2.add(rdbtnNewRadioButton_3);
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
		
		txtJoueur = new JTextField();
		splitPane.setRightComponent(txtJoueur);
		txtJoueur.setText("Joueur 1");
		txtJoueur.setColumns(10);
		
		JLabel lblNom = new JLabel("Nom :");
		splitPane.setLeftComponent(lblNom);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("New radio button");
		GridBagConstraints gbc_rdbtnNewRadioButton = new GridBagConstraints();
		gbc_rdbtnNewRadioButton.fill = GridBagConstraints.BOTH;
		gbc_rdbtnNewRadioButton.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnNewRadioButton.gridx = 0;
		gbc_rdbtnNewRadioButton.gridy = 2;
		panelJ1.add(rdbtnNewRadioButton, gbc_rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("New radio button");
		GridBagConstraints gbc_rdbtnNewRadioButton_2 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_2.fill = GridBagConstraints.BOTH;
		gbc_rdbtnNewRadioButton_2.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnNewRadioButton_2.gridx = 0;
		gbc_rdbtnNewRadioButton_2.gridy = 3;
		panelJ1.add(rdbtnNewRadioButton_2, gbc_rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("New radio button");
		GridBagConstraints gbc_rdbtnNewRadioButton_1 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_1.fill = GridBagConstraints.BOTH;
		gbc_rdbtnNewRadioButton_1.gridx = 0;
		gbc_rdbtnNewRadioButton_1.gridy = 4;
		panelJ1.add(rdbtnNewRadioButton_1, gbc_rdbtnNewRadioButton_1);
		frame.getContentPane().setLayout(groupLayout);
	}
}
