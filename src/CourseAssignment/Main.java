package CourseAssignment;

public class Main {

    private static Employee[] employees = new Employee[10];

    public static void main(String[] args) {

        employees[0] = null;
        employees[1] = new Employee("Кичеев", "Святослав", "Романович",2,20050.00);
        employees[2] = new Employee("Иноземцев", "Даниил", "Захарович",3,27000.00);
        employees[3] = new Employee("Калинин", "Марк", "Архипович",4,19000.10);
        employees[4] = new Employee("Бобылев", "Владислав", "Ибрагимович",5,25000.00);
        employees[5] = new Employee("Корявов", "Матвей", "Артёмович",1,24000.00);
        employees[6] = new Employee("Бормотов", "Никита", "Витальевич",2,19000.01);
        employees[7] = new Employee("Мальцев", "Виталий", "Денисович",3,31000.00);
        employees[8] = new Employee("Бортник", "Илья", "Максимович",4,43000.00);
        employees[9] = new Employee("Свечников", "Георгий", "Тимурович",5,111000.00);

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
    }

    public static void getAllEmployees(){
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public static double getSumSalaryPerMonth(){
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
}
