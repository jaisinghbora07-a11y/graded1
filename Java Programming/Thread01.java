
public class Thread01 extends Thread{
    public void run(){
        System.out.println("Hello");
        Thread.currentThread(MAX_PRIORITY);
    }
    public static void main(String[] args) {
        Thread01 obj=new Thread01();
        obj.start();
    }
}
