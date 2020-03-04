package com.zach.design.observer;

public class MainApp {
    public static void main(String[] args) {
        CommandCenter commandCenter = new ConcreteCommandCenter("金庸群侠!");
        //定义4个观察者
        Observer player1 = new Player("杨过");
        commandCenter.join(player1);
        Observer player2 = new Player("令狐冲");
        commandCenter.join(player2);
        Observer player3 = new Player("张无忌");
        commandCenter.join(player3);
        Observer player4 = new Player("段誉");
        commandCenter.join(player4);
        //某成员遭受攻击
        player1.beAttacked(commandCenter);

    }
}
