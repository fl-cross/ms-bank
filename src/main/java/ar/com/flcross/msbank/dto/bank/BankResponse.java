package ar.com.flcross.msbank.dto.bank;

import ar.com.flcross.msbank.entity.BankEntity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BankResponse {

    private Long id;
    private String code;
    private String name;
    private String country;
    private String swiftCode;
    private boolean active;

    public static BankResponse fromEntity(BankEntity bank) {
        return BankResponse.builder()
                .id(bank.getId())
                .code(bank.getCode())
                .name(bank.getName())
                .country(bank.getCountry())
                .swiftCode(bank.getSwiftCode())
                .active(bank.isActive())
                .build();
    }
}
