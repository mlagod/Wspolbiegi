import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;



public class Person extends Thread {
	
	int cel;	// na ktore pietro chce sie dostac
	int pietro = 0; // na ktorym pietrze jest aktualnie osoba
	boolean reached = true;
	Start s = new Start();
	Elevator e = s.listaWind.get();
	boolean inside = false;
	

	
	ReentrantLock blokada = new ReentrantLock();
	
	@Override
	public void run() {
		
		akcja();
		
	}
	
	
	private void losujPietroCel(){
		
		Random r = new Random();
		cel = r.nextInt(s.liczbaPieter+1);
		
		if(cel == pietro){					// jezeli wylosuje sie aktualne pietro, dodaj 1
			cel = (cel+1)%s.liczbaPieter;
		}
		
	
	}
	
	private void losujPietroStart(){	// losuje poczatkowe polozenie czlowieka
		
		Random r = new Random();
		pietro = r.nextInt(s.liczbaPieter+1);
		
		blokada.lock();
		s.kolejkaIn[pietro].add(this);
		blokada.unlock();
		
	}

	public static int getElevatorIndex(int x){
		return x;
	}
	
	
	
	public void akcja(){
		
		losujPietroStart();
		
		
		
		while(true){
		
		if(reached == true){ // jezeli dojechalismy na wybrane pietro
			
			reached = false; // losuje pietro celu
			losujPietroCel();
		}
		
		if(s.listaWind.get().aktualnePietro == pietro){ // winda podjezdza
			
			if(pietro == cel){  // osoby wysiadaja
				
				e.ileOsob--;
				inside = false;
				
				reached = true;
				
				blokada.lock();
				s.kolejkaOut[pietro].poll();
				s.kolejkaIn[pietro].add(this); // czy nie powinno byc przy losowaniu pietra celu ?
				blokada.unlock();
			}
			
			
			
			if(e.ileOsob < e.FULL){ // sa miejsca 
			
				e.ileOsob++;
				inside = true; // osoba wsiada
				
				blokada.lock();
				s.kolejkaIn[pietro].poll();
				s.kolejkaOut[cel].add(this);
				blokada.unlock();
				
			
		}
		
		}
		} // koniec while
	}
}
