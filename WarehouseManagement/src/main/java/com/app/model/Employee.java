package com.app.model;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="emptab")
public class Employee {
	@Id
	@Column(name="eid")
	@GeneratedValue(generator="emp_gen")
	@GenericGenerator(name="emp_gen",strategy="increment")
	private Integer empId;
	@Column(name="ename")
	private String empName;
	@Column(name="gen")
	private String empGender;
	@Column(name="addr")
	private String empAddr;
	@Column(name="cntry")
	private String empCntry;
	
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name="emplangs",
		joinColumns=@JoinColumn(name="eid"))
	@OrderColumn(name="pos")
	@Column(name="data")
	private List<String> empLangs;
	
	//default const
	//alt+shift+S,O(DeselectAll>OK)
	public Employee() {
		super();
	}
	//one param pk const
	//alt+shift+S,O(DeselectAll>select PK>OK)
	public Employee(Integer empId) {
		super();
		this.empId = empId;
	}
	//all params const..
	//alt+shift+S,O(SelectAll>select PK>OK)
	public Employee(Integer empId, String empName, String empGender, String empAddr, String empCntry,
			List<String> empLangs) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empGender = empGender;
		this.empAddr = empAddr;
		this.empCntry = empCntry;
		this.empLangs = empLangs;
	}
	//set,get 
	//alt+shift+S,R(selectAll>OK)
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpGender() {
		return empGender;
	}
	public void setEmpGender(String empGender) {
		this.empGender = empGender;
	}
	public String getEmpAddr() {
		return empAddr;
	}
	public void setEmpAddr(String empAddr) {
		this.empAddr = empAddr;
	}
	public String getEmpCntry() {
		return empCntry;
	}
	public void setEmpCntry(String empCntry) {
		this.empCntry = empCntry;
	}
	public List<String> getEmpLangs() {
		return empLangs;
	}
	public void setEmpLangs(List<String> empLangs) {
		this.empLangs = empLangs;
	}
	//toString
	//alt+shift+S,S(OK)
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empGender=" + empGender + ", empAddr=" + empAddr
				+ ", empCntry=" + empCntry + ", empLangs=" + empLangs + "]";
	}
	
	
}
