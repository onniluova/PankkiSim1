package view;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class Visualisointi2 extends Canvas implements IVisualisointi {

	private GraphicsContext gc;
	private final List<Double> customerPositions;
	private final double gap = 5; // Gap between customers
	private final double customerSize = 15; // Size of the customer

	private double linePosition = 50; // Initial position
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
	 * Visualisointi2-luokan konstruktori.
	 *
	 * @param w leveys
	 * @param h korkeus
	 */
	public Visualisointi2(int w, int h) {
		super(w, h);
		gc = this.getGraphicsContext2D();
		customerPositions = new ArrayList<>();
		tyhjennaNaytto();
	}
	/**
	 * Tyhjentää näytön.
	 */
	public void tyhjennaNaytto() {
		gc.setFill(Color.GREY);
		gc.fillRect(0, 0, this.getWidth(), this.getHeight());
	}
	/**
	 * Luo uuden asiakkaan.
	 */
	public void uusiAsiakas() {
		palveluPisteet();
	}
	/**
	 * Lisää asiakkaan jonoon.
	 */
	public void lisaaAsiakasJonoon() {
		gc.setFill(Color.WHITE);
		double yPosition = 125 + ((customerPositions.size() / 10) * (customerSize + gap));
		double xPosition = 50 + ((customerPositions.size() % 10) * (customerSize + gap));
		gc.fillOval(xPosition, yPosition, customerSize, customerSize);
		customerPositions.add(xPosition);
		gc.fillText("Jono", 65, 100);
	}
	/**
	 * Poistaa asiakkaan jonosta.
	 */
	public void poistaJonosta() {
		if (!customerPositions.isEmpty()) {
			double removedPosition = customerPositions.remove(customerPositions.size() - 1);
			gc.setFill(Color.GREY);
			gc.fillRect(removedPosition, 125, customerSize, customerSize);
			linePosition -= customerSize + gap;
		}
	}
	/**
	 * Piirtää varatun tilan.
	 *
	 * @param index indeksi
	 * @param occupied onko varattu
	 */
	public void piirraVarattu(int index, boolean occupied) {
		gc.setFill(occupied ? Color.RED : Color.BLUE);
		gc.fillOval(280, 50 + 50 * index, 30, 30);
	}
	/**
	 * Piirtää palvelupisteet.
	 */
	public void palveluPisteet() {
		gc.setFill(Color.BLUE);
		gc.fillText("Palvelupisteet", 255, 40);
		//gc.fillOval(230, 20, 30, 30);
		//gc.fillOval(230, 70, 30, 30);
		//gc.fillOval(230, 120, 30, 30);
	}
}
