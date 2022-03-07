package pro.sky.Employee.Service;

import org.springframework.stereotype.Service;
import pro.sky.Employee.Class.Employee;
import pro.sky.Employee.Exception.EmployeeIsInArrayException;
import pro.sky.Employee.Exception.NotFoundEmployeeException;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    Integer nextId = 1;

    public Map<Employee, Integer> employees = new HashMap<>(Map.of(
            new Employee("Крылов", "Тихон"), getNextId(),
            new Employee("Маслова", "Милиса"), getNextId(),
            new Employee("Яковлев", "Леонид"), getNextId(),
            new Employee("Полякова", "Божена"), getNextId(),
            new Employee("Волков", "Мирослав"), getNextId(),
            new Employee("Анисимова", "Данна"), getNextId(),
            new Employee("Соловьёв", "Ефрем"), getNextId(),
            new Employee("Меркушева", "Глория"), getNextId(),
            new Employee("Никитин", "Адам"), getNextId(),
            new Employee("Кудрявцева", "Галина"), getNextId()
    ));

    private Integer getNextId() {
        int iD = nextId;
        nextId++;
        return iD;
    }

    @Override
    public Employee addNewEmployee(Employee employee) {
        if (employees.containsKey(employee)){
            employees.put(employee, getNextId());
        } else {
            throw new EmployeeIsInArrayException("Такой сотрудник уже существует", null);
        }
        return employee;
    }

    @Override
    public void removeEmployee(Employee employee) {
        if (employees.containsKey(employee)) {
            throw new NotFoundEmployeeException("Удаляемый сотрудник не найден", null);
        }
        employees.remove(employee);
    }

    public Integer findEmployees(Employee employee) {
        if (employees.containsKey(employee)) {
            throw new NotFoundEmployeeException("Сотрудник не найден", null);
        }
        return employees.get(employee);
    }
    
    @Override
    public Set<Map.Entry<Employee, Integer>> getEmployees(){
        return employees.entrySet();
    }
}
