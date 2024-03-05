package DoVanTrung_DAo;

import java.util.List;

import org.hibernate.Session;

import Entity.Employee;
import HibernateUtils.HibernateUti;

public class EmployeeDao_Impl implements Employee_DAO {
	@Override
	public List<Employee> getAllProduct() {
		Session session = 
				HibernateUti.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			List<Employee> list = session.createQuery("from Employee").list();
			session.getTransaction().commit();
			session.close();
			return list;
		}catch(Exception ex) {
			ex.printStackTrace();
			session.close();
		}
		return null;
	}

	@Override
	public Employee getProductById(String id) {
		Session session = 
				HibernateUti.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			Employee product = (Employee)session.createQuery("from Product where empId = :empId").setParameter("maSp", id).uniqueResult();			
			session.getTransaction().commit();
			session.close();
			return product;
		}catch(Exception ex) {
			ex.printStackTrace();
			session.close();
		}
		return null;
	}

	@Override
	public boolean insertProduct(Employee product) {
		Session session = 
				HibernateUti.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.save(product);
			session.getTransaction().commit();
			session.close();
			return true;
		}catch(Exception ex) {
			ex.printStackTrace();
			session.close();
		}
		return false;
	}

	@Override
	public boolean updateProduct(Employee product) {
		Session session = 
				HibernateUti.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.update(product);
			session.getTransaction().commit();
			session.close();
			return true;
		}catch(Exception ex) {
			ex.printStackTrace();
			session.close();
		}
		return false;
	}

	@Override
	public boolean deleteProduct(String id) {
		Session session = 
				HibernateUti.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			int res = session.createQuery("delete from Employee where empId = :empId").setParameter("empId", id).executeUpdate();
			session.getTransaction().commit();
			session.close();
			if(res > 0)
				return true;
		}catch(Exception ex) {
			ex.printStackTrace();
			session.close();
		}
		return false;
	}
}
