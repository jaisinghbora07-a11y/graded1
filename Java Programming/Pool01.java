
class Bank{

    private int balance=1000;

    synchronized void withdraw(int amount){
        
            System.out.println(Thread.currentThread().getName()+" is trying to withdraw money of about "+amount);

            if(balance>=amount){
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    System.out.println("");
                }
                balance-=amount;
                System.out.println(" Withdrawl of "+amount+" made by "+Thread.currentThread().getName());
            }
            else{
                System.out.println("Insufficient Balance for: "+Thread.currentThread().getName());
            }
        
    }
}

class Customer extends Thread{
    Bank b;
    int amount;
    String s;

    public Customer(Bank b,int amount,String name){
        super(name);
        this.b=b;
        this.amount=amount;
    }
    public void run(){
        b.withdraw(amount);
    }
}

public class Pool01{
    public static void main(String[] args) {
        Bank b=new Bank();
        Customer c1=new Customer(b,600,"Jai");
        Customer c2=new Customer(b, 500, "Gaurav");
        c1.start();
        c2.start();
    }
}