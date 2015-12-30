package clienteServidor;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.border.LineBorder;

import comandos.EjecutorComandoRunPCPLC;
import puertoSerial.PuertoSerial;
import puertoSerial.TextAreaEscritura;
import puertoSerial.TextAreaLectura;
import java.awt.Insets;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.PrintStream;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;


public class ModoClientePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private GUIRetrasos enVentana;
	private JTextField AreaTxtIP;
	private JTextField textField;
	private JComboBox<Object> ComboBox;
	private PuertoSerial thePort; //El puerto.
	private JComboBox<Object> nombrePuerto;
	private JButton btnDesconectar; 
	private JButton btnConectar;
	private JComboBox<Object> bitPorSegundo; 
	private JComboBox<Object> bitDeDatos;
	private JComboBox<Object> paridad;
	private JComboBox<Object> bitParada;
	private JComboBox<Object> controlFlujo;
	private JTextArea textArea; // Donde vamos a escribir el comando y las salidas.
	private JTextField entradaComando;
	private JButton btnEnviar;
	private JButton BotonConectar;
	private JTextField fieldSourceIndex;
	private JTextField fieldTarjetIndex;
	private JTextField partID;
	private JTextField sourceID;
	private JTextField sourceIndex;
	private JTextField targetID;
	private JTextField targetIndex;
	private JTextField speed;
	private JButton btnNewButton;
	private JComboBox<Object> comboPartID;
	private JComboBox<Object> comboSourceID;
	private JComboBox<Object> comboTarjetID;
	private JButton btnEjecutar;
	
	
	//private JTextField textField_1;
	//private JPanel contentPane;
	//private JTextField simboloMayor;

	public ModoClientePanel(GUIRetrasos ventana) {
		super();
		enVentana = ventana;
		this.setSize(1008,557);
		setLayout(null);

		JPanel panelEstacion1 = new JPanel();
		panelEstacion1.setBackground(new Color(176, 224, 230));
		panelEstacion1.setBorder(new LineBorder(new Color(255, 255, 255), 3));

		panelEstacion1.setBounds(7, 12, 432, 300);
		add(panelEstacion1);
		GridBagLayout gbl_panelEstacion1 = new GridBagLayout();
		gbl_panelEstacion1.columnWidths = new int[]{122, 196, 102, 41, 0};
		gbl_panelEstacion1.rowHeights = new int[]{7, 0, 12, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelEstacion1.columnWeights = new double[]{1.0, 1.0, 1.0, 11.0, Double.MIN_VALUE};
		gbl_panelEstacion1.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		panelEstacion1.setLayout(gbl_panelEstacion1);

		JLabel lblRobot1 = new JLabel("Estaci\u00F3n:");
		lblRobot1.setForeground(new Color(0, 0, 0));
		lblRobot1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		GridBagConstraints gbc_lblRobot1 = new GridBagConstraints();
		gbc_lblRobot1.fill = GridBagConstraints.VERTICAL;
		gbc_lblRobot1.insets = new Insets(0, 0, 5, 5);
		gbc_lblRobot1.anchor = GridBagConstraints.EAST;
		gbc_lblRobot1.gridx = 0;
		gbc_lblRobot1.gridy = 0;
		panelEstacion1.add(lblRobot1, gbc_lblRobot1);

		ComboBox = new JComboBox<Object>();
		ComboBox.setModel(new DefaultComboBoxModel<Object>(new String[] {"Seleccione...", "Estaci\u00F3n 1", "Estaci\u00F3n 2", "Estaci\u00F3n 3", "Estaci\u00F3n 4"}));
		ComboBox.setLightWeightPopupEnabled(false);
		ComboBox.setBackground(new Color(255, 255, 255));
		ComboBox.setFont(new Font("Dialog", Font.PLAIN, 11));
		ComboBox.setMaximumRowCount(10);
		GridBagConstraints gbc_ComboBox = new GridBagConstraints();
		gbc_ComboBox.fill = GridBagConstraints.BOTH;
		gbc_ComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_ComboBox.gridx = 1;
		gbc_ComboBox.gridy = 0;
		panelEstacion1.add(ComboBox, gbc_ComboBox);

		btnNewButton = new JButton("<- Volver");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				getEnVentana().getContentPane().remove(getEnVentana().getPanelCliente());
				getEnVentana().getContentPane().add(getEnVentana().getPanelIniciar());
				getEnVentana().repaint();
				getEnVentana().getPanelIniciar().paintComponents(getEnVentana().getPanelIniciar().getGraphics());
			}
		});
		btnNewButton.setBackground(new Color(211, 211, 211));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 0;
		panelEstacion1.add(btnNewButton, gbc_btnNewButton);

		JLabel lblIngreseIp = new JLabel("Direcci\u00F3n IP:");
		lblIngreseIp.setForeground(new Color(0, 0, 0));
		lblIngreseIp.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		GridBagConstraints gbc_lblIngreseIp = new GridBagConstraints();
		gbc_lblIngreseIp.fill = GridBagConstraints.VERTICAL;
		gbc_lblIngreseIp.insets = new Insets(0, 0, 5, 5);
		gbc_lblIngreseIp.anchor = GridBagConstraints.EAST;
		gbc_lblIngreseIp.gridx = 0;
		gbc_lblIngreseIp.gridy = 1;
		panelEstacion1.add(lblIngreseIp, gbc_lblIngreseIp);

		AreaTxtIP = new JTextField();
		AreaTxtIP.setFont(new Font("Monospaced", Font.PLAIN, 14));
		GridBagConstraints gbc_AreaTxtIP = new GridBagConstraints();
		gbc_AreaTxtIP.insets = new Insets(0, 0, 5, 5);
		gbc_AreaTxtIP.fill = GridBagConstraints.BOTH;
		gbc_AreaTxtIP.gridx = 1;
		gbc_AreaTxtIP.gridy = 1;
		panelEstacion1.add(AreaTxtIP, gbc_AreaTxtIP);
		AreaTxtIP.setColumns(10);

		BotonConectar = new JButton("Conectar");
		BotonConectar.setForeground(new Color(0, 0, 0));
		BotonConectar.setContentAreaFilled(false);
		GridBagConstraints gbc_BotonConectar = new GridBagConstraints();
		gbc_BotonConectar.fill = GridBagConstraints.BOTH;
		gbc_BotonConectar.insets = new Insets(0, 0, 5, 5);
		gbc_BotonConectar.gridx = 2;
		gbc_BotonConectar.gridy = 1;
		panelEstacion1.add(BotonConectar, gbc_BotonConectar);

		JLabel label = new JLabel("Puerto serial:");
		label.setForeground(new Color(0, 0, 0));
		label.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.fill = GridBagConstraints.VERTICAL;
		gbc_label.anchor = GridBagConstraints.EAST;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 2;
		panelEstacion1.add(label, gbc_label);

		nombrePuerto = new JComboBox<Object>();
		nombrePuerto.setLightWeightPopupEnabled(false);
		nombrePuerto.setModel(this.ObtenerListaDePuertosParaBox());
		nombrePuerto.setFont(new Font("Dialog", Font.PLAIN, 11));
		nombrePuerto.setForeground(new Color(0, 0, 0));
		nombrePuerto.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_nombrePuerto = new GridBagConstraints();
		gbc_nombrePuerto.insets = new Insets(0, 0, 5, 5);
		gbc_nombrePuerto.fill = GridBagConstraints.BOTH;
		gbc_nombrePuerto.gridx = 1;
		gbc_nombrePuerto.gridy = 2;
		panelEstacion1.add(nombrePuerto, gbc_nombrePuerto);

		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setForeground(new Color(0, 0, 0));
		btnActualizar.setContentAreaFilled(false);
		GridBagConstraints gbc_btnActualizar = new GridBagConstraints();
		gbc_btnActualizar.fill = GridBagConstraints.BOTH;
		gbc_btnActualizar.insets = new Insets(0, 0, 5, 5);
		gbc_btnActualizar.gridx = 2;
		gbc_btnActualizar.gridy = 2;
		panelEstacion1.add(btnActualizar, gbc_btnActualizar);
		btnActualizar.addActionListener(e -> nombrePuerto.setModel(ObtenerListaDePuertosParaBox()));

		JLabel label_1 = new JLabel("Bit por segundo:");
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.fill = GridBagConstraints.VERTICAL;
		gbc_label_1.anchor = GridBagConstraints.EAST;
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 3;
		panelEstacion1.add(label_1, gbc_label_1);

		bitPorSegundo = new JComboBox<Object>();
		bitPorSegundo.setMaximumRowCount(20);
		bitPorSegundo.setModel(new DefaultComboBoxModel<Object>(new String[] {"75", "110", "134", "150", "300", "600", "1200", "2400", "4800", "7200", "9600", "14400", "19200", "38400", "57600", "115200", "128000"}));
		bitPorSegundo.setLightWeightPopupEnabled(false);
		bitPorSegundo.setFont(new Font("Dialog", Font.PLAIN, 11));
		bitPorSegundo.setForeground(new Color(0, 0, 0));
		bitPorSegundo.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_bitPorSegundo = new GridBagConstraints();
		gbc_bitPorSegundo.insets = new Insets(0, 0, 5, 5);
		gbc_bitPorSegundo.fill = GridBagConstraints.BOTH;
		gbc_bitPorSegundo.gridx = 1;
		gbc_bitPorSegundo.gridy = 3;
		panelEstacion1.add(bitPorSegundo, gbc_bitPorSegundo);

		JLabel label_2 = new JLabel("Bit de datos:");
		label_2.setForeground(Color.BLACK);
		label_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.fill = GridBagConstraints.VERTICAL;
		gbc_label_2.anchor = GridBagConstraints.EAST;
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 0;
		gbc_label_2.gridy = 4;
		panelEstacion1.add(label_2, gbc_label_2);

		bitDeDatos = new JComboBox<Object>();
		bitDeDatos.setModel(new DefaultComboBoxModel<Object>(new String[] {"4", "5", "6", "7", "8"}));
		bitDeDatos.setLightWeightPopupEnabled(false);
		bitDeDatos.setFont(new Font("Dialog", Font.PLAIN, 11));
		bitDeDatos.setForeground(new Color(0, 0, 0));
		bitDeDatos.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_bitDeDatos = new GridBagConstraints();
		gbc_bitDeDatos.insets = new Insets(0, 0, 5, 5);
		gbc_bitDeDatos.fill = GridBagConstraints.BOTH;
		gbc_bitDeDatos.gridx = 1;
		gbc_bitDeDatos.gridy = 4;
		panelEstacion1.add(bitDeDatos, gbc_bitDeDatos);

		JLabel label_3 = new JLabel("Paridad:");
		label_3.setForeground(Color.BLACK);
		label_3.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.fill = GridBagConstraints.VERTICAL;
		gbc_label_3.anchor = GridBagConstraints.EAST;
		gbc_label_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_3.gridx = 0;
		gbc_label_3.gridy = 5;
		panelEstacion1.add(label_3, gbc_label_3);

		paridad = new JComboBox<Object>();
		paridad.setModel(new DefaultComboBoxModel<Object>(new String[] {"Par", "Impar", "Ninguno", "Marca", "Espacio"}));
		paridad.setLightWeightPopupEnabled(false);
		paridad.setFont(new Font("Dialog", Font.PLAIN, 11));
		paridad.setForeground(new Color(0, 0, 0));
		paridad.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_paridad = new GridBagConstraints();
		gbc_paridad.insets = new Insets(0, 0, 5, 5);
		gbc_paridad.fill = GridBagConstraints.BOTH;
		gbc_paridad.gridx = 1;
		gbc_paridad.gridy = 5;
		panelEstacion1.add(paridad, gbc_paridad);

		JLabel label_4 = new JLabel("Bit de parada:");
		label_4.setForeground(Color.BLACK);
		label_4.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.fill = GridBagConstraints.VERTICAL;
		gbc_label_4.anchor = GridBagConstraints.EAST;
		gbc_label_4.insets = new Insets(0, 0, 5, 5);
		gbc_label_4.gridx = 0;
		gbc_label_4.gridy = 6;
		panelEstacion1.add(label_4, gbc_label_4);

		bitParada = new JComboBox<Object>();
		bitParada.setModel(new DefaultComboBoxModel<Object>(new String[] {"1", "1.5", "2"}));
		bitParada.setLightWeightPopupEnabled(false);
		bitParada.setFont(new Font("Dialog", Font.PLAIN, 11));
		bitParada.setForeground(new Color(0, 0, 0));
		bitParada.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_bitParada = new GridBagConstraints();
		gbc_bitParada.insets = new Insets(0, 0, 5, 5);
		gbc_bitParada.fill = GridBagConstraints.BOTH;
		gbc_bitParada.gridx = 1;
		gbc_bitParada.gridy = 6;
		panelEstacion1.add(bitParada, gbc_bitParada);

		JLabel label_5 = new JLabel("Control de flujo:");
		label_5.setForeground(Color.BLACK);
		label_5.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		GridBagConstraints gbc_label_5 = new GridBagConstraints();
		gbc_label_5.fill = GridBagConstraints.VERTICAL;
		gbc_label_5.anchor = GridBagConstraints.EAST;
		gbc_label_5.insets = new Insets(0, 0, 5, 5);
		gbc_label_5.gridx = 0;
		gbc_label_5.gridy = 7;
		panelEstacion1.add(label_5, gbc_label_5);

		controlFlujo = new JComboBox<Object>();
		controlFlujo.setModel(new DefaultComboBoxModel<Object>(new String[] {"Xon / Xoff", "Hardware", "Ninguno"}));
		controlFlujo.setLightWeightPopupEnabled(false);
		controlFlujo.setFont(new Font("Dialog", Font.PLAIN, 11));
		controlFlujo.setForeground(new Color(0, 0, 0));
		controlFlujo.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_controlFlujo = new GridBagConstraints();
		gbc_controlFlujo.insets = new Insets(0, 0, 5, 5);
		gbc_controlFlujo.fill = GridBagConstraints.BOTH;
		gbc_controlFlujo.gridx = 1;
		gbc_controlFlujo.gridy = 7;
		panelEstacion1.add(controlFlujo, gbc_controlFlujo);

		JPanel panel_2 = new JPanel();
		panel_2.setOpaque(false);
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.gridwidth = 4;
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 8;
		panelEstacion1.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0};
		gbl_panel_2.columnWeights = new double[]{2.0, 1.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);

		btnConectar = new JButton("Conectar COM");
		btnConectar.addActionListener(e -> conectarPuertoSerial());
		btnConectar.setContentAreaFilled(false);
		GridBagConstraints gbc_btnConectarConPuerto = new GridBagConstraints();
		gbc_btnConectarConPuerto.insets = new Insets(0, 0, 0, 5);
		gbc_btnConectarConPuerto.gridx = 2;
		gbc_btnConectarConPuerto.gridy = 0;
		panel_2.add(btnConectar, gbc_btnConectarConPuerto);

		JButton btnLimpiar = new JButton("Limpiar terminal");
		btnLimpiar.setContentAreaFilled(false);
		GridBagConstraints gbc_btnLimpiar = new GridBagConstraints();
		gbc_btnLimpiar.insets = new Insets(0, 0, 0, 5);
		gbc_btnLimpiar.gridx = 3;
		gbc_btnLimpiar.gridy = 0;
		panel_2.add(btnLimpiar, gbc_btnLimpiar);

		btnDesconectar = new JButton("Desconectar");
		btnDesconectar.addActionListener(e -> this.desconectarPuertoSerial());
		btnDesconectar.setEnabled(false);
		btnDesconectar.setContentAreaFilled(false);
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.insets = new Insets(0, 0, 0, 5);
		gbc_button_1.gridx = 4;
		gbc_button_1.gridy = 0;
		panel_2.add(btnDesconectar, gbc_button_1);

		JPanel panel = new JPanel();
		panel.setForeground(Color.WHITE);
		panel.setBorder(new LineBorder(new Color(255, 255, 255), 3));
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(446, 12, 550, 482);
		add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{537, 0};
		gbl_panel.rowHeights = new int[]{414, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);


		// Salida de datos con scroll !!
		JScrollPane salidaDatos = new JScrollPane();
		salidaDatos.setAutoscrolls(true);

		//salidaDatos.setBorder(new LineBorder(new Color(30, 144, 255),2,true));
		salidaDatos.setBackground(new Color(20, 20, 20));
		//salidaDatos.setBounds(364, 14, 644, 491);


		textArea = new JTextArea();
		textArea.setTabSize(2);
		textArea.setLineWrap(true);
		textArea.setForeground(Color.BLACK);
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
		textArea.setEnabled(false);
		textArea.setDisabledTextColor(Color.WHITE);
		textArea.setCaretColor(Color.WHITE);
		textArea.setBorder(null);
		textArea.setBackground(new Color(20, 20, 20));
		textArea.setAutoscrolls(true);
		GridBagConstraints gbc_txtrHelpADelete = new GridBagConstraints();
		gbc_txtrHelpADelete.fill = GridBagConstraints.BOTH;
		gbc_txtrHelpADelete.gridx = 0;
		gbc_txtrHelpADelete.gridy = 0;
		salidaDatos.setViewportView(textArea);
		salidaDatos.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		panel.add(salidaDatos, gbc_txtrHelpADelete);
		//panel.add(textArea, gbc_txtrHelpADelete);
		

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(255, 255, 255), 3));
		panel_1.setBackground(new Color(20,20,20));
		panel_1.setBounds(446, 499, 550, 46);
		add(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{21, 408, 69, 5, 0};
		gbl_panel_1.rowHeights = new int[]{51, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, 1.0, 0.0, 2.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);

		textField = new JTextField();
		textField.setText(" >");
		textField.setOpaque(false);
		textField.setForeground(Color.WHITE);
		textField.setFont(new Font("Monospaced", Font.PLAIN, 18));
		textField.setEnabled(false);
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setCaretColor(Color.WHITE);
		textField.setBorder(null);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 0, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 0;
		panel_1.add(textField, gbc_textField);

		entradaComando = new JTextField();
		entradaComando.setOpaque(false);
		entradaComando.setForeground(Color.WHITE);
		entradaComando.setFont(new Font("Monospaced", Font.PLAIN, 16));
		entradaComando.setColumns(10);
		entradaComando.setCaretColor(Color.WHITE);
		entradaComando.setBorder(null);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 0, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 0;
		panel_1.add(entradaComando, gbc_textField_1);

		btnEnviar = new JButton("Enviar");
		btnEnviar.setRolloverEnabled(false);
		btnEnviar.setForeground(Color.WHITE);
		btnEnviar.setFont(new Font("Dialog", Font.BOLD, 16));
		btnEnviar.setEnabled(false);
		btnEnviar.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_btnNewButton1 = new GridBagConstraints();
		gbc_btnNewButton1.gridwidth = 2;
		gbc_btnNewButton1.gridx = 2;
		gbc_btnNewButton1.gridy = 0;
		panel_1.add(btnEnviar, gbc_btnNewButton1);

		JPanel panelRobot2 = new JPanel();
		panelRobot2.setBorder(new LineBorder(new Color(255, 255, 255), 3));
		panelRobot2.setBackground(new Color(240, 230, 140));
		panelRobot2.setBounds(7, 318, 432, 227);
		add(panelRobot2);
		GridBagLayout gbl_panelRobot2 = new GridBagLayout();
		gbl_panelRobot2.columnWidths = new int[]{127, 0, 37, 181, 0, 0};
		gbl_panelRobot2.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelRobot2.columnWeights = new double[]{1.0, 19.0, 1.0, 20.0, 17.0, Double.MIN_VALUE};
		gbl_panelRobot2.rowWeights = new double[]{20.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		panelRobot2.setLayout(gbl_panelRobot2);

		JLabel lblPartId = new JLabel("Part ID");
		lblPartId.setForeground(Color.BLACK);
		lblPartId.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		GridBagConstraints gbc_lblPartId = new GridBagConstraints();
		gbc_lblPartId.anchor = GridBagConstraints.EAST;
		gbc_lblPartId.fill = GridBagConstraints.VERTICAL;
		gbc_lblPartId.insets = new Insets(0, 0, 5, 5);
		gbc_lblPartId.gridx = 0;
		gbc_lblPartId.gridy = 1;
		panelRobot2.add(lblPartId, gbc_lblPartId);

		partID = new JTextField();
		partID.setFont(new Font("Monospaced", Font.PLAIN, 14));
		partID.setColumns(2);
		GridBagConstraints gbc_partID = new GridBagConstraints();
		gbc_partID.insets = new Insets(0, 0, 5, 5);
		gbc_partID.fill = GridBagConstraints.BOTH;
		gbc_partID.gridx = 2;
		gbc_partID.gridy = 1;
		panelRobot2.add(partID, gbc_partID);

		comboPartID = new JComboBox<Object>();
		comboPartID.setMaximumRowCount(30);
		comboPartID.setModel(new DefaultComboBoxModel<Object>(new String[] {"TEMPLATE", "VISION_DIRECTO", "UBB_DIRECTO", "VISION", "PEON", "UBB", "EJE1", "PORTA EJE", "HILARIO", "CYLINDER", "BOX", "ASSEMBLY", "MY_BARCODE", "SIMPL_PART", "CYLYNDER_FOR_VI", "BASE_FOR_VISION", "BOX_SUPPLY", "CYLINDER_SUPPLY", "PHANTOM"}));
		comboPartID.setLightWeightPopupEnabled(false);
		comboPartID.setForeground(Color.BLACK);
		comboPartID.setFont(new Font("Dialog", Font.PLAIN, 11));
		comboPartID.setBackground(Color.WHITE);
		GridBagConstraints gbc_comboPartID = new GridBagConstraints();
		gbc_comboPartID.insets = new Insets(0, 0, 5, 5);
		gbc_comboPartID.fill = GridBagConstraints.BOTH;
		gbc_comboPartID.gridx = 3;
		gbc_comboPartID.gridy = 1;
		panelRobot2.add(comboPartID, gbc_comboPartID);
		comboPartID.addItemListener(e -> obtenerPartID());

		JLabel lblSourceId = new JLabel("Source ID");
		lblSourceId.setForeground(Color.BLACK);
		lblSourceId.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		GridBagConstraints gbc_lblSourceId = new GridBagConstraints();
		gbc_lblSourceId.anchor = GridBagConstraints.EAST;
		gbc_lblSourceId.insets = new Insets(0, 0, 5, 5);
		gbc_lblSourceId.gridx = 0;
		gbc_lblSourceId.gridy = 2;
		panelRobot2.add(lblSourceId, gbc_lblSourceId);

		sourceID = new JTextField();
		sourceID.setFont(new Font("Monospaced", Font.PLAIN, 14));
		sourceID.setColumns(2);
		GridBagConstraints gbc_sourceID = new GridBagConstraints();
		gbc_sourceID.insets = new Insets(0, 0, 5, 5);
		gbc_sourceID.fill = GridBagConstraints.HORIZONTAL;
		gbc_sourceID.gridx = 2;
		gbc_sourceID.gridy = 2;
		panelRobot2.add(sourceID, gbc_sourceID);

		comboSourceID = new JComboBox<Object>();
		comboSourceID.setModel(new DefaultComboBoxModel<Object>(new String[] {"MILL1", "LATHE1", "BFFR2", "CNV1"}));
		comboSourceID.setLightWeightPopupEnabled(false);
		comboSourceID.setForeground(Color.BLACK);
		comboSourceID.setFont(new Font("Dialog", Font.PLAIN, 11));
		comboSourceID.setBackground(Color.WHITE);
		GridBagConstraints gbc_comboSourceID = new GridBagConstraints();
		gbc_comboSourceID.insets = new Insets(0, 0, 5, 5);
		gbc_comboSourceID.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboSourceID.gridx = 3;
		gbc_comboSourceID.gridy = 2;
		panelRobot2.add(comboSourceID, gbc_comboSourceID);
		comboSourceID.addItemListener(e -> obtenerIDsSourceTarget(comboSourceID, sourceID, sourceIndex, fieldSourceIndex));

		JLabel lblSourceIndex = new JLabel("Source Index");
		lblSourceIndex.setForeground(Color.BLACK);
		lblSourceIndex.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		GridBagConstraints gbc_lblSourceIndex = new GridBagConstraints();
		gbc_lblSourceIndex.anchor = GridBagConstraints.EAST;
		gbc_lblSourceIndex.insets = new Insets(0, 0, 5, 5);
		gbc_lblSourceIndex.gridx = 0;
		gbc_lblSourceIndex.gridy = 3;
		panelRobot2.add(lblSourceIndex, gbc_lblSourceIndex);

		sourceIndex = new JTextField();
		sourceIndex.setFont(new Font("Monospaced", Font.PLAIN, 14));
		sourceIndex.setColumns(2);
		GridBagConstraints gbc_sourceIndex = new GridBagConstraints();
		gbc_sourceIndex.insets = new Insets(0, 0, 5, 5);
		gbc_sourceIndex.fill = GridBagConstraints.HORIZONTAL;
		gbc_sourceIndex.gridx = 2;
		gbc_sourceIndex.gridy = 3;
		panelRobot2.add(sourceIndex, gbc_sourceIndex);

		fieldSourceIndex = new JTextField();
		fieldSourceIndex.setDisabledTextColor(Color.BLACK);
		fieldSourceIndex.setHorizontalAlignment(SwingConstants.CENTER);
		fieldSourceIndex.setForeground(Color.BLACK);
		fieldSourceIndex.setEnabled(false);
		fieldSourceIndex.setEditable(false);
		fieldSourceIndex.setFont(new Font("Monospaced", Font.BOLD, 14));
		fieldSourceIndex.setColumns(10);
		GridBagConstraints gbc_fieldSourceIndex = new GridBagConstraints();
		gbc_fieldSourceIndex.insets = new Insets(0, 0, 5, 5);
		gbc_fieldSourceIndex.fill = GridBagConstraints.HORIZONTAL;
		gbc_fieldSourceIndex.gridx = 3;
		gbc_fieldSourceIndex.gridy = 3;
		panelRobot2.add(fieldSourceIndex, gbc_fieldSourceIndex);

		JLabel lblTargetId = new JLabel("Target ID");
		lblTargetId.setForeground(Color.BLACK);
		lblTargetId.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		GridBagConstraints gbc_lblTargetId = new GridBagConstraints();
		gbc_lblTargetId.anchor = GridBagConstraints.EAST;
		gbc_lblTargetId.insets = new Insets(0, 0, 5, 5);
		gbc_lblTargetId.gridx = 0;
		gbc_lblTargetId.gridy = 4;
		panelRobot2.add(lblTargetId, gbc_lblTargetId);

		targetID = new JTextField();
		targetID.setFont(new Font("Monospaced", Font.PLAIN, 14));
		targetID.setColumns(2);
		GridBagConstraints gbc_targetID = new GridBagConstraints();
		gbc_targetID.insets = new Insets(0, 0, 5, 5);
		gbc_targetID.fill = GridBagConstraints.HORIZONTAL;
		gbc_targetID.gridx = 2;
		gbc_targetID.gridy = 4;
		panelRobot2.add(targetID, gbc_targetID);

		comboTarjetID = new JComboBox<Object>();
		comboTarjetID.setModel(new DefaultComboBoxModel<Object>(new String[] {"MILL1", "LATHE1", "BFFR2", "CNV1"}));
		comboTarjetID.setLightWeightPopupEnabled(false);
		comboTarjetID.setForeground(Color.BLACK);
		comboTarjetID.setFont(new Font("Dialog", Font.PLAIN, 11));
		comboTarjetID.setBackground(Color.WHITE);
		GridBagConstraints gbc_comboTarjetID = new GridBagConstraints();
		gbc_comboTarjetID.insets = new Insets(0, 0, 5, 5);
		gbc_comboTarjetID.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboTarjetID.gridx = 3;
		gbc_comboTarjetID.gridy = 4;
		panelRobot2.add(comboTarjetID, gbc_comboTarjetID);
		comboTarjetID.addItemListener(e -> obtenerIDsSourceTarget(comboTarjetID, targetID, targetIndex, fieldTarjetIndex));

		JLabel lblTargetIndex = new JLabel("Target Index");
		lblTargetIndex.setForeground(Color.BLACK);
		lblTargetIndex.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		GridBagConstraints gbc_lblTargetIndex = new GridBagConstraints();
		gbc_lblTargetIndex.anchor = GridBagConstraints.EAST;
		gbc_lblTargetIndex.insets = new Insets(0, 0, 5, 5);
		gbc_lblTargetIndex.gridx = 0;
		gbc_lblTargetIndex.gridy = 5;
		panelRobot2.add(lblTargetIndex, gbc_lblTargetIndex);

		targetIndex = new JTextField();
		targetIndex.setFont(new Font("Monospaced", Font.PLAIN, 14));
		targetIndex.setColumns(2);
		GridBagConstraints gbc_targetIndex = new GridBagConstraints();
		gbc_targetIndex.insets = new Insets(0, 0, 5, 5);
		gbc_targetIndex.fill = GridBagConstraints.HORIZONTAL;
		gbc_targetIndex.gridx = 2;
		gbc_targetIndex.gridy = 5;
		panelRobot2.add(targetIndex, gbc_targetIndex);

		fieldTarjetIndex = new JTextField();
		fieldTarjetIndex.setDisabledTextColor(Color.BLACK);
		fieldTarjetIndex.setHorizontalAlignment(SwingConstants.CENTER);
		fieldTarjetIndex.setForeground(Color.BLACK);
		fieldTarjetIndex.setFont(new Font("Monospaced", Font.BOLD, 14));
		fieldTarjetIndex.setEnabled(false);
		fieldTarjetIndex.setEditable(false);
		fieldTarjetIndex.setColumns(10);
		GridBagConstraints gbc_fieldTarjetIndex = new GridBagConstraints();
		gbc_fieldTarjetIndex.insets = new Insets(0, 0, 5, 5);
		gbc_fieldTarjetIndex.fill = GridBagConstraints.HORIZONTAL;
		gbc_fieldTarjetIndex.gridx = 3;
		gbc_fieldTarjetIndex.gridy = 5;
		panelRobot2.add(fieldTarjetIndex, gbc_fieldTarjetIndex);

		JLabel lblSpeed = new JLabel("Speed");
		lblSpeed.setForeground(Color.BLACK);
		lblSpeed.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		GridBagConstraints gbc_lblSpeed = new GridBagConstraints();
		gbc_lblSpeed.anchor = GridBagConstraints.EAST;
		gbc_lblSpeed.insets = new Insets(0, 0, 5, 5);
		gbc_lblSpeed.gridx = 0;
		gbc_lblSpeed.gridy = 6;
		panelRobot2.add(lblSpeed, gbc_lblSpeed);

		speed = new JTextField();
		speed.setText("0");
		speed.setFont(new Font("Monospaced", Font.PLAIN, 14));
		speed.setColumns(2);
		GridBagConstraints gbc_speed = new GridBagConstraints();
		gbc_speed.insets = new Insets(0, 0, 5, 5);
		gbc_speed.fill = GridBagConstraints.HORIZONTAL;
		gbc_speed.gridx = 2;
		gbc_speed.gridy = 6;
		panelRobot2.add(speed, gbc_speed);

		btnEjecutar = new JButton("Ejecutar");
		btnEjecutar.setEnabled(false);
		btnEjecutar.setForeground(Color.BLACK);
		btnEjecutar.setContentAreaFilled(false);
		GridBagConstraints gbc_btnEjecutar = new GridBagConstraints();
		gbc_btnEjecutar.insets = new Insets(0, 0, 0, 5);
		gbc_btnEjecutar.gridx = 3;
		gbc_btnEjecutar.gridy = 7;
		panelRobot2.add(btnEjecutar, gbc_btnEjecutar);
		
		bitPorSegundo.setSelectedItem(bitPorSegundo.getModel().getElementAt(10));
		bitDeDatos.setSelectedItem(bitDeDatos.getModel().getElementAt(4));
		paridad.setSelectedItem(paridad.getModel().getElementAt(2));
		controlFlujo.setSelectedItem(controlFlujo.getModel().getElementAt(0));
		controlFlujo.setSelectedItem(controlFlujo.getModel().getElementAt(2));

		//Para el envio de un comando.
		entradaComando.setCaretColor(Color.WHITE);
		entradaComando.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER && btnEnviar.isEnabled() && thePort != null){
					thePort.getEscritor().enviarComando(entradaComando.getText());
					entradaComando.setText("");
				}
			};
		});
		//envio por boton:

		btnEnviar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				thePort.getEscritor().enviarComando(entradaComando.getText());
				entradaComando.setText("");

			}
		});

		//Para la lectura:
		TextAreaLectura entrada = new TextAreaLectura(getTextArea());
		TextAreaEscritura salidaCustom = new TextAreaEscritura(getTextArea());
		PrintStream entradaStream = new PrintStream(salidaCustom);
		System.setOut(entradaStream);
		//System.setErr(entradaStream);
		//textArea.addKeyListener(entrada);
		System.setIn(entrada); 
		btnLimpiar.addActionListener(e -> entrada.limpiar());

		//valor del part id inicial
		obtenerPartID();
		
		obtenerIDsSourceTarget(comboSourceID, sourceID, sourceIndex, fieldSourceIndex);
		
		obtenerIDsSourceTarget(comboTarjetID, targetID, targetIndex, fieldTarjetIndex);
		
		btnEjecutar.addActionListener(e->comandoRunPcplc(partID.getText(), sourceID.getText(), 
				sourceIndex.getText(), targetID.getText(), targetIndex.getText(), speed.getText()));
		
	}
	
	
	
	public JButton getBtnEjecutar() {
		return btnEjecutar;
	}
	
	public void comandoRunPcplc(String primero, String segundo, String tercero, String cuarto, String quinto, String sexto){
		EjecutorComandoRunPCPLC com = new EjecutorComandoRunPCPLC("111111", primero, segundo, tercero, cuarto, quinto, sexto, getThePort());
		com.start();
	}


	public GUIRetrasos getEnVentana() {
		return enVentana;
	}


	private DefaultComboBoxModel<Object> ObtenerListaDePuertosParaBox(){ 
		return new DefaultComboBoxModel<>(PuertoSerial.enumerarPuertos());
	}
	public PuertoSerial getThePort() {
		return thePort;
	}
	public void setThePort(PuertoSerial thePort) {
		this.thePort = thePort;
	}

	public JButton getBtnNewButton() {
		return btnNewButton;
	}

	private void conectarPuertoSerial(){ //Evento boton conectar con puerto serial

		if(!getNombrePuerto().getSelectedItem().toString().equals("")){

			getBtnConectar().setEnabled(false);
			getBtnDesconectar().setEnabled(true);
			getNombrePuerto().setEnabled(false);
			getBitPorSegundo().setEnabled(false);
			getBitDeDatos().setEnabled(false);
			getParidad().setEnabled(false);
			getBitParada().setEnabled(false);
			getControlFlujo().setEnabled(false);
			getBtnEnviar().setEnabled(true);
			getBtnNewButton().setEnabled(false);
			
			//Inicio  boton ejecutar...
			getBtnEjecutar().setEnabled(true);
			//Fin agregar comando al boton.
			try
			{
				( thePort = new PuertoSerial(
						getBitPorSegundo().getSelectedItem().toString(),
						getBitDeDatos().getSelectedItem().toString(),
						getParidad().getSelectedItem().toString(),
						getBitParada().getSelectedItem().toString(),
						getControlFlujo().getSelectedItem().toString()	        		   
						)).connect(getNombrePuerto().getSelectedItem().toString());
			}
			catch ( Exception e )
			{
				desconectarPuertoSerial();
				System.out.println("Error. Puede que otro software tenga el puerto en uso.");
				e.printStackTrace();
			}
		}
	}

	public JComboBox<Object> getComboPartID() {
		return comboPartID;
	}


	private void desconectarPuertoSerial(){ //evento boton desconectar.

		textArea.setEnabled(false);
		getBtnConectar().setEnabled(true);
		getBtnDesconectar().setEnabled(false);
		getNombrePuerto().setEnabled(true);
		getBitPorSegundo().setEnabled(true);
		getBitDeDatos().setEnabled(true);
		getParidad().setEnabled(true);
		getBitParada().setEnabled(true);
		getControlFlujo().setEnabled(true);
		getBtnNewButton().setEnabled(true);
		getBtnEjecutar().setEnabled(false);

		getBtnEnviar().setEnabled(false);
		getThePort().desconectarPuerto();
		setThePort(null);
	}

	public JTextField getPartID() {
		return partID;
	}
	
	private void obtenerIDsSourceTarget(JComboBox<Object> combo, JTextField fieldID, JTextField fieldIndex, JTextField fieldDisable){
		
		if(combo.getSelectedItem().toString().equals("MILL1")){
			fieldID.setText("23");
			fieldIndex.setText("1");
			fieldDisable.setText("1");
		}else if(combo.getSelectedItem().toString().equals("LATHE1")){
			fieldID.setText("24");
			fieldIndex.setText("1");
			fieldDisable.setText("1");
		}else if(combo.getSelectedItem().toString().equals("BFFR2")){
			fieldID.setText("22");
			fieldIndex.setText("2");
			fieldDisable.setText("1-2");
		}else if(combo.getSelectedItem().toString().equals("CNV1")){
			fieldID.setText("1");
			fieldIndex.setText("3");
			fieldDisable.setText("1-3");
		}

	}

	private void obtenerPartID(){

		String partName = getComboPartID().getSelectedItem().toString();
		String variable = null;
		if(partName.equals("TEMPLATE")){
			variable = String.valueOf(0);
		}else if(partName.equals("VISION_DIRECTO")){
			variable = String.valueOf(8);
		}else if(partName.equals("UBB_DIRECTO")){
			variable = String.valueOf(7);
		}else if(partName.equals("VISION")){
			variable = String.valueOf(22);
		}else if(partName.equals("PEON")){
			variable = String.valueOf(19);
		}else if(partName.equals("UBB")){
			variable = String.valueOf(5);
		}else if(partName.equals("EJE1")){
			variable = String.valueOf(17);
		}else if(partName.equals("PORTA EJE")){
			variable = String.valueOf(6);
		}else if(partName.equals("HILARIO")){
			variable = String.valueOf(15);
		}else if(partName.equals("CYLINDER")){
			variable = String.valueOf(12);
		}else if(partName.equals("BOX")){
			variable = String.valueOf(2);
		}else if(partName.equals("ASSEMBLY")){
			variable = String.valueOf(32);
		}else if(partName.equals("MY_BARCODE")){
			variable = String.valueOf(3);
		}else if(partName.equals("SIMPL_PART")){
			variable = String.valueOf(4);
		}else if(partName.equals("CYLYNDER_FOR_VI")){
			variable = String.valueOf(21);
		}else if(partName.equals("BASE_FOR_VISION")){
			variable = String.valueOf(31);
		}else if(partName.equals("BOX_SUPPLY")){
			variable = String.valueOf(1);
		}else if(partName.equals("CYLINDER_SUPPLY")){
			variable = String.valueOf(11);
		}else if(partName.equals("PHANTOM")){
			variable = String.valueOf(99);
		} 
		getPartID().setText(variable);
	}
	
	

	public JComboBox<Object> getNombrePuerto() {
		return nombrePuerto;
	}
	public JButton getBtnConectar() {
		return btnConectar;
	}
	public JButton getBtnDesconectar() {
		return btnDesconectar;
	}
	public JComboBox<Object> getBitPorSegundo() {
		return bitPorSegundo;
	}
	public JComboBox<Object> getBitDeDatos() {
		return bitDeDatos;
	}
	public JComboBox<Object> getParidad() {
		return paridad;
	}
	public JComboBox<Object> getBitParada() {
		return bitParada;
	}
	public JComboBox<Object> getControlFlujo() {
		return controlFlujo;
	}

	public JTextArea getTextArea() {
		return textArea;
	}
	public JButton getBtnEnviar() {
		return btnEnviar;
	}
}
