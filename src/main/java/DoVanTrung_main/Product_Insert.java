package DoVanTrung_main;

import DoVanTrung_DAo.ProductDao_Impl;
import DoVanTrung_entity.Product;

public class Product_Insert {
	public static void main(String[] args) {
		Product p = new Product();
		p.setMaSP("P0004");
		p.setTenSanPham("Kệ để giày");
		p.setAnhSanPham("P0005.jpg");
		p.setSoLuong(150);
		p.setDonGia(1990000d);
		
		
		boolean flag = new  ProductDao_Impl().insertProduct(p);
		if(flag == true) {
			System.out.printf("Thêm mới thành công !!!");
		}else {
			System.out.printf("Xảy ra lỗi khi thêm mới sản phẩm :))");
		}
	}
}
