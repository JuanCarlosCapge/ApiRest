package repaso;

import java.util.HashMap;

public class PruebaHashMap {

	public static void main(String[] args) {

		HashMap< String , String> capitales = new HashMap< String, String>();
		
		capitales.put("España " , " Madrid");
		capitales.put("Colmenar Viejo " , " Madrid");
		capitales.put("Noja " , " Cantabria");
		capitales.put("Vigo " , " Galicia");
		capitales.put("Porzuna " , " Ciudad Real");
		
		
		System.out.println(capitales);
		
		
	}

}
