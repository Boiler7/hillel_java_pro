package HW4_Polymorphism.Participants;

public class Human extends Participant{

    public void run(){
        System.out.println("Human "+ getName() + " is running");
    }
    public void jump(){
        System.out.println("Human "+ getName() + " is jumping");
    }
    public Human(double maxJump, double maxRun, String name){
        super(maxJump, maxRun, name);
    }
}
