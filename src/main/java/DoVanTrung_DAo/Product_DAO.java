package DoVanTrung_DAo;

import java.util.List;

import DoVanTrung_entity.Product;

public interface Product_DAO {
	public List<Product> getAllProduct();
	public Product getProductById(String id);
	public boolean insertProduct(Product product);
	public boolean updateProduct(Product product);
	public boolean deleteProduct(String id);
}
