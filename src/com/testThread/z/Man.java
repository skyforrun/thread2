package com.testThread.z;

/**
 * @ProjectName: thread
 * @Package: com.testThread.z
 * @ClassName: Man
 * @Author: zj
 * @Description: ${description}
 * @Date: 2019/8/5 20:32
 * @Version: 1.0
 */
public class Man implements Runnable{
    private Food food;
    public Man(Food food){
        this.food = food;
    }
    @Override
    public void run() {
        for (int i = 0;i<20;i++){
            food.eat();
        }
    }
}
