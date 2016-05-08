package BPP;

public class Artikel implements java.lang.Comparable<Artikel>{
	private int hoogte;
	private boolean verwerkt = false;

	public Artikel(int hoogte) {
		this.hoogte = hoogte;
	}
	
	public void gevuld(){
		verwerkt = true;
	}
	
	@Override
	public int compareTo(Artikel o) {
		if(this.hoogte == o.hoogte){
			return 0;		//het artikel blijft op dezelfde plaats in de lijst staan
		}else if(this.hoogte < o.hoogte){
			return 1;		//het artikel schuift een plaats op naar boven in de lijst
		}else{
			return -1;		//het artikel schuift een plaats op naar beneden in de lijst
		}
	}

	public int getHoogte() {
		return hoogte;
	}

	public boolean isVerwerkt() {
		return verwerkt;
	}
}
// commit test