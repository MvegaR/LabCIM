package clienteServidor;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class HeaderPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	private ImageIcon fondo = new ImageIcon(this.getClass().getResource("/img/head.png"));
	
	public HeaderPanel(){
		super();
		this.setBackground(new Color(141, 84, 2));
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(fondo.getImage(), 0,0, fondo.getIconWidth(), fondo.getIconHeight(), this);
		
	}
	
	
}
