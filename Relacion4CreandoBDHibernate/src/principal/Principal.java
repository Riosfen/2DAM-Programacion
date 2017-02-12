package principal;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import persistencia.Pelicula;

public class Principal {

	public static void main(String[] args) {
		
		SessionFactory factoria;
		
		Configuration configuracion = new Configuration();
		configuracion.configure();
		ServiceRegistry servicio = new ServiceRegistryBuilder().applySettings(configuracion.getProperties()).buildServiceRegistry();
		factoria = configuracion.buildSessionFactory(servicio);
		Session sesion = factoria.openSession();
		
		sesion.beginTransaction(); // TODO error no se ha podido abrir la conexion
		
		sesion.save();
		
		sesion.getTransaction().commit();
		
		sesion.close();

	}

}
