package simu.framework;

import simu.model.TapahtumanTyyppi;
import simu.model.Asiakas;

import java.util.ArrayList;
import java.util.HashMap;

public class Tapahtuma implements Comparable<Tapahtuma> {

	/**
	 * Tapahtuma-luokka, joka kuvaa yksittäistä tapahtumaa.
	 */
	private TapahtumanTyyppi tyyppi;
	private double aika;
	ArrayList <Integer> tapahtumat = new ArrayList<>();

	HashMap<Integer, Integer> palvelupisteidenArviot = new HashMap<>();
	/**
	 * Tapahtuma-luokan konstruktori.
	 *
	 * @param tyyppi tapahtuman tyyppi
	 * @param aika tapahtuman aika
	 */
	public Tapahtuma(TapahtumanTyyppi tyyppi, double aika){
		this.tyyppi = tyyppi;
		this.aika = aika;

		//tapahtumat.add(0);
		//tapahtumat.add(1);
		//tapahtumat.add(2);
		//tapahtumat.add(3);
		//tapahtumat.add(4);

		/*tapahtumat.add("Laina");
		tapahtumat.add("Talletus");
		tapahtumat.add("Kortin uusiminen");
		tapahtumat.add("Tilin avaaminen");
		tapahtumat.add("Tilin sulkeminen");*/

		//for (int tapahtuma : tapahtumat) {
			//palvelupisteidenArviot.put(tapahtuma, 0);
		//}
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
	/**
	 * Lisää asiakkaan arvion.
	 *
	 * @param asiakas asiakas, jonka arvio lisätään
	 */
	public void lisaaAsiakkaanArvio(Asiakas asiakas){
		int tapahtuma = asiakas.getTapahtuma();
		int arvio = asiakas.palautaArviointi();

		switch (tapahtuma){
			case 0:
				palvelupisteidenArviot.put(0, palvelupisteidenArviot.get(0) + arvio);
				break;
			case 1:
				palvelupisteidenArviot.put(1, palvelupisteidenArviot.get(1) + arvio);
				break;
			case 2:
				palvelupisteidenArviot.put(2, palvelupisteidenArviot.get(2) + arvio);
				break;
			case 3:
				palvelupisteidenArviot.put(3, palvelupisteidenArviot.get(3) + arvio);
				break;
			case 4:
				palvelupisteidenArviot.put(4, palvelupisteidenArviot.get(4) + arvio);
				break;
		}
	}
	/**
	 * Vertaa tätä tapahtumaa toiseen tapahtumaan ajan perusteella.
	 *
	 * @param arg toinen tapahtuma, johon tätä tapahtumaa verrataan
	 * @return negatiivinen luku, jos tämän tapahtuman aika on pienempi kuin toisen tapahtuman aika,
	 *         positiivinen luku, jos tämän tapahtuman aika on suurempi kuin toisen tapahtuman aika,
	 *         tai 0, jos tapahtumien ajat ovat yhtä suuret
	 */
	@Override
	public int compareTo(Tapahtuma arg) {
		if (this.aika < arg.aika) return -1;
		else if (this.aika > arg.aika) return 1;
		return 0;
	}
}
