package es.upm.dit.isst.Labo17.dao;

import es.upm.dit.isst.Labo17.model.PartidoPolitico;

import java.util.Collection;

import org.hibernate.Session;



public class PartidoPoliticoDAOImplementation implements PartidoPoliticoDAO{
	
	private static PartidoPoliticoDAOImplementation instancia = null;
	
	private PartidoPoliticoDAOImplementation() {}
	
	public static PartidoPoliticoDAOImplementation getInstance() {
		if (null == instancia) instancia = new PartidoPoliticoDAOImplementation();
		return instancia;
	}
	
	

	@Override
	public void create(PartidoPolitico partido) {
		// TODO Auto-generated method stub
		
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.save(partido);
		session.getTransaction().commit();
		session.close();
		
		
	}

	@Override
	public PartidoPolitico read(String acronimo) {
		// TODO Auto-generated method stub
		
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		PartidoPolitico partido = session.get(PartidoPolitico.class, acronimo);
		session.getTransaction().commit();
		session.close();
		return partido;		
		
		
	}

	@Override
	public void update(PartidoPolitico partido) {
		// TODO Auto-generated method stub
		
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.saveOrUpdate(partido);
		session.getTransaction().commit();
		session.close();
		
		
	}

	@Override
	public void delete(PartidoPolitico partido) {
		// TODO Auto-generated method stub
		
		
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.delete(partido);
		session.getTransaction().commit();
		session.close();
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Collection<PartidoPolitico> readAll() {
		// TODO Auto-generated method stub
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		
		Collection<PartidoPolitico> partidoPolitico = session.createQuery("from Eleccion").list();
		session.getTransaction().commit();
		session.close();
		return partidoPolitico;	
		
	}

}
