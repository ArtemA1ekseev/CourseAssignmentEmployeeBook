package CourseAssignment;

public class Main {

    public static void main(String[] args) {
        EmployeeBook employeeBook = new EmployeeBook();

        employeeBook.addEmployee("Кичеев", "Святослав", "Романович", 2, 20050.00);
        employeeBook.addEmployee("Иноземцев", "Даниил", "Захарович", 2, 27000.00);
        employeeBook.addEmployee("Калинин", "Марк", "Архипович", 4, 10000.10);
        employeeBook.addEmployee("Бобылев", "Владислав", "Ибрагимович", 5, 25000.00);
        employeeBook.addEmployee("Корявов", "Матвей", "Артёмович", 1, 24000.00);
        employeeBook.addEmployee("Бормотов", "Никита", "Витальевич", 2, 19000.00);
        employeeBook.addEmployee("Мальцев", "Виталий", "Денисович", 4, 31000.00);
        employeeBook.addEmployee("Бортник", "Илья", "Максимович", 4, 111000.00);
        employeeBook.addEmployee("Свечников", "Георгий", "Тимурович", 5, 43000.00);

        // Пункт 8. a.
        employeeBook.getAllEmployees();
        System.out.println(" ");
        // Пункт 8. b.
        System.out.printf("Сумма затрат на зарплаты в месяц: %.2f рублей.", employeeBook.getSumSalaryPerMonth());
        System.out.println(" ");
        System.out.println(" ");
        // Пункт 8. c.
        System.out.println("Сотрудник с минимальной зарплатой - " + employeeBook.getMinSalary());
        System.out.println(" ");
        // Пункт 8. d.
        System.out.println("Сотрудник с максимальной зарплатой - " + employeeBook.getMaxSalary());
        System.out.println(" ");
        // Пункт 8. e.
        System.out.printf("Среднее значение зарплат: %.2f рублей.", employeeBook.getAverageSalary());
        System.out.println(" ");
        System.out.println(" ");
        // Пункт 8. f.
        employeeBook.getFioEmployees();

        // Повышенная сложность.
        // Задание 1.
        System.out.println(" ");
        employeeBook.getIndexSalary();
        System.out.println(" ");
        System.out.println(" ");
        // Задание 2. a.
        int departmentNumber = 5;
        System.out.println("Сотрудник с минимальной зарплатой в отделе № "+ departmentNumber +" - " + employeeBook.getMinDepartmentSalary(departmentNumber));
        System.out.println(" ");
        // Задание 2. b.
        System.out.println("Сотрудник с максимальной зарплатой в отделе № "+ departmentNumber +" - " + employeeBook.getMaxDepartmentSalary(departmentNumber));
        System.out.println(" ");
        // Задание 2. c.
        System.out.printf("Сумма затрат на зарплаты в месяц: в отделе № " + departmentNumber + " - %.2f рублей.", employeeBook.getSumSalaryDepartmentPerMonth(departmentNumber));
        System.out.println(" ");
        System.out.println(" ");
        // Задание 2. d.
        System.out.printf("Среднее значение зарплат: в отделе № " + departmentNumber +" - %.2f рублей.", employeeBook.getAverageSalaryDepartment(departmentNumber));
        System.out.println(" ");
        System.out.println(" ");
        // Задание 2. e.
        int procent = 10;
        employeeBook.getIndexSalaryDepartment(departmentNumber, procent);
        System.out.println(" ");
        System.out.println(" ");
        // Задание 2. f.
        employeeBook.getAllEmployeesDepartment(departmentNumber);
        System.out.println(" ");
        // Задание 3 a.
        double EmployeesSalary = 30000.00d;
        employeeBook.getAllEmployeesSalaryMin(EmployeesSalary);
        System.out.println(" ");
        // Задание 3 b.
        employeeBook.getAllEmployeesSalaryMax(EmployeesSalary);
        System.out.println(" ");

        // Очень сложно.
        String fioEmployees = "Калинин Марк Архипович";
        employeeBook.getNewSalaryDepartmentEmployee(fioEmployees, EmployeesSalary, departmentNumber);
        System.out.println(" ");
        System.out.println(" ");
        employeeBook.removeEmployee(4);
        System.out.println(" ");
        employeeBook.getAllEmployeesDepartment();

    }
}
