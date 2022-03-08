package pro.sky.Employee.Service;

import org.springframework.stereotype.Service;
import pro.sky.Employee.Class.Employee;
import pro.sky.Employee.Exception.EmployeeIsInArrayException;
import pro.sky.Employee.Exception.NotFoundEmployeeException;
import pro.sky.Employee.Service.EmployeeService;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    public Map<String, Employee> employees = new HashMap<>(Map.of(
            "Тихон Крылов", new Employee("Крылов", "Тихон"),
            "Маслова Милиса", new Employee("Маслова", "Милиса"),
            "Яковлев Леонид" ,new Employee("Яковлев", "Леонид"),
            "Полякова Божена", new Employee("Полякова", "Божена"),
            "Волков Мирослав" ,new Employee("Волков", "Мирослав"),
            "Анисимова Данна", new Employee("Анисимова", "Данна"),
            "Соловьёв Ефрем", new Employee("Соловьёв", "Ефрем"),
            "Меркушева Глория", new Employee("Меркушева", "Глория"),
            "Никитин Адам", new Employee("Никитин", "Адам"),
            "Кудрявцева Галина", new Employee("Кудрявцева", "Галина")
    ));

    @Override
    public Employee addNewEmployee(String nameEmployee, Employee employee) {
        if (employees.containsValue(employee)){
            employees.put(nameEmployee, employee);
        } else {
            throw new EmployeeIsInArrayException("Такой сотрудник уже существует", null);
        }
        return employees.get(nameEmployee);
    }

    @Override
    public void removeEmployee(String nameEmployee) {
        if (employees.containsKey(nameEmployee)) {
            throw new NotFoundEmployeeException("Удаляемый сотрудник не найден", null);
        }
        employees.remove(nameEmployee);
    }

    public String findEmployees(String nameEmployee) {
        if (employees.containsKey(nameEmployee)) {
            throw new NotFoundEmployeeException("Сотрудник не найден", null);
        } else {
            return String.valueOf(employees.get(nameEmployee));
        }
    }
    
    @Override
    public String getEmployees(){
        return String.valueOf(employees.values());
    }
}
