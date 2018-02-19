package com.banking.services;

import com.banking.api.dtos.AccountWithdrawReqDTO;
import com.banking.api.dtos.StatementResponseDTO;
import com.banking.domains.Statement;

/**
 * Created by Master on 2/19/2018.
 */
public interface AccountService {

    StatementResponseDTO withdraw(AccountWithdrawReqDTO withdrawReqDTO);
    StatementResponseDTO deposit(AccountWithdrawReqDTO withdrawReqDTO);
    Double getAccountBalance(AccountWithdrawReqDTO accountRequestDTO);
}
