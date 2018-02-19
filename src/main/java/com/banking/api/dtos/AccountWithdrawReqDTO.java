package com.banking.api.dtos;

/**
 * Created by Master on 2/19/2018.
 */
public class AccountWithdrawReqDTO extends FreshCustomerDTO{

    private String accountNo;
    private Double amount;

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
