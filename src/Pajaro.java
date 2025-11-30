import java.util.Random;

public class Pajaro extends Animal{
	private boolean estaVolando;
	
	
	public Pajaro() {
		super("Pajaro", 3);
		
	}

	@Override
	protected void moverse() {
		estaVolando();
		if(!estaEnElTunel) {
			if(estaVolando) {
				Random r = new Random();
				if(hayViento) {
					if(r.nextBoolean()) {
						posicion = posicion+10;
					}else {
						posicion = posicion-10;
					}
				}else {
					if(r.nextBoolean()) {
						posicion = posicion+5;
					}else {
						posicion = posicion-5;
					}
				}
				
			}else {
				posicion = posicion+velocidad;
			}	
		}else {
			posicion = posicion+velocidad;
		}
		
		
		mostrarPosicion();	
	}

	@Override
	protected void mostrarPosicion() {
		System.out.println(nombre + " está volando: "+ estaVolando+". Hay viento:" +hayViento+". La posición de "+nombre+ ": "+posicion);

	
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void pisarCharco() {
		estaVolando();
		if(!estaVolando) {
			System.out.println(nombre + " ha pisado un charco en el metro:"+posicion+". Pierde 5 segundos");
			
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			moverse();
			mostrarPosicion();
			
		}
		
	}
	private void estaVolando() {
		Random r = new Random();
		estaVolando = r.nextBoolean();
	}




}
