package in.nit.model;

import java.util.Arrays;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="etab")
public class Employee 
{
	@Id
	@GeneratedValue
	private Integer id;
	private String empName;
	private String email;
	private int empMbl;
	@ElementCollection()

	@CollectionTable(
			name="usr_roles_tab", //child table name
			joinColumns = @JoinColumn(name="id") //key column
	)
	@Column(name="role")
	private List<String> roles;
	private String addr1;
	private String addr2;
	private String addr3;
	private String idtype;
	private Integer idnum;
	@Column(name="fname")
	private String fileName;
	@Lob
	@Column(name="fdata")
	private byte[] fileData;
	public Employee() {
		super();
	}
	public Employee(Integer id) {
		super();
		this.id = id;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getEmpMbl() {
		return empMbl;
	}
	public void setEmpMbl(int empMbl) {
		this.empMbl = empMbl;
	}
	public List<String> getRoles() {
		return roles;
	}
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	public String getAddr1() {
		return addr1;
	}
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	public String getAddr2() {
		return addr2;
	}
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}
	public String getAddr3() {
		return addr3;
	}
	public void setAddr3(String addr3) {
		this.addr3 = addr3;
	}
	public String getIdtype() {
		return idtype;
	}
	public void setIdtype(String idtype) {
		this.idtype = idtype;
	}
	public Integer getIdnum() {
		return idnum;
	}
	public void setIdnum(Integer idnum) {
		this.idnum = idnum;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public byte[] getFileData() {
		return fileData;
	}
	public void setFileData(byte[] fileData) {
		this.fileData = fileData;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", empName=" + empName + ", email=" + email + ", empMbl=" + empMbl + ", roles="
				+ roles + ", addr1=" + addr1 + ", addr2=" + addr2 + ", addr3=" + addr3 + ", idtype=" + idtype
				+ ", idnum=" + idnum + ", fileName=" + fileName + ", fileData=" + Arrays.toString(fileData) + "]";
	}
	
	
	
	
}