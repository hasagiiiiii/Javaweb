package DoVanTrung_main;

import java.util.List;

import DoVanTrung_DAo.EmployeeDao_Impl;
import Entity.Employee;


public class Employee_Select {
	public static void main(String[] args) {
		List<Employee> list = new EmployeeDao_Impl().getAllProduct();
		if(list == null) 
			return;
		for(Employee item:list) {
			System.out.printf("\n%-10s", item.getEmpId());
			System.out.printf("%-15s", item.getDepartment());
			System.out.printf("% 15d", item.getEmpName());
			System.out.printf("% 15.0f", item.getEmpNo());
			System.out.printf("% 15.0f", item.getHireDate());
			System.out.printf("% 15.0f", item.getJob());
			System.out.printf("% 15.0f", item.getSalary());
		}
	}
}
