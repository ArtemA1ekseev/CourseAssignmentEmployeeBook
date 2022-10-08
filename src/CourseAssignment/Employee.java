package CourseAssignment;

import java.util.Objects;

public class Employee {

    private final int id;

    private String surname;

    private String name;

    private String middleName;

    private int department;

    private double salary;

    private static int counter;

    public Employee(String surname, String name, String middleName, int department, double salary) {
        if (department < 0 || department > 5) throw new IllegalArgumentException("Введено невалидное значение department");
        counter++;
        this.id = getCounter();
        this.surname = surname;
        this.name = name;
        this.middleName = middleName;
        this.department = department;
        this.salary = salary;
    }

    private int getCounter() {
        return counter;
    }

    public int getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public int getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public void setDepartment(int department) {
        if (department < 0 || department > 5) {
            throw new IllegalArgumentException("Введено невалидное значение");
        }
        this.department = department ;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getFullName(){
        return "Фамилия: " + getSurname() + " Имя: " + getName()  + " Отчество: " + getMiddleName();
    }

    @Override
    public String toString() {
        return "Информация о сотруднике: (" + "Уникальный идентификатор = " + id + ", Ф.И.О. - '" + surname + " " + name + " " + middleName + '\'' +
                ", Отдел: " + department + ", З/П в месяц: " + salary + ')';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
