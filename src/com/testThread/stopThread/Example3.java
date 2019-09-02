package com.testThread.stopThread;

/**
 * @ProjectName: thread
 * @Package: com.testThread.stopThread
 * @ClassName: Example3
 * @Author: zj
 * @Description:    Thread.interrupt()方法不会中断一个正在运行的线程。这一方法实际上完成的是，
 *   在线程受到阻塞时抛出一个中断信号，这样线程就得以退出阻塞的状态。更确切的说，
 *   如果线程被Object.wait, Thread.join和Thread.sleep三种方法之一阻塞，那么，
 *   它将接收到一个中断异常（InterruptedException），从而提早地终结被阻塞状态
 * @Date: 2019/9/2 23:38
 * @Version: 1.0
 */

class Example3 extends Thread {
    volatile boolean stop = false;
    public static void main( String args[] ) throws Exception {
        Example3 thread = new Example3();
        System.out.println( "Starting thread..." );
        thread.start();
        Thread.sleep( 3000 );
        System.out.println( "Asking thread to stop..." );
        thread.stop = true;//如果线程阻塞，将不会检查此变量
        thread.interrupt();
        Thread.sleep( 3000 );
        System.out.println( "Stopping application..." );
        //System.exit( 0 );
    }

    public void run() {
        while ( !stop ) {
            System.out.println( "Thread running..." );
            try {
                Thread.sleep( 1000 );
            } catch ( InterruptedException e ) {
                System.out.println( "Thread interrupted..." );
            }finally {
                System.out.println("will you enter this sentence?");
            }
        }
        System.out.println( "Thread exiting under request..." );
    }
}
