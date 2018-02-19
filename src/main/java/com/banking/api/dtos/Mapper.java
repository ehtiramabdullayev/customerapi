package com.banking.api.dtos;

import com.banking.domains.Customer;
import com.banking.domains.Statement;

/**
 * Created by Master on 2/19/2018.
 */
public class Mapper {
    public FreshCustomerDTO customerToCustomerDTO(Customer customer){
        FreshCustomerDTO freshCustomerDTO = new FreshCustomerDTO();
        freshCustomerDTO.setEmail(customer.getEmail());
        freshCustomerDTO.setPassword(customer.getPassword());
        return freshCustomerDTO;
    }
    public Customer customerDTOToCustomer(FreshCustomerDTO customerDTO){
        Customer customer = new Customer();
        customer.setEmail(customerDTO.getEmail());
        customer.setPassword(customerDTO.getPassword());
        return customer;
    }

    public FreshCustomerResponseDTO customerToCustomerResponseDTO(Customer customer){
        FreshCustomerResponseDTO fd = new FreshCustomerResponseDTO();
        fd.setEmail(customer.getEmail());
        fd.setAccountNo(customer.getAccounts().stream().findFirst().get().getaccountNo());
        return fd;
    }


    public StatementResponseDTO statementToResponseDTO(Statement statement){

        StatementResponseDTO responseDTO = new StatementResponseDTO();
        responseDTO.setAccountNo(statement.getAccount().getaccountNo());
        responseDTO.setCurrentBalance(statement.getCurrent());
        responseDTO.setOperationDate(statement.getOperationDate());
        responseDTO.setPreviousBalance(statement.getPrevious());
        responseDTO.setWithdrawedAmount(statement.getMovement());
        return responseDTO;
    }



}
