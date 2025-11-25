package ar.com.flcross.msbank.dto.bank;

import ar.com.flcross.msbank.entity.BankEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class BankResponse {

    private Long id;
    private String code;
    private String name;
    private String country;
    private String swiftCode;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime createdAt;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime updatedAt;
    private boolean active;

    public static BankResponse fromEntity(BankEntity bank) {
        return BankResponse.builder()
                .id(bank.getId())
                .code(bank.getCode())
                .name(bank.getName())
                .country(bank.getCountry())
                .swiftCode(bank.getSwiftCode())
                .createdAt(bank.getCreatedAt())
                .updatedAt(bank.getUpdatedAt())
                .active(bank.isActive())
                .build();
    }
}
