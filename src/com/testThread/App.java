package com.testThread;

/**
 * @ProjectName: thread
 * @Package: com.testThread
 * @ClassName: App
 * @Description: 消费者生产者的测试用例
 * @Author: zj
 * @CreateDate: 2019/2/9 15:33
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/2/9 15:33
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class App {
    public static void main(String[] args) {
        //共同的资源
        Moive m = new Moive();

        //两个线程
        Player p = new Player(m);
        Watcher w = new Watcher(m);

        new Thread(p).start();
        new Thread(w).start();
    }

}
