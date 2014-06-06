import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Start {

	int liczbaPasazerow;
	static int liczbaPieter;
	int liczbaWind;
	
	List<Elevator> listaWind = new ArrayList<Elevator>();
	List<Thread> watkiWind = new ArrayList<Thread>();

	
	public void setup(){
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Podaj liczbe pasazerow : ");
		liczbaPasazerow = s.nextInt();
		
		System.out.println("Podaj liczbe pieter : ");
		liczbaPieter = s.nextInt();
		
		System.out.println("Podaj liczbe wind (podzielna przez 3 stworzy tyle samo wind kazdego rozaju) : ");
		liczbaWind = s.nextInt();
		
	
		System.out.println(" | Winda     | pietro | osoby w windzie |");
		System.out.println("----------------------------------------------");
		// dodanie nazw do wind
		for(int i = 0; i < liczbaWind; i++){

			listaWind.add(new Elevator((i%3)+1));
			listaWind.get(i).setName(" | Winda " + ((i%3)+1) + "." + ((i+1)/4) + " | ");
		}
		
		for(int i = 0; i < liczbaWind; i++){
			
			watkiWind.add(new Thread(listaWind.get(i)));
		}
		
		for(int i = 0; i < liczbaWind; i++){
			watkiWind.get(i).start();
		}
		
	}
}
