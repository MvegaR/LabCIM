package app;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class ServidorEsclavo extends Thread{

    private String[] valor;
    private Socket so;
    private DataOutputStream salida; // respuesta que se le dara al cliente, en este caso segun el ws su dato probabilistico  
    private String mensajeRecibido ="";
    private DataInputStream entrada;

    public ServidorEsclavo(Socket so, String[] datos) {
	
	this.so = so;
	this.valor = datos;
    }

    @Override
    public void run() {
	try {
	System.out.println("Un cliente se ha conectado.");
	entrada = new DataInputStream(so.getInputStream());
	salida = new DataOutputStream(so.getOutputStream());
	System.out.println("Confirmando conexion al cliente....");
	mensajeRecibido = entrada.readUTF();  // no necesito una segunda respuesta del cliente solo la primera con su  id

	if("1".equals(mensajeRecibido)){
	    salida.writeUTF(valor[0]);  // aca deberia mandar el dato correspondiente al cliente

	}
	if("2".equals(mensajeRecibido)){
	    salida.writeUTF(valor[1]+","+valor[2]+","+valor[3]);  // aca deberia mandar el dato correspondiente al cliente
	}
	if("3".equals(mensajeRecibido)){
	    salida.writeUTF(valor[4]+","+valor[5]);  // aca deberia mandar el dato correspondiente al cliente
	}
	if("4".equals(mensajeRecibido)){
	    salida.writeUTF(valor[6]);  // aca deberia mandar el dato correspondiente al cliente
	}
	System.out.println(mensajeRecibido);    

	System.out.println("Cerrando conexión...");
	so.close();//Aqui se cierra la conexión con el cliente
	    
	} catch (Exception e) {
	    e.getStackTrace();
	}

    }




}
