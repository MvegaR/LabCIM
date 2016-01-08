
package app;

import java.io.*;
import java.net.*;

/**
 *
 * @author Carlos
 */
public class Servidor implements Runnable{
    public String[] valor;
    final int puerto = 5000;
    static ServerSocket sc;
    //static Socket so;
   // static DataOutputStream salida; // respuesta que se le dara al cliente, en este caso segun el ws su dato probabilistico  
    //String mensajeRecibido ="";
   // static DataInputStream entrada;

    public void servidor(String [] datos) throws IOException{  // aca puse el throws  por el sc.close(); en el catch
	// se guardara aca lo que recivamos del cliente
	this.valor=datos;
	Thread hilo = new Thread(this);
	hilo.start();

    }
    @Override
    public void run() {
	try{
	    sc= new ServerSocket(puerto); //el puerto y cuantos clientes puede atender
	    while(true){
		System.out.println("Esperando una conexión:");
		new ServidorEsclavo(sc.accept(), valor).start();
	    } 
	} 

	catch(Exception e){
	    System.out.println("Error: "+e.getMessage());

	}

    }

}
