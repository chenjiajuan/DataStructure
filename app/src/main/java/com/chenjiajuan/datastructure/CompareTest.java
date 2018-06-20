package com.chenjiajuan.datastructure;

/**
 * Created by chenjiajuan on 2018/6/19.
 */

public class CompareTest {

    public static Comparable findMax(Comparable [] arr){
        int maxIndex=0;
        for (int i=0;i<arr.length;i++){
            if (arr[i].compareTo(arr[maxIndex])>0){
                maxIndex=i;
            }
        }
        return arr[maxIndex];
    }
    public static Comparable findMin(Comparable [] arr){
        int minIndex=0;
        for (int i=0;i<arr.length;i++){

            if (arr[i].compareTo(arr[minIndex])<0){
                minIndex=i;
            }
        }
        return arr[minIndex];
    }

    public static void main(String [] args){
        String [] str1={"Job","Bob","Bill","Zake"};
        System.out.println(findMax(str1));
        System.out.println(findMin(str1));


    }
}
