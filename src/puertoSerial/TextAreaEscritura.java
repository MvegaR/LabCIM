package puertoSerial;

import java.io.IOException;
import java.io.OutputStream;
import javax.swing.JTextArea;
 
/*
 * Esta clase fue diseñada para emular un terminal en un JTextArea,
 * en particular la escritura de datos en reemplazo de System.out
 * Funciona correctamente para System.err
 */


public class TextAreaEscritura extends OutputStream {
  
	//Para enviar la salida estandar (normalmente el terminal) a un componente de Java como un JTextArea.
	
	private JTextArea textArea;
     
    public TextAreaEscritura(JTextArea textArea) {
        this.textArea = textArea;
       
    }
     
    @Override
    public void write(int b) throws IOException {
    	//Metodo de muy bajo nivel, escribe byte a byte cada caracter.
        // Moviendo datos al componente
        textArea.append(String.valueOf((char)b)); //Agregando un caracter JtextArea
        // Moviendo el scroll del componente al final.
        textArea.setCaretPosition(textArea.getDocument().getLength());
        
    }
}