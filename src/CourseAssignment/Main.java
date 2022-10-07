package CourseAssignment;

public class Main {

    static Employee[] employees = new Employee[10];

    public static void main(String[] args) {

        employees[0] = new Employee("Алексеев", "Артем", "Александрович",1,26000.42);
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
        getSumSalaryPerMonth();
        System.out.println(" ");
        System.out.println(" ");
        // Пункт 8. c.
        getMinSalary();
        System.out.println(" ");
        // Пункт 8. d.
        getMaxSalary();
        System.out.println(" ");
        // Пункт 8. e.
        getAverageSalary();
        System.out.println(" ");
        System.out.println(" ");
        // Пункт 8. f.
        getFioEmployees();
    }

    public static void getAllEmployees(){
        for (int i = 0; i < employees.length; i++){
            System.out.println(employees[i].toString());
        }
    }

    public static void getSumSalaryPerMonth(){
        double SumSalaryPerMonth = 0.0d;
        for (int i = 0; i < employees.length; i++) {
            SumSalaryPerMonth = SumSalaryPerMonth + employees[i].getSalary();
        }
        System.out.printf("Сумма затрат на зарплаты в месяц: %.2f рублей.", SumSalaryPerMonth);
    }

    public static void getMinSalary() {
        Employee minSalary = null;
        for (int i = 0; i < employees.length; i++) {
            for (int j = 0; j < employees.length; j++) {
                if (j != 9)
                    if (employees[j].getSalary() > employees[j + 1].getSalary()) {
                        minSalary = employees[j + 1];
                        employees[j + 1] = employees[j];
                        employees[j] = minSalary;
                    }
            }
        }
        System.out.println("Сотрудник с минимальной зарплатой - " + minSalary);
    }

    public static void getMaxSalary() {
        Employee maxSalary = null;
        for (int i = 0; i < employees.length; i++) {
            for (int j = 0; j < employees.length; j++) {
                if (j != 9)
                    if (employees[j].getSalary() < employees[j + 1].getSalary()) {
                        maxSalary = employees[j + 1];
                        employees[j + 1] = employees[j];
                        employees[j] = maxSalary;
                    }
            }
        }
        System.out.println("Сотрудник с максимальной зарплатой - " + maxSalary);
    }

    public static void getAverageSalary() {
        double AverageSalary = 0.0d;
        for (int i = 0; i < employees.length; i++) {
            AverageSalary = AverageSalary + employees[i].getSalary();
        }
        System.out.printf("Среднее значение зарплат: %.2f рублей.", AverageSalary/employees.length);
    }

    public static void getFioEmployees() {
        System.out.println("Список Ф.И.О. работников:");
        for (int i = 0; i < employees.length; i++){
            System.out.println("Фамилия: " + employees[i].getSurname() + "\t" + "Имя: " + employees[i].getName() + "\t" + "Отчество: " + employees[i].getMiddleName());
        }
    }
}
