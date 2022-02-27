package pro.sky.Employee.Service;

import org.springframework.stereotype.Service;
import pro.sky.Employee.Class.Employee;
import pro.sky.Employee.Exception.NotFoundEmployeeException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    public List<Employee> employees = new ArrayList<>(Arrays.asList(
            new Employee("Крылов", "Тихон"),
            new Employee("Маслова", "Милиса"),
            new Employee("Яковлев", "Леонид"),
            new Employee("Полякова", "Божена"),
            new Employee("Волков", "Мирослав"),
            new Employee("Анисимова", "Данна"),
            new Employee("Соловьёв", "Ефрем"),
            new Employee("Меркушева", "Глория"),
            new Employee("Никитин", "Адам"),
            new Employee("Кудрявцева", "Галина")
    ));

    @Override
    public Employee addNewEmployee(Employee employee) {
        employees.add(employee);
        return null;
    }

    @Override
    public void removeEmployee(Employee employee) {
        int a = 0;
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getEmployeeLastName().equals(employee.getEmployeeLastName()) && employees.get(i).getEmployeeName().equals(employee.getEmployeeName())) {
                employees.remove(i);
            }
            if (employees.get(i) != null) {
                a++;
            }
        }
        if (a == employees.size()) {
            throw new NotFoundEmployeeException("Удаляемый сотрудник не найден", null);
        }
    }

    @Override
    public Employee findEmployees(Employee employee) {
        int a = 0;
        Employee employee1 = null;
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getEmployeeLastName().equals(employee.getEmployeeLastName()) && employees.get(i).getEmployeeName().equals(employee.getEmployeeName())) {
                employee1 = employees.get(i);
            }
            if (employees.get(i) == null) {
                a++;
            }
        }
        if (employee1 == null) {
            throw new NotFoundEmployeeException("Сотрудник не найден", null);
        }
        return employee;
    }
    
    @Override
    public List<Employee> getEmployees(){
        return employees;
    }
}
