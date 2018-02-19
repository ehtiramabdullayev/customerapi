package com.banking.api.dtos;

import com.banking.domains.Customer;

/**
 * Created by Master on 2/19/2018.
 */
public class FreshCustomerDTO {

    private String email;
    private String password;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
