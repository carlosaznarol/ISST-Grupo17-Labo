package es.upm.dit.isst.Labo17.dao;

import java.util.Collection;
import org.hibernate.Session;


import es.upm.dit.isst.Labo17.model.Resultado;


public class ResultadoDAOImplementation implements ResultadoDAO{
	
	private static ResultadoDAOImplementation instancia = null;
	
	private ResultadoDAOImplementation() {}
	
	public static ResultadoDAOImplementation getInstance() {
		if (null == instancia) instancia = new ResultadoDAOImplementation();
		return instancia;
	}
	
	

	@Override
	public void create(Resultado resultado) {
		// TODO Auto-generated method stub
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.save(resultado);
		session.getTransaction().commit();
		session.close();
		
	}

	@Override
	public Resultado read(Integer id) {
		// TODO Auto-generated method stub
		
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		Resultado resultado = session.get(Resultado.class, id);
		session.getTransaction().commit();
		session.close();
		return resultado;
		
		
	}

	@Override
	public void update(Resultado resultado) {
		// TODO Auto-generated method stub
		try {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.saveOrUpdate(resultado);
		session.getTransaction().commit();
		session.close();
		}catch(Exception e) {
			System.out.println(">>>>>>>>> OTRA VEZ EL FALLO");
		}
		
	}

	@Override
	public void delete(Resultado resultado) {
		// TODO Auto-generated method stub
		
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.delete(resultado);
		session.getTransaction().commit();
		session.close();
		
	}
	@SuppressWarnings("unchecked")
	@Override
	public Collection<Resultado> readAll() {
		// TODO Auto-generated method stub
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		
		Collection<Resultado> resultado = session.createQuery("from Resultado").list();
		session.getTransaction().commit();
		session.close();
		return resultado;
		
		
		
	}

}
