package ar.com.flcross.msbank.service;

import ar.com.flcross.msbank.dto.bank.BankRequest;
import ar.com.flcross.msbank.dto.bank.BankResponse;

import java.util.List;

public interface BankService {

    BankResponse create(BankRequest request);
    BankResponse getById(Long id);
    BankResponse getByCode(String code);
    List<BankResponse> getAll();
    BankResponse update(Long id, BankRequest request);
    void delete(Long id);
}
