package view;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Visualisointi extends Canvas implements IVisualisointi{

	Canvas canvas;
	private final GraphicsContext gc;
	
	double i = 0;
	double j = 10;

	@Override
	public Canvas getCanvas() {
		return this;
	}
	
	
	public Visualisointi(int w, int h) {
		super(w, h);
		gc = this.getGraphicsContext2D();
		tyhjennaNaytto();
	}
	

	public void tyhjennaNaytto() {
		gc.setFill(Color.GREEN);
		gc.fillRect(0, 0, this.getWidth(), this.getHeight());
	}

	public void lisaaAsiakasJonoon() {
		gc.setFill(Color.WHITE);
		gc.fillOval(50,50,10,10);
	}

	public void poistaJonosta() {
		gc.setFill(Color.GREEN);
		gc.fillOval(50,50,10,10);
	}
	
	public void uusiAsiakas() {
		gc.setFill(Color.WHITE);
		gc.fillOval(i,j,10,10);
		
		i = (i + 10) % this.getWidth();
		//j = (j + 12) % this.getHeight();
		if (i==0) j+=10;			
	}

	public void piirraVarattu(int index, boolean occupied) {
		gc.setFill(occupied ? Color.RED : Color.BLUE);
		gc.fillOval(175, 20 + 50 * index, 10, 10);
	}
}
