package sextoEjercicioB;

public class Vendedor extends Empleado {

	private static int porcenComision;
	private int totalVentas;
	public static int getPorcenComision() {
		return porcenComision;
	}
	public static void setPorcenComision(int porcenComision) {
		Vendedor.porcenComision = porcenComision;
	}
	public int getTotalVentas() {
		return totalVentas;
	}
	public void setTotalVentas(int totalVentas) {
		this.totalVentas = totalVentas;
	}
	
	public double getSueldo() {
		
		return getSueldoBase() + (getPorcenComision() * getTotalVentas()/100);
	}
}
