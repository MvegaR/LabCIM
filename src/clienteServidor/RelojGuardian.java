package clienteServidor;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.Cursor;

public class RelojGuardian extends JPanel implements Runnable {

    /**
     * Además de ser creado y agregado a un JFrame se 
     * debe de entregar a el contructor de un objeto de tipo Thread 
     * y ejecutar el metodo start() de ese objeto.
     * */

    private static final long serialVersionUID = 1L;
    private JTextField textField;
    private Integer minutos;
    private long tiempoInicial;
    private long tiempoActual;
    private boolean iniciado;

    public RelojGuardian() {
	super();
	setOpaque(false);
	this.iniciado = false;
	this.setSize(90,100);
	setLayout(null);

	JSpinner spinner = new JSpinner();
	spinner.setModel(new SpinnerNumberModel(new Integer(5), new Integer(1), null, new Integer(1)));
	spinner.setBounds(0, 27, 57, 19);
	add(spinner);
	spinner.addKeyListener(new KeyAdapter() {
	    @Override
	    public void keyPressed(KeyEvent e) {
		if(Character.isLetter(e.getKeyChar())){
		    e.consume();
		}
	    }
	});

	JButton btnNewButton = new JButton(">");
	btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
	btnNewButton.setBackground(Color.LIGHT_GRAY);
	btnNewButton.setContentAreaFilled(false);
	btnNewButton.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		setTiempoActual(System.currentTimeMillis());
		setTiempoInicial(System.currentTimeMillis());
		setMinutos(Integer.parseInt(spinner.getValue().toString()));
		
		if(!iniciado)start();
		iniciado = true;
		
	    }
	});
	btnNewButton.setBounds(74, 27, 41, 19);
	add(btnNewButton);

	JLabel lblminutos = new JLabel("Definir minutos");
	lblminutos.setBounds(0, 12, 115, 14);
	add(lblminutos);

	JLabel lblSegundosRestantes = new JLabel("Segundos restantes");
	lblSegundosRestantes.setBounds(0, 44, 115, 14);
	add(lblSegundosRestantes);

	textField = new JTextField();
	textField.setEnabled(false);
	textField.setEditable(false);
	textField.setBounds(1, 59, 114, 20);
	add(textField);
	textField.setColumns(10);

    }
    
    public void reportar(){
	setTiempoInicial(System.currentTimeMillis());
    }

    public void definirMinutos(Integer minutos){
	setMinutos(minutos);
	setTiempoInicial(System.currentTimeMillis());
	setTiempoActual(System.currentTimeMillis());
	actualizarSegundosRestantes();
    }

    public void actualizarSegundosRestantes(){
	setTiempoActual(System.currentTimeMillis());
	textField.setText(getDiferencia().toString());
    }

    private Long getDiferencia(){
	return (((long)getMinutos()*60*1000) - ((getTiempoActual() - getTiempoInicial())))/1000;
    }

    @Override
    public synchronized void run() {

	    while(true){
		
		if(iniciado){
		    if(getDiferencia() <= 0){
			Toolkit.getDefaultToolkit().beep();
			System.out.println("Watchdog: TIEMPO TERMINADO.");
			try {
			    wait(1000);
			} catch (InterruptedException e) {
			    // TODO Auto-generated catch block
			    e.printStackTrace();
			}
		    }else{
			actualizarSegundosRestantes();
			try {
			    wait(1000);
			} catch (InterruptedException e) {
			    // TODO Auto-generated catch block
			    e.printStackTrace();
			}
		    }
		}else{
		    try {
			wait(1000);
		    } catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		    }
		}

	    }
	
    }

    public void start(){
	Thread hilo = null;
	if(hilo==null){
	    hilo=new Thread(this);
	    hilo.start();
	}
    }

    public Integer getMinutos() {
	return minutos;
    }
    public long getTiempoActual() {
	return tiempoActual;
    }
    public long getTiempoInicial() {
	return tiempoInicial;
    }
    public void setTiempoActual(long tiempoActual) {
	this.tiempoActual = tiempoActual;
    }
    public void setMinutos(Integer minutos) {
	this.minutos = minutos;
    }
    public void setTiempoInicial(long tiempoInicial) {
	this.tiempoInicial = tiempoInicial;
    }

}
