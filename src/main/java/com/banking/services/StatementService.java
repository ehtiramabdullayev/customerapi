package com.banking.services;

import com.banking.api.dtos.AccountWithdrawReqDTO;
import com.banking.api.dtos.StatementResponseDTO;
import com.banking.domains.Account;

import java.util.List;

/**
 * Created by Master on 2/19/2018.
 */
public interface StatementService {
    List<StatementResponseDTO> getStatements(AccountWithdrawReqDTO reqDTO);
}
