package simu.framework;

/**
 * Kello-luokka, joka pitää kirjaa ajasta.
 */
public class Kello {

	private double aika;
	private static Kello instanssi;

	/**
	 * Yksityinen konstruktori, joka alustaa ajan nollaksi.
	 */
	private Kello(){
		aika = 0;
	}

	/**
	 * Palauttaa Kello-instanssin. Jos instanssia ei ole vielä luotu, se luodaan.
	 *
	 * @return Kello-instanssi
	 */
	public static Kello getInstance(){
		if (instanssi == null){
			instanssi = new Kello();
		}
		return instanssi;
	}

	/**
	 * Asettaa kellon ajan.
	 *
	 * @param aika uusi aika
	 */
	public void setAika(double aika){
		this.aika = aika;
	}

	/**
	 * Palauttaa kellon ajan.
	 *
	 * @return kellon aika
	 */
	public double getAika(){
		return aika;
	}
}