package pro.sky.Employee;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    private int size;
    public Employee[] employees = {
            new Employee("Крылов", "Тихон"),
            new Employee("Маслова", "Милиса"),
            new Employee("Яковлев", "Леонид"),
            new Employee("Полякова", "Божена"),
            new Employee("Волков", "Мирослав"),
            new Employee("Анисимова", "Данна"),
            new Employee("Соловьёв", "Ефрем"),
            new Employee("Меркушева", "Глория"),
            new Employee("Никитин", "Адам"),
            new Employee("Кудрявцева", "Галина"),
    };

    public void addNewEmployee(String employeeName, String employeeLastName) {
        if (size >= employees.length) {
            throw new ArrayIsFull();
        }
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getEmployeeLastName().equals(employeeLastName) && employees[i].getEmployeeName().equals(employeeName)) {
                throw new EmployeeIsInArray();
            }
            if (employees[i] == null) {
                employees[i] = new Employee(employeeLastName, employeeName);
                break;
            } else {
                size++;
            }
        }
    }

    public void removeEmployee(String employeeName, String employeeLastName) {
        int a = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getEmployeeLastName().equals(employeeLastName) && employees[i].getEmployeeName().equals(employeeName)) {
                employees[i] = null;
            }
            if (employees[i] != null) {
                a++;
            }
        }
        if (a == employees.length) {
            throw new NotFound();
        }
    }

    public String findEmployees(String employeeName, String employeeLastName) {
        int a = 0;
        String employee = null;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getEmployeeLastName().equals(employeeLastName) && employees[i].getEmployeeName().equals(employeeName)) {
                    employee = employees[i].getEmployeeLastName() + " " + employees[i].getEmployeeName() + ";";
            }
            if (employees[i] == null) {
                a++;
            }
        }
        if (a == size) {
            throw new NotFound();
        }
        return employee;
    }
}
