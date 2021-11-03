package homeloan.web.jpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import homeloan.web.jpa.entity.LoanApplicationDetails;
import homeloan.web.jpa.repository.LoanApplicationDetailsRepository;

@Service
public class LoanApplicationDetailsService
{
	@Autowired
	LoanApplicationDetailsRepository loanApplicationDetailsRepository;

	 @Transactional(readOnly=true)
	 public LoanApplicationDetails getLoanApplicationDetails(int applicationId)
	 {
	  Optional<LoanApplicationDetails> a = loanApplicationDetailsRepository.findById(applicationId);
	  if(a.isPresent())
	   return a.get();
	  throw new RuntimeException("Loan Application Details Not found");
	 }

	 @Transactional(readOnly=true)
	 public List<LoanApplicationDetails> getLoanApplicationDetailss()
	 {
	  List<LoanApplicationDetails> llist = loanApplicationDetailsRepository.findAll();
	  if(llist.size() > 0)
	   return llist;
	  throw new RuntimeException("Not Found");
	 }
	 
	 @Transactional
	 public boolean addOrModifyLoanApplicationDetails(LoanApplicationDetails loanApplicationDetails)
	 {
		 LoanApplicationDetails loan = loanApplicationDetailsRepository.save(loanApplicationDetails);
	  return loan!=null;
	 }
	 
	 @Transactional
	 public void removeLoanApplicationDetails(int applicationId)
	 {
		 loanApplicationDetailsRepository.deleteById(applicationId);
	 }
	 
	 @Transactional
	 public boolean changeLoanApplicationStatus(String status,String remarks,int applicationId)
	 {
		int count= loanApplicationDetailsRepository.modifyLoanApplicationStatus(status,remarks,applicationId);
		 return count == 1;
	 }
	 
	}