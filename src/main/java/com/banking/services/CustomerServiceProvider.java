package com.banking.services;

import com.banking.api.dtos.FreshCustomerDTO;
import com.banking.api.dtos.FreshCustomerResponseDTO;
import com.banking.api.dtos.Mapper;
import com.banking.domains.Account;
import com.banking.domains.Customer;
import com.banking.repos.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.UUID;

/**
 * Created by Master on 2/19/2018.
 */
@Service
public class CustomerServiceProvider implements CustomerService {

    private CustomerRepository customerRepository;

    @Override
    public FreshCustomerResponseDTO registerCustomer(FreshCustomerDTO customerDTO) {
        Account account = new Account();
        account.setStatus(Account.Status.ACTIVE);
        account.setaccountNo(UUID.randomUUID().toString().substring(0,10).concat(customerDTO.getEmail()));
        account.setBalance(0D);
        Customer convertedCustomer = Mapper.customerDTOToCustomer(customerDTO);
        convertedCustomer.setAccounts(new HashSet<>());
        convertedCustomer.getAccounts().add(account);
        account.setCustomer(convertedCustomer);
        Customer customer = customerRepository.save(convertedCustomer);
        return Mapper.customerToCustomerResponseDTO(customer);
    }

    @Autowired
    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
}
