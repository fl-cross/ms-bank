package ar.com.flcross.msbank.dto.bank;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class BankRequest {

    @Schema(description = "Código único del banco", example = "BNA")
    @NotBlank(message = "El código es obligatorio")
    private String code;

    @Schema(description = "Nombre del banco", example = "Banco Nación")
    @NotBlank(message = "El nombre es obligatorio")
    private String name;

    @Schema(description = "Código de país del banco", example = "AR")
    private String country;

    @Schema(description = "Código SWIFT del banco", example = "NACNARBA")
    private String swiftCode;

    @Schema(description = "Indica si el banco está activo", example = "true")
    private boolean active;
}
