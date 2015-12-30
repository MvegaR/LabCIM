package puertoSerial;

import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;

/*
 * Esta es la clase lectora del puerto serial
 * Lee los caracteres recibidos byte por byte 
 * y los escribe en System.out (puede ser direccionado a cualquier otro lado).
 */

public class LectorSerial implements SerialPortEventListener 
{
	private InputStream in;
	private byte[] buffer = new byte[1024];
	private Calendar calendario = new GregorianCalendar();
	private PuertoSerial port;
	
	//Para la verificación de estado de la maquina.
	private HashMap<String, Boolean> map = new HashMap<String, Boolean>();
	//Linea es una linea de texto enviada por el puerto(Ej. Robot) a la salida local.
	public synchronized void addLinea(String linea){
		String comando = "";
		int i = 0;
		//Eliminando caracter \n y \r de la linea. INICIO.
		while(i < linea.length()){
			if(linea.charAt(i) != '\n' && linea.charAt(i) != '\r'){
				comando = comando + String.valueOf(linea.charAt(i));
			}
			i++;
		}
		//Eliminando caracter \n y \r de la linea. FIN.
		if(getMap() != null){
			getMap().put(comando, true);
		}else{
			map = new HashMap<String, Boolean>();
			getMap().put(comando, true);
		}
	}
	
	public synchronized Boolean searchEventoLinea(String linea){
		Boolean r = false;
		if(getMap() != null){
			if(getMap().containsKey(linea) && getMap().get(linea) == true){
				r = true;
			}else{
				r = false;
			}
		}
		return r;
	}
	
	public synchronized void usarLinea(String linea){
		if(getMap() != null){
			getMap().put(linea, false);
		}else{
			map = new HashMap<String, Boolean>();
			getMap().put(linea, false);
		}
	}
	
	
	private HashMap<String, Boolean> getMap() {
		return map;
	}
	//Fin de map para la busqueda de mensajes de estado de la maquina.

	private File log = new File("logs"+System.getProperty("file.separator")+"Log"+calendario.get(GregorianCalendar.YEAR)+
			"-"+(calendario.get(GregorianCalendar.MONTH)+1)+"-"+calendario.get(GregorianCalendar.DAY_OF_MONTH)+
			"-"+calendario.get(GregorianCalendar.HOUR_OF_DAY)+"-"+calendario.get(GregorianCalendar.MINUTE)+"-"+
			calendario.get(GregorianCalendar.SECOND)+".txt");

	public LectorSerial ( PuertoSerial port )
	{
		this.port = port;
		this.in = port.getIn();
		File folder = new File("logs");
		if(!folder.exists()){
			folder.mkdirs();
		}
		
	}

	public void serialEvent(SerialPortEvent arg0) {
		
		synchronized(this.port){
			
			int data;
			try
			{
				int len = 0;
				while ( ( data = in.read()) > -1 )
				{
					if(len > 0 && buffer[len-1] == 13 && data != 10){
						buffer[len++] = (byte) '\n';
					}
					
					if ( data == 10) {
						buffer[len++] = (byte) data;
						break;
					}
					buffer[len++] = (byte) data;
				}
				if(len > 0 && buffer[len-1] == 13){
					buffer[len++] = (byte) '\n';
				}
				
				if(len != 0){
					String linea = new String(buffer,0,len);
					System.out.print(linea);
					this.addLinea(linea);
					FileWriter impresora = new FileWriter(log, true);
					impresora.write(linea); //Aqui pueden agregar caracteres para ver donde inicia o termina un comando.
					impresora.close();
					for(int i = 0; i < buffer.length; i++){
						buffer[i] = 0;
					}
				}


			}
			catch ( IOException e )
			{
				e.printStackTrace();
				System.exit(-1);
			}
		}
		
		
	}
	
	



}