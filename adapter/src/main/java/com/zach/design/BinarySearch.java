package com.zach.design;

/**
 * @Classname BinarySearch
 * @Description: 二分法查找类: 适配者
 * @Date 2020/3/7 23:06
 * @Created by Zach
 */
public class BinarySearch {
    public int binarySearch(int[] array, int key) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (array[mid] < key) {
                low = mid + 1;
            } else if (array[mid] > key) {
                high = mid - 1;
            } else {
                return 1;
            }
        }
        return -1;
    }
}
