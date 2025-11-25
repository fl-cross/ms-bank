package ar.com.flcross.msbank;

import ar.com.flcross.msbank.dto.bank.BankRequest;
import ar.com.flcross.msbank.dto.bank.BankResponse;
import ar.com.flcross.msbank.entity.BankEntity;
import ar.com.flcross.msbank.exception.dedicated.BankNotFoundException;
import ar.com.flcross.msbank.exception.dedicated.DuplicateBankCodeException;
import ar.com.flcross.msbank.repository.BankRepository;
import ar.com.flcross.msbank.service.impl.BankServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BankServiceImplTest {

    @Mock
    private BankRepository repository;

    @InjectMocks
    private BankServiceImpl service;

    private BankRequest buildRequest(String code, String name) {
        BankRequest req = new BankRequest();
        req.setCode(code);
        req.setName(name);
        req.setCountry("AR");
        req.setSwiftCode("NACNARBA");
        req.setActive(true);
        return req;
    }

    @Test
    void create_WhenCodeAlreadyExists_ShouldThrowDuplicateBankCodeException() {
        // given
        BankRequest request = buildRequest("BNA", "Banco Nación");
        when(repository.existsByCode("BNA")).thenReturn(true);

        // when + then
        DuplicateBankCodeException ex = assertThrows(
                DuplicateBankCodeException.class,
                () -> service.create(request)
        );

        assertTrue(ex.getMessage().contains("BNA"));
        verify(repository, never()).save(any());
    }

    @Test
    void update_WhenCodeBelongsToAnotherBank_ShouldThrowDuplicateBankCodeException() {

        Long idToUpdate = 1L;

        BankRequest request = buildRequest("BNA", "Banco Nación Actualizado");

        BankEntity current = BankEntity.builder()
                .id(idToUpdate)
                .code("BBVA")
                .name("Banco BBVA")
                .country("AR")
                .swiftCode("BBVAARBA")
                .active(true)
                .build();

        when(repository.findById(idToUpdate)).thenReturn(Optional.of(current));
        when(repository.existsByCode("BNA")).thenReturn(true);

        DuplicateBankCodeException ex = assertThrows(
                DuplicateBankCodeException.class,
                () -> service.update(idToUpdate, request)
        );

        assertTrue(ex.getMessage().contains("BNA"));
        verify(repository, never()).save(any());
    }

    @Test
    void update_WhenCodeIsSame_ShouldUpdateSuccessfully() {
        Long idToUpdate = 1L;

        BankRequest request = buildRequest("BNA", "Banco Nación Nuevo Nombre");

        BankEntity current = BankEntity.builder()
                .id(idToUpdate)
                .code("BNA")
                .name("Banco Nación Viejo Nombre")
                .country("AR")
                .swiftCode("NACNARBA")
                .active(true)
                .build();

        when(repository.findById(idToUpdate)).thenReturn(Optional.of(current));
        when(repository.save(any(BankEntity.class))).thenAnswer(invocation -> invocation.getArgument(0));

        BankResponse response = service.update(idToUpdate, request);

        ArgumentCaptor<BankEntity> captor = ArgumentCaptor.forClass(BankEntity.class);
        verify(repository).save(captor.capture());

        BankEntity saved = captor.getValue();
        assertEquals("BNA", saved.getCode());
        assertEquals("Banco Nación Nuevo Nombre", saved.getName());

        verify(repository, never()).existsByCode(anyString());
        assertEquals("Banco Nación Nuevo Nombre", response.getName());
    }

    @Test
    void update_WhenBankDoesNotExist_ShouldThrowBankNotFoundException() {

        Long idToUpdate = 99L;
        BankRequest request = buildRequest("BNA", "Banco Fantasma");

        when(repository.findById(idToUpdate)).thenReturn(Optional.empty());

        assertThrows(
                BankNotFoundException.class,
                () -> service.update(idToUpdate, request)
        );

        verify(repository, never()).save(any());
    }
}
