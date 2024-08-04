package org.example.concurrency.udemy.ThreadTermination;

public class ThreadTermination {
    public static void main(String[] args) throws InterruptedException {
        Thread blockingThread=new Thread(new BlockingTask());
        blockingThread.start();
        Thread.sleep(1000); //blocks the main thread
        // to exit from blocking thread
        blockingThread.interrupt(); //sends the interrupt signal to the blocking thread

    }
    private static class BlockingTask implements Runnable{
        @Override
        public void run() {
            try {
                Thread.sleep(5000000);
            } catch (InterruptedException e) {
                System.out.println("Exiting Blocking thread");
            }
        }
    }
}
