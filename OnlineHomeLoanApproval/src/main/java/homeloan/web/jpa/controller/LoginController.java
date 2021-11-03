package homeloan.web.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import homeloan.web.jpa.entity.Login;
import homeloan.web.jpa.service.LoginService;
@RestController
@RequestMapping("/login")
public class LoginController
{
	@Autowired
	LoginService loginService;
	
	@GetMapping(value="/userId/{userId}",produces="application/json")
	public ResponseEntity<Login> getLoginDetails(@PathVariable String userId)
	{
		Login login1 = loginService.getLogin(userId);
		return new ResponseEntity<Login>(login1,HttpStatus.OK);
	}
	
	@GetMapping(value="/allUserId",produces="application/json")
	public ResponseEntity<List<Login>> getLoginDetailss()
	{
		return new ResponseEntity<List<Login>>(loginService.getLogins(),HttpStatus.OK);
	}
	
	@PostMapping(value="/addUserId",consumes="application/json")
	public HttpStatus addLoginDetails(@RequestBody Login login)
	{
		if(loginService.addOrModifyLogin(login))
			return HttpStatus.OK;
		return HttpStatus.NOT_MODIFIED;
	}
	
	@PutMapping(value="/modifyUserId",consumes="application/json")
	public HttpStatus modifyLoginDetails(@RequestBody Login login)
	{
		if(loginService.addOrModifyLogin(login))
			return HttpStatus.OK;
		return HttpStatus.NOT_MODIFIED;
	}
	
	@GetMapping(value="/loginDetails/user_id/{userId}/password/{password}")
	public ResponseEntity <String> sigin(@PathVariable String userId, @PathVariable String password)
	{
		
		String role = loginService.signVerification(userId, password);
		if(role!=null)
			return new ResponseEntity<String>(role,HttpStatus.OK);
		return new ResponseEntity<String>(role,HttpStatus.NOT_FOUND);
	}

	@DeleteMapping(value="/removeUserId/{userId}")
	public HttpStatus removeLoginDetails(@PathVariable String userId)
	{
		loginService.removeLogin(userId);
		return HttpStatus.OK;
	}
	/*@ExceptionHandler(RuntimeException.class)
	public HttpStatus exceptionHandlerMethod()
	{
		return HttpStatus.NO_CONTENT;
	}*/
	
}
