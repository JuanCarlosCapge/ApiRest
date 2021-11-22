package com.example.demo.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.service.ClienteService;
import com.example.demo.models.entity.Cliente;

@RestController
@RequestMapping("/api")
	public class ClienteRestController {
	
		@Autowired
		private ClienteService clienteService;
	
		@GetMapping("/cliente")
		private List<Cliente> index(){
			return clienteService.findAll();
		}
		
		@GetMapping("/cliente/{id}")
		public Cliente show (@PathVariable Long id) {
			return clienteService.findById(id);
		
		}
		
		@PutMapping("/clientes")
		@ResponseStatus(HttpStatus.CREATED)
		public Cliente update(@RequestBody Cliente cliente,@PathVariable Long id) {
			Cliente clienteUpdate = clienteService.findById(id);
			clienteUpdate.setApellido(cliente.getApellido());
			clienteUpdate.setNombre(cliente.getNombre());
			clienteUpdate.setEmail(cliente.getEmail());
			
			return clienteService.save(clienteUpdate);
			
		}
		
		
		@PostMapping("/cliente")
		public Cliente guardar (@RequestBody Cliente c) {
		return clienteService.save(c);
				 
		}
		
		
		
}
