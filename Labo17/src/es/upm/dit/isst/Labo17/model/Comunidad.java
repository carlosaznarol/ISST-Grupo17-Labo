package es.upm.dit.isst.Labo17.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Comunidad implements Serializable{

	@Id
	private String nombre;
	
	private int escanos;
	private int censo;
	
	//private String acronimo;
	public Comunidad() {
		
	}

	/*public String getAcronimo() {
		return acronimo;
	}*/

	/*public void setAcronimo(String acronimo) {
		this.acronimo = acronimo;
	}*/

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEscanos() {
		return escanos;
	}

	public void setEscanos(int escanos) {
		this.escanos = escanos;
	}

	public int getCenso() {
		return censo;
	}

	public void setCenso(int censo) {
		this.censo = censo;
	}
	
	
}
