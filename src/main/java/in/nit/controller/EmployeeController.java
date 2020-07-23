package in.nit.controller;


import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import in.nit.model.Employee;
import in.nit.service.IEmployeeService;

@Controller
@RequestMapping("/emp")
public class EmployeeController {
	@Autowired
	public IEmployeeService service;
	
	//1. show Documents Upload Page
	@RequestMapping("/register")
	public String showUploadPage(Model model) {
		return "EmployeeRegister";
	}
	//2. upload data into DB
		@RequestMapping(value = "/upload",method = RequestMethod.POST)
		public String doUpload(
				@RequestParam String empName,
				@RequestParam String email,
				@RequestParam int empMbl,
				@RequestParam List<String> roles,
				@RequestParam String addr1,
				@RequestParam String addr2,
				@RequestParam String addr3,
				@RequestParam String idtype,
				@RequestParam Integer idnum,
				@RequestParam CommonsMultipartFile fileOb,
			 RedirectAttributes redirectAttribute) 
		
		{
			if(fileOb!=null) {
				Employee ob=new Employee();
			
				ob.setEmpName(empName);
				ob.setEmail(email);
				ob.setEmpMbl(empMbl);
				ob.setRoles(roles);
				ob.setAddr1(addr1);
				ob.setAddr2(addr2);
				ob.setAddr3(addr3);
				ob.setIdtype(idtype);
				ob.setIdnum(idnum);
				ob.setFileName(fileOb.getOriginalFilename());
				ob.setFileData(fileOb.getBytes());
				service.saveEmployee(ob);



			}
		
			//response.sendRedirect
			redirectAttribute.addFlashAttribute("msg","Hey'"+ empName +"' Successfully Register");
			return "redirect:register";
		}				
	@RequestMapping("/all")//Get
	public String getAllEmployee(Model model) {
		List<Employee> list=service.getAllEmployee();
		model.addAttribute("list",list);
		model.addAttribute("opr", null);
		return "EmployeeData";
		
	}
	@RequestMapping(value= "/getemployeephoto/{id}", method=RequestMethod.GET)
	public void getEmployeePhoto(HttpServletResponse res, @PathVariable("id") Integer id)
			throws Exception{
		res.setContentType("image/jpeg");
		Blob ph=service.getPhotoById(id);
		byte[] bytes=ph.getBytes(1, (int) ph.length());
		InputStream inputStream=new ByteArrayInputStream(bytes);
		IOUtils.copy(inputStream, res.getOutputStream());
	}
	@RequestMapping("/delete")
	public String deleteEmployee(@RequestParam("id") Integer id, Model model) {
		service.deleteEmployee(id);
		String message="Employee" + id + "deleted";
		model.addAttribute("message", message );
		model.addAttribute("opr","del");
		
		
		//Fetch New Data
		List<Employee> list=service.getAllEmployee();
		model.addAttribute("list",list);
		return "EmployeeData";
		
		
	}


	@RequestMapping("/edit")
	public String showEditPage(@RequestParam("id") Integer id, 
			Model model)
	{
		Employee e=service.getOneEmployee(id);
		model.addAttribute("employee",e);
		return "EmployeeEdit";
		
	}
	
	
	
	
	
}

	
	
	
	
