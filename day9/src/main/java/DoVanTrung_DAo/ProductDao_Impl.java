package DoVanTrung_DAo;

import java.util.List;

import org.hibernate.Session;

import Entity.TbProduct;
import HibernateUtils.HibernateUti;

public class ProductDao_Impl implements Product_DAO {
	@Override
	public List<TbProduct> getAllProduct() {
		Session session = 
				HibernateUti.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			List<TbProduct> list = session.createQuery("from TbProduct").list();
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
	public TbProduct getProductById(String id) {
		Session session = 
				HibernateUti.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			TbProduct product = (TbProduct)session.createQuery("from Product where MaSP = :maSp").setParameter("maSp", id).uniqueResult();			
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
	public boolean insertProduct(TbProduct product) {
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
	public boolean updateProduct(TbProduct product) {
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
			int res = session.createQuery("delete from Product where MaSP = :maSp").setParameter("maSp", id).executeUpdate();
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
