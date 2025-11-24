package ar.com.flcross.msbank.controller;

import ar.com.flcross.msbank.dto.bank.BankRequest;
import ar.com.flcross.msbank.dto.bank.BankResponse;
import ar.com.flcross.msbank.dto.api.ApiResponse;
import ar.com.flcross.msbank.service.BankService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/banks")
@RequiredArgsConstructor
public class BankController {

    private final BankService service;

    @PostMapping
    public ResponseEntity<ApiResponse<BankResponse>> create(@RequestBody BankRequest request) {
        BankResponse response = service.create(request);
        return ResponseEntity.ok(ApiResponse.success(response));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<BankResponse>> getById(@PathVariable Long id) {
        BankResponse response = service.getById(id);
        return ResponseEntity.ok(ApiResponse.success(response));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<BankResponse>>> getAll() {
        List<BankResponse> response = service.getAll();
        return ResponseEntity.ok(ApiResponse.success(response));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<BankResponse>> update(@PathVariable Long id,
                                                            @RequestBody BankRequest request) {
        BankResponse response = service.update(id, request);
        return ResponseEntity.ok(ApiResponse.success(response));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok(ApiResponse.success(null));
    }
}
