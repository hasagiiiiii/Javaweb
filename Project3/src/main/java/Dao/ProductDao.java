package Dao;

import java.util.List;

import Entity.Product;

public interface ProductDao {
	public List<Product> getAllProduct();
	public Product getProductById(int id);
	public boolean insertProduct (Product product);
	public boolean updateProduct (Product product);
	public boolean deleteProduct (int id);
}
