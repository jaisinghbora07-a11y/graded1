
public class Thread04 extends Thread{
    static class A extends Thread04{
        public void run(){
            for(int i=1;i<100;i++){
                try {
                    System.out.println(i);
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    System.out.println("Exception");
                }
            }
        }
    }
    static class B extends Thread04{
        public void run(){
            for(int i=1;i<50;i++){
                try {
                    System.out.println(i);
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    System.out.println("Exception");
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
       A a=new A();
       B b=new B();
       b.setPriority(MAX_PRIORITY);
       a.start();
       //a.join();
       b.start();
        
    }
}
