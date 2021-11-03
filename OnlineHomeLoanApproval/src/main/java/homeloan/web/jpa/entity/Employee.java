package homeloan.web.jpa.entity;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property="employeeId")
@Table(name="employee")
public class Employee
{
	@Id
	@Column(name="empid")
	int employeeId;
	
	@Column(name="firstname")
	String firstName;
	
	@Column(name="lastname")
	String lastName;
	

	@Column(name="mobile")
	long mobile;
	

	@Column(name="email_id")
	String emailId;
	
	@Column(name="dessignation")
	String designation;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="add_id")
	Address address;

	public Employee() {
		
	}

	public Employee(int employeeId, String firstName, String lastName, long mobile, String emailId, String designation,
			Address address) {
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobile = mobile;
		this.emailId = emailId;
		this.designation = designation;
		this.address = address;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastNAme(String lastName) {
		this.lastName = lastName;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	
}
	