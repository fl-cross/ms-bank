package ar.com.flcross.msbank.dto.bank;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class BankRequest {

    @NotBlank
    private String code;

    @NotBlank
    private String name;

    private String country;

    private String swiftCode;

    private boolean active;
}
