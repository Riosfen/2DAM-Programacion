package patronDAO;

import org.hibernate.Session;

public class GenericDAO<T> {
	
	public void guardar(T entidad) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(entidad);
		session.getTransaction().commit();

	}
	
	public  void borrar(T entidad) {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.delete(entidad);
		session.getTransaction().commit();
	}

}
