import java.util.Random;


public class Person extends Thread {
	
	int cel;	// na ktore pietro chce sie dostac
	int pietro = 0; // na ktorym pietrze jest aktualnie osoba
	
	Start s = new Start();
	
	
	@Override
	public void run() {
		
		boolean reached = true;
		
		if(reached == true){ // jezeli dojechalismy na wybrane pietro
			
			reached = false;
			losujPietro();
		}
		
		
	}
	
	
	private void losujPietro(){
		
		Random r = new Random();
		cel = r.nextInt(s.liczbaPieter+1);
		
		if(cel == pietro){					// jezeli wylosuje sie aktualne pietro, dodaj 1
			cel = (cel+1)%s.liczbaPieter;
		}
	}

}
