
public class Tortuga extends Animal{
 
	public Tortuga(){
		super ("Tortuga",2);	
	}
	
	@Override
	protected void moverse() {

		this.posicion=this.posicion + this.velocidad;
		mostrarPosicion();
		
	}

	@Override
	protected void mostrarPosicion() {
		System.out.println("La posición de "+nombre+ ": "+posicion);
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	@Override
	protected void pisarCharco() {
		System.out.println(nombre + " ha pisado un charco");
		this.posicion=this.posicion+ 3;
		mostrarPosicion();
	}


	
}