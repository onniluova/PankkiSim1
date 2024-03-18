package simu.model;

import simu.framework.*;
import java.util.LinkedList;
import eduni.distributions.ContinuousGenerator;

/**
 * Palvelupiste-luokka, joka hallinnoi asiakkaiden palvelupisteen jonotusta ja palvelua.
 */
public class Palvelupiste {

	private final LinkedList<Asiakas> jono = new LinkedList<>(); // Tietorakennetoteutus
	private final ContinuousGenerator generator;
	private final Tapahtumalista tapahtumalista;
	private final TapahtumanTyyppi skeduloitavanTapahtumanTyyppi;

	//JonoStartegia strategia; //optio: asiakkaiden järjestys

	private boolean varattu = false;
	private double varattuStartTime = 0.0;
	private double totalVarattuTime = 0.0;

	/**
	 * Palvelupiste-luokan konstruktori.
	 *
	 * @param generator generaattori, joka tuottaa palveluajat
	 * @param tapahtumalista tapahtumalista, johon uudet tapahtumat lisätään
	 * @param tyyppi tyyppi tapahtumalle, joka skeduloidaan
	 */
	public Palvelupiste(ContinuousGenerator generator, Tapahtumalista tapahtumalista, TapahtumanTyyppi tyyppi){
		this.tapahtumalista = tapahtumalista;
		this.generator = generator;
		this.skeduloitavanTapahtumanTyyppi = tyyppi;
	}

	/**
	 * Lisää asiakkaan jonoon.
	 *
	 * @param a asiakas, joka lisätään jonoon
	 */
	public void lisaaJonoon(Asiakas a){
		jono.add(a);
	}

	/**
	 * Poistaa ja palauttaa jonon ensimmäisen asiakkaan.
	 *
	 * @return poistettu asiakas
	 */
	public Asiakas otaJonosta(){
		varattu = false;
		return jono.poll();
	}

	/**
	 * Aloittaa palvelun jonon ensimmäiselle asiakkaalle.
	 */
	public void aloitaPalvelu(){
		varattu = true;
		double palveluaika = generator.sample();
		tapahtumalista.lisaa(new Tapahtuma(skeduloitavanTapahtumanTyyppi,Kello.getInstance().getAika()+palveluaika));
	}

	/**
	 * Tarkistaa, onko palvelupiste varattu.
	 *
	 * @return true, jos palvelupiste on varattu, muuten false
	 */
	public boolean onVarattu(){
		return varattu;
	}

	/**
	 * Tarkistaa, onko jonossa asiakkaita.
	 *
	 * @return true, jos jonossa on asiakkaita, muuten false
	 */
	public boolean onJonossa(){
		return jono.size() != 0;
	}

	/**
	 * Palauttaa palvelupisteen kokonaisvarausajan.
	 *
	 * @return palvelupisteen kokonaisvarausaika
	 */
	public double getTotalVarattuTime() {
		if (varattu) {
			return totalVarattuTime + Kello.getInstance().getAika() - varattuStartTime;
		} else {
			return totalVarattuTime;
		}
	}

}