package view;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Visualisointi-luokka, joka tarjoaa toiminnallisuuden simulaation visualisointiin.
 */
public class Visualisointi extends Canvas implements IVisualisointi{

	Canvas canvas;
	private final GraphicsContext gc;

	double i = 0;
	double j = 10;

	/**
	 * Palauttaa tämän luokan Canvas-olion.
	 *
	 * @return Canvas-olio
	 */
	@Override
	public Canvas getCanvas() {
		return this;
	}

	/**
	 * Visualisointi-luokan konstruktori.
	 *
	 * @param w leveys
	 * @param h korkeus
	 */
	public Visualisointi(int w, int h) {
		super(w, h);
		gc = this.getGraphicsContext2D();
		tyhjennaNaytto();
	}

	/**
	 * Tyhjentää näytön.
	 */
	public void tyhjennaNaytto() {
		gc.setFill(Color.GREEN);
		gc.fillRect(0, 0, this.getWidth(), this.getHeight());
	}

	/**
	 * Lisää asiakkaan jonoon.
	 */
	public void lisaaAsiakasJonoon() {
		gc.setFill(Color.WHITE);
		gc.fillOval(50,50,10,10);
	}

	/**
	 * Poistaa asiakkaan jonosta.
	 */
	public void poistaJonosta() {
		gc.setFill(Color.GREEN);
		gc.fillOval(50,50,10,10);
	}

	/**
	 * Luo uuden asiakkaan.
	 */
	public void uusiAsiakas() {
		gc.setFill(Color.WHITE);
		gc.fillOval(i,j,10,10);

		i = (i + 10) % this.getWidth();
		if (i==0) j+=10;
	}

	/**
	 * Piirtää varatun tilan.
	 *
	 * @param index indeksi
	 * @param occupied onko varattu
	 */
	public void piirraVarattu(int index, boolean occupied) {
		gc.setFill(occupied ? Color.RED : Color.BLUE);
		gc.fillOval(175, 20 + 50 * index, 10, 10);
	}
}