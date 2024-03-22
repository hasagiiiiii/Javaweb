package HibernateUtil;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import Entity.Product;

public class HiberUtil {
	private static StandardServiceRegistry standardServiceRegistry;
	private static SessionFactory sessionFactory;
	static {
		try {
            Configuration config = new Configuration().configure();
//            ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
//            sessionFactory = config.buildSessionFactory(reg);
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().configure();
            sessionFactory = config.buildSessionFactory(builder.build());
        }catch(Throwable ex) {
            ex.printStackTrace();
        }
		}
	 public static SessionFactory getSessionFactory() {
         return sessionFactory;
 }
	}

