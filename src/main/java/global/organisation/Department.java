package global.organisation;

import java.util.Arrays;
import java.util.Comparator;

public class Department {
    private String name;
    private Employee[] employees;

    public Department(String name) {
        this.name = name;
        this.employees = new Employee[0];
    }

    public Department(Employee[] employees) {
        this.employees = employees;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getEmployeesCount() {
        return this.employees.length;
    }
    public double getEmployeesSalary() {
        double employeesSalary = 0;
        for (Employee employee : this.employees) {
            employeesSalary += employee.getSalary();
        }
        return employeesSalary;
    }
    public Employee getEmployeeByName(String name, String surname) {
        for (Employee employee : this.employees) {
            if (employee.getName().equals(name) && employee.getSurname().equals(surname)) {
                return employee;
            }
        }
        return null;
    }
    public void fireEmployee(String name, String surname, String position) {
        for (int removedIdx = 0; removedIdx < this.employees.length; removedIdx++) {
            Employee employee = this.employees[removedIdx];
            if (employee.getName().equals(name) && employee.getSurname().equals(surname)
                    && employee.getPosition().equals(position)) {

                Employee[] newEmployees = new Employee[this.employees.length - 1];
                System.arraycopy(this.employees, 0, newEmployees, 0, removedIdx);
                if (this.employees.length != removedIdx) {
                    System.arraycopy(this.employees, removedIdx + 1, newEmployees, removedIdx,
                            this.employees.length - removedIdx - 1);
                }
                this.employees = newEmployees;

                return;
            }
        }
    }
    public void hireEmployee(Employee newEmployee) {
        Employee[] newEmployees = new Employee[this.employees.length + 1];
        System.arraycopy(this.employees, 0, newEmployees, 0, this.employees.length);
        newEmployees[this.employees.length] = newEmployee;
        this.employees = newEmployees;
    }
    public Employee[] getEmployees() {
        Employee[] resultEmployees = new Employee[this.employees.length];
        System.arraycopy(this.employees, 0, resultEmployees, 0, this.employees.length);
        return resultEmployees;
    }
    public Employee[] getSortedEmployees() {
        Employee[] sortedEmployees = this.getEmployees();
        Arrays.sort(sortedEmployees, new Comparator<Employee>() {

            public int compare(Employee employee1, Employee employee2) {
                if (employee1.getName().equals(employee2.getSurname())) {
                    return employee1.getName().compareTo(employee2.getName());
                }
                return employee1.getSurname().compareTo(employee2.getSurname());
            }
        });
        return sortedEmployees;
    }
}


