package DoVanTrung_main;
import DoVanTrung_DAo.EmployeeDao_Impl;
import Entity.Employee;

public class Employee_Update {
	public static void main(String[] args) {
		Employee p = new EmployeeDao_Impl().getProductById("P0004");
//		
		boolean flag = new EmployeeDao_Impl().updateProduct(p);
		if(flag == true) {
			System.out.printf("Sửa đổi dữ liệu thành công !!!");
		}else {
			System.out.printf("Xảy ra lỗi khi sửa sản phẩm :))");
		}
		
	}
}
