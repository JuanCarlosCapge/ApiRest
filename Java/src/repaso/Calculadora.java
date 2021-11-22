package repaso;

import java.util.Scanner;

public class Calculadora {

	public static void main(String[] args) {

		int a= 0,  b = 0, res= 0;
		
		Scanner sc = new Scanner(System.in);
		String sel = null;
		System.out.println("Seleccione la opcion\n");
		System.out.println("+: suma"
				+ "\n-: Resta"
				+ "\n*: Multiplicar"
				+ "\n/: Dividir");
		sel=sc.next();
		
		switch(sel) {
		case "+":
		
		System.out.println("Ha seleccionado suma\n Ingrese los valores");
		System.out.println("ingrese el primer número");
		a = sc.nextInt();
		System.out.println("ingrese el segundo número");
		b = sc.nextInt();
		res = a+b;
		
		System.out.println(a+ "+" + b + "=" + res);
		break;
		
		case "-":
			
			System.out.println("Ha seleccionado resta\n ");
			System.out.println("ingrese el primer número");
			a = sc.nextInt();
			System.out.println("ingrese el segundo número");
			b = sc.nextInt();
			res = a-b;
			
			System.out.println(a+ "-" + b + "=" + res);
			break;
			
		case "*":
			
			System.out.println("Ha seleccionado multlicación\n ");
			System.out.println("ingrese el primer número");
			a = sc.nextInt();
			System.out.println("ingrese el segundo número");
			b = sc.nextInt();
			res = a*b;
			
			System.out.println(a+ "*" + b + "=" + res);
			break;
			
		case "/":
			
			System.out.println("Ha seleccionado división\n ");
			System.out.println("ingrese el primer número");
			a = sc.nextInt();
			System.out.println("ingrese el segundo número");
			b = sc.nextInt();
			res = a/b;
			
			System.out.println(a+ "/" + b + "=" + res);
			break;
			
		default:
			System.out.println("Esta opción no exite");
		
		}
		
	}

}
