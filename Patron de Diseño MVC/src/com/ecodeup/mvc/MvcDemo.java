package com.ecodeup.mvc;

import com.ecodeup.controller.ClienteController;
import com.ecodeup.model.Cliente;
import com.ecodeup.view.ClienteView;

public class MvcDemo {

	public static void main(String[] args) {

		//objeto vista modelo creando con el metodo estatico, creamos objeto controador
		
		Cliente modelo = rellenarDatosCliente();
		ClienteView vista =  new ClienteView();
		
		// se crea un objeto controlador y se le pasa el modelo a la vista
		
		ClienteController controlador = new ClienteController(modelo, vista);
		
		// se muestra los datos del cliente
		
		controlador.actualizarVista();
		
		//se actualiza un cliente y se muestra de nuevo los datos
		controlador.setNombre("Juan Carlos");
		controlador.actualizarVista();
		
	}

	private static Cliente rellenarDatosCliente() {
		Cliente cliente = new Cliente();
		cliente.setId(1);
		cliente.setNombre("Carlos");
		cliente.setApellido("Pedraza");
		
		

		
		return cliente;
	}

}
