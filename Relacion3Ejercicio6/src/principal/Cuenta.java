package principal;

public class Cuenta {

	private int nCuenta;
	private int saldo;
	
	public Cuenta(int nCuenta, int saldo){
		super();
		this.nCuenta = nCuenta;
		this.saldo = saldo;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Cuenta [nCuenta=" + nCuenta + ", saldo=" + saldo + "]";
	}
	public void setnCuenta(int nCuenta) {
		this.nCuenta = nCuenta;
	}
	public int getnCuenta() {
		return nCuenta;
	}
	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}
	public int getSaldo() {
		return saldo;
	}
	
}
