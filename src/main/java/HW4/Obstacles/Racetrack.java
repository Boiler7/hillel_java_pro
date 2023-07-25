package HW4.Obstacles;

import HW4.Participants.Participant;

public class Racetrack implements Obstacle{
    private double lenght;
    public void overcome(Participant participant) {
        if (participant.isJumpedSuccesfully()) {
            participant.run();
            if (lenght <= participant.getMaxRun()) {
                System.out.println( "Учасник " + participant.getName() + " перебіг бігову доріжку довжиною " + lenght + ". Пройдено " + participant.getMaxRun());
            } else {

                System.out.println("Учасник " + participant.getName() + " не перебіг бігову доріжку довжиною " + lenght + ". Пройдено " + participant.getMaxRun());
            }
        }
    }
    public Racetrack(double lenght){
        this.lenght = lenght;
    }
}