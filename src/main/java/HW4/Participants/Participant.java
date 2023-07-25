package HW4.Participants;

public abstract class Participant {
    protected double maxJump;
    protected double maxRun;
    protected String name;
    protected boolean isJumpedSuccesfully = true;

    public boolean isJumpedSuccesfully() {
        return isJumpedSuccesfully;
    }

    public void setJumpedSuccesfully(boolean jumpedSuccesfully) {
        isJumpedSuccesfully = jumpedSuccesfully;
    }

    public double getMaxJump() {
        return maxJump;
    }

    public String getName() {
        return name;
    }

    public double getMaxRun() {
        return maxRun;
    }

    public abstract void run();
    public abstract void jump();
    public Participant(double maxJump, double maxRun, String name){
        this.maxJump = maxJump;
        this.maxRun = maxRun;
        this.name = name;
    }
}
