package org.example.concurrency.udemy.ThreadJoin;

import java.math.BigInteger;

public class FactorialThread extends Thread{
    BigInteger num;
    boolean isFinished=false;
    BigInteger result=BigInteger.ZERO;

    public FactorialThread(BigInteger num) {
        this.num = num;
    }

    @Override
    public void run() {
       result=calculateFactorial(num);
       this.isFinished=true;
    }

    private BigInteger calculateFactorial(BigInteger num) {
        BigInteger res=BigInteger.ONE;
        for(BigInteger i=BigInteger.ONE;i.compareTo(num)<=0;i=i.add(BigInteger.ONE)){
            res=res.multiply(i);
        }
        return res;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public BigInteger getResult() {
        return result;
    }
}
