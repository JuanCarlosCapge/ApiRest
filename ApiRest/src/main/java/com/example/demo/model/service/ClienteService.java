package com.example.demo.model.service;

import java.util.List;

import com.example.demo.models.entity.Cliente;

public interface ClienteService {

	public List<Cliente>  findAll();
	public  Cliente findById (Long id);
	public Cliente save(Cliente cliente);
	public void delete(long id);
	
}
