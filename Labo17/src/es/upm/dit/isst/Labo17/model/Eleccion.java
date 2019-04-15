package es.upm.dit.isst.Labo17.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Eleccion implements Serializable{
	
	@Id
	private int id;
	
	private int ley;
	private int tipo;
	private Comunidad comunidad;
	
	
	@OneToMany(mappedBy = "partido", fetch = FetchType.EAGER)
	private Collection<Resultado> resultados;
	
	public Eleccion() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLey() {
		return ley;
	}

	public void setLey(int ley) {
		this.ley = ley;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public Comunidad getComunidad() {
		return comunidad;
	}

	public void setComunidad(Comunidad comunidad) {
		this.comunidad = comunidad;
	}

	public Collection<Resultado> getResultados() {
		return resultados;
	}

	public void setResultados(Collection<Resultado> resultados) {
		this.resultados = resultados;
	}
	
	
}