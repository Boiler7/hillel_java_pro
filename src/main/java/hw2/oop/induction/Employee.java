package hw2.oop.induction;

public class Employee {
    private final String fullName;
    private final String occupation;
    private final String email;
    private final String phoneNumber;
    private final int age;

    public Employee(String name, String occupation, String email, String phoneNumber, int age){
        this.fullName = name;
        this.occupation = occupation;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.age = age;
    }
}
