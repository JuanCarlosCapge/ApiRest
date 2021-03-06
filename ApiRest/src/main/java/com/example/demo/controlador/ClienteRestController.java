package com.example.demo.controlador;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.support.Repositories;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.service.ClienteService;
import com.example.demo.models.entity.Cliente;

@RestController
@RequestMapping("/api")
	public class ClienteRestController {
	// cambio repositorio
	
		@Autowired
		private ClienteService clienteService;
	
		@GetMapping("/cliente")
		private List<Cliente> index(){
			return clienteService.findAll();
		}
		/*
		@GetMapping("/cliente/{id}")
		public Cliente show (@PathVariable Long id) {
			return clienteService.findById(id);
		
		}
		*/
		@GetMapping("/cliente/{id}")
		public ResponseEntity<?> show (@PathVariable Long id) {
			Cliente cliente = null;
			HashMap<String, Object> response = new HashMap<>();
			
			try {
				cliente = clienteService.findById(id);
			}catch (DataAccessException e){
			response.put("mensaje", "Error al realizar consulta en la BBDD");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
			
			}
			
			if(cliente == null) {
				response.put("mensaje", "El cliente ID: ".concat(id.toString().concat("no existe en la base de datos")));
				return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
			}
			
			
			return new ResponseEntity<Cliente>(cliente,HttpStatus.OK);
		
		}
		
		/*@PutMapping("/clientes")
		@ResponseStatus(HttpStatus.CREATED)
		public Cliente update(@RequestBody Cliente cliente,@PathVariable Long id) {
			Cliente clienteUpdate = clienteService.findById(id);
			clienteUpdate.setApellido(cliente.getApellido());
			clienteUpdate.setNombre(cliente.getNombre());
			clienteUpdate.setEmail(cliente.getEmail());
			
			return clienteService.save(clienteUpdate);
			
		}*/
		
		@PutMapping("/clientes")
		public ResponseEntity<?> update(@RequestBody Cliente cliente, @PathVariable Long id){
			Cliente clienteActual = clienteService.findById(id);
			
			Cliente clienteUpdated= null;
			Map<String,Object> response = new HashMap<>();
			
			if(clienteActual == null) {
				response.put("mensaje","Error no se puedo editar, el cliente ID".concat(id.toString().concat("no existe la base de datos")));
				return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
			}
			try {
				clienteActual.setApellido(cliente.getApellido());
				clienteActual.setNombre(cliente.getNombre());
				clienteActual.setEmail(cliente.getEmail());
				clienteActual.setTelefono(cliente.getTelefono());
				clienteActual.setCreatAt(cliente.getCreatAt());
			
				clienteUpdated = clienteService.save(clienteActual);
				
			}catch(DataAccessException e) {
				response.put("mensaje" , "Error al actualizar el cliente en BBDD");
				response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
				return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
			}
				
				response.put("mensaje", "El cliente ha sido actualizado con ??xito");
				response.put("cliente", clienteUpdated);
				
				return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
			}
		
		
		/*@PostMapping("/cliente")
		public Cliente guardar (@RequestBody Cliente c) {
		return clienteService.save(c);
				 
		}*/
		
		@PostMapping("/cliente")
		public ResponseEntity<?> create(@RequestBody Cliente cliente){
			Cliente clienteNew=null;
			Map<String, Object> response = new HashMap<String, Object>();
			
			try {
				clienteNew = clienteService.save(cliente);
			}catch(DataAccessException e) {
				response.put("Mensaje", "Error al realizar insert en base de datos");
				response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
				return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
				
			}
			response.put("mensaje","el cliente ha sido creado con ??xito");
			response.put("cliente",clienteNew);
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.CREATED);
			
			
		}
		
		@DeleteMapping("cliente/{id}")
		public ResponseEntity<?> delete (@PathVariable Long id){
			Map<String,Object> response = new HashMap();
			
			
			try {
				clienteService.delete(id);
			}catch (DataAccessException e){
				response.put("mensaje", "error al eliminar el cliente en la base de datos");
				response.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
				
				return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);	
				
			}
			
			response.put("mensaje", "el cliente ha sido eliminado con ??xito");
			
			return new ResponseEntity<Map<String,Object>>(HttpStatus.OK);
		
		
		}
		
		@PostMapping("cliente/upload")
		public ResponseEntity<?> upload(@RequestParam("archivo")MultipartFile archivo, @RequestParam("id")Long id){
			
			Map<String,Object> response = new HashMap<String, Object>();
			Cliente cliente = clienteService.findById(id);
			
			if(!archivo.isEmpty()) {
				String nombreArchivo = UUID.randomUUID().toString()+"_"+archivo.getOriginalFilename().replace(" ","");
				//String nombreArchivo = archivo.getOriginalFilename();
				Path rutaArchivo = Paths
						.get("uploads").resolve(nombreArchivo).toAbsolutePath();
				
				try {
					Files.copy(archivo.getInputStream(),rutaArchivo);
					
				}catch (IOException e) {
					response.put("mensaje","Error al subir la imagen del cliente");
					response.put("error",e.getMessage().concat(": ").concat(e.getCause().getMessage()));
					return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
					
							
				}
				
				String nombreFotoAnterior = cliente.getImagen();
				
				if(nombreFotoAnterior != null && nombreFotoAnterior.length()> 0) {
					
					Path rutaFotoAnterior = Paths.get("uploads").resolve(nombreFotoAnterior).toAbsolutePath();
					File archivoFotoAnterior = rutaFotoAnterior.toFile();
					
					if(archivoFotoAnterior.exists()&& archivoFotoAnterior.canRead()) {
						archivoFotoAnterior.delete();
					}
					
				}
				cliente.setImagen(nombreArchivo);
				
				clienteService.save(cliente);
				response.put("mensaje", "has subido correctamente la imagen" + nombreArchivo);
				
			}
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.CREATED);
		}
			
}
