package ar.com.flcross.msbank.service.impl;

import ar.com.flcross.msbank.dto.bank.BankRequest;
import ar.com.flcross.msbank.dto.bank.BankResponse;
import ar.com.flcross.msbank.entity.BankEntity;
import ar.com.flcross.msbank.exception.dedicated.BankNotFoundException;
import ar.com.flcross.msbank.exception.dedicated.DuplicatedBankException;
import ar.com.flcross.msbank.repository.BankRepository;
import ar.com.flcross.msbank.service.BankService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BankServiceImpl implements BankService {

    private final BankRepository repository;

    @Override
    public BankResponse create(BankRequest request) {
        if (repository.existsByCode(request.getCode())) {
            throw new DuplicatedBankException("Bank with code " + request.getCode() + " already exists");
        }

        BankEntity bank = BankEntity.builder()
                .code(request.getCode())
                .name(request.getName())
                .country(request.getCountry())
                .swiftCode(request.getSwiftCode())
                .active(request.isActive())
                .build();

        return BankResponse.fromEntity(repository.save(bank));
    }

    @Override
    public BankResponse getById(Long id) {
        return repository.findById(id)
                .map(BankResponse::fromEntity)
                .orElseThrow(() -> new BankNotFoundException(id));
    }

    @Override
    public List<BankResponse> getAll() {
        return repository.findAll()
                .stream()
                .map(BankResponse::fromEntity)
                .toList();
    }

    @Override
    public BankResponse update(Long id, BankRequest request) {
        BankEntity bank = repository.findById(id)
                .orElseThrow(() -> new BankNotFoundException(id));

        bank.setName(request.getName());
        bank.setCountry(request.getCountry());
        bank.setSwiftCode(request.getSwiftCode());

        return BankResponse.fromEntity(repository.save(bank));
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new BankNotFoundException(id);
        }
        repository.deleteById(id);
    }
}
