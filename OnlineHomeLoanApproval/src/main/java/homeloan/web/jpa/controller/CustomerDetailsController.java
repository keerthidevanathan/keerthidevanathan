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
import homeloan.web.jpa.entity.CustomerDetails;
import homeloan.web.jpa.service.CustomerDetailsService;
@RestController
@RequestMapping("/customerDetails")
public class CustomerDetailsController
{
	@Autowired
	CustomerDetailsService customerDetailsService;
	
	@GetMapping(value="/customerId/{customerId}",produces="application/json")
	public ResponseEntity<CustomerDetails> getCustomerDetails(@PathVariable int customerId)
	{
		CustomerDetails cust = customerDetailsService.getCustomerDetails(customerId);
		return new ResponseEntity<CustomerDetails>(cust,HttpStatus.OK);
	}
	
	@GetMapping(value="/allCustomerId",produces="application/json")
	public ResponseEntity<List<CustomerDetails>> getCustomerDetailss()
	{
		return new ResponseEntity<List<CustomerDetails>>(customerDetailsService.getCustomerDetailss(),HttpStatus.OK);
	}
	
	@PostMapping(value="/addCustomerId",consumes="application/json")
	public HttpStatus addCustomerDetails(@RequestBody CustomerDetails customerDetails)
	{
		if(customerDetailsService.addOrModifyCustomerDetails(customerDetails))
			return HttpStatus.OK;
		return HttpStatus.NOT_MODIFIED;
	}
	
	@PutMapping(value="/modifyCustomerId",consumes="application/json")
	public HttpStatus modifyCustomerDetails(@RequestBody CustomerDetails customerDetails)
	{
		if(customerDetailsService.addOrModifyCustomerDetails(customerDetails))
			return HttpStatus.OK;
		return HttpStatus.NOT_MODIFIED;
	}
	
	@DeleteMapping(value="/removeCustomerId/{customerId}")
	public HttpStatus removeCustomer(@PathVariable int customerId)
	{
		customerDetailsService.removeCustomerDetails(customerId);
		return HttpStatus.OK;
	}
	
	@ExceptionHandler(RuntimeException.class)
	public HttpStatus exceptionHandlerMethod()
	{
		return HttpStatus.NO_CONTENT;
	}
	
}
