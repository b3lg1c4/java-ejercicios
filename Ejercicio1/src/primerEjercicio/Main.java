package primerEjercicio;

import java.util.Scanner;

public class Main {
	
	private static void mostrarEnteros() {
		
		for(int i=1;i<=10;i++) {
			System.out.println(i);
		};
	};
	
	private static void mostrarImpares() {
		
		int i=1;
		int imparContador = 0;
		
		while(imparContador < 10) {
			if(i%2 != 0) {
				System.out.println(i);
				imparContador+=1;
			};
			i+=1;
			
		};
	};

	public static void main(String[] args) {
		
		System.out.println("Primeros 10 enteros");
		System.out.println("-------------------");
		
		mostrarEnteros();
		
		System.out.println("\nPrimeros 10 impares");
		System.out.println("--------------------");
		
		mostrarImpares();

	}

}
