package HW7_Exceptions;

public class ArraySizeException extends RuntimeException{
    public ArraySizeException(String message){
        super(message);
    }
}
