package cuartoEjercicio;

import java.util.Scanner;

public class Main {

	static Scanner input = new Scanner(System.in);
	static int SIZE = 5;

	private static int[] getEnteros(int[] enteros) {

		for (int i = 0; i < SIZE; i++) {
			enteros[i] = input.nextInt();
		}
		;

		return enteros;
	};

	private static int[] getMayores(int entero, int[] enteros) {
		int[] tempArray = new int[SIZE];

		int counter = 0;

		for (int i = 0; i < SIZE; i++) {

			if (enteros[i] > entero) {
				tempArray[counter] = enteros[i];
				counter += 1;
			}
			;
		}
		;

		return tempArray;
	};

	private static void mostrarMayores(int[] mayoresAEntero) {

		for (int entero : mayoresAEntero) {
			if (entero != 0) {
				System.out.println(entero);
			}
			;

		}
		;
	};

	public static void main(String[] args) {

		int entero = input.nextInt();
		int[] enteros = new int[SIZE];
		int[] mayoresAEntero = new int[SIZE];
		enteros = getEnteros(enteros);
		mayoresAEntero = getMayores(entero, enteros);
		mostrarMayores(mayoresAEntero);

	}

}
