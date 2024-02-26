package simu.framework;

import simu.model.TapahtumanTyyppi;
import simu.model.Asiakas;

import java.util.ArrayList;
import java.util.HashMap;

public class Tapahtuma implements Comparable<Tapahtuma> {
	
		
	private TapahtumanTyyppi tyyppi;
	private double aika;
	ArrayList <Integer> tapahtumat = new ArrayList<>();

	HashMap<Integer, Integer> palvelupisteidenArviot = new HashMap<>();
	
	public Tapahtuma(TapahtumanTyyppi tyyppi, double aika){
		this.tyyppi = tyyppi;
		this.aika = aika;

		tapahtumat.add(0);
		tapahtumat.add(1);
		tapahtumat.add(2);
		tapahtumat.add(3);
		tapahtumat.add(4);

		/*tapahtumat.add("Laina");
		tapahtumat.add("Talletus");
		tapahtumat.add("Kortin uusiminen");
		tapahtumat.add("Tilin avaaminen");
		tapahtumat.add("Tilin sulkeminen");*/

		for (int tapahtuma : tapahtumat) {
			palvelupisteidenArviot.put(tapahtuma, 0);
		}
	}
	
	public void setTyyppi(TapahtumanTyyppi tyyppi) {
		this.tyyppi = tyyppi;
	}
	public TapahtumanTyyppi getTyyppi() {
		return tyyppi;
	}
	public void setAika(double aika) {
		this.aika = aika;
	}
	public double getAika() {
		return aika;
	}

	public void lisaaAsiakkaanArvio(Asiakas asiakas){
		int tapahtuma = asiakas.getTapahtuma();
		int arvio = asiakas.palautaArviointi();
		palvelupisteidenArviot.put(tapahtuma, arvio);
	}

	@Override
	public int compareTo(Tapahtuma arg) {
		if (this.aika < arg.aika) return -1;
		else if (this.aika > arg.aika) return 1;
		return 0;
	}
}
