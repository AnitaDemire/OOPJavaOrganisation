package global.organisation;

import java.util.Objects;

public class Employee {
    private String name;
    private String surname;
    private String position;
    private int salary;

    public Employee(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Employee(String name, String surname, String position, int salary) {
        this.name = name;
        this.surname = surname;
        this.position = position;
        this.salary = salary;
    }
    public String getName () {
        return name;
    }
    public void setName (String name){
        this.name = name;
    }
    public String getSurname () {
        return surname;
    }
    public void setSurname (String surname){
        this.surname = surname;
    }
    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }
    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        if (this.salary < 0) {
            System.out.println("Work for food");
        } else {
            this.salary = salary;
        }

    }
}