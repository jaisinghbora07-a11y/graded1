import java.util.concurrent.*;

public class ThreadPool01 extends Thread {

    private int id;

    public ThreadPool01(int id) {
        this.id=id;
    }
    public void run(){
        System.out.println("Task:"+id+"by"+Thread.currentThread().getName());
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            System.out.println("");
        }
        System.out.println("Task:"+id+"by"+Thread.currentThread().getName());
    }
    
    public static void main(String[] args) {
        ExecutorService pool=Executors.newFixedThreadPool(4);
        for (int i = 0; i < 7; i++) {
            pool.execute(new ThreadPool01(i));
        }
        pool.shutdown();
    }
}
