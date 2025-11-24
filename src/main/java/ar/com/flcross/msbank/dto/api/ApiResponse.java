package ar.com.flcross.msbank.dto.api;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Collections;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiResponse<T> {

    private String code;
    private String message;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime timestamp;
    private T data;

    public static <T> ApiResponse<T> success(T data) {
        return ApiResponse.<T>builder()
                .code("0000")
                .message("Success.")
                .timestamp(LocalDateTime.now())
                .data(data)
                .build();
    }

    public static ApiResponse<Object> error(String code, String message) {
        return ApiResponse.builder()
                .code(code)
                .message(message)
                .timestamp(LocalDateTime.now())
                .data(Collections.emptyMap())
                .build();
    }
}
