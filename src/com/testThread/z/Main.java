package com.testThread.z;

import com.sun.xml.internal.txw2.NamespaceResolver;

import java.awt.*;

/**
 * @ProjectName: thread
 * @Package: com.testThread.z
 * @ClassName: Main
 * @Author: zj
 * @Description: ${description}
 * @Date: 2019/8/5 20:39
 * @Version: 1.0
 */
public class Main {
    public static void main(String[] args) {
        Food food = new Food();

        Cook cook = new Cook(food);
        Man man = new Man(food);

        new Thread(cook).start();
        new Thread(man).start();
    }
}
