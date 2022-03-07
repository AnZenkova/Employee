package pro.sky.Employee.Service;

import pro.sky.Employee.Class.Employee;

import java.util.Map;
import java.util.Set;

public interface EmployeeService {

    Employee addNewEmployee(Employee employee);
    void removeEmployee(Employee employee);
    Integer findEmployees(Employee employee);
    Set<Map.Entry<Employee, Integer>> getEmployees();
}
