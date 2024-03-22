package Dao;

import java.util.List;

import org.hibernate.Session;

import Entity.Product;
import HibernateUtil.HiberUtil;

public class ProductImpl implements ProductDao{

	@Override
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		// Mở 1 sesion mới từ SessionFactory của Hibernate
		Session session = HiberUtil.getSessionFactory().openSession();
		try {
			// Bắt đầu sesion
			session.beginTransaction();
			// Truy vấn tất cả sản phẩm của tb.Product 
			List<Product> list = session.createQuery("from Product").list();
			// Kết thúc sesion
			session.getTransaction().commit();
			//Đóng sesion
			session.close();
			// Retrun all Product
			return list;
		}catch(Exception e) {
			e.printStackTrace();
			session.close();
		}
		return null;
	}

	@Override
	public Product getProductById(int id) {
		// TODO Auto-generated method stub
		// Mở 1 sesion mới từ SessionFactory của Hibernate
				Session session = HiberUtil.getSessionFactory().openSession();
				try {
					// Bắt đầu sesion
					session.beginTransaction();
					// Truy vấn sản phẩm theo id của tb.Product 
					Product product= (Product)session.createQuery("from Product where id_product = :idProduct").setParameter("idProduct", id).uniqueResult();
					// Kết thúc sesion
					session.getTransaction().commit();
					//Đóng sesion
					session.close();
					// Retrun all Product
					return product;
				}catch(Exception e) {
					e.printStackTrace();
					session.close();
				}
		return null;
	}

	@Override
	public boolean insertProduct(Product product) {
		// TODO Auto-generated method stub
		// Mở 1 sesion mới từ SessionFactory của Hibernate
		Session session = HiberUtil.getSessionFactory().openSession();
		try {
			//start session
			session.beginTransaction();
			// save product vao session
			session.save(product);
			// ket thuc session
			session.getTransaction().commit();
			// Dong session
			session.close();
			return true;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.close();
		}
		return false;
	}

	@Override
	public boolean updateProduct(Product product) {
		// TODO Auto-generated method stub
		//Mở 1 phiên sesion trong sesion Factory 
		Session session = HiberUtil.getSessionFactory().openSession();
		try {
			//mở một session
			session.beginTransaction();
			session.save(product);
			session.getTransaction().commit();
			session.close();
			return true;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.close();
		}
		return false;
	}

	@Override
	public boolean deleteProduct(int id) {
		// TODO Auto-generated method stub
		Session session = HiberUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			int deleteP = (int) session.createQuery("delete from Product where id_product = :idProduct").setParameter("idProduct", id).executeUpdate();
			session.getTransaction().commit();
			session.close();
			if(deleteP > 0) {
				return true;
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.close();
		}
		return false;
	}
	
}
