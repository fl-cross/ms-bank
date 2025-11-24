package ar.com.flcross.msbank.exception.dedicated;

public class DuplicatedBankException extends RuntimeException {
    public DuplicatedBankException(String message) {
        super(message);
    }
}