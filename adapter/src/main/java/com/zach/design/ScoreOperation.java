package com.zach.design;

/**
 * @Classname ScoreOperation
 * @Description: 抽象成绩操作类, 目标接口
 * @Date 2020/3/7 16:26
 * @Created by Zach
 */
public interface ScoreOperation {
    //成绩排序
    int[] sort(int[] array);
    //成绩查找
    int srarch(int[] array, int key);
}
