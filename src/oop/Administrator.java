package oop;

public class Administrator extends Person {
    private String role;
    private String adminId;

    public Administrator(String name, int age, String adminId, String role) {
        super(name, age);
        this.adminId = adminId;
        this.role    = role;
    }

    public String getAdminId() { return adminId; }
    public String getRole()    { return role; }

    @Override
    public void displayInfo() {
        System.out.println("  Name    : " + name);
        System.out.println("  Age     : " + age);
        System.out.println("  Admin ID: " + adminId);
        System.out.println("  Role    : " + role);
        System.out.println("  " + "-".repeat(38));
    }
}
