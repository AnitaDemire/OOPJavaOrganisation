package organisationtest;

import global.organisation.Department;
import global.organisation.Employee;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DepartmentTest {
    @Test
    public void departmenttest(){
        Department department = new Department("School");
        Assert.assertEquals("School", department.getName());
        Assert.assertEquals(0, department.getEmployeesCount());
        Assert.assertEquals(0, department.getEmployeesSalary(), 0);
    }
    @Test
    public void test(){
        Department department = new Department("Zavychevskaya");

        Employee HeadTeacher = new Employee("Anna","Nikitina", "zavych", 450);
        department.hireEmployee(HeadTeacher);
        Assert.assertEquals(HeadTeacher, department.getEmployeeByName("Anna", "Nikitina"));

        Employee HeadTeacher2 = new Employee("Sergey","Petrov", "zavych", 400);
        department.hireEmployee(HeadTeacher2);
        Assert.assertEquals(HeadTeacher2, department.getEmployeeByName("Sergey","Petrov"));

        Employee Teacher = new Employee("Svetlana", "Samoilova", "teacher of math", 200);
        department.hireEmployee(Teacher);
        Assert.assertEquals(Teacher, department.getEmployeeByName("Svetlana", "Samoilova"));

        Employee Teacher2 = new Employee("Boris", "Akynin", "teacher of literatura", 200);
        department.hireEmployee(Teacher2);
        Assert.assertEquals(Teacher2, department.getEmployeeByName("Boris", "Akynin"));

        Assert.assertEquals(4, department.getEmployeesCount());
        Assert.assertEquals(450 + 400 + 200 + 200, department.getEmployeesSalary(), 0);

        department.fireEmployee("Boris", "Akynin", "teacher of literatura");

        Assert.assertEquals(3, department.getEmployeesCount());
        Assert.assertEquals(450 + 400 + 200, department.getEmployeesSalary(), 0);
    }

}
