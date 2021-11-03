package homeloan.web.jpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import homeloan.web.jpa.entity.CustomerDetails;
import homeloan.web.jpa.repository.CustomerDetailsRepository;

@Service
public class CustomerDetailsService
{
	@Autowired
	CustomerDetailsRepository customerDetailsRepository;
	
	@Transactional(readOnly=true)
	public CustomerDetails getCustomerDetails(int customerId)
	{
		Optional<CustomerDetails> a = customerDetailsRepository.findById(customerId);
		  if(a.isPresent())
			return a.get();
		throw new RuntimeException("CustomerDetails Not found");
	}
	
	@Transactional(readOnly=true)
	public List<CustomerDetails> getCustomerDetailss()
	{
		List<CustomerDetails> clist = customerDetailsRepository.findAll();
		if(clist.size() > 0)
			return clist;
		throw new RuntimeException("Not Found");
	}
	@Transactional
	public boolean addOrModifyCustomerDetails(CustomerDetails customerDetails)
	{
		CustomerDetails cus= customerDetailsRepository.save(customerDetails);
		return cus!=null;
	}
	@Transactional
	public void removeCustomerDetails(int customerId)
	{
		customerDetailsRepository.deleteById(customerId);
	}
}
