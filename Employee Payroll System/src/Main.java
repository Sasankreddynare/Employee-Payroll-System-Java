import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
abstract class Employee{
    private String name;
    private int id;

    public Employee(String name, int id){
        this.name=name;
        this.id=id;
    }
    public String getName(){
        return name;
    }
    public int getId(){
        return id;
    }
    public abstract double calculateSalary();
    @Override
    public String toString(){
        return "Employee [name="+name+", id="+id+", salary="+calculateSalary()+"]";
    }
}

class FullTimeEmployee extends Employee{
    private double monthlySalary;
    public FullTimeEmployee(String name,int id,double monthlySalary){
        super(name,id);
        this.monthlySalary=monthlySalary;
    }
    @Override
    public double calculateSalary(){
        return monthlySalary;
    }
}

class PartTimeEmployee extends Employee{
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(String name,int id,int hoursWorked,double hourlyRate){
        super(name,id);
        this.hourlyRate=hourlyRate;
        this.hoursWorked=hoursWorked;

    }
    @Override
    public double calculateSalary(){
        return hoursWorked*hourlyRate;
    }
}

//payroll
//ArrayList<Integer> arr=new ArrayList<>();
//break this
class PayrollSystem{
    //Employee is data type here like int,float etc
    private ArrayList<Employee> employeeList;

    public PayrollSystem(){
        employeeList=new ArrayList<>();
    }

    public void addEmployee(Employee employee){
        employeeList.add(employee);
    }
    public void removeEmployee(int id){
        Employee employeeToRemove = null;
        for(Employee employee : employeeList){
            if(employee.getId()==id){
                employeeToRemove=employee;
                break;
            }
        }
        if(employeeToRemove !=null){
            employeeList.remove(employeeToRemove);
        }
    }
    public void displayEmployees(){
        for(Employee employee: employeeList){
            System.out.println(employee);
        }
    }
}
public class Main{
    public static void main(String[] args){
        PayrollSystem payrollSystem = new PayrollSystem();
        FullTimeEmployee emp1=new FullTimeEmployee("shash",1,70000.0);
        PartTimeEmployee emp2=new PartTimeEmployee("Alex",2,40,45);

        payrollSystem.addEmployee(emp1);
        payrollSystem.addEmployee(emp2);
        System.out.println("Initial Employee Details: ");
        payrollSystem.displayEmployees();
        System.out.println("Removing Employees");
        payrollSystem.removeEmployee(2);
        System.out.println("Remaining Employees Details: ");
        payrollSystem.displayEmployees();
    }
}