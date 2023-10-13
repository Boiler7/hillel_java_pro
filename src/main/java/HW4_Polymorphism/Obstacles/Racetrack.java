package HW4_Polymorphism.Obstacles;

import HW4_Polymorphism.Participants.Participant;

public class Racetrack implements Obstacle{
    private double lenght;
    public void overcome(Participant participant) {
        if (participant.isJumpedSuccesfully()) {
            participant.run();
            if (lenght <= participant.getMaxRun()) {
                System.out.println( " " + participant.getName() + " перебіг бігову доріжку довжиною " + lenght + ". Пройдено " + participant.getMaxRun());
            } else {

                System.out.println(" " + participant.getName() + " не перебіг бігову доріжку довжиною " + lenght + ". Пройдено " + participant.getMaxRun());
            }
        }
    }
    public Racetrack(double lenght){
        this.lenght = lenght;
    }
}