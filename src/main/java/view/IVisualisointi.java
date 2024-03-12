package view;
import javafx.scene.canvas.Canvas;


public interface IVisualisointi {

	Canvas getCanvas();
	public void tyhjennaNaytto();
	
	public void uusiAsiakas();

	public void lisaaAsiakasJonoon();

	public void poistaJonosta();

	public void piirraVarattu(int index, boolean occupied);
		
}

