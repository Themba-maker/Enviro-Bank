package com.eviro.assessment.grad001.ThembaNtuli;

import java.math.BigDecimal;

public class SavingsAccount {
    private String customerNum;
    private BigDecimal overdraftLimit = new BigDecimal(100000); //set limit value
    private String id,accNumber;
    private BigDecimal balance,overdraft;

    public SavingsAccount(String customerNum,String id,String accNumber,BigDecimal balance,BigDecimal overdraft)
    {
        this.customerNum=customerNum;
        this.id = id;
        this.accNumber = accNumber;
        this.balance = balance;
        this.overdraft=overdraft;
    }

    public void withdraw(String accNumber, BigDecimal amountToWithdraw) throws Exception{
        if(this.accNumber==accNumber)//check existence of an account
        {
                BigDecimal val1= balance.add(amountToWithdraw);
                if(val1.compareTo(amountToWithdraw)==0 || val1.compareTo(amountToWithdraw)==-1 )
                {
                    balance = balance.subtract(amountToWithdraw);
                }
                else
                {
                    throw new Exception("Withdraw amount too large");
                }

        }else {
            throw new RuntimeException("Account not found");
        }
        System.out.println("Amount successfully withdrawn from Savings account remaining balance R"+ balance);



    }




}
