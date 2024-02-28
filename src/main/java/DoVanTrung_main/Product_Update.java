package DoVanTrung_main;
import DoVanTrung_DAo.ProductDao_Impl;
import DoVanTrung_entity.Product;
public class Product_Update {
	public static void main(String[] args) {
		Product p = new ProductDao_Impl().getProductById("P0004");
		p.setMaSP("P0004");
		p.setTenSanPham("Kệ để giày nam");
		p.setAnhSanPham("P0004.jpg");
		p.setSoLuong(150);
		p.setDonGia(2990000d);
		
		boolean flag = new ProductDao_Impl().updateProduct(p);
		if(flag == true) {
			System.out.printf("Sửa đổi dữ liệu thành công !!!");
		}else {
			System.out.printf("Xảy ra lỗi khi sửa sản phẩm :))");
		}
		
	}
}