package tercerEjercicio;

import java.util.Scanner;

public class Main {

	private static Scanner input = new Scanner(System.in);

	private static String[] getPalabras(String[] palabras) {

		for (int i = 0; i < 10; i++) {
			System.out.println("Ingrese palabra: " + i);
			palabras[i] = input.nextLine();
		}
		;

		return palabras;

	};

	private static void buscarPalabra(String palabraAComparar, String[] palabras) {

		boolean encontrado = false;
		int i = 0;

		while (i < palabras.length && encontrado == false) {
			if (palabras[i].equals(palabraAComparar)) {
				encontrado = true;
			}
			;

			i += 1;
		}
		;

		if (encontrado) {
			System.out.println("La palabra " + palabraAComparar + " existe en el array");
		} else {
			System.out.println("La palabra " + palabraAComparar + " NO existe en el array");
		}
		;

	};

	public static void main(String[] args) {
		String[] palabras = new String[10];
		String palabraAComparar;
		palabras = getPalabras(palabras);
		palabraAComparar = input.nextLine();
		buscarPalabra(palabraAComparar, palabras);

	}

}
