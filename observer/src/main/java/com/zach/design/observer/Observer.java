package com.zach.design.observer;

/**
 * 抽象观察者接口
 */
public interface Observer {
    String getName();
    void setName(String name);
    void help();

    void beAttacked(CommandCenter commandCenter);
}
