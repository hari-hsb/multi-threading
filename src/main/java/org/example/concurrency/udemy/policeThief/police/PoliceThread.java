package org.example.concurrency.udemy.policeThief.police;

public class PoliceThread extends Thread {
    @Override
    public void run() {
        for(int i=10;i>=0;i--){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("time Remaining:"+i);
        }
        System.out.println("Caught!!!");
        System.exit(0);
    }
}
