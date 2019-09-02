package com.testThread;

import java.util.concurrent.*;

/**
 * @ProjectName: thread
 * @Package: com.testThread
 * @ClassName: Call
 * @Description: callable创建线程
 * @Author: zj
 * @CreateDate: 2019/2/3 18:58
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/2/3 18:58
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class Call {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //创建线程
        ExecutorService ser = Executors.newFixedThreadPool(2);
        Race tortolse = new Race("老乌龟",1000);
        Race rabbit = new Race("兔子",500);
        //获取值
        Future<Integer> result1 = ser.submit(tortolse);
        Future<Integer> result2 = ser.submit(rabbit);

        //停止线程体的循环
        Thread.sleep(2000);
        tortolse.setFlag(false);
        rabbit.setFlag(false);

        int num1 = result1.get();
        int num2 = result2.get();
        System.out.println("老乌龟"+"跑了"+num1+"步");
        System.out.println("兔子跑了"+num1+"步");
        //停止服务
        ser.shutdown();
    }
}

 /**
  * @method
  * @description 模拟龟兔赛跑
  * @date:
  * @author: zj
  * @return
  */
class Race implements Callable<Integer>{
    private String name; //名称
    private long time; //比赛延时
    private boolean flag = true;
    private int step = 0;//走的步数
     public Race(String name,int time) {
         this.name = name;
         this.time = time;
     }
     public Race() {}

     public String getName() {
         return name;
     }

     public Race setName(String name) {
         this.name = name;
         return this;
     }

     public long getTime() {
         return time;
     }

     public Race setTime(long time) {
         this.time = time;
         return this;
     }

     public boolean isFlag() {
         return flag;
     }

     public Race setFlag(boolean flag) {
         this.flag = flag;
         return this;
     }

     public int getStep() {
         return step;
     }

     public Race setStep(int step) {
         this.step = step;
         return this;
     }

     @Override
    public Integer call() throws Exception {
        while (flag){
            Thread.sleep(time);
            step++;
        }
        return step;
    }
}