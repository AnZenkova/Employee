package pro.sky.Employee.Cntroller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.Employee.Class.Employee;
import pro.sky.Employee.Service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping("/add")
    public String addEmployee(@RequestParam String firstName,
                              @RequestParam String lastName) {
        Employee employee = new Employee(firstName,lastName);
        employeeService.addNewEmployee(employee);
        return "Сотрудник " + employee + " добавлен.";
    }

    @RequestMapping("/remove")
    public String remove(@RequestParam Integer id) {
        employeeService.removeEmployee(id);
        return  "Сотрудник  с ID " + id + " удалён";
    }

    @RequestMapping("/find")
    public String find(@RequestParam Integer id) {
        return String.valueOf(employeeService.findEmployees(id));
    }

    @RequestMapping("/get")
    public String getEmployees() {
        return String.valueOf(employeeService.getEmployees());
    }

}
