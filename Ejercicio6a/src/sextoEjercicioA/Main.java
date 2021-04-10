package sextoEjercicioA;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {

	static Scanner input = new Scanner(System.in);
	static int SIZE = 5;

	private static ArrayList<Integer> getEnteros(ArrayList<Integer> enteros) {

		for (int i = 0; i < SIZE; i++) {
			enteros.add(input.nextInt());
		}
		;

		return enteros;
	};

	private static ArrayList<Integer> getMayores(int entero, ArrayList<Integer> enteros) {

		ArrayList<Integer> tempArray = new ArrayList<Integer>();

		int counter = 0;

		for (int i = 0; i < SIZE; i++) {

			if (enteros.get(i) > entero) {
				tempArray.add(enteros.get(i));
				counter += 1;
			}
			;
		}
		;

		return tempArray;
	};

	private static void mostrarMayores(ArrayList<Integer> mayoresAEntero) {

		for (int entero : mayoresAEntero) {

			System.out.println(entero);

		}
		;
	};

	public static void main(String[] args) {

		int entero = input.nextInt();
		ArrayList<Integer> enteros = new ArrayList<Integer>();
		ArrayList<Integer> mayoresAEntero = new ArrayList<Integer>();
		enteros = getEnteros(enteros);
		mayoresAEntero = getMayores(entero, enteros);
		mostrarMayores(mayoresAEntero);

	}

}
