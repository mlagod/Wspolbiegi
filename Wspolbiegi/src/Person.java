import java.util.Random;



public class Person extends Thread {
	
	int cel;	// na ktore pietro chce sie dostac
	int pietro = 0; // na ktorym pietrze jest aktualnie osoba
	boolean reached = true;
	Start s = new Start();
	Elevator e = new Elevator();
	boolean inside = false;
	
	
	@Override
	public void run() {
		
		
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
		
	}

	
	public void akcja(){
		
		losujPietroStart();
		
		
		
		while(true){
		
		if(reached == true){ // jezeli dojechalismy na wybrane pietro
			
			reached = false; // losuje pietro celu
			losujPietroCel();
		}
		
		if(e.aktualnePietro == pietro){ // winda podjezdza
			
			if(e.ileOsob <= e.FULL){ // sa miejsca  // to do wyrzucenia raczej
			
				e.ileOsob++;
				inside = true; // osoba wsiada
			
			}else{
				// watki czekaja w kolejce na miejsce
			}
		}
		
		if(e.aktualnePietro == cel){ // winda podjezdza
		
			e.ileOsob--;
			inside = false;
			pietro = e.aktualnePietro;
			reached = true;
		}
		} // koniec while
	}
}
