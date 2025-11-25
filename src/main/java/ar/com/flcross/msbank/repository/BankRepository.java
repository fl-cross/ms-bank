package ar.com.flcross.msbank.repository;

import ar.com.flcross.msbank.entity.BankEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BankRepository extends JpaRepository<BankEntity, Long> {

    Optional<BankEntity> findByCode(String code);
    boolean existsByCode(String code);
}
