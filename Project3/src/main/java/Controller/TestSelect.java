package Controller;

import java.util.List;

import Dao.ProductImpl;
import Entity.Product;

public class TestSelect {
	public static void main(String[] args) {
		List<Product> list = new ProductImpl().getAllProduct();
		if(list == null) {
			return;
		}
		for(Product itemProduct:list) {
			System.out.printf("%-15s",itemProduct.getNameProduct() );
		}
	}
}
