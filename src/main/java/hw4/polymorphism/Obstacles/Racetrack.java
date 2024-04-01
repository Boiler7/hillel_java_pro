package hw4.polymorphism.Obstacles;

import hw4.polymorphism.Participants.Participant;

public class Racetrack implements Obstacle{
    private final double lenght;
    public void overcome(Participant participant) {
        if (participant.isJumpedSuccessfully()) {
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