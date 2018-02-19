package com.banking.services;

import com.banking.api.dtos.AccountReqDTO;
import com.banking.api.dtos.Mapper;
import com.banking.api.dtos.StatementResponseDTO;
import com.banking.domains.Account;
import com.banking.domains.Customer;
import com.banking.domains.Statement;
import com.banking.repos.AccountRepository;
import com.banking.repos.CustomerRepository;
import com.banking.repos.StatementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

/**
 * Created by Master on 2/19/2018.
 */
@Service
public class AccountServiceProvider implements AccountService {

    private AccountRepository accountRepository;
    private CustomerRepository customerRepository;
    private StatementRepository statementRepository;

    @Override
    public StatementResponseDTO withdraw(AccountReqDTO withdrawReqDTO) {
        Customer customer = customerRepository.
                findByEmailAndPassword(withdrawReqDTO.getEmail(), withdrawReqDTO.getPassword());
        if (customer == null) throw new RuntimeException("unahtorized attempt");
        Optional<Account> accountOpt = customer.getAccounts().stream().
                filter(acc -> acc.getaccountNo().equalsIgnoreCase(withdrawReqDTO.getAccountNo())).findFirst();
        if (!accountOpt.isPresent()) throw new RuntimeException("wrong account number");
        if (accountOpt.get().getBalance() - withdrawReqDTO.getAmount() < 0)
            throw new RuntimeException("insufficen tbalance");
        Statement statement = new Statement();
        statement.setAccount(accountOpt.get());
        statement.setPrevious(accountOpt.get().getBalance());
        statement.setMovement(withdrawReqDTO.getAmount());
        statement.setCurrent(accountOpt.get().getBalance() - statement.getMovement());
        statement.setOperationDate(new Date());
        accountOpt.get().setBalance(statement.getCurrent());
        accountRepository.save(accountOpt.get());
        statementRepository.save(statement);
        return Mapper.statementToResponseDTO(statement);
    }

    @Override
    public StatementResponseDTO deposit(AccountReqDTO withdrawReqDTO) {
        Customer customer = customerRepository.
                findByEmail(withdrawReqDTO.getEmail());
        if (customer == null) throw new RuntimeException("unahtorized attempt");
        Optional<Account> accountOpt = customer.getAccounts().stream().
                filter(acc -> acc.getaccountNo().equalsIgnoreCase(withdrawReqDTO.getAccountNo())).findFirst();
        if (!accountOpt.isPresent()) throw new RuntimeException("wrong account number");
        if (withdrawReqDTO.getAmount() < 0)
            throw new RuntimeException("negative amount detected");
        Statement statement = new Statement();
        statement.setAccount(accountOpt.get());
        statement.setPrevious(accountOpt.get().getBalance());
        statement.setMovement(withdrawReqDTO.getAmount());
        statement.setCurrent(accountOpt.get().getBalance() + statement.getMovement());
        statement.setOperationDate(new Date());
        accountOpt.get().setBalance(statement.getCurrent());
        accountRepository.save(accountOpt.get());
        statementRepository.save(statement);
        return Mapper.statementToResponseDTO(statement);
    }

    @Override
    public Double getAccountBalance(AccountReqDTO accountRequestDTO) {
        Customer customer = customerRepository.
                findByEmail(accountRequestDTO.getEmail());
        if (customer == null) throw new RuntimeException("unahtorized attempt");
        Optional<Account> accountOpt = customer.getAccounts().stream().
                filter(acc -> acc.getaccountNo().equalsIgnoreCase(accountRequestDTO.getAccountNo())).findFirst();
        if (!accountOpt.isPresent()) throw new RuntimeException("wrong account number");


        return accountOpt.get().getBalance();
    }

    @Autowired
    public void setAccountRepository(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Autowired
    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Autowired
    public void setStatementRepository(StatementRepository statementRepository) {
        this.statementRepository = statementRepository;
    }
}
