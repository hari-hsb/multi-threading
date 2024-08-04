package org.example.concurrency.udemy.ThreadTermination;

import java.math.BigInteger;

public class ThreadTerminationHandlingInterruptExplicitly {
    public static void main(String[] args) {
        Thread t1=new Thread(new LongComputationTask(new BigInteger("200000"),new BigInteger("100000")));
        t1.start();
        t1.interrupt(); // interrupt doesn't work as there is no handling of interrupt signal explicity


        Thread t2=new Thread(new LongComputationTaskWithInterrupt(new BigInteger("200000"),new BigInteger("100000")));
        t2.start();
        t2.interrupt(); // interrupt work as there is handling of interrupt signal explicity
    }
    private static class LongComputationTask implements Runnable{
        BigInteger base;
        BigInteger pow;
        public LongComputationTask(BigInteger base, BigInteger pow) {
            this.base=base;
            this.pow=pow;
        }

        @Override
        public void run() {
            System.out.println(base+"^"+pow+"="+ calculatePower(base,pow));
        }
        private BigInteger calculatePower(BigInteger base, BigInteger power){
            BigInteger ans=BigInteger.ONE;
            for(BigInteger i=BigInteger.ZERO;i.compareTo(power)!=0;i=i.add(BigInteger.ONE)){
                ans=ans.multiply(base);
            }
            return ans;
        }
    }

    private static class LongComputationTaskWithInterrupt implements Runnable {
        BigInteger base;
        BigInteger pow;
        public LongComputationTaskWithInterrupt(BigInteger base, BigInteger pow) {
            this.base=base;
            this.pow=pow;
        }

        @Override
        public void run() {
            try {
                System.out.println(base+"^"+pow+"="+ calculatePower(base,pow));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
        private BigInteger calculatePower(BigInteger base, BigInteger power) throws InterruptedException {
            BigInteger ans=BigInteger.ONE;
            for(BigInteger i=BigInteger.ZERO;i.compareTo(power)!=0;i=i.add(BigInteger.ONE)){
                if(Thread.currentThread().isInterrupted()){
                    System.out.println("Prematurely Interrupted");
                    throw new InterruptedException();
//                    return BigInteger.ZERO;
                }
                ans=ans.multiply(base);
            }
            return ans;
        }
    }
}
