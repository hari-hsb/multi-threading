package org.example.concurrency.udemy.policeThief;

public class Vault {
    int password;

    public Vault(int password) {
        this.password = password;
    }
    public boolean isCorrectPassword(int n){
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return n==password;
    }
}
