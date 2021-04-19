package ro.msg.learning.shop.Exceptions;

public class SingleLocationException extends RuntimeException{
    public SingleLocationException() {
        super("Cannot apply SingleLocationStrategy");
    }
}
