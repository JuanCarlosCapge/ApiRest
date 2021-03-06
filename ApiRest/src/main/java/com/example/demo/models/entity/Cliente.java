package com.example.demo.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Cliente")
public class Cliente implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false)
	private String nombre;
	private String apellido;
	
	@Column(nullable = false,unique = true)
	private String email;
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getCreatAt() {
		return creatAt;
	}
	public void setCreatAt(Date creatAt) {
		this.creatAt = creatAt;
	}
	public String getEmail() {
		return email;
	}


	private int telefono;
	private Date creteAt;
	//nombre,apellido,email,telefono,create_at
	
	@Column(name="create_at")
	@Temporal(TemporalType.DATE)
	private Date creatAt;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public Date getCreteAt() {
		return creteAt;
	}
	public void setCreteAt(Date creteAt) {
		this.creteAt = creteAt;
	}
	
	private String imagen;
	
	
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

}
