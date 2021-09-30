package nl.thom.tdd2;

public class InvalidLocationException extends RuntimeException{
    public InvalidLocationException(String msg) {
        super(msg);
    }
}
