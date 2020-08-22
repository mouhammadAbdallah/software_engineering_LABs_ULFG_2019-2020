/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package td11Test;

/**
 *
 * @author Moham
 */
public class Array {

    public static double GetAvarage(double[] data) {
        if (data==null)return 0;
        double res = 0;
        for (double num : data) {
            res = res + num;
        }
        return res / data.length;
    }
    public static double[] Sort(double[] data){
        if(data==null)return null;
        double[] arr=new double[data.length];
        System.arraycopy(data, 0, arr, 0, data.length);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    double tmp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = tmp;
                }
            }
        }
        return arr;
    }

}
