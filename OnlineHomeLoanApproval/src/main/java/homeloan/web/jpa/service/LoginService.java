package homeloan.web.jpa.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import homeloan.web.jpa.entity.Login;
import homeloan.web.jpa.repository.LoginRepository;
@Service
public class LoginService
{
	@Autowired
	LoginRepository loginRepository;
	
	@Transactional(readOnly=true)
	public Login getLogin(String userId)
	{
		Optional<Login> a = loginRepository.findById(userId);
		  if(a.isPresent())
			return a.get();
		throw new RuntimeException("User Not found");
	}
	
	@Transactional(readOnly=true)
	public List<Login> getLogins()
	{
		List<Login> ulist = loginRepository.findAll();
		if(ulist.size() > 0)
			return ulist;
		throw new RuntimeException("Not Found");
	}
	
	@Transactional
	public boolean addOrModifyLogin(Login login)
	{
		Login login1= loginRepository.save(login);
		return login1!=null;
	}
	@Transactional
	public void removeLogin(String userId)
	{
		loginRepository.deleteById(userId);
	}
	
	@Transactional(readOnly=true)
	public String signVerification(String userId, String password) {
		String role = loginRepository.verification(userId,password);
		  return role;
	
	}
}
