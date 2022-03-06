package pro.sky.Employee.Service;

import org.springframework.stereotype.Service;
import pro.sky.Employee.Class.Employee;
import pro.sky.Employee.Exception.NotFoundEmployeeException;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    Integer nextId = 1;

    public Map<Integer, Employee> employees = new HashMap<>(Map.of(
            getNextId(), new Employee("Крылов", "Тихон"),
            getNextId(), new Employee("Маслова", "Милиса"),
            getNextId(), new Employee("Яковлев", "Леонид"),
            getNextId(), new Employee("Полякова", "Божена"),
            getNextId(), new Employee("Волков", "Мирослав"),
            getNextId(), new Employee("Анисимова", "Данна"),
            getNextId(), new Employee("Соловьёв", "Ефрем"),
            getNextId(), new Employee("Меркушева", "Глория"),
            getNextId(), new Employee("Никитин", "Адам"),
            getNextId(), new Employee("Кудрявцева", "Галина")
    ));

    private Integer getNextId() {
        int iD = nextId;
        nextId++;
        return iD;
    }

    @Override
    public Employee addNewEmployee(Employee employee) {
        employees.put(getNextId(), employee);
        return employee;
    }

    @Override
    public void removeEmployee(Integer iD) {
        if (employees.containsKey(iD)) {
            throw new NotFoundEmployeeException("Удаляемый сотрудник не найден", null);
        }
        employees.remove(iD);
    }

    public Employee findEmployees(Integer iD) {
        if (employees.containsKey(iD)) {
            throw new NotFoundEmployeeException("Сотрудник не найден", null);
        }
        return employees.get(iD);
    }
    
    @Override
    public Set<Map.Entry<Integer, Employee>> getEmployees(){
        return employees.entrySet();
    }
}
