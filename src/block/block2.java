package block;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class block2 {
    public static void main(String[] args) throws InterruptedException {
        BlockingDeque<Integer> blockingDeque = new LinkedBlockingDeque<>(3);

        Runnable r1 = ()->{
            for(int i = 0; i<5;i++){
                try{
                    Thread.sleep(2000);

                    blockingDeque.put(i);
                    System.out.println(i + "已经存入队列，等待消费");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }; //生产者，创造

        Runnable r2 = ()-> {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(0);
                    System.out.println(blockingDeque.take() + "已经被消费");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }; //消费者，取

        new Thread(r1).start();
        Thread.sleep(3);
        //new Thread(r2).start();
    }

}
