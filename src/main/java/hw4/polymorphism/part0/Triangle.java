package hw4.polymorphism.part0;

public class Triangle implements GeomFigures{
    public double base;
    public double height;
    @Override
    public double findSquare(){
        return 0.5 * base * height;
    }
    public Triangle(double base, double height){
        this.base = base;
        this.height = height;
    }
}
