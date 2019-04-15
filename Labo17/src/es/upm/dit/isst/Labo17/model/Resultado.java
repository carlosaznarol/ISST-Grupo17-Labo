package es.upm.dit.isst.Labo17.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Resultado implements Serializable{
	
	@Id
	private int id;
	
	private int escanos;
	private int votosObtenidos;
	
	@ManyToOne
	private PartidoPolitico partido;
	
	public Resultado() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEscanos() {
		return escanos;
	}

	public void setEscanos(int escanos) {
		this.escanos = escanos;
	}

	public int getVotosObtenidos() {
		return votosObtenidos;
	}

	public void setVotosObtenidos(int votosObtenidos) {
		this.votosObtenidos = votosObtenidos;
	}

	public PartidoPolitico getPartido() {
		return partido;
	}

	public void setPartido(PartidoPolitico partido) {
		this.partido = partido;
	}
	
	
}