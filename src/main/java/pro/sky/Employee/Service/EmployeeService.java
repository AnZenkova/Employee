package pro.sky.Employee.Service;

import pro.sky.Employee.Class.Employee;

import java.util.List;

public interface EmployeeService {

    Employee addNewEmployee(Employee employee);
    void removeEmployee(Employee employee);
    Employee findEmployees(Employee employee);
    List<Employee> getEmployees();
}
