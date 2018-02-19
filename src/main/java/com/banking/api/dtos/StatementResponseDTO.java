package com.banking.api.dtos;


import java.time.LocalDateTime;
import java.util.Date;

/**
 * Created by Master on 2/19/2018.
 */
public class StatementResponseDTO {

    private Double previousBalance;
    private  Double withdrawedAmount;
    private Double currentBalance;
    private String accountNo;
    private Date operationDate;

    public Double getPreviousBalance() {
        return previousBalance;
    }

    public void setPreviousBalance(Double previousBalance) {
        this.previousBalance = previousBalance;
    }

    public Double getWithdrawedAmount() {
        return withdrawedAmount;
    }

    public void setWithdrawedAmount(Double withdrawedAmount) {
        this.withdrawedAmount = withdrawedAmount;
    }

    public Double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(Double currentBalance) {
        this.currentBalance = currentBalance;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public Date getOperationDate() {
        return operationDate;
    }

    public void setOperationDate(Date operationDate) {
        this.operationDate = operationDate;
    }
}
