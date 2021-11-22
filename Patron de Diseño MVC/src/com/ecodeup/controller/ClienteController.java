package com.ecodeup.controller;

import com.ecodeup.model.Cliente;
import com.ecodeup.view.ClienteView;

public class ClienteController {
	
	//objeto vista y modelo
	
	private ClienteView vista;
	private Cliente modelo;
	
	//constructor para inicializar modelo y la vista
	
	public ClienteController(Cliente modelo, ClienteView vista) {
		this.modelo = modelo;
		this.vista = vista;
	}

	public int getId() {
		return modelo.getId();
	}
	
	public void setId(int id) {
		this.modelo.setId(id);
	}
	
	public String getNombre() {
		return modelo.getNombre();
	}
	
	public void setNombre(String nombre) {
		this.modelo.setNombre(nombre);
	}
	
	public String getApellido() {
		return modelo.getApellido();
	}
	
	public void setApellido(String apellido) {
		this.modelo.setApellido(apellido);
	}
	
	
	public void actualizarVista() {
		vista.imprimirDatosCliente(modelo.getId(),
				modelo.getNombre(), modelo.getApellido());
	}
	
	
	
	

}
