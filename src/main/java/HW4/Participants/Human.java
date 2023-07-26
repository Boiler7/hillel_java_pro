package HW4.Participants;

public class Human extends Participant{

    public void run(){
        System.out.println("Людина "+ getName() + " біжить");
    }
    public void jump(){
        System.out.println("Людина "+ getName() + " стрибає");
    }
    public Human(double maxJump, double maxRun, String name){
        super(maxJump, maxRun, name);
    }
}
