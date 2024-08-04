package org.example.concurrency.udemy.policeThief.thief;

import org.example.concurrency.udemy.policeThief.Vault;

import java.util.Random;

public class ThiefThread extends Thread{
    protected Vault vault;

    public ThiefThread(Vault vault) {
        this.vault = vault;
    }

    @Override
    public  void start() {
        System.out.println("Starting thread"+ this.getName());
        super.start();
    }
}
