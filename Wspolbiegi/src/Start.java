import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.ReentrantLock;


public class Start {

	public static int liczbaPasazerow;
	public static int liczbaPieter;
	public static int liczbaWind;
	
	
	
	static Queue[] kolejkaIn; // tablica kolejek osob wsiadajacych na danym pietrze
	static Queue[] kolejkaOut; // tablica kolejek osob wysiadajacych na danym pietrze
	 
	
	List<Elevator> listaWind = new ArrayList<Elevator>();
	List<Thread> watkiWind = new ArrayList<Thread>();
	
	List<Person> listaOsob = new ArrayList<Person>();
	List<Thread> watkiOsob = new ArrayList<Thread>();

	
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
		
		
		kolejkaOut = new Queue[Start.liczbaPieter];
		kolejkaIn = new Queue[Start.liczbaPieter];
		
		for (int i=0; i< kolejkaOut.length; i++)
		{
			kolejkaOut[i] = new LinkedBlockingQueue<Person>(); // kazde pietro ma swoja kolejke osob
			kolejkaIn[i] = new LinkedBlockingQueue<Person>(); // wsiadajacych i wysiadajacych
			
		}
		
	
		
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
		
		/*
		for(int i = 0; i < liczbaPasazerow; i++){
			listaOsob.add(new Person());
			listaOsob.get(i).setName(""+i);
		}
		
		for(int i = 0; i < liczbaPasazerow; i++){
			watkiOsob.add(new Thread(listaOsob.get(i)));
		}
		
		for(int i = 0; i < liczbaPasazerow; i++){
			watkiOsob.get(i).start();
		} */
	} 
}
