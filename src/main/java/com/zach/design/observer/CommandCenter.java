package com.zach.design.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 被观察者,抽象目标类: 命令控制中心
 */

public abstract class CommandCenter {
    //战队名称
    protected String allyName;
    protected List<Observer> players = new ArrayList<>();

    public String getAllyName() {
        return allyName;
    }

    public void setAllyName(String allyName) {
        this.allyName = allyName;
    }

    public void join(Observer obs) {
        System.out.println(obs.getName() + "加入" + this.allyName + "战队!");
        players.add(obs);
    }

    public void quit(Observer obs) {
        System.out.println(obs.getName() + "退出" + this.allyName + "战队");
        players.remove(obs);
    }

    public abstract void notifyObserver(String name);
}
