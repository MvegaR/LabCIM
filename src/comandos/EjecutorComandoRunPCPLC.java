package comandos;

import puertoSerial.PuertoSerial;

public class EjecutorComandoRunPCPLC extends Thread {
	
	private String primero, segundo, tercero, cuarto, quinto, sexto, id;
	private PuertoSerial thePort;
	private final Integer MINUTOS = 5; //Tiempo maximo de espera en minutos.
	
	
	public EjecutorComandoRunPCPLC(String id, String primero, String segundo, String tercero, 
			String cuarto, String quinto, String sexto, PuertoSerial thePort) {
		this.primero = primero; //Part ID
		this.segundo = segundo; //Source ID
		this.tercero = tercero; //Source Index
		this.cuarto = cuarto; //Target ID
		this.quinto = quinto; //Target Index
		this.sexto = sexto; //Note (Speed)
		this.thePort = thePort;
		this.id = id;
	}
	
	public PuertoSerial getThePort() {
		return thePort;
	}
		
	private synchronized void comandoRunPcplc(String id){
		if(isNumber(primero) && isNumber(segundo) && isNumber(tercero) && isNumber(cuarto) 
				&& isNumber(quinto) && isNumber(sexto)){
			try{
			    	long tiempoInicial = System.currentTimeMillis();
			    
				getThePort().getEscritor().enviarComando("run pcplc");
				if(id.length() != 6){
				    System.out.println("Id no valido, se usará 111111");
				}
				getThePort().getEscritor().enviarComando("111111");

				getThePort().getEscritor().enviarComando(primero);

				getThePort().getEscritor().enviarComando(segundo);

				getThePort().getEscritor().enviarComando(tercero);

				getThePort().getEscritor().enviarComando(cuarto);

				getThePort().getEscritor().enviarComando(quinto);

				getThePort().getEscritor().enviarComando(sexto);

				getThePort().getEscritor().enviarComando("");

				if(segundo.length() == 3){
					getThePort().getEscritor().enviarComando("run gt"+segundo);
				}else if(segundo.length() == 2){
					getThePort().getEscritor().enviarComando("run gt0"+segundo);
				}else if(segundo.length() == 1){
					getThePort().getEscritor().enviarComando("run gt00"+segundo);
				}else{
				    System.out.println("Error en RunPCPlc valor fuera de rango");
				    return;
				}
			
				while(!getThePort().getLector().searchEventoLinea("%START 111111")){
				    	if(getThePort().getLector().searchEventoLinea("(53) *** IMPACT PROTECTION axis 2")){
				    	    getThePort().getLector().usarLinea("(53) *** IMPACT PROTECTION axis 2");
				    	    System.out.println("Se detiene RUNPCPLC por IMPACT PROTECTION axis 2");
				    	    return;
				    	}else if(minutos(tiempoInicial) >= MINUTOS){
				    	    System.out.println("Comando RunPCPlc: Tiempo de "+MINUTOS+" minutos terminado.");
				    	    return;
				    	}
					this.wait(300);
				}
				getThePort().getLector().usarLinea("%START 111111");
				
				//getThePort().getEscritor().enviarComando(""); //Da error, pero continua normal. ver que sucede.
				
				if(cuarto.length() == 3){
					getThePort().getEscritor().enviarComando("run pt"+cuarto);
				}else if(cuarto.length() == 2){
					getThePort().getEscritor().enviarComando("run pt0"+cuarto);
				}else if(cuarto.length() == 1){
					getThePort().getEscritor().enviarComando("run pt00"+cuarto);
				}else{
				    System.out.println("Error en RunPCPlc valor fuera de rango");
				    return;
				}
				
				while(!getThePort().getLector().searchEventoLinea("%END 111111")){
				  	if(getThePort().getLector().searchEventoLinea("(53) *** IMPACT PROTECTION axis 2")){
				    	    getThePort().getLector().usarLinea("(53) *** IMPACT PROTECTION axis 2");
				    	    System.out.println("Se detiene RUNPCPLC por IMPACT PROTECTION axis 2");
				    	    return;
				    	}else if(minutos(tiempoInicial) >= MINUTOS){
				    	    System.out.println("Comando RunPCPlc: Tiempo de "+MINUTOS+" minutos terminado.");
				    	    return;
				    	}
					this.wait(300);
				}
				getThePort().getLector().usarLinea("%END 111111");
				getThePort().getEscritor().enviarComando("");
				
			}catch(Exception e){
				e.printStackTrace();
			}
		}else{
			System.out.println("Error en los parametros para comandoRunPclc, no son valores validos");
		}
	}
	
	public static long minutos(long miliTiempoInicial){
	    return ((System.currentTimeMillis()-miliTiempoInicial)/1000)/60;
	}
	
	public static long segundos(long miliTiempoInicial){
	    return ((System.currentTimeMillis()-miliTiempoInicial)/1000);
	}
	
	public static long horas(long miliTiempoInicial){
	    return ((System.currentTimeMillis()-miliTiempoInicial)/1000)/(60*60);
	}
	
	private static boolean isNumber(String n) {
		try {
			Integer.parseInt(n);
			return true;
		} catch (NumberFormatException nfe) {
			return false;
		}
	}

	@Override
	public void run() {
		comandoRunPcplc(id);
	}
}
