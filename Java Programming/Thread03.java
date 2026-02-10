
public class Thread03 extends Thread{
    @Override
    public void run(){
        for (int i = 0; i < 10; i++) {
            try {
                System.out.println(i);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Error");
            }
        }
        //Thread.yield();
    }
    public static void main(String[] args) {
        Thread03 a=new Thread03();
        Thread03 b=new Thread03();
        a.start();
        b.start();
    }
    
}
