package simu.framework;

/**
 * Rajapinta, jota Kontrolleri käyttää.
 */
public interface IMoottori {

	/**
	 * Asettaa simuloinnin ajan.
	 *
	 * @param aika Simuloinnin aika.
	 */
	public void setSimulointiaika(double aika);

	/**
	 * Asettaa viiveen.
	 *
	 * @param aika Viiveen aika.
	 */
	public void setViive(long aika);

	/**
	 * Palauttaa viiveen.
	 *
	 * @return Viiveen aika.
	 */
	public long getViive();
}