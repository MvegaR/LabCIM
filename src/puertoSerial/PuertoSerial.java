package puertoSerial;

import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Enumeration;

/**
 * Esta clase entrega los métodos para la conexión con un puerto serial,
 * se tiene un constructor por defecto con las configuraciones del brazo del laboratorio
 * y un constructor para el envío de las configuraciones personalizadas.
 * una vez conectado el puerto se debe de llamar al método connect, pasándole como argumento
 * el nombre del puerto, se pueden obtener con el metodo de enumerarPuertos que entrega un arreglo
 * de object, (String). 
 */

public class PuertoSerial
{

    private String bitPorSegundo;
    private String bitDeDatos;
    private String paridad;
    private String bitDeParada;
    private String control;
    private InputStream in;
    private OutputStream out;
    private SerialPort serialPort;
    private LectorSerial lector;
    private EscritorSerial escritor;

    public PuertoSerial(){
	//Default
	this.bitPorSegundo = "9600";
	this.bitDeDatos = "8";
	this.paridad = "Ninguno";
	this.bitDeParada = "1";
	this.control = "Nunguno";
    }

    public PuertoSerial(String bitPorSegundo, String bitDeDatos, String paridad, String bitDeParada, String control){
	this.bitPorSegundo = bitPorSegundo;
	this.bitDeDatos = bitDeDatos;
	this.paridad = paridad;
	this.bitDeParada = bitDeParada;
	this.control = control;

    }



    public void connect ( String portName ) throws Exception{



	if(!portName.equals("")){

	    CommPortIdentifier portIdentifier = CommPortIdentifier.getPortIdentifier(portName);
	    if ( portIdentifier.isCurrentlyOwned() )
	    {
		System.out.println("Error: No se encuentra el puerto o está en uso.");
	    }
	    else
	    {
		CommPort commPort = portIdentifier.open(this.getClass().getName(),2000);

		if ( commPort instanceof SerialPort )
		{
		    serialPort = (SerialPort) commPort;
		    Integer var1 = Integer.parseInt(bitDeDatos);
		    switch (var1) {
		    case 5: var1 = SerialPort.DATABITS_5; break;
		    case 6: var1 = SerialPort.DATABITS_6; break;
		    case 7: var1 = SerialPort.DATABITS_7; break;
		    case 8: default: var1 = SerialPort.DATABITS_8; break;
		    }

		    Integer var2;
		    switch (bitDeParada) {
		    case "1": var2 = SerialPort.STOPBITS_1; break;
		    case "1.5": var2 = SerialPort.STOPBITS_1_5; break;
		    case "2": default: var2 = SerialPort.STOPBITS_2; break;
		    }

		    Integer var3;
		    switch (paridad) {
		    case "Par": var3 = SerialPort.PARITY_EVEN; break;
		    case "Impar": var3 = SerialPort.PARITY_ODD; break;
		    case "Ninguno":  default: var3 = SerialPort.PARITY_NONE; break;
		    case "Marca": var3 = SerialPort.PARITY_MARK; break;
		    case "Espacio": var3 = SerialPort.PARITY_SPACE; break;
		    }


		    serialPort.setSerialPortParams(Integer.parseInt(bitPorSegundo), var1, var2, var3);
		    if(control.equals("Xon / Xoff")){
			serialPort.setFlowControlMode(SerialPort.FLOWCONTROL_XONXOFF_IN | SerialPort.FLOWCONTROL_XONXOFF_OUT);
		    }else if(control.equals("Hardware")){
			serialPort.setFlowControlMode(SerialPort.FLOWCONTROL_RTSCTS_IN | SerialPort.FLOWCONTROL_RTSCTS_OUT);
		    }else{
			serialPort.setFlowControlMode(SerialPort.FLOWCONTROL_NONE);
		    }

		    in = serialPort.getInputStream();
		    out = serialPort.getOutputStream();
		    this.lector = new LectorSerial(this);
		    serialPort.addEventListener(lector);
		    serialPort.notifyOnDataAvailable(true);

		    escritor = new EscritorSerial(this);

		}
		else{
		    System.out.println("Error: Solamente se pueden manejar puertos seriales.");
		}
	    }     

	}else{
	    System.out.println("Error nombre del puerto");
	}
    }

