package pro.sky.Employee;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping("/add")
    public String add(@RequestParam String firstName,
                      @RequestParam String lastName) {
        employeeService.addNewEmployee(firstName,lastName);
        return "firstName: " + firstName + ", lastName: " + lastName;
    }

    @RequestMapping("/remove")
    public String remove(@RequestParam String firstName,
                         @RequestParam String lastName) {
        employeeService.removeEmployee(firstName,lastName);
        return "firstName: " + firstName + ", lastName: " + lastName;
    }

    @RequestMapping("/find")
    public String find(@RequestParam String firstName,
                         @RequestParam String lastName) {
        return employeeService.findEmployees(firstName,lastName);
    }

}
