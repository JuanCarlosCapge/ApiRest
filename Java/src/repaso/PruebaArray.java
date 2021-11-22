package repaso;

import java.util.ArrayList;

public class PruebaArray {

	public static void main(String[] args) {
		// instanciamos la clase de tipo strign llamamos 
		ArrayList<String> cars = new ArrayList<String>();
		
		//para llamar valores añadimos el add
		cars.add("Ford");
		cars.add("Audi");
		cars.add("BMV");
		cars.add("Ferrari");
		cars.add("Tesla");
		//sacamos por consola los coches
		System.out.println(cars.get(4));
		
		System.out.println(cars.remove(0));
		System.out.println(cars);
		System.out.println(cars.set(1, null));
		
		
	}

}
