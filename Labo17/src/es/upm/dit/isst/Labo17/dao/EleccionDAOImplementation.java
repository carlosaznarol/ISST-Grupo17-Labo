package es.upm.dit.isst.Labo17.dao;



import java.util.Collection;

import org.hibernate.Session;
import es.upm.dit.isst.Labo17.model.Eleccion;


public class EleccionDAOImplementation implements EleccionDAO {
	
	
	private static EleccionDAOImplementation instancia = null;
	
	private EleccionDAOImplementation() {}
	
	public static EleccionDAOImplementation getInstance() {
		if (null == instancia) instancia = new EleccionDAOImplementation();
		return instancia;
	}
	
		
	

	@Override
	public void create(Eleccion eleccion) {
		// TODO Auto-generated method stub
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.save(eleccion);
		session.getTransaction().commit();
		session.close();
		
		
	}

	@Override
	public Eleccion read(Integer id) {
		// TODO Auto-generated method stub
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		Eleccion eleccion = session.get(Eleccion.class, id);
		session.getTransaction().commit();
		session.close();
		return eleccion;
	}

	@Override
	public void update(Eleccion eleccion) {
		// TODO Auto-generated method stub
		
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.saveOrUpdate(eleccion);
		session.getTransaction().commit();
		session.close();
		
		
		
	}

	@Override
	public void delete(Eleccion eleccion) {
		// TODO Auto-generated method stub
		
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.delete(eleccion);
		session.getTransaction().commit();
		session.close();
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Collection<Eleccion> readAll() {
		// TODO Auto-generated method stub
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		
		Collection<Eleccion> eleccion = session.createQuery("from Eleccion").list();
		session.getTransaction().commit();
		session.close();
		return eleccion;	
		
	}

}
