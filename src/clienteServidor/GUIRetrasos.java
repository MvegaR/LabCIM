package clienteServidor;

import java.awt.Toolkit;

import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Rectangle;

public class GUIRetrasos extends JFrame{

	private static final long serialVersionUID = 1L;

	private HeaderPanel headerPanel = new HeaderPanel();
	private InicialPanel panelIniciar;
	private ModoServidorPanel panelServidor;
	private ModoClientePanel panelCliente;

	public GUIRetrasos(){
		super("Ventana");
		System.out.println(System.getProperty("os.name"));
		System.out.println(System.getProperty("os.arch"));
		System.out.println(System.getProperty("java.home"));
		setResizable(false);
		getContentPane().setBounds(new Rectangle(100, 200, 500, 600));
		setTitle("Gestor y colector de retrasos");
		getContentPane().setLayout(null);
		headerPanel.setLocation(0, 0);
		headerPanel.setSize(new Dimension(1018, 113));
		headerPanel.setMinimumSize(new Dimension(1008, 115));
		this.getContentPane().add(headerPanel);
		headerPanel.setLayout(null);
		panelServidor = new ModoServidorPanel(this);
		panelIniciar = new InicialPanel(this);
		panelIniciar.setBounds(0, 114, 1018, 557);
		panelServidor.setBounds(0, 114, 1018, 557);
		panelCliente = new ModoClientePanel(this);
		panelCliente.setBounds(7, 114, 1018, 557);
		this.getContentPane().add(panelIniciar);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1024, 700);
		this.setBounds(Toolkit.getDefaultToolkit().getScreenSize().width/2 - this.getWidth()/2, 
				Toolkit.getDefaultToolkit().getScreenSize().height/2 - (this.getHeight()/2), 
				this.getWidth(), this.getHeight());
		this.setVisible(true);

	}
	public ModoServidorPanel getPanelServidor() {
		return panelServidor;
	}

	public ModoClientePanel getPanelCliente() {
		return panelCliente;
	}
	
	public InicialPanel getPanelIniciar() {
		return panelIniciar;
	}

	public static void main(String[] args){

		new GUIRetrasos();

	}
}
