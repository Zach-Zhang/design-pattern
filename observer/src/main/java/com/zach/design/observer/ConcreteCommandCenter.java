package com.zach.design.observer;

/**
 * 具体目标类
 */
public class ConcreteCommandCenter extends CommandCenter {
    public ConcreteCommandCenter(String allyName) {
        this.allyName = allyName;
    }

    @Override
    public void notifyObserver(String name) {
        for (Observer obServer : players) {
            if (!obServer.getName().equals(name))
                obServer.help();
        }
    }
}
