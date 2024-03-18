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
	private final double customerSize = 30; // Size of the customer

	private double linePosition = 50; // Initial position

	@Override
	public Canvas getCanvas() {
		return this;
	}

	public Visualisointi2(int w, int h) {
		super(w, h);
		gc = this.getGraphicsContext2D();
		customerPositions = new ArrayList<>();
		tyhjennaNaytto();
	}

	public void tyhjennaNaytto() {
		gc.setFill(Color.GREY);
		gc.fillRect(0, 0, this.getWidth(), this.getHeight());
	}

	public void uusiAsiakas() {
		palveluPisteet();
	}

	public void lisaaAsiakasJonoon() {
		gc.setFill(Color.WHITE);
		gc.fillOval(linePosition, 125, customerSize, customerSize);
		customerPositions.add(linePosition);
		linePosition += customerSize + gap;
		gc.fillText("Jono", 65, 100);
	}

	public void poistaJonosta() {
		if (!customerPositions.isEmpty()) {
			double removedPosition = customerPositions.remove(customerPositions.size() - 1);
			gc.setFill(Color.GREY);
			gc.fillRect(removedPosition, 125, customerSize, customerSize);
			linePosition -= customerSize + gap;
		}
	}

	public void piirraVarattu(int index, boolean occupied) {
		gc.setFill(occupied ? Color.RED : Color.BLUE);
		gc.fillOval(280, 50 + 50 * index, 30, 30);
	}

	public void palveluPisteet() {
		gc.setFill(Color.BLUE);
		gc.fillText("Palvelupisteet", 255, 40);
		//gc.fillOval(230, 20, 30, 30);
		//gc.fillOval(230, 70, 30, 30);
		//gc.fillOval(230, 120, 30, 30);
	}
}
