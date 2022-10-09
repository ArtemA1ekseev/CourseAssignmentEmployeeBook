package CourseAssignment;

import java.util.Objects;

public class EmployeeBook {
    private final Employee[] employees;
    private int size;

    public EmployeeBook() {
        this.employees = new Employee[10];
    }

    public void addEmployee(String surname, String name, String middleName, int department, double salary) {
        if (size >= employees.length) {
            System.out.println("Employee book is full. Adding a new employee is restricted.");
        }
        Employee newContact = new Employee(surname, name, middleName, department, salary);
        employees[size++] = newContact;
    }

    public void removeEmployee(int employeeId) {
        for (int i = 0; i < employees.length; i++) {
            if (Objects.equals(employees[i].getId(), employeeId)) {
                System.out.println("Работник " + employees[i].getId() + " удален(а)");
                System.arraycopy(employees, i + 1, employees, i, size - i - 1);
                employees[size - 1] = null;
                size--;
                return;
            }
        }
    }
    // Очень сложно.
    public void getAllEmployeesDepartment() {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println("Информация о сотруднике: (Ф.И.О. = " + employee.getFullName() + ", Номер отдела: " + employee.getDepartment());
            }
        }
    }
    // Очень сложно.
    public void getNewSalaryDepartmentEmployee(String fioEmployees, double EmployeesSalary, int departmentNumber) {
        for (Employee employee : employees) {
            if (employee != null && employee.getFullName().equals(fioEmployees) && employee.getDepartment() == departmentNumber) {
                employee.setSalary(EmployeesSalary);
                employee.setDepartment(departmentNumber);
                System.out.printf("Новая зарплата сотрудника " + fioEmployees + " из отдела - " + departmentNumber + ", %.2f рублей. ", employee.getSalary());
            }
        }
    }

    public void getAllEmployees() {
        if (employees != null) {
            for (Employee employee : employees) {
                System.out.println(employee);
            }
        }
    }

    public double getSumSalaryPerMonth() {
        double sum = 0;
        for (Employee employee : employees) {
            if (employee == null) continue;
            sum += employee.getSalary();
        }
        return sum;
    }

    public Employee getMinSalary() {
        double min = 0;
        int index = 0;

        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                min = employees[i].getSalary();
                index = i;
                break;
            }
        }
        Employee minSalary = employees[index];
        for (int i = index; i < employees.length; i++) {
            if (employees[i] == null) continue;
            if (employees[i].getSalary() < min) {
                min = employees[i].getSalary();
                minSalary = employees[i];
            }
        }
        return minSalary;
    }

    public Employee getMaxSalary() {
        double max = 0;
        int index = 0;
        Employee maxSalary = null;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                max = employees[i].getSalary();
                maxSalary = employees[i];
                index = i;
                break;
            }
        }

        for (int i = index; i < employees.length; i++) {
            if (employees[i] == null) continue;
            if (employees[i].getSalary() > max) {
                max = employees[i].getSalary();
                maxSalary = employees[i];
            }
        }
        return maxSalary;
    }

    public double getAverageSalary() {
        double sum = 0;
        int countEmp = 0;
        for (Employee emp : employees) {
            if (emp == null) continue;
            countEmp++;
            sum += emp.getSalary();
        }
        return sum / countEmp;
    }

    public void getFioEmployees() {
        System.out.println("Список Ф.И.О. работников:");
        for (Employee empl : employees) {
            if (empl == null) continue;
            System.out.println(empl.getFullName());
        }
    }

    //Повышенная сложность.
    public void getIndexSalary() {
        int arg = 10;
        for (Employee employee : employees) {
            if (employee != null) {
                employee.setSalary(employee.getSalary() + employee.getSalary() * arg / 100);
                System.out.printf("%.2f  ", employee.getSalary());
            }
        }
    }
    //Повышенная сложность.
    public Employee getMinDepartmentSalary(int departmentNumber) {
        double min = 0;
        int index = 0;

        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == departmentNumber) {
                min = employees[i].getSalary();
                index = i;
                break;
            }
        }
        Employee minSalary = employees[index];
        for (int i = index; i < employees.length; i++) {
            if (employees[i] == null) continue;
            if (employees[i].getSalary() < min && employees[i].getDepartment() == departmentNumber) {
                min = employees[i].getSalary();
                minSalary = employees[i];
            }
        }
        return minSalary;
    }

    //Повышенная сложность.
    public Employee getMaxDepartmentSalary(int departmentNumber) {
        double max = 0;
        int index = 0;
        Employee maxSalary = null;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == departmentNumber) {
                max = employees[i].getSalary();
                maxSalary = employees[i];
                index = i;
                break;
            }
        }

        for (int i = index; i < employees.length; i++) {
            if (employees[i] == null) continue;
            if (employees[i].getSalary() > max && employees[i].getDepartment() == departmentNumber) {
                max = employees[i].getSalary();
                maxSalary = employees[i];
            }
        }
        return maxSalary;
    }
    //Повышенная сложность.
    public double getSumSalaryDepartmentPerMonth(int departmentNumber) {
        double sum = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) continue;
            if (employees[i].getDepartment() == departmentNumber) {
                sum += employees[i].getSalary();
            }
        }
        return sum;
    }
    //Повышенная сложность.
    public double getAverageSalaryDepartment(int departmentNumber) {
        double sum = 0;
        int countEmp = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) continue;
            if (employees[i].getDepartment() == departmentNumber) {
                countEmp++;
                sum += employees[i].getSalary();
            }
        }
        return sum / countEmp;
    }
    //Повышенная сложность.
    public void getIndexSalaryDepartment(int departmentNumber, int procent) {
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == departmentNumber) {
                employee.setSalary(employee.getSalary() + employee.getSalary() * procent / 100);
                System.out.printf("%.2f  ", employee.getSalary());
            }
        }
    }
    //Повышенная сложность.
    public void getAllEmployeesDepartment(int departmentNumber) {
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == departmentNumber) {
                System.out.println("Информация о сотруднике: (Уникальный идентификатор = " + employee.getId() + ", " + employee.getFullName() + ", З/П в месяц: " + employee.getSalary() + ')');
            }
        }
    }
    //Повышенная сложность.
    public void getAllEmployeesSalaryMin(double EmployeesSalary) {
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() < EmployeesSalary) {
                System.out.println("Информация о сотруднике: (Уникальный идентификатор = " + employee.getId() + ", " + employee.getFullName() + ", З/П в месяц: " + employee.getSalary() + ')');
            }
        }
    }
    //Повышенная сложность.
    public void getAllEmployeesSalaryMax(double EmployeesSalary) {
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() >= EmployeesSalary) {
                System.out.println("Информация о сотруднике: (Уникальный идентификатор = " + employee.getId() + ", " + employee.getFullName() + ", З/П в месяц: " + employee.getSalary() + ')');
            }
        }
    }
}