    public InputStream getIn() {
	return in;
    }

    public OutputStream getOut() {
	return out;
    }

    public EscritorSerial getEscritor(){
	return this.escritor;
    }

    public void desconectarPuerto(){
	try {
	    if(serialPort != null){
		serialPort.removeEventListener();
		serialPort.close();            
		in.close();
		out.close();
	    }
	} catch (IOException ex) {

	}
	if(serialPort != null)
	    serialPort.close();
    }	

    public LectorSerial getLector() {
	return lector;
    }

    public static Object[] enumerarPuertos(){
	//enumerar los puertos disponibles en el sistema.
	Enumeration<?> listaPuertos = CommPortIdentifier.getPortIdentifiers();

	ArrayList<String> nombres = new ArrayList<>();
	nombres.add("");
	while (listaPuertos.hasMoreElements()) {
	    CommPortIdentifier idPuerto = (CommPortIdentifier) listaPuertos.nextElement();
	    nombres.add(idPuerto.getName());
	}
	return nombres.toArray();

    }

   /* public static void copiarControladores(){ // para intentar una copia automatica de los controladores para RXTX
    //No funciona ya que en windows u otros sistemas se requieren permisos administrativos del ejecutable.
	//Puede hacerlo manualmente, si no funciona.
	URL origen1 = null;
	URL origen2 = null;
	File archivo1 = null;
	File archivo2 = null;
	Path o1;
	Path o2;
	String destino = System.getProperty("java.home").toString()+System.getProperty("file.separator").toString()+"bin"+System.getProperty("file.separator").toString();
	Path d;
	if(System.getProperty("os.name").toString().contains("Windows")){
	    if(System.getProperty("os.arch").toString().contains("64")){
		origen1 = PuertoSerial.class.getResource("/controladores/windows/64bits/rxtxParallel.dll");
		origen2 = PuertoSerial.class.getResource("/controladores/windows/64bits/rxtxSerial.dll");
		archivo1 = new File(origen1.getFile());
		archivo2 = new File(origen1.getFile());
	    }else{
		origen1 = PuertoSerial.class.getResource("/controladores/windows/32bits/rxtxParallel.dll");
		origen2 = PuertoSerial.class.getResource("/controladores/windows/32bits/rxtxSerial.dll");
		archivo1 = new File(origen1.getFile());
		archivo2 = new File(origen1.getFile());
	    }
	}else if(System.getProperty("os.name").toString().contains("Linux")){
	    if(System.getProperty("os.arch").toString().contains("64")){
		origen1 = PuertoSerial.class.getResource("/controladores/linux/64bits/rxtxParallel.so");
		origen2 = PuertoSerial.class.getResource("/controladores/linux/64bits/rxtxSerial.so");
		archivo1 = new File(origen1.getFile());
		archivo2 = new File(origen1.getFile());
	    }else{
		origen1 = PuertoSerial.class.getResource("/controladores/linux/32bits/rxtxParallel.so");
		origen2 = PuertoSerial.class.getResource("/controladores/linux/32bits/rxtxSerial.so");
		archivo1 = new File(origen1.getFile());
		archivo2 = new File(origen1.getFile());
	    }

	}else if(System.getProperty("os.name").toString().contains("Mac")){
		origen1 = PuertoSerial.class.getResource("/controladores/mac/32bits/rxtxParallel.so");
		origen2 = PuertoSerial.class.getResource("/controladores/mac/32bits/rxtxSerial.so");
		archivo1 = new File(origen1.getFile());
		archivo2 = new File(origen1.getFile());

	}
	if(origen1 != null && origen2 != null){
	    o1 = Paths.get(archivo1.getPath());
	    o2 = Paths.get(archivo2.getPath());
	    d = Paths.get(destino);
	    System.out.println("o1: "+ o1);
	    System.out.println("o2: "+ o2);
	    System.out.println("d: "+ d);
	    CopyOption[] options = new CopyOption[]{
		          StandardCopyOption.REPLACE_EXISTING,
		          StandardCopyOption.COPY_ATTRIBUTES
		        }; 
	    try {
		Files.copy(o1, d, options);
		Files.copy(o2, d, options);
	    } catch (Exception e) {
		e.getMessage();
	    }

	}
    } */





}