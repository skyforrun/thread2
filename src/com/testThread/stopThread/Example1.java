package com.testThread.stopThread;

/**
 * @ProjectName: thread
 * @Package: com.testThread.stopThread
 * @ClassName: Example1
 * @Author: zj
 * @Description: interrupt并不会中断一个正在运行的线程
 * @Date: 2019/9/2 23:05
 * @Version: 1.0
 */
class Example1 extends Thread {
    boolean stop=false;
    public static void main( String args[] ) throws Exception {
        Example1 thread = new Example1();
        System.out.println( "Starting thread..." );
        thread.start();
        Thread.sleep( 3000 );
        System.out.println( "Interrupting thread..." );
        thread.interrupt();
        Thread.sleep( 3000 );
        System.out.println("Stopping application..." );
        //System.exit(0);
    }
    public void run() {
        while(!stop){
            System.out.println( "Thread is running..." );
            long time = System.currentTimeMillis();
            while((System.currentTimeMillis()-time < 1000)) {
            }
        }
        System.out.println("Thread exiting under request..." );
    }
}