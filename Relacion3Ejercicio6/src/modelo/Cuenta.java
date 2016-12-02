package modelo;

public class Cuenta {
	
	private String numCuenta;
	private double saldo;
	
	public Cuenta(String numCuenta, double saldo){
		
		this.numCuenta = numCuenta;
		this.saldo = saldo;
		
	}
	
	public String getNumCuenta() {
		return numCuenta;
	}
	public void setNumCuenta(String numCuenta) {
		this.numCuenta = numCuenta;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Cuenta [Numero Cuenta: " + numCuenta + ", Saldo: " + saldo + "]" ;
	}

}
