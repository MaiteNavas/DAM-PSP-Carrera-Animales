import java.util.ArrayList;


public class Main {

	public static void main(String[] args) {
		
		Animal tortuga = new Tortuga();
		Animal liebre = new Liebre();
		Animal pajaro = new Pajaro();
		
		ArrayList<Animal> listaAnimales= new ArrayList<Animal>();
		listaAnimales.add(tortuga);
		listaAnimales.add(liebre);
		listaAnimales.add(pajaro);
		
		Camino camino = new Camino(150, 10, 50, 100);
		Carrera carrera = new Carrera(camino, listaAnimales);
		carrera.comenzarCarrera();


	}

}
