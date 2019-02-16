package com.testThread;

/**
 * @ProjectName: thread
 * @Package: com.testThread
 * @ClassName: SynDemo
 * @Description: 死锁的产生(使用过多得同步方法访问同一份资源)
 * @Author: zj
 * @CreateDate: 2019/2/9 14:57
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/2/9 14:57
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class SynDemo {
    public static void main(String[] args) {
        Object g = new Object();
        Object m = new Object();

        Test t1 = new Test(g,m);
        Test2 t2 = new Test2(g,m);

        Runnable proxy = new Thread(t1);
        Runnable proxy2 = new Thread(t2);

        ((Thread) proxy).start();
        ((Thread) proxy2).start();
    }
}

class Test implements Runnable{
    Object goods ;
    Object money ;

    public Test(Object g, Object m) {
        super();
        this.goods = g;
        this.money = m;
    }

    @Override
    public void run() {
        while(true){
            test();
        }
    }

    public void test(){
       synchronized (goods){
           try {
               Thread.sleep(500);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           synchronized (money){

           }
       }
        System.out.println("一手给钱");
    }
}

class Test2 implements Runnable{
    Object goods ;
    Object money ;

    public Test2(Object g, Object m) {
        super();
        this.goods = g;
        this.money = m;
    }

    @Override
    public void run() {
        while(true){
            test();
        }
    }

    public void test(){
        synchronized (money){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (goods){

            }
        }
        System.out.println("一手给货");
    }
}

