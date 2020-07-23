package in.nit.dao;
import java.sql.Blob;
import java.util.List;

import in.nit.model.Employee;
public interface IEmployeeDao{
	public Integer saveEmployee(Employee ob);
	
	public List<Employee> getAllEmployee();
	
	public Blob getPhotoById(int id); 
	
	public void deleteEmployee(Integer id);
	
	public Employee getOneEmployee(Integer id);

	
	
}