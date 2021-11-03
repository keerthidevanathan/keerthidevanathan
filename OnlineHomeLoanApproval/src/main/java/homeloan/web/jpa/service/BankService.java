package homeloan.web.jpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import homeloan.web.jpa.entity.Bank;
import homeloan.web.jpa.repository.BankRepository;

@Service
public class BankService
{
	@Autowired
	BankRepository bankRepository;
	
	@Transactional(readOnly=true)
	public Bank getBank(String ifscCode)
	{
		Optional<Bank> a = bankRepository.findById(ifscCode);
		if(a.isPresent())
			return a.get();
		throw new RuntimeException("Bank Details Not found");
	}
	
	@Transactional(readOnly=true)
	public List<Bank> getBanks()
	{
		List<Bank> blist = bankRepository.findAll();
		if(blist.size() > 0)
			return blist;
		throw new RuntimeException("Not Found");
	}
	@Transactional
	public boolean addOrModifyBank(Bank bank)
	{
		Bank bank1= bankRepository.save(bank);
		return bank1!=null;
	}
	@Transactional
	public void removeBank(String ifscCode)
	{
		bankRepository.deleteById(ifscCode);
	}
}
