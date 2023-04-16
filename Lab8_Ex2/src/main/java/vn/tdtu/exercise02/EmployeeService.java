package vn.tdtu.exercise02;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EmployeeService {

	@Autowired
	private EmployeeRepository repo;

	public List<Employee> listAll() {
		return repo.findAll();
	}

	public void save(Employee employee) {
		repo.save(employee);
	}

	public Employee get(Integer id) {
		return repo.findById(id).get();
	}
	
	public Employee updateEmployee(Employee updatedEmployee) {
	    Employee existingEmployee = repo.findById(updatedEmployee.getId()).orElse(null);
	    if (existingEmployee != null) {
	        existingEmployee.setName(updatedEmployee.getName());
	        existingEmployee.setEmail(updatedEmployee.getEmail());
	        existingEmployee.setAddress(updatedEmployee.getAddress());
	        existingEmployee.setPhone(updatedEmployee.getPhone());
	        return repo.save(existingEmployee);
	    }
	    return null;
	}

	public void delete(Integer id) {
		repo.deleteById(id);
	}
}