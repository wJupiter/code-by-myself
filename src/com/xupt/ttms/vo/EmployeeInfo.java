package com.xupt.ttms.vo;

import java.util.Date;

/**
 * @author WangFeng
 * @date 2017年5月27日 上午10:25:30
 * @version 1.0
 */
public class EmployeeInfo {

	private Integer empId;
	private String empNo;
	private String empPwd;
	private String empName;
	private String empPosition;
	private String sex; 
	private Date dob;
	private Integer age;
	private String empTel;
	private String empEmail;
	private String empAddress;
	private String empPhoto;
	
	private String tempDob;
	
	public void setTempDob(String tempDob) {
		this.tempDob = tempDob;
	}
	
	public String getTempDob() {
		return tempDob;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpNo() {
		return empNo;
	}

	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	public String getEmpPwd() {
		return empPwd;
	}

	public void setEmpPwd(String empPwd) {
		this.empPwd = empPwd;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpPosition() {
		return empPosition;
	}

	public void setEmpPosition(String empPosition) {
		this.empPosition = empPosition;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getEmpTel() {
		return empTel;
	}

	public void setEmpTel(String empTel) {
		this.empTel = empTel;
	}

	public String getEmpAddress() {
		return empAddress;
	}

	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	public String getEmpPhoto() {
		return empPhoto;
	}

	public void setEmpPhoto(String empPhoto) {
		this.empPhoto = empPhoto;
	}

	@Override
	public String toString() {
		return "EmployeeInfo [empId=" + empId + ", empNo=" + empNo + ", empPwd=" + empPwd + ", empName=" + empName
				+ ", empPosition=" + empPosition + ", sex=" + sex + ", dob=" + dob + ", age=" + age + ", empTel="
				+ empTel + ", empEmail=" + empEmail + ", empAddress=" + empAddress + ", empPhoto=" + empPhoto + "]";
	}
	
}
