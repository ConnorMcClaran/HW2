/**
 * Created by mcclarci on 9/28/2016.
 * Connor McClaran code for 2.1.12
 */
import java.io.* ;
import java.util.Arrays;

public class ShellSortCount {
    public static void shellsort(Comparable[] a){
        int count = 0;
        int N = a.length;
        int h = 1;
        while(h < N/3) h = 3*h + 1;
        while(h >= 1)
        {
            for(int i = h; i < N; i++){
                for(int j = i; j >= h && less(a[j], a[j-h] ); j -=h)
                    exch(a, j, j-h);
                    count++;
            }h = h/3 ;
        } int c = count/ a.length;
          System.out.println(c) ;
    }

    public static boolean less(Comparable v , Comparable w)
    {return v.compareTo(w) < 0;}


    public static void exch(Comparable[] a , int i , int j)
    {Comparable t = a[j]; a[i] = a[j]; a[j] = t;}


    public static void show(Comparable[] a)
    {
        for ( int i = 0; i < a.length; i++)
            System.out.println(a[i] + "");
        System.out.println();
    }

    public static boolean isSorted(Comparable[] a){
        for (int i = 1; i < a.length; i++)
            if(less(a[i] , a[i-1])) return false;
        return true;
    }
    public static double[] arrayBuilder(int size){
        double[] a;
        a = new double[size];
        for (int i =0; i < size; i++){
            a[i] = Math.random();

        }
        return a;

    } public static void main(String[] args){
        double[] x = arrayBuilder(10);

        ShellSortCount.show(x);
        ShellSortCount.shellsort(x);
        ShellSortCount.show(x);

        double[] y = arrayBuilder(100);

        ShellSortCount.show(y);
        ShellSortCount.shellsort(y);
        ShellSortCount.show(y);

        double[] z = arrayBuilder(1000);

        ShellSortCount.show(z);
        ShellSortCount.shellsort(z);
        ShellSortCount.show(z);






    }


}

