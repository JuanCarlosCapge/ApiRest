package repaso;

import java.util.Scanner;

public class CalculadoraMain {

	public static void main(String[] args) {

		CalculadoraMain obj = new CalculadoraMain();
		
		obj.programa();
		
	}
	
	public void programa() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Ingresa primer numero ");
		double x = sc.nextDouble();
		
		System.out.println("Ingrese segundo n�mero");
		double y = sc.nextDouble();

		Calculadora obj = new Calculadora();
			System.out.println("La suma es = " );
			System.out.println("La resta es = " );
			System.out.println("La multiplicaci�n es = ");
			System.out.println("La divisi�n es = " );
			
			sc.close();
		
		}
		
		
		
	}


