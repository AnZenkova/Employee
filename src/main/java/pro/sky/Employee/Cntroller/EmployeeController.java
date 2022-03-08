package pro.sky.Employee.Cntroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.Employee.Class.Employee;
import pro.sky.Employee.Service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping("/add")
    public String addEmployee(@RequestParam String firstName,
                              @RequestParam String lastName) {
        Employee employee = new Employee(firstName,lastName);
        String nameEmployee = lastName + " " + firstName;
        return "Сотрудник " + employeeService.addNewEmployee(nameEmployee, employee) + " добавлен.";
    }

    @RequestMapping("/remove")
    public String remove(@RequestParam String firstName,
                         @RequestParam String lastName) {
        String nameEmployee = lastName + " " + firstName;
        employeeService.removeEmployee(nameEmployee);
        return  "Сотрудник  с ID " + nameEmployee + " удалён";
    }

    @RequestMapping("/find")
    public String find(@RequestParam String firstName,
                       @RequestParam String lastName) {
        String nameEmployee = lastName + " " + firstName;
        return employeeService.findEmployees(nameEmployee);
    }

    @RequestMapping("/get")
    public String getEmployees() {
        return employeeService.getEmployees();
    }

}
