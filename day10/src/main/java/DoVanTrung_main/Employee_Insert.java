package DoVanTrung_main;

import java.math.BigInteger;

import DoVanTrung_DAo.EmployeeDao_Impl;
import Entity.Department;
import Entity.Employee;

public class Employee_Insert {
	public static void main(String[] args) {
		Employee p = new Employee();
		BigInteger emid = new BigInteger("12345678901234567890");
		Department dept = new Department(0, "123", null);
//		Employee emol = new Employee('ad',123);
		p.setEmpId(emid);
		p.setDepartment(dept);
//		p.setAnhSanPham("P0005.jpg");
//		p.setSoLuong(150);
//		p.setDonGia(1990000d);
		
		
		boolean flag = new  EmployeeDao_Impl().insertProduct(p);
		if(flag == true) {
			System.out.printf("Thêm mới thành công !!!");
		}else {
			System.out.printf("Xảy ra lỗi khi thêm mới sản phẩm :))");
		}
	}
}
