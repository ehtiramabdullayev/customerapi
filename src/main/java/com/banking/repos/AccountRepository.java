package com.banking.repos;

import com.banking.domains.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Master on 2/19/2018.
 */
@Repository
public interface AccountRepository extends JpaRepository<Account,Long>{
}
