import java.util.*;
public class Solution {  
    public void selectionSort(int[] arr){  
        for (int i = 0; i < arr.length - 1; i++)  
        {  
            int index = i;  
            for (int j = i + 1; j < arr.length; j++){  
                if (arr[j] < arr[index]){  
                    index = j;
                }  
            }  
            int min = arr[index];   
            arr[index] = arr[i];  
            arr[i] = min;  
        }  
    }  
       
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int arr[] = new int[n];
    for(int i=0;i<n ;i++){
        arr[i] = sc.nextInt();
    }
    Solution solution = new Solution();
    solution.selectionSort(arr);
    for(int i=0;i<n ;i++){
        System.out.println(arr[i]);
    }
    }
}
