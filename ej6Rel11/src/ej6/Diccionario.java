package ej6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;


import ej6.EntradaDiccionario;

public class Diccionario {

	private HashMap<String, EntradaDiccionario> mapDiccionario;

	public Diccionario() {
		mapDiccionario = new HashMap<String, EntradaDiccionario>();
	}

	public void annadirPalabra(String palabra, String significado) throws DiccionarioException{
		EntradaDiccionario entradaExistente=mapDiccionario.get(palabra);
		
		if(entradaExistente==null) {
			EntradaDiccionario entr=new EntradaDiccionario(palabra, significado);
			mapDiccionario.put(significado, entr);
		}
		
		entradaExistente.annadirSignificado(significado);
	}

	public EntradaDiccionario buscarPalabra(String palabraABuscar) throws DiccionarioException {
		EntradaDiccionario buscarPalabra;
		
		buscarPalabra=mapDiccionario.get(palabraABuscar);
		
		if(buscarPalabra==null) {
			throw new DiccionarioException("Error, no existe esa palabra");
		}
		
		return buscarPalabra;
	}

	public void borrarPalabra(String palabraABuscar) throws DiccionarioException {
		
		if(mapDiccionario.remove(palabraABuscar)==null) {
			throw new DiccionarioException("No se ha borrado la palabra "+palabraABuscar);
		}
		
		
	}

	public ArrayList<String> listarPalabrasEmpezadasPorCadena(String cadena) {
		ArrayList<String> palabras=new ArrayList<String>();
		
		for(EntradaDiccionario otro: mapDiccionario.values())	{
			if(otro.getPalabra().startsWith(cadena)) {
				palabras.add(otro.getPalabra());
			}
		
		}
			Collections.sort(palabras);
			return palabras;
		}
	
	public String palabrasConMasDeUnSignificado () {
		StringBuilder sb=new StringBuilder();
		
		for(EntradaDiccionario otro: mapDiccionario.values()) {
			if(otro.getListaSignificados().size()>1) {
				sb.append( otro.getPalabra()+"\n");
			}
		}
		
		return sb.toString();
	}
	
	public EntradaDiccionario primeraEntradaQueEmpiezaPor(String comienzo) throws DiccionarioException {
		ArrayList<EntradaDiccionario> entradas=new ArrayList<EntradaDiccionario>();
		
		for(EntradaDiccionario otro:mapDiccionario.values()) {
			if(otro.getPalabra().startsWith(comienzo)) {
				entradas.add(otro);
			}
		}
		
		Collections.sort(entradas);
		
		if(entradas.size()==0) {
			throw new DiccionarioException("Error, no hay ninguna palabra que empieze por "+comienzo);
		}
		
		
		return entradas.get(0);
		
	}
	
	
}
