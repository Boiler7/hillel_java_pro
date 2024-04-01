package hw4.polymorphism.Obstacles;

import hw4.polymorphism.Participants.Participant;

public class Wall implements Obstacle{
    private final double heigh;


    public void overcome(Participant participant) {
        participant.jump();
        if (heigh <= participant.getMaxJump()) {
            System.out.println("Participant" + participant.getName() + " passed an obstacle the height of a wall " + heigh + ". The route has been completed " + participant.getMaxJump());
        } else {
            participant.setJumpedSuccessfully(false);
            System.out.println("Participant" + participant.getName() + " did not pass an obstacle as high as a wall " + heigh + ". The route has been completed " + participant.getMaxJump());
        }
    }
    public Wall(double heigh){
        this.heigh = heigh;
    }
}
