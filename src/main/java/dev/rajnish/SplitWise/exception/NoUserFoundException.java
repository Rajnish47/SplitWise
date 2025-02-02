package dev.rajnish.SplitWise.exception;

public class NoUserFoundException extends RuntimeException {

    public NoUserFoundException()
    {

    }

    public NoUserFoundException(String message)
    {
        super(message);
    }    
}
