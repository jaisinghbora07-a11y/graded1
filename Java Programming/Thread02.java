
public class Thread02 extends Thread{
    @Override
    public void run(){
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }
    public static void main(String[] args) throws InterruptedException{
        Thread02 thread02=new Thread02();
        thread02.start();

        thread02.join();
        System.out.println("Hello");
    }
}
