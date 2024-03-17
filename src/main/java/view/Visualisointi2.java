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

	private double linePosition = 20; // Initial position

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
		gc.fillOval(linePosition, 80, customerSize, customerSize); // Draw the customer at linePosition
		customerPositions.add(linePosition); // Add the position to the list
		linePosition += customerSize + gap; // Move linePosition forward by the width of the customer plus the gap
	}

	public void poistaJonosta() {
		if (!customerPositions.isEmpty()) {
			double removedPosition = customerPositions.remove(customerPositions.size() - 1); // Remove the last position
			gc.setFill(Color.GREY); // Set the fill color to the background color
			gc.fillRect(removedPosition, 80, customerSize, customerSize); // Fill the area of the removed customer with the background color
			linePosition -= customerSize + gap; // Move linePosition backwards by the width of the customer plus the gap
		}
	}

	public void piirraVarattu(int index, boolean occupied) {
		gc.setFill(occupied ? Color.RED : Color.BLUE);
		gc.fillOval(175, 20 + 50 * index, 10, 10);
	}

	public void palveluPisteet() {
		gc.setFill(Color.BLUE);
		gc.fillOval(175, 20, 10, 10);
		gc.fillOval(175, 70, 10, 10);
		gc.fillOval(175, 120, 10, 10);
		gc.fillOval(175, 170, 10, 10);
	}
}
