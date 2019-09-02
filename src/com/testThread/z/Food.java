package com.testThread.z;

import javax.sound.midi.Soundbank;

/**
 * @ProjectName: thread
 * @Package: com.testThread.z
 * @ClassName: Food
 * @Author: zj
 * @Description: ${description}
 * @Date: 2019/8/5 20:04
 * @Version: 1.0
 */
public class Food {
    private String food;
    private boolean flag=true;

    /**
     * 生产
     * @param food
     */
    public synchronized void produce(String food){
        if (!flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("开始生产食物:"+food);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.food = food;
        this.notify();
        this.flag=false;
    }

    /**
     * 消费
     */
    public synchronized void eat(){
        if (flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("开始消费了:"+food);
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.notify();
        this.flag=true;
    }

}
