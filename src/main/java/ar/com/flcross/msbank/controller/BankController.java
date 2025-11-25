package ar.com.flcross.msbank.controller;

import ar.com.flcross.msbank.dto.bank.BankRequest;
import ar.com.flcross.msbank.dto.bank.BankResponse;
import ar.com.flcross.msbank.dto.api.ApiResponse;
import ar.com.flcross.msbank.service.BankService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/banks")
@RequiredArgsConstructor
@Tag(name = "Banks", description = "Operaciones para la administración de bancos")
public class BankController {

    private final BankService service;

    @PostMapping
    @Operation(
            summary = "Nuevo banco",
            description = "Crea un nuevo banco."
    )
    public ResponseEntity<ApiResponse<BankResponse>> create(@Valid @RequestBody BankRequest request) {
        BankResponse response = service.create(request);
        return ResponseEntity.ok(ApiResponse.success(response));
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Buscar banco por Id",
            description = "Busca un banco por Id de banco"
    )
    public ResponseEntity<ApiResponse<BankResponse>> getById(@PathVariable Long id) {
        BankResponse response = service.getById(id);
        return ResponseEntity.ok(ApiResponse.success(response));
    }

    @GetMapping("/code/{code}")
    @Operation(
            summary = "Buscar banco por Código",
            description = "Busca un banco por su código"
    )
    public ResponseEntity<ApiResponse<BankResponse>> getByCode(@PathVariable String code) {
        BankResponse response = service.getByCode(code);
        return ResponseEntity.ok(ApiResponse.success(response));
    }

    @GetMapping
    @Operation(
            summary = "Listar bancos",
            description = "Obtiene una lista con todos los bancos"
    )
    public ResponseEntity<ApiResponse<List<BankResponse>>> getAll() {
        List<BankResponse> response = service.getAll();
        return ResponseEntity.ok(ApiResponse.success(response));
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "Actualizar banco",
            description = "Actualiza un banco específico por Id"
    )
    public ResponseEntity<ApiResponse<BankResponse>> update(@PathVariable Long id, @Valid @RequestBody BankRequest request) {
        BankResponse response = service.update(id, request);
        return ResponseEntity.ok(ApiResponse.success(response));
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Eliminar banco",
            description = "Borra un banco por Id"
    )
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok(ApiResponse.success(null));
    }
}
