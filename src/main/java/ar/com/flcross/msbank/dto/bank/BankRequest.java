package ar.com.flcross.msbank.dto.bank;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class BankRequest {

    @Schema(description = "Código único del banco", example = "BNA")
    @NotBlank(message = "El código es obligatorio")
    private String code;

    @Schema(description = "Nombre legible del banco", example = "Banco Nación")
    @NotBlank(message = "El nombre es obligatorio")
    private String name;

    @Schema(description = "País del banco en ISO2", example = "AR")
    private String country;

    @Schema(description = "Código SWIFT/BIC del banco", example = "NACNARBA")
    private String swiftCode;

    @Schema(description = "Indica si el banco está activo", example = "true")
    private boolean active;
}
