package HW4.part0;

public class Circle implements GeomFigures {
    private double radius;

    @Override
    public double findSquare(){
        return Math.PI * radius * radius;
    }
    public Circle(double radius){
        this.radius = radius;
    }
}
