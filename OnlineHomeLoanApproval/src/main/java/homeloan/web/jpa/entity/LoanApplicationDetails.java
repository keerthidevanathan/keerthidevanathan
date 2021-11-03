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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property="applicationId")
@Table(name="loan_application_details")
public class LoanApplicationDetails
{
	@Id
	@Column(name="app_id")
	int applicationId;
	
	@OneToOne(cascade=CascadeType.REMOVE)
	@JoinColumn(name="cus_id")
	CustomerDetails customerDetails;
	
	@Column(name="app_date")
	LocalDate applicationDate;
	
	@Column(name="property_value")
	double propertyValue;
	
	@Column(name="loan_amount")
	double loanAmount;
	
	@Column(name="property_add")
	String propertyAddress;
	
	@Column(name="property_area")
	String propertyArea;
	
	@Column(name="status")
	String status;
	
	@Column(name="remarks")
	String remarks;
	
	public LoanApplicationDetails() {
		
	}
	public LoanApplicationDetails(int applicationId, CustomerDetails customerDetails, LocalDate applicationDate, double propertyValue,
			double loanAmount, String propertyAddress, String propertyArea, String status, String remarks) {
		this.applicationId = applicationId;
		this.customerDetails = customerDetails;
		this.applicationDate = applicationDate;
		this.propertyValue = propertyValue;
		this.loanAmount = loanAmount;
		this.propertyAddress = propertyAddress;
		this.propertyArea = propertyArea;
		this.status = status;
		this.remarks = remarks;
	}
	
	public int getApplicationId() {
		return applicationId;
	}
	public void setAppId(int applicationId) {
		this.applicationId = applicationId;
	}
	public CustomerDetails getCustomerDetails() {
		return customerDetails;
	}
	public void setCustomerDetails(CustomerDetails customerDetails) {
		this.customerDetails = customerDetails;
	}
	public LocalDate getApplicationDate() {
		return applicationDate;
	}
	public void setApplicationDate(LocalDate applicationDate) {
		this.applicationDate = applicationDate;
	}
	public double getPropertyValue() {
		return propertyValue;
	}
	public void setPropertyValue(double propertyValue) {
		this.propertyValue = propertyValue;
	}
	public double getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}
	public String getPropertyAddress() {
		return propertyAddress;
	}
	public void setPropertyAddress(String propertyAddress) {
		this.propertyAddress = propertyAddress;
	}
	public String getPropertyArea() {
		return propertyArea;
	}
	public void setPropertyArea(String propertyArea) {
		this.propertyArea = propertyArea;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}