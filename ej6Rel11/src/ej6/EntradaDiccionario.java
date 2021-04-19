package ej6;

import java.util.HashSet;


public class EntradaDiccionario implements Comparable<EntradaDiccionario> {

	private String palabra;
	private HashSet<String> listaSignificados;

	public EntradaDiccionario(String palabra, String significado) {

		this.palabra = palabra;
		listaSignificados = new HashSet<String>();
		listaSignificados.add(significado);
	}

	public String getPalabra() {
		return palabra;
	}

	public HashSet<String> getListaSignificados() {
		return listaSignificados;
	}

	public void annadirSignificado(String nuevoSignificado) throws DiccionarioException{
			if(listaSignificados.contains(nuevoSignificado)) {
				throw new DiccionarioException("Error, significado ya añadido");
			}
			listaSignificados.add(nuevoSignificado);
		}

	@Override
	public int compareTo(EntradaDiccionario o) {

		return this.palabra.compareTo(o.getPalabra());
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("Entrada diccionario: " + palabra + " listaSignificados: " + listaSignificados);

		for (String significado : listaSignificados) {
			sb.append(significado + "\n");
		}

		return sb.toString();
	}
	
	
	public int numeroDeSignificados() {
		
		return listaSignificados.size();
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((listaSignificados == null) ? 0 : listaSignificados.hashCode());
		result = prime * result + ((palabra == null) ? 0 : palabra.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EntradaDiccionario other = (EntradaDiccionario) obj;
		if (listaSignificados == null) {
			if (other.listaSignificados != null)
				return false;
		} else if (!listaSignificados.equals(other.listaSignificados))
			return false;
		if (palabra == null) {
			if (other.palabra != null)
				return false;
		} else if (!palabra.equals(other.palabra))
			return false;
		return true;
	}

}
