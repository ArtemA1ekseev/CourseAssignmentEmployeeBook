package CourseAssignment;

public class Main {

    private static Employee[] employees = new Employee[10];

    public static void main(String[] args) {

        employees[0] = null;
        employees[1] = new Employee("Кичеев", "Святослав", "Романович", 2, 20050.00);
        employees[2] = new Employee("Иноземцев", "Даниил", "Захарович", 2, 27000.00);
        employees[3] = new Employee("Калинин", "Марк", "Архипович", 4, 10000.10);
        employees[4] = new Employee("Бобылев", "Владислав", "Ибрагимович", 5, 25000.00);
        employees[5] = new Employee("Корявов", "Матвей", "Артёмович", 1, 24000.00);
        employees[6] = new Employee("Бормотов", "Никита", "Витальевич", 2, 19000.00);
        employees[7] = new Employee("Мальцев", "Виталий", "Денисович", 4, 31000.00);
        employees[8] = new Employee("Бортник", "Илья", "Максимович", 4, 111000.00);
        employees[9] = new Employee("Свечников", "Георгий", "Тимурович", 5, 43000.00);

        // Пункт 8. a.
        getAllEmployees();
        System.out.println(" ");
        // Пункт 8. b.
        System.out.printf("Сумма затрат на зарплаты в месяц: %.2f рублей.", getSumSalaryPerMonth());
        System.out.println(" ");
        System.out.println(" ");
        // Пункт 8. c.
        System.out.println("Сотрудник с минимальной зарплатой - " + getMinSalary());
        System.out.println(" ");
        // Пункт 8. d.
        System.out.println("Сотрудник с максимальной зарплатой - " + getMaxSalary());
        System.out.println(" ");
        // Пункт 8. e.
        System.out.printf("Среднее значение зарплат: %.2f рублей.", getAverageSalary());
        System.out.println(" ");
        System.out.println(" ");
        // Пункт 8. f.
        getFioEmployees();

        // Повышенная сложность.
        // Задание 1.
        System.out.println(" ");
        getIndexSalary();
        System.out.println(" ");
        System.out.println(" ");
        // Задание 2. a.
        int departmentNumber = 2;
        System.out.println("Сотрудник с минимальной зарплатой в отделе № "+ departmentNumber +" - " + getMinDepartmentSalary(2));
        System.out.println(" ");
        // Задание 2. b.
        System.out.println("Сотрудник с максимальной зарплатой в отделе № "+ departmentNumber +" - " + getMaxDepartmentSalary(2));
        System.out.println(" ");
        // Задание 2. c.
        System.out.printf("Сумма затрат на зарплаты в месяц: в отделе № " + departmentNumber + " - %.2f рублей.", getSumSalaryDepartmentPerMonth(departmentNumber));
        System.out.println(" ");
        System.out.println(" ");
        // Задание 2. d.
        System.out.printf("Среднее значение зарплат: в отделе № " + departmentNumber +" - %.2f рублей.", getAverageSalaryDepartment(departmentNumber));
        System.out.println(" ");
        System.out.println(" ");
        // Задание 2. e.
        getIndexSalaryDepartment(departmentNumber);
        System.out.println(" ");
        System.out.println(" ");
        // Задание 2. f.
        getAllEmployeesDepartment(departmentNumber);
        System.out.println(" ");
        // Задание 3 a.
        double EmployeesSalary = 30000.00d;
        getAllEmployeesSalaryMin(EmployeesSalary);
        System.out.println(" ");
        // Задание 3 b.
        getAllEmployeesSalaryMax(EmployeesSalary);
    }

    public static void getAllEmployees() {
        if (employees != null) {
            for (Employee employee : employees) {
                System.out.println(employee);
            }
        }
    }

    public static double getSumSalaryPerMonth() {
        double sum = 0;
        for (Employee employee : employees) {
            if (employee == null) continue;
            sum += employee.getSalary();
        }
        return sum;
    }

    public static Employee getMinSalary() {
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

    public static Employee getMaxSalary() {
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

    public static double getAverageSalary() {
        double sum = 0;
        int countEmp = 0;
        for (Employee emp : employees) {
            if (emp == null) continue;
            countEmp++;
            sum += emp.getSalary();
        }
        return sum / countEmp;
    }

    public static void getFioEmployees() {
        System.out.println("Список Ф.И.О. работников:");
        for (Employee empl : employees) {
            if (empl == null) continue;
            System.out.println(empl.getFullName());
        }
    }

    //Повышенная сложность.
    public static void getIndexSalary() {
        int arg = 10;
        for (Employee employee : employees) {
            if (employee != null) {
                employee.setSalary(employee.getSalary() + employee.getSalary() * arg / 100);
                System.out.printf("%.2f  ", employee.getSalary());
            }
        }
    }
    //Повышенная сложность.
    public static Employee getMinDepartmentSalary(int departmentNumber) {
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
            if (employees[i].getSalary() < min && employees[i].getDepartment() == departmentNumber) {
                min = employees[i].getSalary();
                minSalary = employees[i];
            }
        }
        return minSalary;
    }
    //Повышенная сложность.
    public static Employee getMaxDepartmentSalary(int departmentNumber) {
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
            if (employees[i].getSalary() > max && employees[i].getDepartment() == departmentNumber) {
                max = employees[i].getSalary();
                maxSalary = employees[i];
            }
        }
        return maxSalary;
    }
    //Повышенная сложность.
    public static double getSumSalaryDepartmentPerMonth(int departmentNumber) {
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
    public static double getAverageSalaryDepartment(int departmentNumber) {
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
    public static void getIndexSalaryDepartment(int departmentNumber) {
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == departmentNumber) {
                employee.setSalary(employee.getSalary() + employee.getSalary() * departmentNumber / 100);
                System.out.printf("%.2f  ", employee.getSalary());
            }
        }
    }
    //Повышенная сложность.
    public static void getAllEmployeesDepartment(int departmentNumber) {
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == departmentNumber) {
                System.out.println("Информация о сотруднике: (Уникальный идентификатор = " + employee.getId() + ", " + employee.getFullName() + ", З/П в месяц: " + employee.getSalary() + ')');
            }
        }
    }
    //Повышенная сложность.
    public static void getAllEmployeesSalaryMin(double EmployeesSalary) {
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() < EmployeesSalary) {
                System.out.println("Информация о сотруднике: (Уникальный идентификатор = " + employee.getId() + ", " + employee.getFullName() + ", З/П в месяц: " + employee.getSalary() + ')');
            }
        }
    }
    //Повышенная сложность.
    public static void getAllEmployeesSalaryMax(double EmployeesSalary) {
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() >= EmployeesSalary) {
                System.out.println("Информация о сотруднике: (Уникальный идентификатор = " + employee.getId() + ", " + employee.getFullName() + ", З/П в месяц: " + employee.getSalary() + ')');
            }
        }
    }
}
