package DoVanTrung_DAo;

import java.util.List;


import Entity.TbProduct;

public interface Product_DAO {
	public List<TbProduct> getAllProduct();
	public TbProduct getProductById(String id);
	public boolean insertProduct(TbProduct product);
	public boolean updateProduct(TbProduct product);
	public boolean deleteProduct(String id);
}