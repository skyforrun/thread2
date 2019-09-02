package com.testThread.produces;

/**
 * @ProjectName: thread
 * @Package: com.testThread
 * @ClassName: Player
 * @Description: 生产者
 * @Author: zj
 * @CreateDate: 2019/2/9 15:26
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/2/9 15:26
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class Player implements Runnable{
    private Moive m;

    public Player(Moive m) {
        this.m = m;
    }

    @Override
    public void run() {
        for (int i = 0;i<20;i++){
            if(i%2==0){
                m.play("无问西东");
            }else {
                m.play("爱国");
            }
        }
    }
}
