package com.testThread;

/**
 * @ProjectName: thread
 * @Package: com.testThread
 * @ClassName: Web12306
 * @Description: 线程同步锁的引出
 * @Author: zj
 * @CreateDate: 2019/2/8 9:20
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/2/8 9:20
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class Web12306 {
    public static void main(String[] args) {
        //真实角色
        Car c1 =  new Car();

        //三个代理，代理同一个角色
        new Thread(c1,"张三").start();
        new Thread(c1,"李思").start();
        new Thread(c1,"wane").start();
    }
}

class Car implements Runnable{
    int Counter = 0;
   @Override
    public synchronized void run() {
       for (int i = 0; i < 5; i++) {
           System.out.println(Thread.currentThread().getName()+"count:"+Counter++);
           try {
               Thread.sleep(100);
           } catch (InterruptedException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
           }
       }
   }

}

