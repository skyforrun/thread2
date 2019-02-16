package com.testThread;

/**
 * @ProjectName: thread
 * @Package: com.testThread
 * @ClassName: Moive
 * @Description: 模拟一个看电影的场景,一份共同的资源
 *        1)生产者消费者模式，信号灯法
 *        2)wait():会释放锁
 * @Author: zj
 * @CreateDate: 2019/2/9 15:19
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/2/9 15:19
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class Moive {
    private String pic;//电影

    //flag-->true, 生产者生产，消费者休眠，生产完成后通知消费
    //flag-->false, 消费者消费，生产者休眠，消费完成后通知生产
    private boolean flag = true;//信号灯

    public synchronized void play(String pic){
        if (flag==false){//生产者等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("开始生产了："+pic);
        //开始生产,时间为500
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //生产完毕
        this.pic = pic;
        //通知消费
        this.notify();
        //生产者停下
        this.flag = false;
    }

    public synchronized void watch(){
        if (flag){//消费者等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("开始消费了："+pic);
        //开始消费,时间为200
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //消费完毕，通知生产
        this.notify();
        //消费停止
        this.flag = true;
        //System.out.println(pic);
    }
}
