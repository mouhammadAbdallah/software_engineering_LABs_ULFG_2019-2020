/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Array;

/**
 *
 * @author Moham
 */
public class Array {
    public static int indexMax(int[] array){
         if ((array==null)||(array.length==0))return -1;
         int j=0,max=array[j];
         for(int i=1;i<array.length;i++){
             if(array[i]>max){
                 max=array[i];
                 j=i;
             }
         }
         return j;
    }
    public static int[] insertElement(int[] sortedArray,int element){//sorted array is always full if it is not null  because default int is 0;
        //sorted array :croissant
        
        if(sortedArray==null)return null;
        int[] arr=new int[sortedArray.length+1];
        System.arraycopy(sortedArray, 0, arr, 0, sortedArray.length);
        
        int i=0;
        while(i+1<arr.length){
            if(arr[i]>arr[i+1])break;
            i++;
        }
        if(i+1 !=arr.length){// not a sorted table we need to sort it to know where to insert the new element
            for ( i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        }
        else{//sorted table
            
            i=0;
            int j=sortedArray.length;
            while(i<arr.length){
                if(arr[i]>element){
                    j=i;
                }
            }
            
            for(i=arr.length-1;i>j;i--){
                arr[i]=arr[i-1];           
            }
            arr[j]=element;

        }
        return arr;
    }
    
}
