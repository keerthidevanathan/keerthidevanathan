package homeloan.web.jpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import homeloan.web.jpa.entity.Employee;
import homeloan.web.jpa.repository.EmployeeRepository;

@Service
public class EmployeeService
{
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Transactional(readOnly=true)
	public Employee getEmployee(int employeeId)
	{
		Optional<Employee> a = employeeRepository.findById(employeeId);
		  if(a.isPresent())
			return a.get();
		throw new RuntimeException("Employee Details Not found");
	}
	
	@Transactional(readOnly=true)
	public List<Employee> getEmployees()
	{
		List<Employee> elist = employeeRepository.findAll();
		if(elist.size() > 0)
			return elist;
		throw new RuntimeException("Not Found");
	}
	@Transactional
	public boolean addOrModifyEmployee(Employee employee)
	{
		Employee emp= employeeRepository.save(employee);
		return emp!=null;
	}
	@Transactional
	public void removeEmployee(int employeeId)
	{
		employeeRepository.deleteById(employeeId);
	}
}