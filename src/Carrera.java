import java.util.ArrayList;


public class Carrera {

	int posFinal=0;
	Camino camino;
	ArrayList<Animal> listaAnimales;
	public Carrera(Camino camino, ArrayList<Animal> listaAnimales) {
		this.camino = camino;
		this.listaAnimales = listaAnimales;
	}
	
	public void comenzarCarrera() {
		
		for(Animal animal: listaAnimales) {
			System.out.println("Comineza la carrera de: "+ animal.nombre+". Posicion de salida: " + animal.getPosicion());
			Thread hiloAnimal = new Thread(new Runnable() {
	            @Override
	            public void run() {
	                while (animal.getPosicion() < camino.getRecorrido()) {
	                	animal.hayViento = camino.generarViento();
	                	// Entrada al tunel
	                	if (!animal.isEstaEnElTunel() && animal.getPosicion() >= camino.getInicioTunel() && animal.getPosicion() <= camino.getFinTunel()) {
	                        camino.entrarTunel(animal);
	                        animal.setEstaEnElTunel(true);
	                        
	                    }
	                	// Moverse dentro del tunel
	                    if (animal.isEstaEnElTunel() && animal.getPosicion() <= camino.getFinTunel()) {
	                        animal.moverse();
	                        System.out.println(animal.getNombre() + " ESTÁ EN EL TÚNEL");
	                    }
	                    // Salida del tunel
	                    else if (animal.isEstaEnElTunel()&& animal.getPosicion() > camino.getFinTunel()) {
	                        camino.salirTunel(animal);
	                        animal.setEstaEnElTunel(false);
	                        animal.moverse();
	                    }
	                    
	                    // Moverse normal
	                    else {
		                    if(camino.hayCharco(animal.getPosicion())) {
		                    	animal.pisarCharco();	
		                    }else {
		                    	animal.moverse();
		                    }
	                    }
	                    try {
	                        Thread.sleep(1000);
	                    } catch (InterruptedException e) {
	                        e.printStackTrace();
	                    }
	                }
	                posFinal++;
	                System.out.println(animal.getNombre() + " LLEGÓ A LA META!!!!!!! Posicion: "+posFinal);
	            }
	        });

	        hiloAnimal.start();
		}
	}

	

	
}
