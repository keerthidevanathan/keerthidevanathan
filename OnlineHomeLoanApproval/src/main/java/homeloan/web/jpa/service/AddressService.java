package homeloan.web.jpa.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import homeloan.web.jpa.entity.Address;
import homeloan.web.jpa.repository.AddressRepository;

@Service
public class AddressService
{
	@Autowired
	AddressRepository addressRepository; 
	
	@Transactional(readOnly=true)
	public Address getAddress(int addressId)
	{
		Optional<Address> a = addressRepository.findById(addressId);
		  if(a.isPresent())
			return a.get();
		throw new RuntimeException("Address Not found");
	}
	
	@Transactional(readOnly=true)
	public List<Address> getAddresses()
	{
		List<Address> elist = addressRepository.findAll();
		if(elist.size() > 0)
			return elist;
		throw new RuntimeException("Not Found");
	}
	@Transactional
	public boolean addOrModifyAddress(Address address)
	{
		Address add = addressRepository.save(address);
		return add!=null;
	}
	
	@Transactional
	public void removeAddress(int addressId)
	{
		addressRepository.deleteById(addressId);
	}
}