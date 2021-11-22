package com.example.demo.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.entity.Cliente;

public interface ClienteDao  extends CrudRepository<Cliente, Long> {
	

}
