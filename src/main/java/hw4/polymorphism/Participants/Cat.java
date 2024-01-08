package hw4.polymorphism.Participants;

public class Cat extends Participant{
    public void run(){
        System.out.println("Cat "+ getName() + " is running");
    }
    public void jump(){
        System.out.println("Cat "+ getName() + "is jumping");
    }
    public Cat(double maxJump, double maxRun, String name){
        super(maxJump, maxRun, name);
    }
}
