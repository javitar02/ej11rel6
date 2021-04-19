package ej6;

public class dasd {

	public static void main(String[] args) {
		
		Diccionario d1=new Diccionario();
		
		try {
			d1.annadirPalabra("Banco","Lugar donde se sientan las personas");
			d1.primeraEntradaQueEmpiezaPor("Lugar");
		} catch (DiccionarioException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}

	}

}
