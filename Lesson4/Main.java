import java.util.Scanner;
import java.lang.Math;

public class Main 
{ 
    public static void main(String[] args) 
    {
        int[] arr = { 1, 3, 13, 5, 7, 8, 9};
        MainTask.checkNumb(arr);
        int[] newArr = MainTask.delNumb(arr);
        for (int i = 0; i < newArr.length; i++)
        {
            System.out.print(newArr[i] + " ");
        }
        MainTask.minAvgMaxInArr();
        MainTask.checkAvgInArrays();
        AdditionalTask.evenArray();
        AdditionalTask.changeNotEvenIndexOnNull();
        AdditionalTask.sortString();
        AdditionalTask.bubbleSort(arr);
    }
    
}
