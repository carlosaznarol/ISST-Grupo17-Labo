package es.upm.dit.isst.Labo17.dao;

import java.util.Collection;

import org.hibernate.Session;

import es.upm.dit.isst.Labo17.model.Comunidad;




public class ComunidadDAOImplementation implements ComunidadDAO {
	
	private static ComunidadDAOImplementation nombre = null;
	
	private ComunidadDAOImplementation() {}
	
	public static ComunidadDAOImplementation getInstance() {
		if (null == nombre) nombre = new ComunidadDAOImplementation();
		return nombre;
	}
	
	
	@Override
	public void create(Comunidad comunidad) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.save(comunidad);
			session.getTransaction().commit();
		}catch (Exception e){
			System.out.println("ERROR!!! CREAR COMUNIDAD");
		}finally {
			 session.close();
		}
	}

	@Override
	public Comunidad read(String nombre) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		Comunidad comunidad = session.get(Comunidad.class, nombre);
		session.getTransaction().commit();
		session.close();
		return comunidad;
	}

	@Override
	public void update(Comunidad comunidad) {
		// TODO Auto-generated method stub
		
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.saveOrUpdate(comunidad);
		session.getTransaction().commit();
		session.close();
		
		
	}

	@Override
	public void delete(Comunidad comunidad) {
		// TODO Auto-generated method stub
		
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.delete(comunidad);
		session.getTransaction().commit();
		session.close();
		
	}

	@Override
	public Collection<Comunidad> readAll() {
		// TODO Auto-generated method stub
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		
		Collection<Comunidad> comunidad = session.createQuery("from Comunidad").list();
		session.getTransaction().commit();
		session.close();
		return comunidad;
		
		
		
	}
	
	
	
	

}
