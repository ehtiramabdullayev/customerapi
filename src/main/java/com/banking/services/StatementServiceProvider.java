package com.banking.services;

import com.banking.api.dtos.AccountWithdrawReqDTO;
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

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by Master on 2/19/2018.
 */
@Service
public class StatementServiceProvider implements StatementService {

    private StatementRepository statementRepository;
    private CustomerRepository customerRepository;
    private AccountRepository accountRepository;
    @Override
    public List<StatementResponseDTO> getStatements(AccountWithdrawReqDTO reqDTO) {
        Customer customer = customerRepository.
                findByEmail(reqDTO.getEmail());
        if (customer == null) throw new RuntimeException("unahtorized attempt");
        Optional<Account> accountOpt = customer.getAccounts().stream().
                filter(acc -> acc.getaccountNo().equalsIgnoreCase(reqDTO.getAccountNo())).findFirst();
        if (!accountOpt.isPresent()) throw new RuntimeException("wrong account number");

        List<Statement> statements = statementRepository
                .findByAccount(accountOpt.get());
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>."+statements);

        return statements.stream().map(st -> Mapper.statementToResponseDTO(st)).collect(Collectors.toList());
    }

    @Autowired
    public void setStatementRepository(StatementRepository statementRepository) {
        this.statementRepository = statementRepository;
    }

    @Autowired
    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Autowired
    public void setAccountRepository(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
}
