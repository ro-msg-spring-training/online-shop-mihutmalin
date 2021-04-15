package ro.msg.learning.shop.Exceptions;

public class MostAbundantException extends RuntimeException{
    public MostAbundantException() {
        super("Cannot apply MostAbundantStrategy");
    }
}
