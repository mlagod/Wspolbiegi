
public class Elevator extends Thread {

	int rodzaj; // 1, 2 lub 3
	int minFloor;
	int maxFloor; // pietro ograniczajace gorne dla windy
	int aktualnePietro = 0;
	final int pojemnoscWindy = 6; // tyle osob pomiesci winda
	
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
		
		if(rodzaj == 1){	// windy obslugujace poziomy nad ziemia
			aktualnePietro = minFloor;
			
			for(int i = minFloor; i <= maxFloor; i++){
			
			try {		
				// czeka na pietrze
				System.out.println(this.getName() + " na pietrze | " + i);
				Thread.sleep(2000);
				
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			aktualnePietro = i;
			}
			
			
			
			for(int i = aktualnePietro; i >= minFloor; i--){
				
				try {
					System.out.println(this.getName() + " na pietrze | " + i);
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				aktualnePietro = i;
			}
		
		}else if(rodzaj == 2){
			
			aktualnePietro = 0;
			System.out.println(this.getName() + " na pietrze | " + aktualnePietro);
			aktualnePietro = minFloor;
					
			for(int i = minFloor; i <= maxFloor; i++){
				
				try {
					System.out.println(this.getName() + " na pietrze | " + i);
					Thread.sleep(2000);
					
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				aktualnePietro = i;
			}
			
			
			
			for(int i = aktualnePietro; i >= minFloor; i--){
				
				try {
					System.out.println(this.getName() + " na pietrze | " + i);
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			aktualnePietro = 0;
			System.out.println(this.getName() + " na pietrze | " + aktualnePietro);
			
		}else{		// windy obslugujace garaz
			
			for(int i = minFloor; i >= maxFloor; i--){
				
				try {									// czeka na pietrze
					System.out.println(this.getName() + " na pietrze | " + i);
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				aktualnePietro = i;
			}
			
			
			for(int i = maxFloor; i <= minFloor; i++){
				
				try {
					System.out.println(this.getName() + " na pietrze | " + i);
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