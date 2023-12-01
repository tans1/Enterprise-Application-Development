package employeepackage;

public class Employee {
    private int id;
    private String name;
    private String designation;
    private int salary;


    public Employee(int id, String name, String designation, int salary) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        this.salary = salary;
    }


    public int getId() {
        return id;
    }

   
    public String getName() {
        return name;
    }

    
    public String getDesignation() {
        return designation;
    }

    
    public int getSalary() {
        return salary;
    }
}