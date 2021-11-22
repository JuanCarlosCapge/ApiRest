package repaso;

public class CalculadoraMetodos {

	private double resultado ;
	
	public double suma (double x, double y ) {
		
		resultado = x + y;
		
		return resultado;
		
	}
	
	
	public double resta (double x , double y) {
		
		resultado = x - y;
		
		return resultado;
	}
	
public double multi (double x , double y) {
		
		resultado = x * y;
		
		return resultado;
	}

public double divi (double x , double y) {
	
	resultado = x / y;
	
	return resultado;
}
}
