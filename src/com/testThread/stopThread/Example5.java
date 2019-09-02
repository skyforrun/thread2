package com.testThread.stopThread;

/**
 * @ProjectName: thread
 * @Package: com.testThread.stopThread
 * @ClassName: Example5
 * @Author: zj
 * @Description:    必须存在socket的引用（reference），只有这样close()方法才能被调用。
 *      这意味着socket对象必须被共享。Listing E描述了这一情形
 *      https://blog.csdn.net/wxwzy738/article/details/8516253
 * @Date: 2019/9/2 23:44
 * @Version: 1.0
 */

import java.net.*;
import java.io.*;
class Example5 extends Thread {
    volatile boolean stop = false;
    volatile ServerSocket socket;
    public static void main( String args[] ) throws Exception {
        Example5 thread = new Example5();
        System.out.println( "Starting thread..." );
        thread.start();
        Thread.sleep( 3000 );
        System.out.println( "Asking thread to stop..." );
        thread.stop = true;
        thread.socket.close();
        Thread.sleep( 3000 );
        System.out.println( "Stopping application..." );
        //System.exit( 0 );
    }
    public void run() {
        try {
            socket = new ServerSocket(7856);
        } catch ( IOException e ) {
            System.out.println( "Could not create the socket..." );
            return;
        }
        while ( !stop ) {
            System.out.println( "Waiting for connection..." );
            try {
                Socket sock = socket.accept();
            } catch ( IOException e ) {
                System.out.println( "accept() failed or interrupted..." );
            }
        }
        System.out.println( "Thread exiting under request..." );
    }
}
