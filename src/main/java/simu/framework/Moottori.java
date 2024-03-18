package simu.framework;

import controller.IKontrolleriForM;
import simu.model.OmaMoottori;

/**
 * Abstrakti Moottori-luokka, joka perii Thread-luokan ja toteuttaa IMoottori-rajapinnan.
 */
public abstract class Moottori extends Thread implements IMoottori{

	private double simulointiaika = 0;
	private long viive = 0;

	private Kello kello;

	protected Tapahtumalista tapahtumalista;

	protected IKontrolleriForM kontrolleri;

	/**
	 * Moottori-luokan konstruktori.
	 *
	 * @param kontrolleri Kontrolleri, joka ohjaa moottorin toimintaa.
	 */
	public Moottori(IKontrolleriForM kontrolleri){
		this.kontrolleri = kontrolleri;
		kello = Kello.getInstance();
		tapahtumalista = new Tapahtumalista();
	}

	@Override
	public void setSimulointiaika(double aika) {
		simulointiaika = aika;
	}

	@Override
	public void setViive(long viive) {
		this.viive = viive;
	}

	@Override
	public long getViive() {
		return viive;
	}

	/**
	 * Suorittaa simuloinnin.
	 */
	@Override
	public void run(){
		alustukset();
		while (simuloidaan()){
			viive();
			kello.setAika(nykyaika());
			suoritaBTapahtumat();
			yritaCTapahtumat();
		}
		tulokset();
	}

	private void suoritaBTapahtumat(){
		while (tapahtumalista.getSeuraavanAika() == kello.getAika()){
			suoritaTapahtuma(tapahtumalista.poista());
		}
	}

	protected abstract void yritaCTapahtumat();

	private double nykyaika(){
		return tapahtumalista.getSeuraavanAika();
	}

	private boolean simuloidaan(){
		Trace.out(Trace.Level.INFO, "Kello on: " + kello.getAika());
		return kello.getAika() < simulointiaika;
	}

	private void viive() {
		Trace.out(Trace.Level.INFO, "Viive " + viive);
		try {
			sleep(viive);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Alustaa simuloinnin.
	 */
	protected abstract void alustukset();

	/**
	 * Suorittaa tapahtuman.
	 *
	 * @param t Suoritettava tapahtuma.
	 */
	protected abstract void suoritaTapahtuma(Tapahtuma t);

	/**
	 * Tulostaa simuloinnin tulokset.
	 */
	protected abstract void tulokset();
}