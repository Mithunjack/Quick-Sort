package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] inputArray = {9 , 6 , 2 , 1 , 7 , 3 , 4 , 8};
        System.out.println(Arrays.toString(inputArray));
        quickSort(inputArray,0,inputArray.length-1);
        System.out.println(Arrays.toString(inputArray));
    }
    public static void quickSort(int[] inputArray,int start,int end){
        System.out.println("Start: " + start);
        System.out.println("End: " + end);
        if(start<end){
            int pivot = partition(inputArray,start,end);
            int leftStartPosition = start;
            int leftEndPosition = pivot-1;
            int rightStartPosition = pivot+1;
            int rightEndPosition = end;
            quickSort(inputArray,leftStartPosition,leftEndPosition);
            quickSort(inputArray,rightStartPosition,rightEndPosition);
        }
    }
    public static int partition (int[] givenArray,int start,int end){
        int pivot = end;
        for (int i=start;i<end;i++){
            pivot = checkLeftValue(givenArray,pivot);
        }
        return pivot;
    }

    private static int checkLeftValue(int[] givenArray,int pivot) {
        for (int i=0;i<pivot;i++){
            if (givenArray[pivot] < givenArray[i]){
                if(pivot-1 != i)
                {
                    pivot = leftshift(givenArray,pivot,pivot-1,i);
                }else{
                    swap(givenArray,pivot-1,givenArray[pivot],pivot);
                    return pivot -1;
                }
                break;
            }
        }
        return pivot;
    }

    public static int leftshift(int[] givenArray, int pivotValuePositionInArray, int previousValuePositionOfPivot, int comparedValuePosition){
        int temp = givenArray[previousValuePositionOfPivot];
        givenArray[previousValuePositionOfPivot] = givenArray[pivotValuePositionInArray] ;
        swap(givenArray,comparedValuePosition,temp,pivotValuePositionInArray);
        return previousValuePositionOfPivot;
    }

    public static void swap(int[] array, int comparedValuePosition, int temp , int pivotValuePosition){
        array[pivotValuePosition]= array[comparedValuePosition];
        array[comparedValuePosition] = temp;
        System.out.println(Arrays.toString(array));
    }
}
