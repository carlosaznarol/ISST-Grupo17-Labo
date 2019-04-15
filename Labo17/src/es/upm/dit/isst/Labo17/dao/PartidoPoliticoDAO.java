package es.upm.dit.isst.Labo17.dao;

import java.util.Collection;
import es.upm.dit.isst.Labo17.model.PartidoPolitico;

public interface PartidoPoliticoDAO {
	
	public void create(PartidoPolitico partido);
	
	public PartidoPolitico read(String acronimo);
	
	public void update(PartidoPolitico partido);
	
	public void delete(PartidoPolitico partido);
	
	public Collection<PartidoPolitico> readAll();

}
