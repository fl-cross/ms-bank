package ar.com.flcross.msbank.exception.dedicated;

public class DuplicateBankCodeException extends RuntimeException {
    public DuplicateBankCodeException(String message) {
        super("Bank with code [" + message + "] already exists");
    }
}