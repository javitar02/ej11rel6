package ej6;

import java.util.Scanner;

public class PrincipalDiccionario {
	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		Diccionario diccionario = new Diccionario();
		int opcion;

		do {
			opcion = mostrarMenu();
			tratarMenu(opcion, diccionario);
		} while (opcion!=5);

	}

	private static int mostrarMenu() {
		int opcion;

		System.out.println("BIENVENIDO AL DICCIONARIO");
		System.out.println("1.Anadir palabra");
		System.out.println("2.Buscar palabra");
		System.out.println("3.Borrar palabra");
		System.out.println("4.Listado de palabras que comiencen por una cadena");
		System.out.println("5.Salir");

		System.out.println("Introduce una opcion: ");
		opcion = Integer.parseInt(teclado.nextLine());

		return opcion;
	}

	private static void tratarMenu(int opcion, Diccionario diccionario) {
		String palabra, significado;
		try {
			switch (opcion) {
			case 1:
				palabra = solicitarPalabra();
				significado = solicitarSignificado();

				diccionario.annadirPalabra(palabra, significado);
				break;

			case 2:
				palabra = solicitarPalabra();
				System.out.println( diccionario.buscarPalabra(palabra));

				
				break;

			case 3:
				String palabraABuscar=solicitarPalabra();
				
				diccionario.borrarPalabra(palabraABuscar);
				break;

			case 4:
				String cadena=solicitarPalabra();
				cadena=teclado.nextLine();
				
				diccionario.listarPalabrasEmpezadasPorCadena(cadena);
				break;
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

	public static String solicitarSignificado() {
		String significado;
		System.out.println("Introduce su significado: ");
		significado = teclado.nextLine();
		return significado;
	}

	public static String solicitarPalabra() {
		String palabra;
		System.out.println("Introduce la palabra: ");
		palabra = teclado.nextLine();
		return palabra;
	}

}
