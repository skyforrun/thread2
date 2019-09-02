package com.testThread.stopThread;

/**
 * @ProjectName: thread
 * @Package: com.testThread.stopThread
 * @ClassName: Example2
 * @Author: zj
 * @Description: 使用共享变量（shared variable）发出信号，告诉线程必须停止正在运行的任务,
 *      使用voliate核查这一变量
 * @Date: 2019/9/2 23:34
 * @Version: 1.0
 */

class Example2 extends Thread {
    volatile boolean stop = false;
    public static void main( String args[] ) throws Exception {
        Example2 thread = new Example2();
        System.out.println( "Starting thread..." );
        thread.start();
        Thread.sleep( 3000 );
        System.out.println( "Asking thread to stop..." );

        thread.stop = true;
        Thread.sleep( 3000 );
        System.out.println( "Stopping application..." );
        //System.exit( 0 );
    }

    public void run() {
        while ( !stop ) {
            System.out.println( "Thread is running..." );
            long time = System.currentTimeMillis();
            while ( (System.currentTimeMillis()-time < 1000) && (!stop) ) {
            }
        }
        System.out.println( "Thread exiting under request..." );
    }
}

