
public class Elevator extends Thread {

	int rodzaj; // 1, 2 lub 3
	int minFloor;
	int maxFloor; // pietro ograniczajace gorne dla windy
	int aktualnePietro = 0;
	final int pojemnoscWindy = 5; // tyle osob pomiesci winda
	
	Start s = new Start();
	
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
				System.out.println(this.getName() + "  " + i + "    |");
				System.out.println("----------------------------------------------");
				Thread.sleep(2000);
				
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			aktualnePietro = i;
			}
			
			
			
			for(int i = aktualnePietro; i >= minFloor; i--){
				
				try {
					System.out.println(this.getName() + "  " + i + "    |");
					System.out.println("----------------------------------------------");
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				aktualnePietro = i;
			}
		
		}else if(rodzaj == 2){	// windy obslugujace pietra 0, n+1 -- do konca budynku
			
			aktualnePietro = 0;
			System.out.println(this.getName() + " " + aktualnePietro + "     |");
			System.out.println("----------------------------------------------");
			aktualnePietro = minFloor;
					
			for(int i = minFloor; i <= maxFloor; i++){
				
				try {
					System.out.println(this.getName() + "  " + i + "    |");
					System.out.println("----------------------------------------------");
					Thread.sleep(2000);
					
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				aktualnePietro = i;
			}
			
			
			
			for(int i = aktualnePietro; i >= minFloor; i--){
				
				try {
					System.out.println(this.getName() + "  " + i + "    |");
					System.out.println("----------------------------------------------");
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			aktualnePietro = 0;
			System.out.println(this.getName() + " " + aktualnePietro + "    |");
			System.out.println("----------------------------------------------");
			
		}else{		// windy obslugujace garaz
			
			for(int i = minFloor; i >= maxFloor; i--){
				
				try {									// czeka na pietrze
					System.out.println(this.getName() + "  " + i + "   |");
					System.out.println("----------------------------------------------");
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				aktualnePietro = i;
			}
			
			
			for(int i = maxFloor; i <= minFloor; i++){
				
				try {
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