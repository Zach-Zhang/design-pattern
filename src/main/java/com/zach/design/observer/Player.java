package com.zach.design.observer;

/**
 * 具体观察者类
 */
public class Player implements Observer {
    private String name;

    public Player(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void help() {
        System.out.println("坚持住," + this.name + "来救你!");
        //做一些业务处理
    }

    @Override
    public void beAttacked(CommandCenter commandCenter) {
        System.out.println(this.name + "被攻击");
        commandCenter.notifyObserver(name);
    }
}
