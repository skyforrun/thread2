package com.testThread;

import java.sql.SQLOutput;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @ProjectName: thread
 * @Package: com.testThread
 * @ClassName: TaskDemo
 * @Description: 任务调度（定时任务）
 * @Author: zj
 * @CreateDate: 2019/2/9 16:01
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/2/9 16:01
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class TaskDemo {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new task(),1000,200);
    }
}

class task extends TimerTask{
    @Override
    public void run() {
        System.out.println("idea是个zz");
    }
}