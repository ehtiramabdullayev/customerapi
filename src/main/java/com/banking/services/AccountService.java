package com.banking.services;

import com.banking.api.dtos.AccountReqDTO;
import com.banking.api.dtos.StatementResponseDTO;

/**
 * Created by Master on 2/19/2018.
 */
public interface AccountService {

    StatementResponseDTO withdraw(AccountReqDTO withdrawReqDTO);
    StatementResponseDTO deposit(AccountReqDTO withdrawReqDTO);
    Double getAccountBalance(AccountReqDTO accountRequestDTO);
}
