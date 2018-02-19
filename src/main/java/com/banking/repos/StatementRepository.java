package com.banking.repos;

import com.banking.domains.Account;
import com.banking.domains.Statement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Master on 2/19/2018.
 */
@Repository
public interface StatementRepository extends JpaRepository<Statement,Long> {
    List<Statement> findByAccount(Account account);
}
