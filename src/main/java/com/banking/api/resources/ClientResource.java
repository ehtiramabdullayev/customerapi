package com.banking.api.resources;

import com.banking.api.dtos.AccountWithdrawReqDTO;
import com.banking.api.dtos.FreshCustomerDTO;
import com.banking.api.dtos.FreshCustomerResponseDTO;
import com.banking.api.dtos.StatementResponseDTO;
import com.banking.services.AccountService;
import com.banking.services.CustomerService;
import com.banking.services.StatementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Master on 2/19/2018.
 */
@RestController
@RequestMapping("banking")
public class ClientResource {

    private CustomerService customerService;
    private AccountService accountService;
    private StatementService statementService;

    @PostMapping
    @RequestMapping("/customer")
    @ResponseStatus(HttpStatus.CREATED)
    public FreshCustomerResponseDTO signupCustomer(@RequestBody FreshCustomerDTO freshCustomerDTO){
        return customerService.registerCustomer(freshCustomerDTO);
    }

    @PutMapping
    @RequestMapping("/account/withdraw")
    @ResponseStatus(HttpStatus.OK)
    public StatementResponseDTO withdraw(@RequestBody AccountWithdrawReqDTO withdrawReqDTO){
        return accountService.withdraw(withdrawReqDTO);
    }


    @PutMapping
    @RequestMapping("/account/deposit")
    @ResponseStatus(HttpStatus.OK)
    public StatementResponseDTO deposit(@RequestBody AccountWithdrawReqDTO withdrawReqDTO){
        return accountService.deposit(withdrawReqDTO);
    }

    @PostMapping
    @RequestMapping("/account/balance")
    @ResponseStatus(HttpStatus.OK)
    public Double getBalance(@RequestBody AccountWithdrawReqDTO accountReqDTO){
        return accountService.getAccountBalance(accountReqDTO);
    }

    @PostMapping
    @RequestMapping("/account/statements")
    @ResponseStatus(HttpStatus.OK)
    public List<StatementResponseDTO> getStatements(@RequestBody AccountWithdrawReqDTO accountReqDTO){
        return statementService.getStatements(accountReqDTO);
    }



    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Autowired
    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    @Autowired
    public void setStatementService(StatementService statementService) {
        this.statementService = statementService;
    }
}
