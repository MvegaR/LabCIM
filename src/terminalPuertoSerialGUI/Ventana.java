package terminalPuertoSerialGUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import puertoSerial.PuertoSerial;
import puertoSerial.TextAreaEscritura;
import puertoSerial.TextAreaLectura;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import java.io.PrintStream;

import javax.swing.DefaultComboBoxModel;

import javax.swing.JTextArea;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

/*
 * Interfaz gráfica que permite la seleccionar de un puerto, su conexión, desconexión, 
 * entrada y salida en un JTextArea, diseñda en eclipse con el plugin WindowsBuilder.
 * 
 * Solo es un ejemplo de lo que se puede hacer con las clases del paquete puertoSerial
 */

public class Ventana extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
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
	private JTextField simboloMayor;
	private JButton btnEnviar;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana frame = new Ventana();
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
	public Ventana() {
		setResizable(true);
		setTitle("Conexi\u00F3n a puerto serial.");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(Toolkit.getDefaultToolkit().getScreenSize().width/2 - this.getWidth()/2, Toolkit.getDefaultToolkit().getScreenSize().height/2 - (this.getHeight()/2), 1024, 600);
		setBounds(Toolkit.getDefaultToolkit().getScreenSize().width/2 - this.getWidth()/2, Toolkit.getDefaultToolkit().getScreenSize().height/2 - (this.getHeight()/2), 1024, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(105, 105, 105));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));


		JPanel panel = new JPanel();
		panel.setBackground(new Color(16, 16, 16));
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel panelPuertoBotones = new JPanel();
		panelPuertoBotones.setBorder(new LineBorder(new Color(30, 144, 255), 2, true));
		panelPuertoBotones.setBackground(new Color(20, 20, 20));
		panelPuertoBotones.setForeground(Color.WHITE);
		panelPuertoBotones.setBounds(10, 14, 344, 111);
		panel.add(panelPuertoBotones);
		panelPuertoBotones.setLayout(null);

		nombrePuerto = new JComboBox<Object>();
		nombrePuerto.setModel(this.ObtenerListaDePuertosParaBox());
		nombrePuerto.setBounds(129, 22, 204, 22);
		panelPuertoBotones.add(nombrePuerto);
		nombrePuerto.setBackground(new Color(90, 90, 90));
		nombrePuerto.setForeground(new Color(255, 255, 255));

		JLabel lblPuerto = new JLabel("Puerto serial:");
		lblPuerto.setLabelFor(nombrePuerto);
		lblPuerto.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPuerto.setForeground(Color.WHITE);
		lblPuerto.setBounds(11, 24, 107, 17);
		panelPuertoBotones.add(lblPuerto);

		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setBackground(Color.DARK_GRAY);
		btnActualizar.setForeground(Color.GREEN);
		btnActualizar.setBounds(226, 66, 107, 22);
		btnActualizar.setRolloverEnabled(false);
		panelPuertoBotones.add(btnActualizar);
		btnActualizar.addActionListener(e -> nombrePuerto.setModel(ObtenerListaDePuertosParaBox()));

		btnDesconectar = new JButton("Desconectar");
		btnDesconectar.setBackground(Color.DARK_GRAY);
		btnDesconectar.setForeground(Color.RED);
		btnDesconectar.setBounds(11, 66, 107, 22);
		panelPuertoBotones.add(btnDesconectar);
		btnDesconectar.setVisible(false);
		btnDesconectar.addActionListener(e -> this.desconectarPuertoSerial());

		btnConectar = new JButton("Conectar");
		btnConectar.setEnabled(true);
		btnConectar.setBackground(Color.DARK_GRAY);
		btnConectar.setForeground(Color.GREEN);
		btnConectar.setBounds(11, 66, 107, 22);
		panelPuertoBotones.add(btnConectar);

		JButton btnLimpiar = new JButton("Limpiar");

		btnLimpiar.setRolloverEnabled(false);
		btnLimpiar.setForeground(Color.WHITE);
		btnLimpiar.setBackground(Color.DARK_GRAY);
		btnLimpiar.setBounds(129, 66, 86, 22);
		panelPuertoBotones.add(btnLimpiar);
		btnConectar.addActionListener(e -> conectarPuertoSerial());

		JPanel panelConfiguracion = new JPanel();
		panelConfiguracion.setBorder(new LineBorder(new Color(30, 144, 255),2,true));
		panelConfiguracion.setBackground(new Color(20, 20, 20));
		panelConfiguracion.setBounds(10, 139, 344, 418);
		panel.add(panelConfiguracion);
		panelConfiguracion.setLayout(null);

		JLabel lblNewLabel = new JLabel("Bit de datos:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(25, 149, 129, 22);
		panelConfiguracion.add(lblNewLabel);

		JLabel lblBitPorSegundo = new JLabel("Bit por segundo:");
		lblBitPorSegundo.setForeground(Color.WHITE);
		lblBitPorSegundo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBitPorSegundo.setBounds(25, 84, 129, 22);
		panelConfiguracion.add(lblBitPorSegundo);

		bitPorSegundo = new JComboBox<Object>();
		bitPorSegundo.setModel(new DefaultComboBoxModel<Object>(new String[] {"75", "110", "134", "150", "300", "600", "1200", "2400", "4800", "7200", "9600", "14400", "19200", "38400", "57600", "115200", "128000"}));
		bitPorSegundo.setBounds(164, 84, 147, 22);
		bitPorSegundo.setBackground(new Color(90, 90, 90));
		bitPorSegundo.setForeground(new Color(255, 255, 255));
		bitPorSegundo.setSelectedItem(bitPorSegundo.getModel().getElementAt(10));
		panelConfiguracion.add(bitPorSegundo);

		JLabel lblParidad = new JLabel("Paridad:");
		lblParidad.setForeground(Color.WHITE);
		lblParidad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblParidad.setBounds(25, 214, 129, 22);
		panelConfiguracion.add(lblParidad);

		JLabel lblBitDeParada = new JLabel("Bit de parada:");
		lblBitDeParada.setForeground(Color.WHITE);
		lblBitDeParada.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBitDeParada.setBounds(25, 279, 129, 22);
		panelConfiguracion.add(lblBitDeParada);

		JLabel lblControlDeFlujo = new JLabel("Control de flujo:");
		lblControlDeFlujo.setForeground(Color.WHITE);
		lblControlDeFlujo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblControlDeFlujo.setBounds(25, 344, 129, 22);
		panelConfiguracion.add(lblControlDeFlujo);

		bitDeDatos = new JComboBox<Object>();
		bitDeDatos.setModel(new DefaultComboBoxModel<Object>(new String[] {"4", "5", "6", "7", "8"}));
		bitDeDatos.setSelectedItem(bitDeDatos.getModel().getElementAt(4));
		bitDeDatos.setBounds(164, 149, 147, 22);
		bitDeDatos.setBackground(new Color(90, 90, 90));
		bitDeDatos.setForeground(new Color(255, 255, 255));
		panelConfiguracion.add(bitDeDatos);

		paridad = new JComboBox<Object>();
		paridad.setModel(new DefaultComboBoxModel<Object>(new String[] {"Par", "Impar", "Ninguno", "Marca", "Espacio"}));
		paridad.setSelectedItem(paridad.getModel().getElementAt(2));
		paridad.setBounds(164, 214, 147, 22);
		paridad.setBackground(new Color(90, 90, 90));
		paridad.setForeground(new Color(255, 255, 255));
		panelConfiguracion.add(paridad);

		bitParada = new JComboBox<Object>();
		bitParada.setModel(new DefaultComboBoxModel<Object>(new String[] {"1", "1.5", "2"}));
		bitParada.setSelectedItem(bitParada.getModel().getElementAt(0));
		bitParada.setBounds(164, 279, 147, 22);
		bitParada.setBackground(new Color(90, 90, 90));
		bitParada.setForeground(new Color(255, 255, 255));
		panelConfiguracion.add(bitParada);

		controlFlujo = new JComboBox<Object>();
		controlFlujo.setModel(new DefaultComboBoxModel<Object>(new String[] {"Xon / Xoff", "Hardware", "Ninguno"}));
		controlFlujo.setSelectedItem(controlFlujo.getModel().getElementAt(2));
		controlFlujo.setBounds(164, 344, 147, 22);
		controlFlujo.setBackground(new Color(90, 90, 90));
		controlFlujo.setForeground(new Color(255, 255, 255));
		panelConfiguracion.add(controlFlujo);

		JLabel lblParaConectarConfigure = new JLabel("Configuración conexión");
		lblParaConectarConfigure.setForeground(Color.WHITE);
		lblParaConectarConfigure.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblParaConectarConfigure.setBounds(86, 11, 171, 22);
		panelConfiguracion.add(lblParaConectarConfigure);

		JScrollPane salidaDatos = new JScrollPane();
		salidaDatos.setAutoscrolls(true);

		salidaDatos.setBorder(new LineBorder(new Color(30, 144, 255),2,true));
		salidaDatos.setBackground(new Color(20, 20, 20));
		salidaDatos.setBounds(364, 14, 644, 491);

		textArea = new JTextArea();
		textArea.setBorder(null);
		textArea.setCaretColor(Color.WHITE);
		textArea.setDisabledTextColor(new Color(211, 211, 211));
		textArea.setTabSize(4);
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
		textArea.setLineWrap(true);
		textArea.setForeground(Color.WHITE);
		textArea.setBackground(new Color(20,20,20));
		textArea.setBounds(10, 11, 882, 521);
		textArea.setAutoscrolls(true);
		salidaDatos.setViewportView(textArea);
		salidaDatos.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		textArea.setEnabled(false);


		TextAreaLectura entrada = new TextAreaLectura(getTextArea());
		TextAreaEscritura salidaCustom = new TextAreaEscritura(getTextArea());
		PrintStream entradaStream = new PrintStream(salidaCustom);
		System.setOut(entradaStream);
		//System.setErr(entradaStream);
		//textArea.addKeyListener(entrada);
		System.setIn(entrada); 
		btnLimpiar.addActionListener(e -> entrada.limpiar());

		JPanel panelEnviar = new JPanel();
		panelEnviar.setLayout(null);
		panelEnviar.setBorder(new LineBorder(new Color(30, 144, 255),2,true));
		panelEnviar.setBackground(new Color(20, 20, 20));
		panelEnviar.setBounds(364, 517, 644, 40);
		panel.add(panelEnviar);

		btnEnviar = new JButton("Enviar");
		btnEnviar.setEnabled(false);
		btnEnviar.setFont(new Font("Dialog", Font.BOLD, 16));
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEnviar.setRolloverEnabled(false);
		btnEnviar.setForeground(Color.WHITE);
		btnEnviar.setBackground(Color.DARK_GRAY);
		btnEnviar.setBounds(544, 2, 98, 36);

		panelEnviar.add(btnEnviar);


		entradaComando = new JTextField();
		entradaComando.setForeground(Color.WHITE);
		entradaComando.setFont(new Font("Monospaced", Font.PLAIN, 18));
		entradaComando.setOpaque(false);
		entradaComando.setBounds(24, 2, 508, 38);
		entradaComando.setBorder(null);
		panelEnviar.add(entradaComando);
		entradaComando.setColumns(10);
		panel.add(salidaDatos);
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

		btnEnviar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				thePort.getEscritor().enviarComando(entradaComando.getText());
				entradaComando.setText("");

			}
		});

		simboloMayor = new JTextField();
		simboloMayor.setEnabled(false);
		simboloMayor.setEditable(false);
		simboloMayor.setText(" >");
		simboloMayor.setOpaque(false);
		simboloMayor.setForeground(Color.WHITE);
		simboloMayor.setFont(new Font("Monospaced", Font.PLAIN, 18));
		simboloMayor.setColumns(10);
		simboloMayor.setCaretColor(Color.WHITE);
		simboloMayor.setBorder(null);
		simboloMayor.setBounds(0, 2, 21, 38);
		panelEnviar.add(simboloMayor);

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

	private void conectarPuertoSerial(){ //Evento boton conectar

		if(!getNombrePuerto().getSelectedItem().toString().equals("")){

			getBtnConectar().setVisible(false);
			getBtnDesconectar().setVisible(true);
			getNombrePuerto().setEnabled(false);
			getBitPorSegundo().setEnabled(false);
			getBitDeDatos().setEnabled(false);
			getParidad().setEnabled(false);
			getBitParada().setEnabled(false);
			getControlFlujo().setEnabled(false);
			getBtnEnviar().setEnabled(true);

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

	private void desconectarPuertoSerial(){ //evento boton desconectar.

		textArea.setEnabled(false);
		getBtnConectar().setVisible(true);
		getBtnDesconectar().setVisible(false);
		getNombrePuerto().setEnabled(true);
		getBitPorSegundo().setEnabled(true);
		getBitDeDatos().setEnabled(true);
		getParidad().setEnabled(true);
		getBitParada().setEnabled(true);
		getControlFlujo().setEnabled(true);

		getBtnEnviar().setEnabled(false);
		getThePort().desconectarPuerto();
		setThePort(null);
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
