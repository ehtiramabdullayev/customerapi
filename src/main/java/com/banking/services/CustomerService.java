package com.banking.services;

import com.banking.api.dtos.FreshCustomerDTO;
import com.banking.api.dtos.FreshCustomerResponseDTO;

/**
 * Created by Master on 2/19/2018.
 */

public interface CustomerService {

    FreshCustomerResponseDTO registerCustomer(FreshCustomerDTO customerDTO);


}
