package es.upm.dit.isst.Labo17.dao;

import java.util.Collection;
import es.upm.dit.isst.Labo17.model.Eleccion;


public interface EleccionDAO {

	public void create(Eleccion eleccion);
	
	public Eleccion read(Integer id);
	
	public void update(Eleccion eleccion);
	
	public void delete(Eleccion eleccion);
	
	public Collection<Eleccion> readAll();
	
	
}
