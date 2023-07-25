package HW4.Participants;

public class Robot extends Participant{
    public void run(){
        System.out.println("Робот "+ getName() + " біжить");
    }
    public void jump(){
        System.out.println("Робот "+ getName() + " стрибає");
    }
    public Robot(double maxJump, double maxRun, String name){
        super(maxJump, maxRun, name);
    }
}
