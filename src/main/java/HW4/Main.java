package HW4;

import HW4.part0.Circle;
import HW4.part0.GeomFigures;
import HW4.part0.Square;
import HW4.part0.Triangle;
import HW4.Participants.Cat;
import HW4.Participants.Human;
import HW4.Participants.Participant;
import HW4.Participants.Robot;
import HW4.Obstacles.Obstacle;
import HW4.Obstacles.Racetrack;
import HW4.Obstacles.Wall;

public class Main {
    public static void main(String[] args){
        GeomFigures[] figures = new GeomFigures[3];
        figures[0] = new Circle(6.0);
        figures[1] = new Triangle(4.0, 5.0);
        figures[2] = new Square(5.5);

        double totalSquare = 0;

        for(GeomFigures k : figures){
            totalSquare += k.findSquare();
        }
        System.out.println("Total square: " + totalSquare);

        //6
        Participant[] participants = new Participant[3];
        participants[0] = new Human(1.0, 100.0, "John");
        participants[1] = new Robot(3.0, 50, "C3PO");
        participants[2] = new Cat(4, 250, "Barsik");

        Obstacle[] obstacles = new Obstacle[2];
        obstacles[0] = new Wall(3.0);
        obstacles[1] = new Racetrack(100.0);

        for (Participant participant : participants) {
            for (Obstacle obstacle : obstacles) {
                obstacle.overcome(participant);
            }
        }

    }
}
