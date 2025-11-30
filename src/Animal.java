public abstract class Animal implements Runnable{
	protected String nombre;
	protected double velocidad;
	protected double posicion;
	protected boolean estaEnElTunel;
	protected boolean hayViento;
	
	public Animal(String nombre, double velocidad) {
		this.nombre = nombre;
		this.velocidad = velocidad;
		this.posicion = 0;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(double velocidad) {
		this.velocidad = velocidad;
	}

	public double getPosicion() {
		return posicion;
	}

	public void setPosicion(double posicion) {
		this.posicion = posicion;
	}
	
	
	
	public boolean isEstaEnElTunel() {
		return estaEnElTunel;
	}

	public void setEstaEnElTunel(boolean estaEnElTunel) {
		this.estaEnElTunel = estaEnElTunel;
	}

	abstract protected void moverse();
	abstract protected void pisarCharco();
	abstract protected void mostrarPosicion();
}
