package com;

class Account{

    private double balance;

    public synchronized double getBalance() {
        return balance;
    }

    public synchronized void setBalance(double balance) {
        for (int i = 0; i < 100000; i++) {
            this.balance++;
        }
    }
    
    
    
}

public class Test {
    public static void main(String[] args){
        
        Account account = new Account();
        
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                account.setBalance(1);
            }
        });
        
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Balance : "+account.getBalance());
            }
        });
        
        t.start();
        t2.start();
        
    }
}
