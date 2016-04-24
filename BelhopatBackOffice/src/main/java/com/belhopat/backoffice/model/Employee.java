package com.belhopat.backoffice.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Employee")
public class Employee extends BaseEntity{

	
	@OneToOne(cascade=CascadeType.ALL)
	private User employeeUser;
	
	private Date joiningDate;
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private Candidate employeeMaster;
	
	private String officialEmail;
	
	private String employeeId;

	@ManyToOne
	private Employee reportingManager;

	@ManyToOne
	private BusinessUnit businessUnit;
	
	@ManyToOne
	private Employee accountManager;
	
	@ManyToOne
	private Employee hrManager;
	
	@ManyToOne
	private City workLocation;
	
	@ManyToOne
	private TimeZone timeZone;


	public Employee getReportingManager() {
		return reportingManager;
	}

	public void setReportingManager(Employee reportingManager) {
		this.reportingManager = reportingManager;
	}

	public BusinessUnit getBusinessUnit() {
		return businessUnit;
	}

	

	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	public User getEmployeeUser() {
		return employeeUser;
	}

	public void setEmployeeUser(User employeeUser) {
		this.employeeUser = employeeUser;
	}

	public Candidate getEmployeeMaster() {
		return employeeMaster;
	}

	public void setEmployeeMaster(Candidate employeeMaster) {
		this.employeeMaster = employeeMaster;
	}

	public String getOfficialEmail() {
		return officialEmail;
	}

	public void setOfficialEmail(String officialEmail) {
		this.officialEmail = officialEmail;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public void setBusinessUnit(BusinessUnit businessUnit) {
		this.businessUnit = businessUnit;
	}

	public Employee getAccountManager() {
		return accountManager;
	}

	public void setAccountManager(Employee accountManager) {
		this.accountManager = accountManager;
	}

	public Employee getHrManager() {
		return hrManager;
	}

	public void setHrManager(Employee hrManager) {
		this.hrManager = hrManager;
	}

	public City getWorkLocation() {
		return workLocation;
	}

	public void setWorkLocation(City workLocation) {
		this.workLocation = workLocation;
	}


	public TimeZone getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(TimeZone timeZone) {
		this.timeZone = timeZone;
	}

	@Override
	public String toString() {
		return "Employee [employeeUser=" + employeeUser + ", employeeMaster=" + employeeMaster + ", officialEmail="
				+ officialEmail + ", employeeId=" + employeeId + ", reportingManager=" + reportingManager
				+ ", businessUnit=" + businessUnit + ", accountManager=" + accountManager + ", hrManager=" + hrManager
				+ ", workLocation=" + workLocation + ", timeZone=" + timeZone + "]";
	}

	
	


}
