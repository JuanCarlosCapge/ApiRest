package repaso;

import java.util.Scanner;

public class ClaseIfMAyorEdad {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int edad = sc.nextInt();
		
		if(edad<18) {
			System.out.println("Eres adolescente");
			
		}else if (edad <40) {
			System.out.println("Eres adulto");
			
		}else if (edad <=60) {
			System.out.println("Erer adulto");
			
		}else
			
			System.out.println("Te has pasado el juego");
		
	}

}
