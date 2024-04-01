package hw4.polymorphism.Participants;

import lombok.Getter;

@Getter
public abstract class Participant {
    protected double maxJump;
    protected double maxRun;
    protected String name;
    protected boolean isJumpedSuccesfully = true;

    public boolean isJumpedSuccessfully() {
        return isJumpedSuccesfully;
    }

    public void setJumpedSuccessfully(boolean jumpedSuccesfully) {
        isJumpedSuccesfully = jumpedSuccesfully;
    }


    public abstract void run();
    public abstract void jump();
    public Participant(double maxJump, double maxRun, String name){
        this.maxJump = maxJump;
        this.maxRun = maxRun;
        this.name = name;
    }
}
