package org.example.concurrency.udemy.ThreadJoin;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class ThreadJoinExample {
    public static void main(String[] args) {
        List<BigInteger> bigIntegerList=new ArrayList<>();
        bigIntegerList.add(new BigInteger("3"));
        bigIntegerList.add(new BigInteger("542"));
        bigIntegerList.add(new BigInteger("33342"));
        bigIntegerList.add(new BigInteger("55443"));
        bigIntegerList.add(new BigInteger("12476673124"));
        List<FactorialThread> threadList=new ArrayList<>();
        for(int i=0;i<bigIntegerList.size();i++){
            threadList.add(new FactorialThread(bigIntegerList.get(i)));
        }

        for(int i=0;i<threadList.size();i++){
            threadList.get(i).start();
        }
//        try {
//            Thread.sleep(1);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }




        //Approach 1
        for(int i=0;i<threadList.size();i++){
            if(threadList.get(i).isFinished()){
                System.out.println("factorial of "+threadList.get(i).num+ " is "+threadList.get(i).result);
            }
            else System.out.println("factorial of "+threadList.get(i).num+ " is still in progress");
        }



        // Approach 2
        for(Thread thread:threadList){
            try {
                thread.join(1000); // how much time to wait to for thread to return the result
            } catch (InterruptedException e) {
                // if there is no error thrown then application will not terminate till all thread completes their work (except Daemon Thread)
                throw new RuntimeException(e);
            }

        }
        // allthread has done their work completely due to thread.join()
        for(int i=0;i<threadList.size();i++){
            if(threadList.get(i).isFinished()){
                System.out.println("factorial of "+threadList.get(i).num+ " is "+threadList.get(i).result);
            }
            else System.out.println("factorial of "+threadList.get(i).num+ " is still in progress");
        }


    }
}
