package com.eviro.assessment.grad001.ThembaNtuli;
import java.math.BigDecimal;
import java.util.logging.Level;

public class Main {

    public static void main(String[] args) {
        try{
            Log my_log = new Log("log.txt");

            my_log.logger.setLevel(Level.WARNING);
            my_log.logger.info("Info msg");
            my_log.logger.warning("warning info");
            my_log.logger.severe("Severe msg");
        }catch(Exception e){

        }


        SystemDB systemDB = SystemDB.getInstance();//getting an object
        //populating DB
        //first Saving account
        BigDecimal SavBal = new BigDecimal(2000);
        systemDB.setSavingsAccount("101","1",SavBal);
        //first Saving account
        BigDecimal SavBal2 = new BigDecimal(5000);
        systemDB.setSavingsAccount("102","2",SavBal2);
        //first Current account
        BigDecimal bal = new BigDecimal(1000);
        BigDecimal overD = new BigDecimal(10000);
        systemDB.setCurrentAccount("103","3",bal,overD);
        //second Current account
        BigDecimal bal2 = new BigDecimal(-5000);
        BigDecimal overD2 = new BigDecimal(20000);
        systemDB.setCurrentAccount("103","3",bal2,overD2);



        ///test case1 for current account
        String customerNum="10233";
        AccountService currAccount = new CurrentAccount(customerNum,systemDB.getId(),systemDB.getAccountNum(),systemDB.getBalance(),systemDB.getOverdraft());
        try {
            BigDecimal withAmount = new BigDecimal(500);
            currAccount.withdraw("1", withAmount);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //
        ///test case2
//        AccountService savAccount = new SavingsAccount();
//        try {
//            BigDecimal withAmount = new BigDecimal(8000);
//            savAccount.withdraw("4", withAmount);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}

