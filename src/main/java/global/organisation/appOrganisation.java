package global.organisation;

import java.util.ArrayList;
import java.util.Scanner;

public class appOrganisation {
    static String s1   = "-Console interface-";
    static String s2   = "What you want to do?";
    static String s2_1 = "Print action number for make action.";
    static String s3   = "1. Show all departments.";
    static String s4   = "2. Show all employees.";
    static String s4_1 = "3. Add new department.";
    static String s5   = "4. Add new employee in department.";
    static String s6   = "5. Remove employee from department.";
    static String s7   = "6. Show all employees in department.";
    static String s8   = "7. Show sorted all employees in department.";
    static String s9   = "8. Exit";

    static Scanner _scanner = new Scanner(System.in);

    private static boolean isNeedExit = false;

    private static ArrayList<Department> Departments = new ArrayList<>();

    private static void printHead1(){
        System.out.println(s2);
        System.out.println(s2_1);
        System.out.println(s3);
        System.out.println(s4);
        //System.out.println(s5);
        //System.out.println(s6);
        // System.out.println(s7);
        //System.out.println(s8);
        // System.out.println(s9);

    }

    private static void action_Exit(){
        isNeedExit = true;
    }
    private static void action_ShowAllDepartments(){
        System.out.println();
        System.out.println(s3);

        if(Departments.size() == 0){
            System.out.println("There is no departments now.q");
            return;
        }

        int iDepartment = 0;
        for (Department d: Departments) {
            System.out.println("Department #"+(iDepartment+1));
            System.out.println(" Name                      : " + Departments.get(iDepartment).getName());
            System.out.println(" Count of employeers       : " + Departments.get(iDepartment).getEmployeesCount());
            System.out.println(" Employeers summary salary : " + Departments.get(iDepartment).getEmployeesSalary());
            System.out.println();
            System.out.println(" List of employers         : ");
            int iEmployeer = 0;
            for (Employee e: Departments.get(iDepartment).getEmployees()) {
                System.out.println(" "+(iEmployeer+1) + ".[Name/Surname, Position, Salary] "+ e.getName() + " " + e.getSurname() + " \""+e.getPosition()+"\"" + " " + e.getSalary() + " Nothing");
                iEmployeer++;
            }

            System.out.println(" List of employers sorted         : ");
            iEmployeer = 0;
            for (Employee e: Departments.get(iDepartment).getSortedEmployees()) {
                System.out.println(" "+(iEmployeer+1) + ".[Name/Surname, Position, Salary] "+ e.getName() + " " + e.getSurname() + " \""+e.getPosition()+"\"" + " " + e.getSalary() + " Nothing");
                iEmployeer++;
            }

            System.out.println();
            iDepartment++;
        }
    }

    private static void readHead1Input(){
        boolean isIncorrectInput = false;

        do{
            isIncorrectInput = false;

            int inputNumber = 0;
            try {
                _scanner    = new Scanner(System.in);
                inputNumber = _scanner.nextInt();
                _scanner.close();
            }catch(Exception exp){
                isIncorrectInput = true;
                _scanner.close();
                return;
            }


            switch(inputNumber){
                case 1 : action_ShowAllDepartments(); break;
                case 2 : action_ShowAllDepartments(); break;
                case 8 : action_Exit(); break;
                default: isIncorrectInput = true; break;
            }

            if (isIncorrectInput) {
                System.out.println("Incorrect input. Try again.");
            }
        }while(isIncorrectInput);
    }

    public static void main(String[] args) {
        Employee e1 = new Employee("Viktoriya","Nikitina","director",500);
        Employee e2 = new Employee("Nikolay"  ,"Manorin"   ,"teacher",150);
        Employee e3 = new Employee("Olga"  ,"Banosh"   ,"secretary",50);
        Employee e4 = new Employee("Inna"  ,"Asuarina"   ,"accountant",250);

        Employee e51 = new Employee("Vladimir"  ,"Sohnin"   ,"caretaker",100);

        Department d1 = new Department("School");
        d1.hireEmployee(e1);
        d1.hireEmployee(e2);
        d1.hireEmployee(e3);
        d1.hireEmployee(e4);

        Departments.add(d1);
        System.out.println(s1);
        System.out.println();

        printHead1();
        readHead1Input();
    }
}
