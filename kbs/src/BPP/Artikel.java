package BPP;

public class Artikel implements java.lang.Comparable<Artikel>{
	private int hoogte;

	public Artikel(int hoogte) {
		this.hoogte = hoogte;
	}
	
	@Override
	public int compareTo(Artikel o) {
		if(this.hoogte == o.hoogte){
			return 0;
		}else if(this.hoogte < o.hoogte){
			return 1;
		}else{
			return -1;
		}
	}
}
