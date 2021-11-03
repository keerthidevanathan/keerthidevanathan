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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property="ifscCode")
@Table(name="bank")
public class Bank
{
	@Id
	@Column(name="ifsc_code")
	String ifscCode;
	
	@Column(name="name")
	String bankName;
	
	@Column(name="branch")
	String branchName;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="add_id")
	Address address;

	public Bank() {
	}

	public Bank(String ifscCode, String bankName, String branchName, Address address) {
		super();
		this.ifscCode = ifscCode;
		this.bankName = bankName;
		this.branchName = branchName;
		this.address = address;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName=bankName;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
}
