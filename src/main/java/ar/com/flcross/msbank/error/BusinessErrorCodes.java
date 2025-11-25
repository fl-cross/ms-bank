package ar.com.flcross.msbank.error;

public enum BusinessErrorCodes {
    BANK_NOT_FOUND("B404"),
    BANK_DUPLICATED("B409");

    private final String code;

    BusinessErrorCodes(String code) {
        this.code = code;
    }

    public String code() { return code; }
}
