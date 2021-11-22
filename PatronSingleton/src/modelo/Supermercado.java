package modelo;

import java.util.ArrayList;

public class Supermercado {
	
	private ArrayList<Alimento> productos;
	private static Supermercado supermercado;
	
	private Supermercado() {
		productos = new ArrayList<Alimento>();
	}
	
	public static Supermercado getInstancia() {
		if(supermercado == null) {
			supermercado = new Supermercado();
		}
		return supermercado;
	}
	
	public void agregarAlimento(Alimento alimento) {
		productos.add(alimento);
	}
	
	public ArrayList<Alimento> getCesta(){
		return this.productos;
	}

}
