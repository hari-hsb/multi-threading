package org.example.concurrency.udemy.policeThief.thief;

import org.example.concurrency.udemy.policeThief.Vault;

public class AscHackerThread extends ThiefThread{
    public AscHackerThread(Vault vault) {
        super(vault);
    }

    @Override
    public void start() {
        super.start();
    }

    @Override
    public void run() {
        for(int i=0;i<10000;i++){
            if(vault.isCorrectPassword(i)){
                System.out.println("Unlocked by "+this.getName());
                System.exit(0);
            }
//            System.out.println(this.getName()+" " +i);
        }
    }
}
