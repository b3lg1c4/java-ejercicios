package quintoEjercicio;

import java.util.Scanner;

public class Main {

	private static Scanner stringScanner = new Scanner(System.in);
	private static Scanner intScanner = new Scanner(System.in);

	private static int SIZE = 5;
	private static double sueldoBase = 20000;
	private static int porcenComision = 30;

	private static void inicializarDatos() {
		Empleado.setSueldoBase(sueldoBase);
		Vendedor.setPorcenComision(porcenComision);
	};

	private static void cargarEmpleadoBasico(Empleado emp) {
		System.out.println("Nombre:");
		emp.setNombre(stringScanner.nextLine());
		System.out.println("Apellido:");
		emp.setApellido(stringScanner.nextLine());
		System.out.println("Email:");
		emp.setEmail(stringScanner.nextLine());
		System.out.println("DNI:");
		emp.setDni(stringScanner.nextLine());

	};

	private static void cargarVendedor(Vendedor vendedor) {
		System.out.println("Total Ventas:");
		int ventas = intScanner.nextInt();
		vendedor.setTotalVentas(ventas);
	};

	private static void cargarAdministrativo(Administrativo administrativo) {

		System.out.println("Horas Extra:");
		administrativo.setHsExtra(intScanner.nextInt());
		System.out.println("Horas Mes:");
		administrativo.setHsMes(intScanner.nextInt());
	};

	private static Empleado[] cargarEmpleados(Empleado[] empleados) {

		int option = 0;
		int i = 0;

		do {

			System.out.println("1-Cargar Vendedor 2-Cargar Administrativo 3-Dejar de cargar");
			option = intScanner.nextInt();
			if (option >= 1 && option <= 3) {
				if (option == 1) {
					Vendedor vendedor = new Vendedor();
					cargarEmpleadoBasico(vendedor);
					cargarVendedor(vendedor);
					empleados[i] = vendedor;

				} else if (option == 2) {

					Administrativo administrativo = new Administrativo();
					cargarEmpleadoBasico(administrativo);
					cargarAdministrativo(administrativo);
					empleados[i] = administrativo;
				}
				;

				i += 1;

			}
			;

		} while (i < SIZE && option != 3);

		return empleados;
	};

	private static void mostrarEmpleados(Empleado[] empleados) {
		for (Empleado empleado : empleados) {
			try {
				System.out.println(empleado.getDni());
				System.out.println(empleado.getNombre());
				System.out.println(empleado.getApellido());
				System.out.println(empleado.getSueldo());
				System.out.println("----------------------------");
			}

			catch (Exception e) {

			}

		}
		;
	};

	public static void main(String[] args) {

		Empleado[] empleados = new Empleado[SIZE];

		inicializarDatos();

		empleados = cargarEmpleados(empleados);
		mostrarEmpleados(empleados);
	}

}
