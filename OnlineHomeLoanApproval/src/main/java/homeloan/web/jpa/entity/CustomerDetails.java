package homeloan.web.jpa.entity;

import java.time.LocalDate;

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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property="customerId")
@Table(name="customerdetails")
public class CustomerDetails
{
	@Id
	@Column(name="cus_id")
	int customerId;
	
	@Column(name="aadhar_no")
	long aadharNo;
	
	@Column(name="firstname")
	String firstName;
	
	@Column(name="lastname")
	String lastName;
	
	@Column(name="mobile")
	long mobileNo;
	
	@Column(name="email_id")
	String emailId;
	
	@Column(name="gender")
	String gender;
	
	@Column(name="dob")
	LocalDate dateOfBirth;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="add_id")
	Address address;
	
	@OneToOne(cascade=CascadeType.REMOVE,mappedBy="customerDetails")
	LoanApplicationDetails loanApplicationDetails;
	
	public CustomerDetails() {
	}

	public CustomerDetails(int customerId, long aadharNo, String firstName, String lastName, long mobileNo,
			String emailId, String gender, LocalDate dateOfBirth, Address address) {
	
		this.customerId = customerId;
		this.aadharNo = aadharNo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNo = mobileNo;
		this.emailId = emailId;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public long getAadharNo() {
		return aadharNo;
	}

	public void setAadharNo(long aadharNo) {
		this.aadharNo = aadharNo;
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

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public LoanApplicationDetails getLoanApplicationDetails() {
		return loanApplicationDetails;
	}

	public void setLoanApplicationDetails(LoanApplicationDetails loanApplicationDetails) {
		this.loanApplicationDetails = loanApplicationDetails;
	}
	
}
