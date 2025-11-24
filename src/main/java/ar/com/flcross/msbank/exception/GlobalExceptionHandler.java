package ar.com.flcross.msbank.exception;

import ar.com.flcross.msbank.dto.api.ApiResponse;
import ar.com.flcross.msbank.exception.dedicated.BankNotFoundException;
import ar.com.flcross.msbank.exception.dedicated.DuplicatedBankException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler  {

    @ExceptionHandler(BankNotFoundException.class)
    public ResponseEntity<ApiResponse<Object>> handleBankNotFound(BankNotFoundException ex) {
        log.info("Bank not found.");
        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.error("0000", ex.getMessage()));
    }

    @ExceptionHandler(DuplicatedBankException.class)
    public ResponseEntity<ApiResponse<Object>> handleDuplicatedBank(DuplicatedBankException ex) {
        log.info("Duplicated bank found.");
        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.error("0000", ex.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Object>> handleGeneric(Exception ex) {
        log.error("Internal server error: ", ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ApiResponse.error("500", "Internal Server Error"));
    }
}
