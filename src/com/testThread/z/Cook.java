package com.testThread.z;

/**
 * @ProjectName: thread
 * @Package: com.testThread.z
 * @ClassName: Cook
 * @Author: zj
 * @Description: ${description}
 * @Date: 2019/8/5 20:36
 * @Version: 1.0
 */
public class Cook implements Runnable{
    private Food food;
    public Cook(Food food){
        this.food = food;
    }
    @Override
    public void run() {
        for (int i = 0;i<20;i++){
            if (i%2==1){
                food.produce("包子");
            }else {
                food.produce("馒头");
            }
        }
    }
}
