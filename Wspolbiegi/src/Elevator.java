
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;


public class Elevator extends Thread {

	int rodzaj; // 1, 2 lub 3
	int minFloor;
	int maxFloor; // pietro ograniczajace gorne dla windy
	int aktualnePietro = 0;
	final int FULL = 5; // tyle osob pomiesci winda
	int ileOsob = 0;
	Start s = new Start();
	//Person p;
	
	public int selfNumber=0;
	
	
	
	
	
	
	public Elevator(){
		
	}
	
	public Elevator(int id){
		rodzaj = id;

		
		if(id == 2){
			
			maxFloor = s.liczbaPieter;
			minFloor = (s.liczbaPieter/2)+1;
			
		}else if(id == 1){
			
			maxFloor = s.liczbaPieter/2;
			minFloor = 0;
			
		}else if(id == 3){
			
			minFloor = 0;
			maxFloor = -2;
		}
		
	
	}
	
	
	public void run(){
	
		ruchWindy();
	}
	
	public synchronized void ruchWindy(){   // musi wykonac metode do konca  
		
		while(true){
		
		if(rodzaj == 1){	// windy obslugujace poziomy nad ziemia od 0 po polowy
			aktualnePietro = minFloor;
			
			for(int i = minFloor; i <= maxFloor; i++){
			
			try {		
				// czeka na pietrze
				
				aktualnePietro = i;
				
			/*	if(p.inside == true){
					String s = p.getName();
				} */
				
				System.out.println(this.getName() + "  " + i + "    | ");
				System.out.println("----------------------------------------------");
				Thread.sleep(2000);
				
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			}
			
			
			
			for(int i = aktualnePietro; i >= minFloor; i--){
				
				try {
					
					aktualnePietro = i;
					
					System.out.println(this.getName() + "  " + i + "    |");
					System.out.println("----------------------------------------------");
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		
		}else if(rodzaj == 2){	// windy obslugujace pietra 0, n+1 -- do konca budynku
			
			
			
			try {
				
				aktualnePietro = 0;
				
				Thread.sleep(2000);
				System.out.println(this.getName() + " " + aktualnePietro + "     |");
				System.out.println("----------------------------------------------");
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			aktualnePietro = minFloor;
					
			for(int i = minFloor; i <= maxFloor; i++){
				
				try {
					aktualnePietro = i;
					
					System.out.println(this.getName() + "  " + i + "    |");
					System.out.println("----------------------------------------------");
					Thread.sleep(2000);
					
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			
			
			for(int i = aktualnePietro; i >= minFloor; i--){
				
				try {
					aktualnePietro = i;
					
					System.out.println(this.getName() + "  " + i + "    |");
					System.out.println("----------------------------------------------");
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			try {
				aktualnePietro = 0;
				System.out.println(this.getName() + " " + aktualnePietro + "    |");
				System.out.println("----------------------------------------------");
				
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}else{		// windy obslugujace garaz
			
			for(int i = minFloor; i >= maxFloor; i--){
				
				try {			
					aktualnePietro = i;
					// czeka na pietrze
					System.out.println(this.getName() + "  " + i + "   |");
					System.out.println("----------------------------------------------");
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
			
			
			for(int i = maxFloor; i <= minFloor; i++){
				
				try {
					aktualnePietro = i;
					
					System.out.println(this.getName() + "  " + i + "   |");
					System.out.println("----------------------------------------------");
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		System.out.println("----------------------------------------- obrot windy" + this.getName()); // gdy kazdy watek wykona pelny kurs
	}
	
	}
}