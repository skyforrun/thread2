package com.testThread;

public class Javadeadlock {

    public static void main(String[] args) {

        ThreadLock lock=new ThreadLock();

        Test1 t1=new Test1(lock,1);
        Test3 t2=new Test3(lock,2);
        t1.start();
        t2.start();
    }

}
class ThreadLock  extends Thread{

    private Object obj=new Object();

    public synchronized void fun1(int i){
        try{
            System.out.println("我在使用函数1，我是线程"+i);
            Thread.sleep(2000);
            System.out.println("我使用完了，我要是使用函数2我是线程"+i);
            fun2(i);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public  void fun2(int i){
        synchronized(obj){
            try{
                System.out.println("我在使用函数2，我是线程"+i);
                Thread.sleep(2000);
                System.out.println("我使用完了，我要使用函数1我是线程"+i);
                fun1(i);
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}

class Test1 extends Thread{

    ThreadLock lock;
    int i;
    public Test1(ThreadLock lock,int i){
        this.lock=lock;
        this.i=i;
    }

    public void run(){
        try{
            lock.fun1(i);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

class Test3 extends Thread{
    ThreadLock lock;
    int i;
    public Test3(ThreadLock lock,int i){
        this.lock=lock;
        this.i=i;
    }
    public void run(){
        try{



            lock.fun2(i);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
