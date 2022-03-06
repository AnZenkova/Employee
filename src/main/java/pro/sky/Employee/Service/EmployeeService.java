package pro.sky.Employee.Service;

import pro.sky.Employee.Class.Employee;

import java.util.Map;
import java.util.Set;

public interface EmployeeService {

    Employee addNewEmployee(Employee employee);
    void removeEmployee(Integer iD);
    Employee findEmployees(Integer iD);
    Set<Map.Entry<Integer, Employee>> getEmployees();
}
