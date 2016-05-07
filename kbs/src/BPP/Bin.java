package BPP;

import java.util.ArrayList;

public class Bin {
	private int hoogte;
	public ArrayList<Artikel> artikelen = new ArrayList<Artikel>();
	private int ruimte;
			
	public Bin() {
		this.hoogte = 12;
		this.ruimte = hoogte;
	}
	
	public int getRuimte(){
		for(Artikel artikel : artikelen){
			this.ruimte -= artikel.getHoogte();
		}
		return ruimte;
	}
	
	@Override
	public String toString(){
		String _return = "";
		for(Artikel artikel : artikelen){
			_return += artikel.getHoogte() + " ";
//			_return += artikel;
		}
		return _return;
	}
}
// commit test