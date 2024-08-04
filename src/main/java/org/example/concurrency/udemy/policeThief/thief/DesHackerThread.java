package org.example.concurrency.udemy.policeThief.thief;

import org.example.concurrency.udemy.policeThief.Vault;

public class DesHackerThread extends ThiefThread{
    public DesHackerThread(Vault vault) {
        super(vault);
    }

    @Override
    public void start() {
        super.start();
    }

    @Override
    public void run() {
        for(int i=10000;i>=0;i--){
            if(vault.isCorrectPassword(i)){
                System.out.println("Unlocked by "+this.getName());
                System.exit(0);
            }
//            System.out.println(this.getName()+" " +i);

        }
    }
}
