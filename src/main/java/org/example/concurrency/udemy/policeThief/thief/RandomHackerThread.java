package org.example.concurrency.udemy.policeThief.thief;

import org.example.concurrency.udemy.policeThief.Vault;

import java.util.Random;

public class RandomHackerThread extends ThiefThread{
    public RandomHackerThread(Vault vault) {
        super(vault);
    }

    @Override
    public void start() {
        super.start();
    }

    @Override
    public void run() {
        while(true){
            int n=new Random().nextInt(10000);
            if(vault.isCorrectPassword(n)){
                System.out.println("Unlocked by "+this.getName());
                System.exit(0);
            }
//            System.out.println(this.getName()+" "+n);
        }
    }
}
