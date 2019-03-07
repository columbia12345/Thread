package block;

/*
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class block {
    public static void main(String[] args) {
        BlockingDeque<Integer> blockingDeque = new LinkedBlockingDeque<>(2);

        Runnable r1 = ()->{
            for(int i = 0; i<5; i++) {
                try {
                    Thread.sleep(2000);
                    ((LinkedBlockingDeque) blockingDeque).put(i);
                    System.out.println(i +  "已经存入队列，等待消费");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
/**//*

            }
        };

        Runnable r2 = ()->{
            for(int i = 0; i<5; i++) {
                try {
                    Thread.sleep(0);
                    System.out.println(blockingDeque.take() + "已经被消费");;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        new Thread(r1).start();
        new Thread(r2).start();

    }
}
*/
