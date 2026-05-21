package oop;

public class Guest extends Person {
    private String guestId;

    public Guest(String name, int age, String guestId) {
        super(name, age);
        this.guestId = guestId;
    }

    public String getGuestId() { return guestId; }

    @Override
    public void displayInfo() {
        System.out.println("  Name    : " + name);
        System.out.println("  Age     : " + age);
        System.out.println("  Guest ID: " + guestId);
        System.out.println("  " + "-".repeat(38));
    }
}
