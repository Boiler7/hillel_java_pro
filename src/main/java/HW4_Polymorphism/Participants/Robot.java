package HW4_Polymorphism.Participants;

public class Robot extends Participant{
    public void run(){
        System.out.println("Robot "+ getName() + " is running");
    }
    public void jump(){
        System.out.println("Robot "+ getName() + " is jumping");
    }
    public Robot(double maxJump, double maxRun, String name){
        super(maxJump, maxRun, name);
    }
}
