import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class Sorts {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] a = new int[n];
        int[] a1 = new int[n];
        Random r = new Random();

        for (int i = 0; i < a.length; i++) {
            a[i] = r.nextInt();
         }

        print(a);
        q_sort(a, 0, a.length-1);
        print(a);
    }
    // guarantee that l and r are not out of array
    public void insertion (int[] a, int l, int r)
    {

        for (int i = l; i < r+1; i++) {
            int j = i-1;
            int t = a[i];
            while (((j >= 0) &&  (a[j] >= t))) {
                a[j+1] = a[j];
                a[j] = t;
                j--;
                if (j < 0) {
                    break;
                }
            }
        }
    }

    public static void insertion1(LinkedList<Integer> a) {
        for (int i = 1; i < a.size(); i++) {
            int j = i-1;
            int t = a.get(i);
            while (((j >= 0)&  (a.get(j) >= t))) {
                t = a.get(j+1);
                int t1 = a.get(j);
                a.remove(j+1);
                a.remove(j);
                a.add(t);
                a.add(t1);
                j--;
                if (j < 0) {
                    break;
                }
            }
        }
    }

    public static void selection (int[] a) {
        for (int j = 0; j < a.length; j++) {
            int m = Integer.MAX_VALUE;
            int mi = -1;
            for (int i = j; i < a.length; i++) {
                if (a[i] < m) {
                    m = a[i];
                    mi = i;
                }
            }
            a[mi] = a[j];
            a[j] = m;
        }
    }

    public static int q_index(int[] a, int l, int r) {  //O(n)
        int mi = l;      //There was an error costed lots of time
        for (int i = l; i < r; i++) {
            if (a[i] <= a[r]) {
                int t = a[i];
                a[i] = a[mi];
                a[mi] = t;
                mi++;
            }
        }
        return mi;
    }

    public static int q_index1(int[] a, int l, int r) {
        int i = r -1;
        int j = l;
        while (true) {
            while (a[j] < a[r]) {
                j++;
                if (j >= a.length) {
                    break;
                }
            }
            while (a[i] > a[r]) {
                i--;
                if (i < 0) {
                    break;
                }
            }
            if (i > j) {
                swap(a[i], a[j]);
            } else {
                return j;
            }
        }
    }

    public static void q_sort(int[] a, int l, int r) {
        if (r > l) {
            int ind = q_index(a, l, r);
                int t = a[ind];
                a[ind] = a[r];
                a[r] = t;
                q_sort(a, l, ind - 1);
                q_sort(a, ind + 1, r);
        }
    }

    public static void print(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
        System.out.println();
    }


    public static void merge_s(int[] a, int l, int r, int[] a1) {
        if (r > l) {
            int m = (r + l) / 2;
            merge_s(a, l, m, a1);
            merge_s(a, m + 1, r, a1);
            System.out.println("l "+l+" r "+r);
            merge(a,l,r,a1);
        }
    }

    public static void merge(int[] a, int l, int r, int[] a1) {
        int m = (r+l)/2;
            for (int i = l; i < m; i++) {
                if (a[i] < a[m + 1 + i - l]) {
                    a1[i] = a[i];
                    a1[i + 1] = a[m + i - l+1];
                } else {
                    a1[i] = a[m - l + i+1];
                    a1[i + 1] = a[i];
                }
            }
        }


    public static int[] count_s(int[] a, int[] p) {
        int[] res = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            p[a[i]] = 1;
        }
        int j = 0;
        for (int i = 0; i < p.length; i++) {
            if (p[i] > 0) {
                res[j] = i;
                j++;
            }
        }
        return res;
    }

    public static void bucket_s(double[] a, int n, double dl, double dr) {
        LinkedList<Integer>[] b = new LinkedList[n];
        double d = (dr - dl)/n;
        int bi = 0;
        for (int i = 0; i < a.length; i++) {
            bi = (int)(a[i]/d);

        }

    }

    public static void swap(int a, int b) {
        int t = a;
        a = b;
        b = t;
    }

}
