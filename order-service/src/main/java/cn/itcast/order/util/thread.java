package cn.itcast.order.util;

public class thread {

    public static void main(String[] args) {
        you y = new you();
        new Thread(y).start();
        new Thread(y).start();
        new Thread(y).start();
    }

}
class Account {
    int j;
    public Account(int i){
        this.j=i;
    }
}
class you implements Runnable {
    int i = 2;
    Account account =new Account(i);
    @Override
    public void run() {
        synchronized (account){
            if(account.j>=1){
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                account.j-=1;
                System.out.println(account.j);
            }else{
                System.out.println(account.j+"小了");
            }
        }


    }
}