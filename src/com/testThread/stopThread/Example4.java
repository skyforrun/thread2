package com.testThread.stopThread;

/**
 * @ProjectName: thread
 * @Package: com.testThread.stopThread
 * @ClassName: Example4
 * @Author: zj
 * @Description:    如果线程被I/O操作阻塞，该线程将接收到一个SocketException异常，
 *      这与使用interrupt()方法引起一个InterruptedException异常被抛出非常相似。
 * @Date: 2019/9/2 23:42
 * @Version: 1.0
 */
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

class Example4 extends Thread {
    public static void main( String args[] ) throws Exception {
        Example4 thread = new Example4();
        System.out.println( "Starting thread..." );
        thread.start();
        Thread.sleep( 3000 );
        System.out.println( "Interrupting thread..." );
        thread.interrupt();
        Thread.sleep( 3000 );
        System.out.println( "Stopping application..." );
        //System.exit( 0 );
    }

    public void run() {
        ServerSocket socket;
        try {
            socket = new ServerSocket(7856);
        } catch ( IOException e ) {
            System.out.println( "Could not create the socket..." );
            return;
        }
        while ( true ) {
            System.out.println( "Waiting for connection..." );
            try {
                Socket sock = socket.accept();
            } catch ( IOException e ) {
                System.out.println( "accept() failed or interrupted..." );
            }
        }
    }
}
