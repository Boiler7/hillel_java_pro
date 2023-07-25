package HW4.Participants;

public class Cat extends Participant{
    public void run(){
        System.out.println("Кіт "+ getName() + " біжить");
    }
    public void jump(){
        System.out.println("Кіт "+ getName() + " стрибає");
    }
    public Cat(double maxJump, double maxRun, String name){
        super(maxJump, maxRun, name);
    }
}
