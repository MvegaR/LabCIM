package puertoSerial;

import java.io.IOException;

public class EscritorSerial {

	private Integer pos = 0;
	private String str = null;
	private Character caracterFinal = '\r';
	private PuertoSerial port;

	/*
	 *Clase estática que entrega un método, que dado un puerto, y un string 
	 *escribe el string en el puerto serial. (finalizando con un retorno de carro, '\r')
	 */
	
	public EscritorSerial(PuertoSerial port){
		this.port = port;
		
	}
	
	public void enviarComando(String comando) {
		
		synchronized (port) {
			pos = 0;
			str = comando;
			if(port != null){
				while(str != null)
					try {
						port.getOut().write(read());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					
					}
			}else{
				System.err.println("Puerto es nulo (No existe).");
			}
			
		}
		
		
	}

	private int read() {
		//Ultimo: //Si el comando existe y es igual a la posición actual, se retorna el valor cero conocido como caracter nulo.
		if(str != null && pos == str.length()){
			str = null;
			pos = 0; //Es el caracter del comando que se está enviando, si es el último; se reinicia a 0.
			//Existen muchas formas de terminar un string (al precionar ENTER), con un -1, 0, '\n' (10), '\r' (13) o incluso -2 en algúnos casos.
			try {
				Thread.sleep(100); //por el eco.
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return caracterFinal; //Lo más dificil, saber con que termina el robot una lectura, no erá ni 0 ni -1 ni 10... era 13
		}
		
		//Primero: //se lee el comando str en su posición "pos" y se avanza al siguiente caracter (++).
		return str.charAt(pos++);
	}

}