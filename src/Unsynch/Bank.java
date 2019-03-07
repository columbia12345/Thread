package Unsynch;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {
    private Lock banklock = new ReentrantLock();
    private final double[] accounts;
    //private Condition sufficientFunds;
    private Object lock = new Object();


    private volatile boolean done;

    public boolean isDone() {
        return done;
    }

    public void setDone() {
        done = true;
    }


    public Bank(int n, double initialBalance) {
        accounts = new double[n];
        Arrays.fill(accounts, initialBalance);
        //sufficientFunds = banklock.newCondition();
    }

    public synchronized void transfer(int from, int to, double amount) throws InterruptedException {

        if (banklock.tryLock(1, TimeUnit.NANOSECONDS)) {
            try {
                while (accounts[from] < amount)
                    //lock.wait(); //一定加lock.
                    System.out.print(Thread.currentThread());
                accounts[from] -= amount;
                System.out.printf("%10.2f from %d to %d", amount, from, to);
                accounts[to] += amount;
                System.out.printf("Total Balance: %10.2f%n", getTotalBalance());
                //sufficientFunds.signalAll();

            } finally {
                banklock.unlock();
            }

        } else {
            System.out.println("**************解锁失败");
        }
    }


    public double getTotalBalance() {
        synchronized (lock) {
            double sum = 0;
            for (double a : accounts)
                sum += a;
            return sum;
        }
    }

    public int size() {
        return accounts.length;
    }
}
