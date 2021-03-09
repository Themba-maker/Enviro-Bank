package com.eviro.assessment.grad001.ThembaNtuli;

import java.math.*;

public class CurrentAccount implements AccountService
{

    private String customerNum;
    private BigDecimal overdraftLimit = new BigDecimal(100000); //set limit value
    private String id,accNumber;
    private BigDecimal balance,overdraft;

 public CurrentAccount(String customerNum,String id,String accNumber,BigDecimal balance,BigDecimal overdraft)
 {
     this.customerNum=customerNum;
     this.id = id;
     this.accNumber = accNumber;
     this.balance = balance;
     this.overdraft=overdraft;
 }


    public void withdraw(String accountNum, BigDecimal amountToWithdraw) throws Exception
    {
        if(accountNum==accNumber)//check existence of an account
        {
                if (overdraft.compareTo(overdraftLimit) ==-1)//check for overdraft limit
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
                }
                else{
                    throw new Exception("maximum overdraft is R100 000");
                }
        }else {
            throw new RuntimeException("Account not found");
        }
        System.out.println("Amount successfully withdrawn from Current account remaining balance R"+ balance);

    }


}
