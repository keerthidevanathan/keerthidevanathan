package homeloan.web.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import homeloan.web.jpa.entity.LoanApplicationDetails;
import homeloan.web.jpa.service.LoanApplicationDetailsService;

@RestController
@RequestMapping("/loanApplicationDetails")
public class LoanApplicationDetailsController
{
	@Autowired
	LoanApplicationDetailsService loanApplicationDetailsService;
	
	@GetMapping(value="/applicationId/{applicationId}",produces="application/json")
	public ResponseEntity<LoanApplicationDetails> getLoanApplicationDetails(@PathVariable int applicationId)
	{
		LoanApplicationDetails loan= loanApplicationDetailsService.getLoanApplicationDetails(applicationId);
		return new ResponseEntity<LoanApplicationDetails>(loan,HttpStatus.OK);
	}
	
	@GetMapping(value="/allApplicationId",produces="application/json")
	public ResponseEntity<List<LoanApplicationDetails>> getLoanApplicationDetailss()
	{
		return new ResponseEntity<List<LoanApplicationDetails>>(loanApplicationDetailsService.getLoanApplicationDetailss(),HttpStatus.OK);
	}
	
	@PostMapping(value="/addApplicationId",consumes="application/json")
	public HttpStatus addLoanApplicationDetails(@RequestBody LoanApplicationDetails loanApplicationDetails)
	{
		if(loanApplicationDetailsService.addOrModifyLoanApplicationDetails(loanApplicationDetails))
			return HttpStatus.OK;
		return HttpStatus.NOT_MODIFIED;
	}
	
	@PutMapping(value="/modifyApplicationId",consumes="application/json")
	public HttpStatus modifyLoanApplicationDetails(@RequestBody LoanApplicationDetails loanApplicationDetails)
	{
		if(loanApplicationDetailsService.addOrModifyLoanApplicationDetails(loanApplicationDetails))
			return HttpStatus.OK;
		return HttpStatus.NOT_MODIFIED;
	}
	
	@PutMapping(value="/modifyApplicationStatus/{status}/{remarks}/{applicationId}")
	public HttpStatus changeByLoanApplicationStatus(@PathVariable String status, @PathVariable String remarks, @PathVariable int applicationId)
	{
		if(loanApplicationDetailsService.changeLoanApplicationStatus(status,remarks,applicationId))
			return HttpStatus.OK;
		return HttpStatus.NOT_MODIFIED;
	}
	
	@DeleteMapping(value="/removeApplicationId/{applicationId}")
	public HttpStatus removeLoanApplication(@PathVariable int applicationId)
	{
		loanApplicationDetailsService.removeLoanApplicationDetails(applicationId);
		return HttpStatus.OK;
	}
	
	@ExceptionHandler(RuntimeException.class)
	public HttpStatus exceptionHandlerMethod()
	{
		return HttpStatus.NO_CONTENT;
	}
	
}
