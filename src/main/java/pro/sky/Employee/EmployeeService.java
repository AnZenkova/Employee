package pro.sky.Employee;

public class EmployeeService {
    Employee[] employees = {
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

    public void addNewEmployee(String employeeLastName, String employeeName) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = new Employee(employeeLastName, employeeName);
                break;
            }
        }
    }

    public void removeEmployee(String employeeLastName, String employeeName) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getEmployeeLastName().equals(employeeLastName) && employees[i].getEmployeeName().equals(employeeName)) {
                employees[i] = null;
            }
        }
    }

    public String findEmployees(String employeeLastName, String employeeName) {
        String employee = null;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getEmployeeLastName().equals(employeeLastName) && employees[i].getEmployeeName().equals(employeeName)) {
                    employee = employees[i].getEmployeeLastName() + " " + employees[i].getEmployeeName() + ";";
            }
        }
        return employee;
    }
}
