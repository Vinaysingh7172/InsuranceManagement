package in.nit.service.impl;




import java.sql.Blob;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.nit.dao.IEmployeeDao;
import in.nit.model.Employee;
import in.nit.service.IEmployeeService;

@Service
public class EmployeeServiceImpl 
	implements IEmployeeService{
	@Autowired
	public IEmployeeDao dao;
	@Transactional
	public Integer saveEmployee(Employee ob) {
		return dao.saveEmployee(ob);
	}
	@Transactional(readOnly = true)
	public List<Employee> getAllEmployee() {
		List<Employee> list=dao.getAllEmployee();
		Collections.sort(list, (o1,o2)->o1.getId());
		return list;
	}
	
	  @Transactional
		public Blob getPhotoById(int id) {

			return dao.getPhotoById(id);
		}

	
	
	@Transactional
	public void deleteEmployee(Integer id) {
		dao.deleteEmployee(id);

		
	}
	@Transactional(readOnly = true)
	public Employee getOneEmployee(Integer id) {
		
		return dao.getOneEmployee(id);
	}
	
	
	
 



	
}