package clienteServidor;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.border.LineBorder;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.Component;

public class ModoServidorPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private GUIRetrasos enVentana;
	private JTextField AreaTextR1;
	private JTextField AreaTextR2;
	private JTextField AreaTextFr;
	private JTextField textField_2;
	private JTextField AreaTextR3;
	private JTextField AreaTextVs1;
	private JTextField AreaTextCv;
	//Editar con el plugin WindowsBuilder de Eclipse.
	public ModoServidorPanel(GUIRetrasos ventana) {
		super();
		enVentana = ventana;
		this.setSize(1008,515);
		setLayout(null);
		
		JPanel panelEstacion1 = new JPanel();
		panelEstacion1.setBackground(new Color(176, 224, 230));
		panelEstacion1.setBorder(new LineBorder(new Color(255, 255, 255), 3));
		
		panelEstacion1.setBounds(64, 16, 407, 119);
		add(panelEstacion1);
		GridBagLayout gbl_panelEstacion1 = new GridBagLayout();
		gbl_panelEstacion1.columnWidths = new int[]{93, 194, 46, 17, 0};
		gbl_panelEstacion1.rowHeights = new int[]{41, 31, 0, 0};
		gbl_panelEstacion1.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelEstacion1.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelEstacion1.setLayout(gbl_panelEstacion1);
		
		JLabel lblEstacion1 = new JLabel("Estaci\u00F3n 1");
		lblEstacion1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GridBagConstraints gbc_lblEstacion1 = new GridBagConstraints();
		gbc_lblEstacion1.insets = new Insets(0, 0, 5, 5);
		gbc_lblEstacion1.gridx = 1;
		gbc_lblEstacion1.gridy = 0;
		panelEstacion1.add(lblEstacion1, gbc_lblEstacion1);
		
		JLabel lblRobot1 = new JLabel("Robot 1:");
		lblRobot1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GridBagConstraints gbc_lblRobot1 = new GridBagConstraints();
		gbc_lblRobot1.fill = GridBagConstraints.VERTICAL;
		gbc_lblRobot1.insets = new Insets(0, 0, 5, 5);
		gbc_lblRobot1.anchor = GridBagConstraints.EAST;
		gbc_lblRobot1.gridx = 0;
		gbc_lblRobot1.gridy = 1;
		panelEstacion1.add(lblRobot1, gbc_lblRobot1);
		
		JComboBox<Object> jComboBoxR1 = new JComboBox<Object>();
		jComboBoxR1.setFont(new Font("Dialog", Font.PLAIN, 16));
		jComboBoxR1.setMaximumRowCount(20);
		jComboBoxR1.setModel(new DefaultComboBoxModel<Object>(new String[] {"Seleccione...", "1. Distribuci\u00F3n t de Students", "2. Distribuci\u00F3n Exponencial", "3. Distribuci\u00F3n Laplace", "4. Distribuci\u00F3n Normal Estandar", "5. Distribuci\u00F3n Poisson", "6. Distribuci\u00F3n Uniforme", "7. Distribuci\u00F3n Weibull", "8. Congruencia Lineal"}));
		
		GridBagConstraints gbc_jComboBoxR1 = new GridBagConstraints();
		gbc_jComboBoxR1.insets = new Insets(0, 0, 5, 5);
		gbc_jComboBoxR1.fill = GridBagConstraints.BOTH;
		gbc_jComboBoxR1.gridx = 1;
		gbc_jComboBoxR1.gridy = 1;
		panelEstacion1.add(jComboBoxR1, gbc_jComboBoxR1);
		
		JButton jButton4 = new JButton(">>");
		jButton4.setContentAreaFilled(false);
		GridBagConstraints gbc_jButton4 = new GridBagConstraints();
		gbc_jButton4.gridwidth = 2;
		gbc_jButton4.insets = new Insets(0, 0, 5, 0);
		gbc_jButton4.fill = GridBagConstraints.VERTICAL;
		gbc_jButton4.gridx = 2;
		gbc_jButton4.gridy = 1;
		panelEstacion1.add(jButton4, gbc_jButton4);
		
		AreaTextR1 = new JTextField();
		AreaTextR1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_AreaTextR1 = new GridBagConstraints();
		gbc_AreaTextR1.insets = new Insets(0, 0, 0, 5);
		gbc_AreaTextR1.fill = GridBagConstraints.BOTH;
		gbc_AreaTextR1.gridx = 1;
		gbc_AreaTextR1.gridy = 2;
		panelEstacion1.add(AreaTextR1, gbc_AreaTextR1);
		AreaTextR1.setColumns(10);
		
		JPanel panelEstacion2 = new JPanel();
		panelEstacion2.setBorder(new LineBorder(new Color(255, 255, 255), 3));
		panelEstacion2.setBackground(new Color(176, 196, 222));
		panelEstacion2.setBounds(64, 151, 407, 249);
		add(panelEstacion2);
		GridBagLayout gbl_panelEstacion2 = new GridBagLayout();
		gbl_panelEstacion2.columnWidths = new int[]{95, 194, 46, 17, 0};
		gbl_panelEstacion2.rowHeights = new int[]{41, 0, 31, 0, 27, 0, 0, 0};
		gbl_panelEstacion2.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelEstacion2.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelEstacion2.setLayout(gbl_panelEstacion2);
		
		JLabel lblEstacion2 = new JLabel("Estaci\u00F3n 2");
		lblEstacion2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GridBagConstraints gbc_lblEstacion2 = new GridBagConstraints();
		gbc_lblEstacion2.insets = new Insets(0, 0, 5, 5);
		gbc_lblEstacion2.gridx = 1;
		gbc_lblEstacion2.gridy = 0;
		panelEstacion2.add(lblEstacion2, gbc_lblEstacion2);
		
		JLabel lblRobot2 = new JLabel("Robot 2:");
		lblRobot2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GridBagConstraints gbc_lblRobot2 = new GridBagConstraints();
		gbc_lblRobot2.fill = GridBagConstraints.VERTICAL;
		gbc_lblRobot2.anchor = GridBagConstraints.EAST;
		gbc_lblRobot2.insets = new Insets(0, 0, 5, 5);
		gbc_lblRobot2.gridx = 0;
		gbc_lblRobot2.gridy = 1;
		panelEstacion2.add(lblRobot2, gbc_lblRobot2);
		
		JComboBox<Object> ComboBoxR2 = new JComboBox<Object>();
		ComboBoxR2.setFont(new Font("Dialog", Font.PLAIN, 16));
		ComboBoxR2.setModel(new DefaultComboBoxModel<Object>(new String[] {"Seleccione...", "1. Distribuci\u00F3n t de Students", "2. Distribuci\u00F3n Exponencial", "3. Distribuci\u00F3n Laplace", "4. Distribuci\u00F3n Normal Estandar", "5. Distribuci\u00F3n Poisson", "6. Distribuci\u00F3n Uniforme", "7. Distribuci\u00F3n Weibull", "8. Congruencia Lineal"}));
		ComboBoxR2.setMaximumRowCount(20);
		GridBagConstraints gbc_ComboBoxR2 = new GridBagConstraints();
		gbc_ComboBoxR2.insets = new Insets(0, 0, 5, 5);
		gbc_ComboBoxR2.fill = GridBagConstraints.BOTH;
		gbc_ComboBoxR2.gridx = 1;
		gbc_ComboBoxR2.gridy = 1;
		panelEstacion2.add(ComboBoxR2, gbc_ComboBoxR2);
		
		JButton jButton6 = new JButton(">>");
		jButton6.setContentAreaFilled(false);
		GridBagConstraints gbc_jButton6 = new GridBagConstraints();
		gbc_jButton6.fill = GridBagConstraints.VERTICAL;
		gbc_jButton6.gridwidth = 2;
		gbc_jButton6.insets = new Insets(0, 0, 5, 0);
		gbc_jButton6.gridx = 2;
		gbc_jButton6.gridy = 1;
		panelEstacion2.add(jButton6, gbc_jButton6);
		
		AreaTextR2 = new JTextField();
		AreaTextR2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		AreaTextR2.setColumns(10);
		GridBagConstraints gbc_AreaTextR2 = new GridBagConstraints();
		gbc_AreaTextR2.insets = new Insets(0, 0, 5, 5);
		gbc_AreaTextR2.fill = GridBagConstraints.HORIZONTAL;
		gbc_AreaTextR2.gridx = 1;
		gbc_AreaTextR2.gridy = 2;
		panelEstacion2.add(AreaTextR2, gbc_AreaTextR2);
		
		JLabel lblRobot = new JLabel("Fresadora:");
		lblRobot.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GridBagConstraints gbc_lblRobot = new GridBagConstraints();
		gbc_lblRobot.fill = GridBagConstraints.VERTICAL;
		gbc_lblRobot.anchor = GridBagConstraints.EAST;
		gbc_lblRobot.insets = new Insets(0, 0, 5, 5);
		gbc_lblRobot.gridx = 0;
		gbc_lblRobot.gridy = 3;
		panelEstacion2.add(lblRobot, gbc_lblRobot);
		
		JComboBox<Object> jComboBoxFr = new JComboBox<Object>();
		jComboBoxFr.setFont(new Font("Dialog", Font.PLAIN, 16));
		jComboBoxFr.setMaximumRowCount(20);
		jComboBoxFr.setModel(new DefaultComboBoxModel<Object>(new String[] {"Seleccione...", "1. Distribuci\u00F3n t de Students", "2. Distribuci\u00F3n Exponencial", "3. Distribuci\u00F3n Laplace", "4. Distribuci\u00F3n Normal Estandar", "5. Distribuci\u00F3n Poisson", "6. Distribuci\u00F3n Uniforme", "7. Distribuci\u00F3n Weibull", "8. Congruencia Lineal"}));
		GridBagConstraints gbc_jComboBoxFr = new GridBagConstraints();
		gbc_jComboBoxFr.insets = new Insets(0, 0, 5, 5);
		gbc_jComboBoxFr.fill = GridBagConstraints.BOTH;
		gbc_jComboBoxFr.gridx = 1;
		gbc_jComboBoxFr.gridy = 3;
		panelEstacion2.add(jComboBoxFr, gbc_jComboBoxFr);
		
		JButton jButton7 = new JButton(">>");
		jButton7.setContentAreaFilled(false);
		GridBagConstraints gbc_jButton7 = new GridBagConstraints();
		gbc_jButton7.fill = GridBagConstraints.VERTICAL;
		gbc_jButton7.gridwidth = 2;
		gbc_jButton7.insets = new Insets(0, 0, 5, 0);
		gbc_jButton7.gridx = 2;
		gbc_jButton7.gridy = 3;
		panelEstacion2.add(jButton7, gbc_jButton7);
		
		AreaTextFr = new JTextField();
		AreaTextFr.setFont(new Font("Tahoma", Font.PLAIN, 15));
		AreaTextFr.setColumns(10);
		GridBagConstraints gbc_AreaTextFr = new GridBagConstraints();
		gbc_AreaTextFr.insets = new Insets(0, 0, 5, 5);
		gbc_AreaTextFr.fill = GridBagConstraints.HORIZONTAL;
		gbc_AreaTextFr.gridx = 1;
		gbc_AreaTextFr.gridy = 4;
		panelEstacion2.add(AreaTextFr, gbc_AreaTextFr);
		
		JLabel lblTorno = new JLabel("Torno:");
		lblTorno.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GridBagConstraints gbc_lblTorno = new GridBagConstraints();
		gbc_lblTorno.fill = GridBagConstraints.VERTICAL;
		gbc_lblTorno.anchor = GridBagConstraints.EAST;
		gbc_lblTorno.insets = new Insets(0, 0, 5, 5);
		gbc_lblTorno.gridx = 0;
		gbc_lblTorno.gridy = 5;
		panelEstacion2.add(lblTorno, gbc_lblTorno);
		
		JComboBox<Object> jComboBoxTr = new JComboBox<Object>();
		jComboBoxTr.setFont(new Font("Dialog", Font.PLAIN, 16));
		jComboBoxTr.setMaximumRowCount(20);
		jComboBoxTr.setModel(new DefaultComboBoxModel<Object>(new String[] {"Seleccione...", "1. Distribuci\u00F3n t de Students", "2. Distribuci\u00F3n Exponencial", "3. Distribuci\u00F3n Laplace", "4. Distribuci\u00F3n Normal Estandar", "5. Distribuci\u00F3n Poisson", "6. Distribuci\u00F3n Uniforme", "7. Distribuci\u00F3n Weibull", "8. Congruencia Lineal"}));
		GridBagConstraints gbc_jComboBoxTr = new GridBagConstraints();
		gbc_jComboBoxTr.insets = new Insets(0, 0, 5, 5);
		gbc_jComboBoxTr.fill = GridBagConstraints.BOTH;
		gbc_jComboBoxTr.gridx = 1;
		gbc_jComboBoxTr.gridy = 5;
		panelEstacion2.add(jComboBoxTr, gbc_jComboBoxTr);
		
		JButton jButton8 = new JButton(">>");
		jButton8.setContentAreaFilled(false);
		jButton8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_jButton8 = new GridBagConstraints();
		gbc_jButton8.fill = GridBagConstraints.VERTICAL;
		gbc_jButton8.gridwidth = 2;
		gbc_jButton8.insets = new Insets(0, 0, 5, 5);
		gbc_jButton8.gridx = 2;
		gbc_jButton8.gridy = 5;
		panelEstacion2.add(jButton8, gbc_jButton8);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_2.setColumns(10);
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 0, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 6;
		panelEstacion2.add(textField_2, gbc_textField_2);
		
		JPanel panelEstacion3 = new JPanel();
		panelEstacion3.setBorder(new LineBorder(new Color(255, 255, 255), 3));
		panelEstacion3.setBackground(new Color(173, 216, 230));
		panelEstacion3.setBounds(535, 113, 407, 184);
		add(panelEstacion3);
		GridBagLayout gbl_panelEstacion3 = new GridBagLayout();
		gbl_panelEstacion3.columnWidths = new int[]{83, 194, 46, 17, 0};
		gbl_panelEstacion3.rowHeights = new int[]{0, 26, 0, 31, 0, 27, 0, 0};
		gbl_panelEstacion3.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelEstacion3.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelEstacion3.setLayout(gbl_panelEstacion3);
		
		JLabel lblEstacion3 = new JLabel("Estaci\u00F3n 3");
		lblEstacion3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GridBagConstraints gbc_lblEstacion3 = new GridBagConstraints();
		gbc_lblEstacion3.insets = new Insets(0, 0, 5, 5);
		gbc_lblEstacion3.gridx = 1;
		gbc_lblEstacion3.gridy = 1;
		panelEstacion3.add(lblEstacion3, gbc_lblEstacion3);
		
		JLabel lblRobot3 = new JLabel("Robot 3:");
		lblRobot3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GridBagConstraints gbc_lblRobot3 = new GridBagConstraints();
		gbc_lblRobot3.fill = GridBagConstraints.VERTICAL;
		gbc_lblRobot3.anchor = GridBagConstraints.EAST;
		gbc_lblRobot3.insets = new Insets(0, 0, 5, 5);
		gbc_lblRobot3.gridx = 0;
		gbc_lblRobot3.gridy = 2;
		panelEstacion3.add(lblRobot3, gbc_lblRobot3);
		
		JComboBox<Object> ComboBoxR3 = new JComboBox<Object>();
		ComboBoxR3.setFont(new Font("Dialog", Font.PLAIN, 16));
		ComboBoxR3.setMaximumRowCount(20);
		ComboBoxR3.setModel(new DefaultComboBoxModel<Object>(new String[] {"Seleccione...", "1. Distribuci\u00F3n t de Students", "2. Distribuci\u00F3n Exponencial", "3. Distribuci\u00F3n Laplace", "4. Distribuci\u00F3n Normal Estandar", "5. Distribuci\u00F3n Poisson", "6. Distribuci\u00F3n Uniforme", "7. Distribuci\u00F3n Weibull", "8. Congruencia Lineal"}));
		GridBagConstraints gbc_ComboBoxR3 = new GridBagConstraints();
		gbc_ComboBoxR3.fill = GridBagConstraints.BOTH;
		gbc_ComboBoxR3.insets = new Insets(0, 0, 5, 5);
		gbc_ComboBoxR3.gridx = 1;
		gbc_ComboBoxR3.gridy = 2;
		panelEstacion3.add(ComboBoxR3, gbc_ComboBoxR3);
		
		JButton jButton5 = new JButton(">>");
		jButton5.setContentAreaFilled(false);
		GridBagConstraints gbc_jButton5 = new GridBagConstraints();
		gbc_jButton5.gridwidth = 2;
		gbc_jButton5.insets = new Insets(0, 0, 5, 0);
		gbc_jButton5.gridx = 2;
		gbc_jButton5.gridy = 2;
		panelEstacion3.add(jButton5, gbc_jButton5);
		
		AreaTextR3 = new JTextField();
		AreaTextR3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		AreaTextR3.setColumns(10);
		GridBagConstraints gbc_AreaTextR3 = new GridBagConstraints();
		gbc_AreaTextR3.fill = GridBagConstraints.HORIZONTAL;
		gbc_AreaTextR3.insets = new Insets(0, 0, 5, 5);
		gbc_AreaTextR3.gridx = 1;
		gbc_AreaTextR3.gridy = 3;
		panelEstacion3.add(AreaTextR3, gbc_AreaTextR3);
		
		JLabel lblVisin = new JLabel("Visi\u00F3n 1:");
		lblVisin.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GridBagConstraints gbc_lblVisin = new GridBagConstraints();
		gbc_lblVisin.fill = GridBagConstraints.VERTICAL;
		gbc_lblVisin.anchor = GridBagConstraints.EAST;
		gbc_lblVisin.insets = new Insets(0, 0, 5, 5);
		gbc_lblVisin.gridx = 0;
		gbc_lblVisin.gridy = 4;
		panelEstacion3.add(lblVisin, gbc_lblVisin);
		
		JComboBox<Object> jComboBoxV1 = new JComboBox<Object>();
		jComboBoxV1.setFont(new Font("Dialog", Font.PLAIN, 16));
		jComboBoxV1.setMaximumRowCount(20);
		jComboBoxV1.setModel(new DefaultComboBoxModel<Object>(new String[] {"Seleccione...", "1. Distribuci\u00F3n t de Students", "2. Distribuci\u00F3n Exponencial", "3. Distribuci\u00F3n Laplace", "4. Distribuci\u00F3n Normal Estandar", "5. Distribuci\u00F3n Poisson", "6. Distribuci\u00F3n Uniforme", "7. Distribuci\u00F3n Weibull", "8. Congruencia Lineal"}));
		GridBagConstraints gbc_jComboBoxV1 = new GridBagConstraints();
		gbc_jComboBoxV1.fill = GridBagConstraints.BOTH;
		gbc_jComboBoxV1.insets = new Insets(0, 0, 5, 5);
		gbc_jComboBoxV1.gridx = 1;
		gbc_jComboBoxV1.gridy = 4;
		panelEstacion3.add(jComboBoxV1, gbc_jComboBoxV1);
		
		JButton jButton1 = new JButton(">>");
		jButton1.setContentAreaFilled(false);
		GridBagConstraints gbc_jButton1 = new GridBagConstraints();
		gbc_jButton1.gridwidth = 2;
		gbc_jButton1.insets = new Insets(0, 0, 5, 0);
		gbc_jButton1.gridx = 2;
		gbc_jButton1.gridy = 4;
		panelEstacion3.add(jButton1, gbc_jButton1);
		
		AreaTextVs1 = new JTextField();
		AreaTextVs1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		AreaTextVs1.setColumns(10);
		GridBagConstraints gbc_AreaTextVs1 = new GridBagConstraints();
		gbc_AreaTextVs1.fill = GridBagConstraints.HORIZONTAL;
		gbc_AreaTextVs1.insets = new Insets(0, 0, 5, 5);
		gbc_AreaTextVs1.gridx = 1;
		gbc_AreaTextVs1.gridy = 5;
		panelEstacion3.add(AreaTextVs1, gbc_AreaTextVs1);
		
		JPanel panelEstacion4 = new JPanel();
		panelEstacion4.setBorder(new LineBorder(new Color(255, 255, 255), 3));
		panelEstacion4.setBackground(new Color(176, 196, 222));
		panelEstacion4.setBounds(535, 313, 407, 184);
		add(panelEstacion4);
		GridBagLayout gbl_panelEstacion4 = new GridBagLayout();
		gbl_panelEstacion4.columnWidths = new int[]{96, 194, 46, 17, 0};
		gbl_panelEstacion4.rowHeights = new int[]{41, 0, 31, 0, 27, 0};
		gbl_panelEstacion4.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelEstacion4.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelEstacion4.setLayout(gbl_panelEstacion4);
		
		JLabel lblEstacin = new JLabel("Estaci\u00F3n 4");
		lblEstacin.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GridBagConstraints gbc_lblEstacin = new GridBagConstraints();
		gbc_lblEstacin.insets = new Insets(0, 0, 5, 5);
		gbc_lblEstacin.gridx = 1;
		gbc_lblEstacin.gridy = 0;
		panelEstacion4.add(lblEstacin, gbc_lblEstacin);
		
		JLabel lblConveyor = new JLabel("Conveyor:");
		lblConveyor.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GridBagConstraints gbc_lblConveyor = new GridBagConstraints();
		gbc_lblConveyor.fill = GridBagConstraints.VERTICAL;
		gbc_lblConveyor.anchor = GridBagConstraints.EAST;
		gbc_lblConveyor.insets = new Insets(0, 0, 5, 5);
		gbc_lblConveyor.gridx = 0;
		gbc_lblConveyor.gridy = 2;
		panelEstacion4.add(lblConveyor, gbc_lblConveyor);
		
		
		JComboBox<Object> jComboBoxCv = new JComboBox<Object>();
		jComboBoxCv.setFont(new Font("Dialog", Font.PLAIN, 16));
		jComboBoxCv.setMaximumRowCount(20);
		jComboBoxCv.setModel(new DefaultComboBoxModel<Object>(new String[] {"Seleccione...", "1. Distribuci\u00F3n t de Students", "2. Distribuci\u00F3n Exponencial", "3. Distribuci\u00F3n Laplace", "4. Distribuci\u00F3n Normal Estandar", "5. Distribuci\u00F3n Poisson", "6. Distribuci\u00F3n Uniforme", "7. Distribuci\u00F3n Weibull", "8. Congruencia Lineal"}));
		GridBagConstraints gbc_jComboBoxCv = new GridBagConstraints();
		gbc_jComboBoxCv.fill = GridBagConstraints.BOTH;
		gbc_jComboBoxCv.insets = new Insets(0, 0, 5, 5);
		gbc_jComboBoxCv.gridx = 1;
		gbc_jComboBoxCv.gridy = 2;
		panelEstacion4.add(jComboBoxCv, gbc_jComboBoxCv);
		
		JButton jButton9 = new JButton(">>");
		jButton9.setContentAreaFilled(false);
		GridBagConstraints gbc_jButton9 = new GridBagConstraints();
		gbc_jButton9.fill = GridBagConstraints.VERTICAL;
		gbc_jButton9.gridwidth = 2;
		gbc_jButton9.insets = new Insets(0, 0, 5, 0);
		gbc_jButton9.gridx = 2;
		gbc_jButton9.gridy = 2;
		panelEstacion4.add(jButton9, gbc_jButton9);
		
		AreaTextCv = new JTextField();
		AreaTextCv.setFont(new Font("Tahoma", Font.PLAIN, 15));
		AreaTextCv.setColumns(10);
		GridBagConstraints gbc_AreaTextCv = new GridBagConstraints();
		gbc_AreaTextCv.fill = GridBagConstraints.BOTH;
		gbc_AreaTextCv.insets = new Insets(0, 0, 5, 5);
		gbc_AreaTextCv.gridx = 1;
		gbc_AreaTextCv.gridy = 3;
		panelEstacion4.add(AreaTextCv, gbc_AreaTextCv);
		
		JPanel panelBotones1 = new JPanel();
		panelBotones1.setBackground(new Color(220, 220, 220));
	
		panelBotones1.setForeground(new Color(0, 0, 0));
		panelBotones1.setBorder(new LineBorder(new Color(255, 255, 255), 3));
		
		panelBotones1.setBounds(64, 416, 407, 81);
		add(panelBotones1);
		GridBagLayout gbl_panelBotones1 = new GridBagLayout();
		gbl_panelBotones1.columnWidths = new int[]{25, 151, 180, 34, 0};
		gbl_panelBotones1.rowHeights = new int[]{41, 27, 36, 37, 27, 0};
		gbl_panelBotones1.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelBotones1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelBotones1.setLayout(gbl_panelBotones1);
		
		JButton botonVolver = new JButton("Ir a ventana inicial");
		botonVolver.setAutoscrolls(true);
		botonVolver.setContentAreaFilled(false);
		botonVolver.setOpaque(false);
		botonVolver.setBackground(new Color(143, 188, 143));
		botonVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getEnVentana().getContentPane().remove(getEnVentana().getPanelServidor());
				getEnVentana().getContentPane().add(getEnVentana().getPanelIniciar());
				getEnVentana().repaint();
				getEnVentana().getPanelIniciar().paintComponents(getEnVentana().getPanelIniciar().getGraphics());
			}
		});
		GridBagConstraints gbc_botonVolver = new GridBagConstraints();
		gbc_botonVolver.fill = GridBagConstraints.VERTICAL;
		gbc_botonVolver.insets = new Insets(0, 0, 5, 5);
		gbc_botonVolver.gridx = 1;
		gbc_botonVolver.gridy = 2;
		panelBotones1.add(botonVolver, gbc_botonVolver);
		
		JButton botonDetener = new JButton("Detener Conexiones");
		botonDetener.setOpaque(false);
		botonDetener.setBackground(new Color(143, 188, 143));
		botonDetener.setAlignmentX(Component.CENTER_ALIGNMENT);
		botonDetener.setContentAreaFilled(false);
		GridBagConstraints gbc_botonDetener = new GridBagConstraints();
		gbc_botonDetener.fill = GridBagConstraints.VERTICAL;
		gbc_botonDetener.insets = new Insets(0, 0, 5, 5);
		gbc_botonDetener.gridx = 2;
		gbc_botonDetener.gridy = 2;
		panelBotones1.add(botonDetener, gbc_botonDetener);
		
		JPanel panelBotones2 = new JPanel();
		panelBotones2.setBackground(new Color(220, 220, 220));
		
		panelBotones2.setBorder(new LineBorder(new Color(255, 255, 255), 3));
		
		panelBotones2.setBounds(535, 16, 407, 81);
		add(panelBotones2);
		GridBagLayout gbl_panelBotones2 = new GridBagLayout();
		gbl_panelBotones2.columnWidths = new int[]{60, 60, 2, 0};
		gbl_panelBotones2.rowHeights = new int[]{41, 27, 36, 39, 27, 0};
		gbl_panelBotones2.columnWeights = new double[]{1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelBotones2.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelBotones2.setLayout(gbl_panelBotones2);
		
		JButton btnAbrirDesdeArchivo = new JButton("Abrir desde archivo de texto (.txt)");
		btnAbrirDesdeArchivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAbrirDesdeArchivo.setContentAreaFilled(false);
		GridBagConstraints gbc_btnAbrirDesdeArchivo = new GridBagConstraints();
		gbc_btnAbrirDesdeArchivo.fill = GridBagConstraints.VERTICAL;
		gbc_btnAbrirDesdeArchivo.anchor = GridBagConstraints.EAST;
		gbc_btnAbrirDesdeArchivo.insets = new Insets(0, 0, 5, 5);
		gbc_btnAbrirDesdeArchivo.gridx = 0;
		gbc_btnAbrirDesdeArchivo.gridy = 2;
		panelBotones2.add(btnAbrirDesdeArchivo, gbc_btnAbrirDesdeArchivo);
		
		JButton btnEstablecerParametros = new JButton("Establecer parametros");
		btnEstablecerParametros.setContentAreaFilled(false);
		GridBagConstraints gbc_btnEstablecerParametros = new GridBagConstraints();
		gbc_btnEstablecerParametros.fill = GridBagConstraints.VERTICAL;
		gbc_btnEstablecerParametros.gridwidth = 2;
		gbc_btnEstablecerParametros.anchor = GridBagConstraints.EAST;
		gbc_btnEstablecerParametros.insets = new Insets(0, 0, 5, 5);
		gbc_btnEstablecerParametros.gridx = 1;
		gbc_btnEstablecerParametros.gridy = 2;
		panelBotones2.add(btnEstablecerParametros, gbc_btnEstablecerParametros);
	}
	

	public GUIRetrasos getEnVentana() {
		return enVentana;
	}
}
