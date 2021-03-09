package com.eviro.assessment.grad001.ThembaNtuli;

import java.math.BigDecimal;

public class SystemDB {

     private  String id;
    private String accountNum;
    private BigDecimal balance;
    private BigDecimal overdraft;
    private static SystemDB systemDb;

    private SystemDB(){
        //hinder other classes to create object of this class
    }


    public  static  SystemDB getInstance()//lazy loading
    {

        if (null==systemDb){
            systemDb = new SystemDB();
        }
        return  systemDb;
    }
 //Set accounts attributes
    public void setCurrentAccount(String id,String accountNum,BigDecimal balance,BigDecimal overdraft){
        this.id = id;
        this.accountNum = accountNum;
        this.balance = balance;
        this.overdraft=overdraft;
    }
    protected  void setSavingsAccount(String id,String accountNum,BigDecimal balance){
        this.id = id;
        this.accountNum = accountNum;
        this.balance = balance;
    }

//return accounts attributes
    public String getId(){
        return id;
    }
    public String getAccountNum(){
            return accountNum;
    }
   public BigDecimal getBalance(){
        return balance;
   }

    public BigDecimal getOverdraft() {
        return overdraft;
    }


}













