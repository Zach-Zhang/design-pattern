package com.zach.design;

/**
 * @Classname OperationAdapter
 * @Description: 操作适配器
 * @Date 2020/3/7 23:19
 * @Created by Zach
 */
public class OperationAdapter implements ScoreOperation{
    private QuickSort quickSort;
    private BinarySearch binarySearch;

    public OperationAdapter() {
        quickSort = new QuickSort();
        binarySearch = new BinarySearch();
    }

    public int[] sort(int[] array) {
        return quickSort.quickSort(array);
    }

    public int srarch(int[] array, int key) {
        return binarySearch.binarySearch(array,key);
    }
}
