package hw4.polymorphism.part0;

public class Square implements GeomFigures{
    public double lenght;
    @Override
    public double findSquare(){
        return lenght * lenght;
    }
    public Square(double lenght){
        this.lenght = lenght;
    }
}
