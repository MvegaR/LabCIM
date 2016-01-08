package puertoSerial;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.InputStream;
import java.util.LinkedList;
import javax.swing.JTextArea;

/* No usada.
 * Esta clase fue diseñada para emular un terminal usando un JTextArea.
 * En particular la lectura de los datos para reemplazar el flujo de
 * System.in (con System.setIn)
 * 
 */

public class TextAreaLectura extends InputStream implements KeyListener {
//No se uso...
	private JTextArea tf;
	private String str = null;
	private int pos = 0;
	private Integer postAnterior = 0;

	public TextAreaLectura(JTextArea jtf) {
		tf = jtf;
	}

	public void limpiar(){ 
		str = null;
		pos = 0;
		postAnterior = 0;
		tf.setText("");
	}

	@Override
	public void keyPressed(java.awt.event.KeyEvent e) { 
		char [] caracter = {'|', '!', '"', '#', '$', '%', '&', '/', '(', ')', '=', '?', '¡', '\'', '¿', '{', '}', '[', ']', '^', '`', '*', ',', ';', '.', '-', '_', ' ','°','¬','@','+','~'}; //No supe como distingir estos caracteres de otra forma.
		LinkedList<Character> listaCaracteres = new LinkedList<>();
		for(char k: caracter){
			listaCaracteres.add(k);
		}

		if(tf.getCaretPosition() != tf.getText().length()){ 
			tf.setCaretPosition(tf.getText().length()); 
		}

		if(tf.getSelectionStart() != tf.getSelectionEnd()){ //Se bloquea poder seleccionar texto anterior.
			
			tf.setSelectionStart(tf.getText().length()+1);
			tf.setSelectionEnd(tf.getText().length()+1);
		}else if(tf.getCaretPosition() < postAnterior ){ 
			//despues del enter todo el texto anterior es bloqueado.
			e.consume();
			tf.setCaretPosition(tf.getText().length());

		}else if(e.getKeyCode() == KeyEvent.VK_ENTER){ //Fijar texto despues de enviar un comando.

			postAnterior = tf.getText().length()+1;
			if(str == null){
				str = "\n";
			}
			synchronized (this) {

				this.notifyAll();
			}

		}else if(Character.isLetter(e.getKeyChar()) || Character.isDigit(e.getKeyChar())  || e.getKeyCode() == KeyEvent.VK_BACK_SPACE || listaCaracteres.contains(e.getKeyChar()) || e.getKeyCode() == KeyEvent.VK_ENTER){ //str es el comando que se está escribiendo y se enviará.

			if(str != null && e.getKeyCode() == KeyEvent.VK_BACK_SPACE){ //Tecla borrar <--
				if(str.length() > 1){
					str = str.substring(0, str.length()-1);
				}
				else{
					str = null;
				}

			}else if(str != null){ 
				//Se agrega caracter por caracter al string, el caracter de este evento en este caso
				StringBuilder aux = new StringBuilder();
				aux.append(e.getKeyChar());
				str = str + aux.toString();

			}else if(e.getKeyChar() != KeyEvent.VK_BACK_SPACE){ //si es nulo se hace uno nuevo.
				str = new String();
				StringBuilder aux = new StringBuilder(); //Para crear un string usando un caracter.
				aux.append(e.getKeyChar()); //agregando el caracter
				str = aux.toString(); //asignando como str al string generado.
				//recordar, que todo string termina con un caracter especial  "" = '\0'
			}
			//El comando, (escrito en el jtextfield)
			//System.err.println(str);

		}else{
			e.consume();
		}


	};


	@Override
	public int read() {
		//Si el comando existe y es igual a la posición actual, se retorna el valor cero conocido como caracter nulo.
		if(str != null && pos == str.length()){
			str = null;
			pos = 0; //Es el caracter del comando que se está enviando, si es el último, se reinicia la "cabeza lectora"
			//Existen muchas formas de terminar un string (al precionar ENTER), con un -1, 0, '\n' (10), '\r' (13) o incluso -2 en algúnos casos.
			return '\r';
		}
		//esto lo requiere la documentación de Java, es para que se pause el hilo si no se esta enviando nada.
		while (str == null || pos >= str.length()) {
			try {
				//according to the docs read() should block until new input is available
				synchronized (this) {
					this.wait();
				}
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		} 
		//se lee el comando str en su posición "pos" y se avanza al siguiente caracter (++).
		return str.charAt(pos++);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// evento no usado, tecla mantenida.

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// evento no usado, tecla soltada.
	}


}