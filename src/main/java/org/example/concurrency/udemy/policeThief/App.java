package org.example.concurrency.udemy.policeThief;

import org.example.concurrency.udemy.policeThief.police.PoliceThread;
import org.example.concurrency.udemy.policeThief.thief.AscHackerThread;
import org.example.concurrency.udemy.policeThief.thief.DesHackerThread;
import org.example.concurrency.udemy.policeThief.thief.RandomHackerThread;

public class App {
    public static void main(String[] args) {
        Vault vault=new Vault(7655);
        AscHackerThread ascHackerThread=new AscHackerThread(vault);
        ascHackerThread.setName("AscThread");
        DesHackerThread desHackerThread=new DesHackerThread(vault);
        desHackerThread.setName("DesThread");
        RandomHackerThread randomHackerThread=new RandomHackerThread(vault);
        randomHackerThread.setName("Random Hacker Thread");
        PoliceThread policeThread=new PoliceThread();
        ascHackerThread.start();
        desHackerThread.start();
        randomHackerThread.start();
        policeThread.start();

    }
}
