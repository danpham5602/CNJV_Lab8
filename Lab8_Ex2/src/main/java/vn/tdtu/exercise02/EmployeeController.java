package vn.tdtu.exercise02;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@RequestMapping("/")
	public String viewHomePage(Model model) {
		List<Employee> listEmployees = service.listAll();
		model.addAttribute("listEmployees", listEmployees);
		return "index";
	}
	
	@GetMapping("/add")
	public String showAddForm(Model model) {
		model.addAttribute("employee", new Employee());
		return "add";
	}
	
	@PostMapping("/add")
    public String addEmployee(@ModelAttribute("employee") Employee employee) {
        service.save(employee);
        return "redirect:/";
    }
	
	@GetMapping("/edit/{id}")
	public String showEditForm(@PathVariable("id") Integer id, Model model) {
		Employee employee = service.get(id);
		model.addAttribute("employee", employee);
		return "edit";
	}
	
	@PostMapping("/edit/{id}")
	public String updateEmployee(@PathVariable("id") Integer id, @ModelAttribute("employee") Employee updatedEmployee) {
		updatedEmployee.setId(id);
		service.updateEmployee(updatedEmployee);
		return "redirect:/";
	}
	
	@PostMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable("id") Integer id) {
		service.delete(id);
		return "redirect:/";
	}
}