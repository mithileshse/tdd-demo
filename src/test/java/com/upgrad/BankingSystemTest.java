package com.upgrad;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;


import static org.junit.Assert.*;
public class BankingSystemTest {

    private BankingSystem bankingSystem;

    @Mock
    private BankingSystem.Account accountMock;

    private String accountNumber;


    @Before
    public  void setUp(){
        MockitoAnnotations.initMocks(this);
        bankingSystem = new BankingSystem();
        accountNumber=bankingSystem.createAccount("Mark");
        // Deposit initial amount to the account
//        double initialDeposit= 6000.0;
//        bankingSystem.deposit(accountNumber,initialDeposit);

    }


    @Test
    public  void testDepositSuccess(){
        double initialBalance =bankingSystem.getBalance(accountNumber);
        double depositAmount = 1000;
        double updatedAmount=bankingSystem.deposit(accountNumber,depositAmount);

        // validate (expected output , Actual output)
        assertEquals(initialBalance+depositAmount,updatedAmount,0.0);
    }



    @Test
    public void testWithDrawSuccess(){
        double initialBalance =bankingSystem.getBalance(accountNumber);
        double withDrawAmount = 1000;
        double updatedAmount=bankingSystem.withdraw(accountNumber,withDrawAmount);
        assertEquals(initialBalance-withDrawAmount,updatedAmount,0.0);
    }


    @Test(expected = IllegalArgumentException.class)
    public void testWithDrawInSufficientFunds(){
        double withDrawAmount = 10000;
        when(accountMock.getBalance()).thenReturn(6000.0);

        double updatedAmount=bankingSystem.withdraw(accountNumber,withDrawAmount);
    }








}
