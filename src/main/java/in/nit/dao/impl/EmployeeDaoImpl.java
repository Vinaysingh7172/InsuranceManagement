package in.nit.dao.impl;


import java.sql.Blob;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import in.nit.dao.IEmployeeDao;
import in.nit.model.Employee;


@Repository
public class EmployeeDaoImpl implements IEmployeeDao {
	
	
	public JdbcTemplate jdbcTemp;
	public EmployeeDaoImpl(DataSource dataSource) {
		jdbcTemp = new JdbcTemplate(dataSource);
	}
	
	
	
	@Autowired
	public HibernateTemplate ht;
	@Override
	
	
	public Integer saveEmployee(Employee ob) {
		
		return (Integer) ht.save(ob);
	}
	
	
	public List<Employee> getAllEmployee() 
	{
		return ht.loadAll(Employee.class);
	}
	
	
	@Override
	public Blob getPhotoById(int id) {
		String query="select fileData from Employee where id=?" ;
		Blob fileData=jdbcTemp.queryForObject(query,new Object[] {id}, Blob.class);
		return fileData;
	}
	
	
	public void deleteEmployee(Integer id) {
		 ht.delete(new Employee(id));
		
	}
	
	public Employee getOneEmployee(Integer id) {
		return ht.get(Employee.class, id);
	}




	
	
}