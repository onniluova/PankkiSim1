package controller;

import javafx.application.Platform;
import simu.framework.IMoottori;
import simu.framework.Trace;
import simu.model.OmaMoottori;
import view.ISimulaattorinUI;
import view.SimulaattorinGUI;
import view.Visualisointi;
import view.Visualisointi2;
import simu.framework.Trace.Level;

public class Kontrolleri implements IKontrolleriForM, IKontrolleriForV{   // UUSI
	
	private IMoottori moottori;
	private ISimulaattorinUI ui;

	public Kontrolleri(ISimulaattorinUI ui) {
		this.ui = ui;
		this.moottori = new OmaMoottori(this, ui);
	}
	
	// Moottorin ohjausta:
		
	@Override
	public void kaynnistaSimulointi() {
		Trace.setTraceLevel(Trace.Level.INFO);
		moottori = new OmaMoottori(this, ui); // luodaan uusi moottorisäie jokaista simulointia varten
		moottori.setSimulointiaika(ui.getAika());
		moottori.setViive(ui.getViive());
		ui.getVisualisointi().tyhjennaNaytto();
		((Thread)moottori).start();
		//((Thread)moottori).run(); // Ei missään tapauksessa näin. Miksi?		
	}
	
	@Override
	public void hidasta() { // hidastetaan moottorisäiettä
		moottori.setViive((long)(moottori.getViive()*1.10));
	}

	@Override
	public void nopeuta() { // nopeutetaan moottorisäiettä
		moottori.setViive((long)(moottori.getViive()*0.9));
	}
	
	// Simulointitulosten välittämistä käyttöliittymään.
	// Koska FX-ui:n päivitykset tulevat moottorisäikeestä, ne pitää ohjata JavaFX-säikeeseen:
		
	@Override
	public void naytaLoppuaika(double aika) {
		Platform.runLater(()->ui.setLoppuaika(aika)); 
	}

	public void visualisoiJono() {
		Platform.runLater(new Runnable(){
			public void run(){
				(ui.getVisualisointi()).lisaaAsiakasJonoon();
				((GUIkontrolleri)ui).updateCanvas();
			}
		});
	}

	public void visualisoiJonostaPoisto() {
		Platform.runLater(new Runnable(){
			public void run(){
				(ui.getVisualisointi()).poistaJonosta();
			}
		});
	}

	public void drawPalveluPiste(int index, boolean isReserved) {
		Platform.runLater(new Runnable(){
			public void run(){
				(ui.getVisualisointi()).piirraVarattu(index, isReserved);
			}
		});
	}
	
	@Override
	public void visualisoiAsiakas() {
		Platform.runLater(new Runnable(){
			public void run(){
				(ui.getVisualisointi()).uusiAsiakas();
			}
		});
	}
}
