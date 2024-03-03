package DoVanTrung_main;

import java.util.List;

import DoVanTrung_DAo.ProductDao_Impl;
import Entity.TbProduct;


public class Product_Select {
	public static void main(String[] args) {
		List<TbProduct> list = new ProductDao_Impl().getAllProduct();
		if(list == null) 
			return;
		for(TbProduct item:list) {
			System.out.printf("\n%-10s", item.getMaSP());
			System.out.printf("%-15s", item.getTenSanPham());
			System.out.printf("% 15d", item.getSoLuong());
			System.out.printf("% 15.0f", item.getDonGia());
		}
	}
}
