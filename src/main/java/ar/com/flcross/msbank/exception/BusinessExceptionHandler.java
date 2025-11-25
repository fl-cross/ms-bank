package ar.com.flcross.msbank.exception;

import ar.com.flcross.msbank.error.BusinessErrorCodes;
import ar.com.flcross.msbank.dto.api.ApiResponse;
import ar.com.flcross.msbank.exception.dedicated.BankNotFoundException;
import ar.com.flcross.msbank.exception.dedicated.DuplicateBankCodeException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class BusinessExceptionHandler {

    @ExceptionHandler(BankNotFoundException.class)
    public ResponseEntity<ApiResponse<Void>> handleBankNotFound(BankNotFoundException ex) {
        log.info(ex.getMessage());
        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.error(BusinessErrorCodes.BANK_NOT_FOUND.code(), ex.getMessage()));
    }

    @ExceptionHandler(DuplicateBankCodeException.class)
    public ResponseEntity<ApiResponse<Void>> handleDuplicatedBank(DuplicateBankCodeException ex) {
        log.info(ex.getMessage());
        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.error(BusinessErrorCodes.BANK_DUPLICATED.code(), ex.getMessage()));
    }
}
