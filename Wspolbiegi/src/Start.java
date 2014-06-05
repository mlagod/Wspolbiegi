import java.util.Scanner;


public class Start {

	int liczbaPasazerow;
	static int liczbaPieter;
	int liczbaWind;
	
	public void setup(){
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Podaj liczbe pasazerow : ");
		liczbaPasazerow = s.nextInt();
		
		System.out.println("Podaj liczbe pieter (parzysta) : ");
		liczbaPieter = s.nextInt();
		
		System.out.println("Podaj liczbe wind (podzielna przez 3) : ");
		liczbaWind = s.nextInt();
		
	//	Thread watek1 = new Thread("winda 1");
		//Thread watek2 = new Thread("winda 2");
		
		Elevator e1 = new Elevator(1);
		e1.setName("| Winda 1 | ");
		
		Elevator e2 = new Elevator(2);
		e2.setName("| Winda 2 | ");
		
		Elevator e3 = new Elevator(3);
		e3.setName("| Winda 3 | ");
		
		Thread t1 = new Thread(e1);
		Thread t2 = new Thread(e2);
		Thread t3 = new Thread(e3);
		
		t1.start();
		t2.start();
		t3.start();
	}
}
