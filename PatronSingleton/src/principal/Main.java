package principal;

import java.util.Iterator;
import java.util.Scanner;
import java.util.UUID;

import modelo.Alimento;
import modelo.Supermercado;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("BIENVENIDO AL SUPER");
		Scanner sc = new Scanner(System.in);
		System.out.println("Ve introduciendo los nombres de los alimentos que quieras añadir a tu cesta o escribe '-' para finalizar la compra");
		String alimento = "";
		while(!alimento.equals("-")) {
			System.out.print("Nombre del alimento: ");
			alimento = sc.nextLine();
			if(!alimento.equals("-")) {
				String id = UUID.randomUUID().toString();
				Alimento nuevoAlimento = new Alimento(id, alimento);
				Supermercado.getInstancia().agregarAlimento(nuevoAlimento);
			}
		}
		System.out.println("Los alimentos añadidos a la cesta han sido: ");
		Supermercado.getInstancia().getCesta().forEach(a -> System.out.println(" - " + a.getNombre()));
		System.out.println("¡GRACIAS POR SU COMPRA!");

	}

}
