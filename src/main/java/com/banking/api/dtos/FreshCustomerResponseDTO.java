package com.banking.api.dtos;

/**
 * Created by Master on 2/19/2018.
 */
public class FreshCustomerResponseDTO {

    private String email;
    private String accountNo;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }
}
