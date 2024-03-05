package DoVanTrung_DAo;

import java.util.List;


import Entity.Employee;

public interface Employee_DAO {
	public List<Employee> getAllProduct();
	public Employee getProductById(String id);
	public boolean insertProduct(Employee employee);
	public boolean updateProduct(Employee employee);
	public boolean deleteProduct(String id);
}
