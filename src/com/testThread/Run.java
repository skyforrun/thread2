package com.testThread;

import javax.naming.Name;
import javax.security.auth.login.AppConfigurationEntry;

/**
 * @ProjectName: thread
 * @Package: com.testThread
 * @ClassName: Run
 * @Description: java类作用描述
 * @Author: zj
 * @CreateDate: 2019/2/3 19:41
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/2/3 19:41
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class Run implements Runnable{

    @Override
    public void run() {
        while (true){
            Race1 tuzi = new Race1("tuzi",200);
            Race1 wugui = new Race1("wugui",100);

            tuzi.setFlag(false);
            wugui.setFlag(false);

            int step1 = tuzi.run();
            int step2 = wugui.run();

            System.out.println("兔子跑了"+step1+"步");
            System.out.println("乌龟跑了"+step2+"步");
        }
    }

    public static void main(String[] args) {
        Run runone =  new Run();
        Thread t1 = new Thread(runone);
        t1.start();
    }
}

class Race1{
    private String name;
    private long time;
    private boolean flag;
    private int step;

    public String getName() {
        return name;
    }

    public Race1 setName(String name) {
        this.name = name;
        return this;
    }

    public long getTime() {
        return time;
    }

    public Race1 setTime(long time) {
        this.time = time;
        return this;
    }

    public boolean isFlag() {
        return flag;
    }

    public Race1 setFlag(boolean flag) {
        this.flag = flag;
        return this;
    }

    public int getStep() {
        return step;
    }

    public Race1 setStep(int step) {
        this.step = step;
        return this;
    }

    public Race1() {

    }

    public Race1(String name, int step) {
        this.name = name;
        this.step = step;
    }

    public int run(){
        while (flag) {
            try {
                Thread.sleep(3000);
                step++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return step;
    }
}