package simu.framework;

public class Trace {

	public enum Level{INFO, WAR, ERR}
	
	private static Level traceLevel;
	/**
	 * Asettaa jäljitystason.
	 *
	 * @param lvl Jäljitystaso.
	 */
	
	public static void setTraceLevel(Level lvl){
		traceLevel = lvl;
	}
	/**
	 * Tulostaa jäljitystiedot.
	 *
	 * @param lvl Jäljitystaso.
	 * @param txt Tulostettava teksti.
	 */
	public static void out(Level lvl, String txt){
		if (lvl.ordinal() >= traceLevel.ordinal()){
			System.out.println(txt);
		}
	}
	
	
	
}