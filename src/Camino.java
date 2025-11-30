import java.util.Random;

public class Camino {
	private int recorrido;
	private int posCharco;
	private int inicioTunel;
	private int finTunel;
	private boolean tunelOcupado=false;
	
	public Camino(int recorrido, int posCharco, int inicioTunel, int finTunel) {
		this.recorrido= recorrido;
		this.posCharco= posCharco;
		this.inicioTunel = inicioTunel;
		this.finTunel= finTunel;
	};
	
	
	public int getRecorrido() {
		return recorrido;
	}
	
	public void setRecorrido(int recorrido) {
		this.recorrido = recorrido;
	}
	
	public int getPosCharco() {
		return posCharco;
	}
	
	public void setPosCharco(int posCharco) {
		this.posCharco = posCharco;
	}
	
	
	public boolean isTunelOcupado() {
		return tunelOcupado;
	}


	public void setTunelOcupado(boolean tunelOcupado) {
		this.tunelOcupado = tunelOcupado;
	}


	public int getInicioTunel() {
		return inicioTunel;
	}
	
	public void setInicioTunel(int inicioTunel) {
		this.inicioTunel = inicioTunel;
	}
	
	public int getFinTunel() {
		return finTunel;
	}

	public void setFinTunel(int finTunel) {
		this.finTunel = finTunel;
	}

	public boolean hayCharco(double posicion) {
		if(posicion != 0 &&posicion%posCharco==0) {
			return true;
		}else {
			return false;
		}
	}
	public boolean generarViento() {
		Random r = new Random();
		return r.nextBoolean();
	}
	public void entrarTunel(Animal animal) {
	    synchronized (this) {

	        while (tunelOcupado) {
	            try {
	                this.wait();
	            } catch (InterruptedException e) {}
	        }

	        tunelOcupado = true;
	        System.out.println(animal.getNombre() + " ENTRA EN EL TUNEL");
	    }
	}
	
	public void salirTunel(Animal animal) {
	    synchronized (this) {

	        tunelOcupado = false;
	        System.out.println(animal.getNombre() + " SALE DEL TUNEL");

	        this.notify();
	    }
	}
	

}
