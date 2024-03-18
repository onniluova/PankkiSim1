package simu.framework;

import java.util.PriorityQueue;

/**
 * Tapahtumalista-luokka, joka hallinnoi tapahtumien prioriteettijonoa.
 */
public class Tapahtumalista {
	private PriorityQueue<Tapahtuma> lista = new PriorityQueue<Tapahtuma>();

	/**
	 * Tapahtumalista-luokan konstruktori.
	 */
	public Tapahtumalista(){

	}

	/**
	 * Poistaa ja palauttaa prioriteettijonon ensimmäisen tapahtuman.
	 *
	 * @return poistettu tapahtuma
	 */
	public Tapahtuma poista(){
		return lista.remove();
	}

	/**
	 * Lisää uuden tapahtuman prioriteettijonoon.
	 *
	 * @param t lisättävä tapahtuma
	 */
	public void lisaa(Tapahtuma t){
		lista.add(t);
	}

	/**
	 * Palauttaa seuraavan tapahtuman ajan prioriteettijonosta.
	 *
	 * @return seuraavan tapahtuman aika
	 */
	public double getSeuraavanAika(){
		return lista.peek().getAika();
	}
}