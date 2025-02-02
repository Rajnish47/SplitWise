package dev.rajnish.SplitWise.exception;

public class InvalidDetailsException extends RuntimeException {

    public InvalidDetailsException()
    {

    }
    
    public InvalidDetailsException(String message)
    {
        super(message);
    }
}
