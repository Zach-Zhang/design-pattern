package com.zach.design;

/**
 * @Classname MainApp
 * @Description:
 * @Date 2020/3/8 11:03
 * @Created by Zach
 */
public class MainApp {
    public static void main(String[] args) {
        ScoreOperation operation = new OperationAdapter();
        int scores[] = {84, 76, 50, 69, 90, 91, 88, 96};
        System.out.println("成绩排序结果:");
        int result[] = operation.sort(scores);

        //遍历输出成绩
        for (int i : result) {
            System.out.print(i + ",");

        }

        System.out.println();
        int score = 0;
        System.out.println("查找成绩90:");
        score = operation.srarch(result, 90);

        if (score != -1) {
            System.out.println("找到成绩90.");
        } else {
            System.out.println("没有找到成绩90.");
        }

        System.out.println("查找成绩92:");
        score = operation.srarch(result, 92);

        if (score != -1) {
            System.out.println("找到成绩92.");
        } else {
            System.out.println("没有找到成绩92.");
        }
    }

}
