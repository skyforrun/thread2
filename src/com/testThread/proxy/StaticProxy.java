package com.testThread.proxy;

/**
  *
  * @ProjectName:
  * @Package:
  * @ClassName:
  * @Description:    静态代理 设计模式
  *     1、有真实角色
  *     2、有代理角色:持有真实角色的引用
  *     3、二者实现相同的接口
 *
 *     4、针对线程的创建实现接口方式
 *        1）thread已经实现runbable，为代理
 *        2）真实引用为自己写的，为真实角色
 *        3） TestThread t = new TestThread()；
 *              new Thread(t);//真实对象的引用
  * @Author:         zj
  * @CreateDate:
  * @UpdateUser:     更新者
  * @UpdateDate:
  * @UpdateRemark:   更新内容
  * @Version:        1.0
  */

public class StaticProxy {
    public static void main(String[] args) {
        //创建真实角色
        You you = new You();
        //创建代理角色,加入真实角色的引用
        Vedding v = new Vedding(you);
       //执行任务
        v.marry();
    }
}
//接口
interface Marry{
    void marry();
}
//真实角色
class You implements Marry{
    @Override
    public void marry() {
        System.out.println("you结婚了");
    }
}
//代理角色
 class Vedding implements Marry{
    private You you;
    public Vedding(){}
    public Vedding(You you){
        this.you = you;
    }
    private void before(){
        System.out.println("前面忙前忙后");
    }
    private void after(){
        System.out.println("后面忙完了要收钱");
    }
    public void marry() {
        before();
        you.marry();
        after();
    }
}