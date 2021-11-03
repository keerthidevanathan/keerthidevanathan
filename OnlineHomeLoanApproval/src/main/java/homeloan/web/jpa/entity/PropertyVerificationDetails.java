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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property="verificationId")
@Table(name="property_verification_details")
public class PropertyVerificationDetails
{
	@Id
	@Column(name="verification_id")
	int verificationId;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="empid")
	Employee employeeId;
	
	@Column(name="verification_date")
	LocalDate verificationDate;
	
	@Column(name="property_worth")
	double propertyWorth;
	
	@Column(name="remark")
	String remark;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="app_id")
	LoanApplicationDetails loanApplicationDetails;

	public PropertyVerificationDetails() {
		
	}

	public PropertyVerificationDetails(int verificationId, Employee employeeId, LocalDate verificationDate,
			double propertyWorth, String remark, LoanApplicationDetails loanApplicationDetails) {
		super();
		this.verificationId = verificationId;
		this.employeeId = employeeId;
		this.verificationDate = verificationDate;
		this.propertyWorth = propertyWorth;
		this.remark = remark;
		this.loanApplicationDetails = loanApplicationDetails;
	}

	public int getVerificationId() {
		return verificationId;
	}

	public void setVerificationId(int verificationId) {
		this.verificationId = verificationId;
	}

	public Employee getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Employee employeeId) {
		this.employeeId = employeeId;
	}

	public LocalDate getVerificationDate() {
		return verificationDate;
	}

	public void setVerificationDate(LocalDate verificationDate) {
		this.verificationDate = verificationDate;
	}

	public double getPropertyWorth() {
		return propertyWorth;
	}

	public void setPropertyWorth(double propertyWorth) {
		this.propertyWorth = propertyWorth;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public LoanApplicationDetails getLoanApplicationDetails() {
		return loanApplicationDetails;
	}

	public void setLoanApplicationDetails(LoanApplicationDetails loanApplicationDetails) {
		this.loanApplicationDetails = loanApplicationDetails;
	}
	
}