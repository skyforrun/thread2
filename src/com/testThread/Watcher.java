package com.testThread;

/**
 * @ProjectName: thread
 * @Package: com.testThread
 * @ClassName: Watcher
 * @Description: 消费者
 * @Author: zj
 * @CreateDate: 2019/2/9 15:27
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/2/9 15:27
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class Watcher implements Runnable{
    private Moive m;

    public Watcher(Moive m) {
        this.m = m;
    }

    @Override
    public void run() {
        for (int i = 0;i<20;i++){
            m.watch();
        }
    }
}
