package com.yunusemrenalbant.locking;


import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;


public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {

    @Lock(LockModeType.OPTIMISTIC)
    Optional<BankAccount> findById(Long id);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("select b from BankAccount b where b.id = ?1")
    Optional<BankAccount> findByIdWithPessimisticLock(Long id);
}
