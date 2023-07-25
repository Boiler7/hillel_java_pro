package HW4.Obstacles;

import HW4.Participants.Participant;

public class Wall implements Obstacle{
    private double heigh;
    private static boolean isjumpedSuccesfully = true;

    public boolean isJumpedSuccesfully() {
        return isjumpedSuccesfully;
    }

    public void overcome(Participant participant) {
        participant.jump();
        if (heigh <= participant.getMaxJump()) {
            System.out.println("Учасник " + participant.getName() + " пройшов перешкоду стіну висотою " + heigh + ". Пройдено " + participant.getMaxJump());
        } else {
            participant.setJumpedSuccesfully(false);
            System.out.println("Учасник " + participant.getName() + " не пройшов перешкоду стіну висотою " + heigh + ". Пройдено " + participant.getMaxJump());
        }
    }
    public Wall(double heigh){
        this.heigh = heigh;
    }
}
