package clienteServidor;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InicialPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private GUIRetrasos enVentana;
	
	public InicialPanel(GUIRetrasos ventana) {
		super();
		enVentana = ventana;
		this.setSize(1008,515);
		setLayout(null);
		JLabel label = new JLabel("Seleccione modo de configuraci\u00F3n");
		label.setBounds(315, 81, 387, 41);
		label.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		add(label);
		
		JButton button_1 = new JButton("Modo cliente");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getEnVentana().getContentPane().remove(getEnVentana().getPanelIniciar());
				getEnVentana().getContentPane().add(getEnVentana().getPanelCliente());
				getEnVentana().repaint();
				getEnVentana().getPanelCliente().paintComponents(getEnVentana().getPanelCliente().getGraphics());
			}
		});
		button_1.setBounds(386, 201, 244, 78);
		button_1.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		button_1.setContentAreaFilled(false);
		add(button_1);
		
		JButton button = new JButton("Modo servidor");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				getEnVentana().getContentPane().remove(getEnVentana().getPanelIniciar());
				getEnVentana().getContentPane().add(getEnVentana().getPanelServidor());
				getEnVentana().repaint();
				getEnVentana().getPanelServidor().paintComponents(getEnVentana().getPanelServidor().getGraphics());
		
			}
		});
		button.setBounds(386, 358, 244, 78);
		button.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		button.setContentAreaFilled(false);
		add(button);
	}
	

	public GUIRetrasos getEnVentana() {
		return enVentana;
	}
	
	
}
