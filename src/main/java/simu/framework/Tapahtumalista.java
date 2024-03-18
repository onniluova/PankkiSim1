package simu.framework;

import java.util.PriorityQueue;

public class Tapahtumalista {
	private PriorityQueue<Tapahtuma> lista = new PriorityQueue<Tapahtuma>();
	
	public Tapahtumalista(){
	 
	}
	/**
	 * Poistaa ja palauttaa ensimmäisen tapahtuman listalta.
	 *
	 * @return Poistettu tapahtuma.
	 */
	public Tapahtuma poista(){
		return lista.remove();
	}
	/**
	 * Lisää tapahtuman listaan.
	 *
	 * @param t Lisättävä tapahtuma.
	 */
	public void lisaa(Tapahtuma t){
		lista.add(t);
	}
	/**
	 * Palauttaa seuraavan tapahtuman ajan listalta.
	 *
	 * @return Seuraavan tapahtuman aika.
	 */
	public double getSeuraavanAika(){
		return lista.peek().getAika();
	}
	
	
}
