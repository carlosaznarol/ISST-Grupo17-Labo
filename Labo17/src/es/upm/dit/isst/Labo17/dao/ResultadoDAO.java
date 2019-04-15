package es.upm.dit.isst.Labo17.dao;


import java.util.Collection;


import es.upm.dit.isst.Labo17.model.Resultado;

public interface ResultadoDAO {
	
	public void create(Resultado resultado);
	
	public Resultado read(Integer id);
	
	public void update(Resultado resultado);
	
	public void delete(Resultado resultado);
	
	public Collection<Resultado> readAll();
	

}
