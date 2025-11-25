package ar.com.flcross.msbank.exception.dedicated;

public class BankNotFoundException extends RuntimeException {

    public BankNotFoundException(Long id) {
        super("Bank with ID [" + id + "] not found");
    }

    public BankNotFoundException(String code) {
        super("Bank with Code [" + code + "] not found");
    }
}
