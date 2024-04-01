package hw4.polymorphism.part0;

public class Circle implements GeomFigures {
    private final double radius;

    @Override
    public double findSquare(){
        return Math.PI * radius * radius;
    }
    public Circle(double radius){
        this.radius = radius;
    }
}
