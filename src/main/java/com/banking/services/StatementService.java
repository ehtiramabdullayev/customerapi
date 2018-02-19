package com.banking.services;

import com.banking.api.dtos.AccountReqDTO;
import com.banking.api.dtos.StatementResponseDTO;

import java.util.List;

/**
 * Created by Master on 2/19/2018.
 */
public interface StatementService {
    List<StatementResponseDTO> getStatements(AccountReqDTO reqDTO);
}
