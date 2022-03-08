package pro.sky.Employee.Service;

import pro.sky.Employee.Class.Employee;

public interface EmployeeService {

    Employee addNewEmployee(String nameEmployee, Employee employee);
    void removeEmployee(String nameEmployee);
    String findEmployees(String nameEmployee);
    String getEmployees();
}
