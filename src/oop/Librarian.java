package oop;

public class Librarian extends Person {
    private String employeeId;

    public Librarian(String name, int age, String employeeId) {
        super(name, age);
        this.employeeId = employeeId;
    }

    public String getEmployeeId() { return employeeId; }

    @Override
    public void displayInfo() {
        System.out.println("  Name       : " + name);
        System.out.println("  Age        : " + age);
        System.out.println("  Employee ID: " + employeeId);
        System.out.println("  Role       : Librarian");
        System.out.println("  " + "-".repeat(38));
    }
}
