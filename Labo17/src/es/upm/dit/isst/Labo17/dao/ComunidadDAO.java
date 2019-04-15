package es.upm.dit.isst.Labo17.dao;

import java.util.Collection;

import es.upm.dit.isst.Labo17.model.Comunidad;



public interface ComunidadDAO {
	
	public void create(Comunidad comunidad);
	
	public Comunidad read(String nombre);
	
	public void update(Comunidad comunidad);
	
	public void delete(Comunidad comunidad);
	
	public Collection<Comunidad> readAll();
	
	

}
