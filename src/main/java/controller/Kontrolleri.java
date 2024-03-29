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
/**
 * Luokka, joka hallinnoi simulaattorin toimintoja.
 */
public class Kontrolleri implements IKontrolleriForM, IKontrolleriForV{   // UUSI

	private IMoottori moottori;
	private ISimulaattorinUI ui;
	/**
	 * Kontrolleri-luokan konstruktori.
	 *
	 * @param ui Käyttöliittymä.
	 */
	public Kontrolleri(ISimulaattorinUI ui) {
		this.ui = ui;
		moottori = new OmaMoottori(this, ui, ((GUIkontrolleri)ui).getChartController());
	}


	/**
	 * Käynnistää simulaation.
	 */
	@Override
	public void kaynnistaSimulointi() {
		Trace.setTraceLevel(Trace.Level.INFO);
		moottori = new OmaMoottori(this, ui, ((GUIkontrolleri)ui).getChartController()); // luodaan uusi moottorisäie jokaista simulointia varten
		moottori.setSimulointiaika(ui.getAika());
		moottori.setViive(ui.getViive());
		ui.getVisualisointi().tyhjennaNaytto();
		((Thread)moottori).start();
		//((Thread)moottori).run(); // Ei missään tapauksessa näin. Miksi?
	}
	/**
	 * Hidastaa simulaatiota.
	 */
	@Override
	public void hidasta() { // hidastetaan moottorisäiettä
		moottori.setViive((long)(moottori.getViive()*1.10));
	}
	/**
	 * Nopeuttaa simulaatiota.
	 */
	@Override
	public void nopeuta() { // nopeutetaan moottorisäiettä
		moottori.setViive((long)(moottori.getViive()*0.9));
	}

	/**
	 * Näyttää simulaation loppuajan.
	 *
	 * @param aika Loppuaika.
	 */

	@Override
	public void naytaLoppuaika(double aika) {
		Platform.runLater(()->ui.setLoppuaika(aika));
	}
	/**
	 * Visualisoi jonon.
	 */
	public void visualisoiJono() {
		Platform.runLater(new Runnable(){
			public void run(){
				(ui.getVisualisointi()).lisaaAsiakasJonoon();
				((GUIkontrolleri)ui).updateCanvas();
			}
		});
	}
	/**
	 * Visualisoi jonosta poiston.
	 */
	public void visualisoiJonostaPoisto() {
		Platform.runLater(new Runnable(){
			public void run(){
				(ui.getVisualisointi()).poistaJonosta();
				((GUIkontrolleri)ui).updateCanvas();
			}

		});
	}
	/**
	 * Piirtää palvelupisteen.
	 *
	 * @param index Palvelupisteen indeksi.
	 * @param isReserved Onko palvelupiste varattu.
	 */
	public void drawPalveluPiste(int index, boolean isReserved) {
		Platform.runLater(new Runnable(){
			public void run(){
				(ui.getVisualisointi()).piirraVarattu(index, isReserved);
				((GUIkontrolleri)ui).updateCanvas();
			}
		});
	}
	/**
	 * Visualisoi asiakkaan.
	 */
	@Override
	public void visualisoiAsiakas() {
		Platform.runLater(new Runnable(){
			public void run(){
				(ui.getVisualisointi()).uusiAsiakas();
				((GUIkontrolleri)ui).updateCanvas();
			}
		});
	}
}
