
public class Liebre extends Animal{
	private boolean estaDormida;
	private int contador;
	public Liebre() {
		super("Liebre",5);
	}

	@Override
	protected void moverse() {
		if(estaDormida) {
			contador++;
			mostrarPosicion();
			if(hayViento || contador>=14) {
				estaDormida = false;
				System.out.println("La liebre se despertó");
				contador=0;
			}
		}else {
			posicion = posicion+velocidad;
			mostrarPosicion();
			contador++;
			if(contador>4) {
				estaDormida=true;
				System.out.println("La libre se durmió");
			}
				
		}
		
	}

	@Override
	protected void mostrarPosicion() {
		
		if(!estaDormida) {
			System.out.println("La posición de "+nombre+ ": "+posicion);
		}else {
			System.out.println("La liebre está dormida..." +(contador-4)+ "en la posicion"+posicion);
			
		}

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void pisarCharco() {
		
			System.out.println(nombre + " ha pisado un charco en el metro:"+posicion+". Pierde 5 segundos");

			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			moverse();
			
		
		
	}

}


