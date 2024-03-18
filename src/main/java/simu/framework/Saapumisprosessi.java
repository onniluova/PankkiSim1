package simu.framework;
import eduni.distributions.*;
import simu.model.TapahtumanTyyppi;

/**
 * Saapumisprosessi-luokka, joka generoi uusia tapahtumia.
 */
public class Saapumisprosessi {

	private ContinuousGenerator generaattori;
	private Tapahtumalista tapahtumalista;
	private TapahtumanTyyppi tyyppi;

	/**
	 * Saapumisprosessi-luokan konstruktori.
	 *
	 * @param g generaattori, joka generoi uusia tapahtumia
	 * @param tl tapahtumalista, johon uudet tapahtumat lisätään
	 * @param tyyppi tapahtuman tyyppi
	 */
	public Saapumisprosessi(ContinuousGenerator g, Tapahtumalista tl, TapahtumanTyyppi tyyppi){
		this.generaattori = g;
		this.tapahtumalista = tl;
		this.tyyppi = tyyppi;
	}

	/**
	 * Generoi uuden tapahtuman ja lisää sen tapahtumalistaan.
	 */
	public void generoiSeuraava(){
		Tapahtuma t = new Tapahtuma(tyyppi, Kello.getInstance().getAika()+generaattori.sample());
		tapahtumalista.lisaa(t);
	}
}