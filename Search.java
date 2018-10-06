import java.util.Random;
import java.util.Scanner;

public class Search {

    //k - ya statistica  ne canon
    public static int search_k(int[] a, int k) {
        int t = a.length % k;
        if (t > 0) {
            t = 1;
        }
        int[] loc_max_k = new int[(a.length / k)+t];
        int[] loc_min_k = new int[loc_max_k.length];

        int min = 0;
        int max = 0;
        int j = -1;
        for (int i = 0; i < a.length; i++) {
            if (i % k == 0) {

                if (j < loc_max_k.length) {
                    j++;
                }
                    max = Integer.MIN_VALUE;
                    min = Integer.MAX_VALUE;
                }
                if (a[i] > max) {
                    max = a[i];
                    loc_max_k[j] = max;
                }
                if (a[i] < min) {
                   min = a[i];
                   loc_min_k[j] = min;
                }
            }

            max = Integer.MIN_VALUE;
            int ind_min = 0;
            for (int i = 0; i < loc_min_k.length; i++) {
                if (loc_min_k[i] > max) {
                    max = loc_min_k[i];
                }
            }
            return max;
        }

        public static int med_ind(int[] min, int[] max) {
            int[] a = new int[min.length*2];

            return 0;
        }
        // ] a[0..n/5] and a[k1] - med

       // med.length <= 5 after while
       // proof: if med.length >=5 then l >= 5 ==> while still working ==> make divide_med
    public void k_search1(int[] a, int k) //Utechka?
     {
         int[] med = divide_med(a, 5);
         int l = med.length;
         while (l >= 2) {
             med = divide_med(med, 5);
             l = med.length;
         }
         System.out.println("med_l "+med.length);
         int a_med = med[0];

         int a_med_index = 0;
         for (int i = 0; i < a.length; i++) {
             if (a[i] == a_med) {
                 a_med_index = i;
                 break;
             }
         }

         int q = partitition(a, 0, a.length-1, a_med_index);
         if (q != k) {
             int[] a1 = new int[a.length - q];
             for (int i = 0; i < a1.length; i++) {
                 a1[i] = a[q + i];
             }

             k_search1(a1, k-q);
         } else {
             System.out.println(a[q]);
         }

     }



        // dividing []a on k line segments and finding med-s on them
        public int[] divide_med(int[] a, int k) {
              // sorting segments
             // proof: i-iteration ==> if (j < a.length) ==> s.insertion(a, -1+1+i*k, -1+(i+1)*k)
             // (i-1) iteration segment doesn't intersec i and (i-2). Length of each seg. is k ==> each segment doesn't intersec another
            //     proof: i-1 - iter ==> s.insertion(a, -1+1+(i-1)*k, -1+i*k) ==> work on a[(i-1)*k..i*k-1] ==> doesn't intersec i-iter and by analogy (i-2) - iter doesn't intersec (i-1). Length is i*k-1-(i-1)*k+1 = k
            // while ends, when j < a.length and j+k > a.length
            //   proof:
            //
            if (a.length > k) {
                Sorts s = new Sorts();
                int j = -1;
                while (j < a.length) {
                    try {
                        s.insertion(a, j + 1, j + k);
                    } catch (Exception e) {}
                    j += k;
                }
                if (a.length % k > 0) {
                    j -= k;
                    s.insertion(a, j + 1, a.length - 1);
                }

                int[] res = new int[seg_count(a.length, k)];
                for (int i = 0; i < res.length; i++) {
                    res[i] = a[res.length + i * res.length];
                }

                return res;
            } else {
                    Sorts s = new Sorts();
                    s.insertion(a, 0, a.length - 1);
                    int[] res = new int[1];
                    res[0] = a[a.length / 2];
                    return res;
            }
        }

        // ammount of segments with length <= k on which a segment with length a can be divided
        public int seg_count(int a, int k) {
             int res = a/k;
             if (a % k > 0) {
                 res++;
             }
             return res;
        }


        // 1) ] a[1..j] - sorted and (a[j+1] > a[j]) ==> a[1..j+1] -sorted
        //             proof: a[1..j] - sorted <==> a[1] < a[2] < ... < a[j]. a[j+1] > a[j] ==> a[1] < a[2] < ... < a[j] < a[j+1] <===> a[1..j+1] - sorted
        // 2) let a[1..j] - sorted
        // 3) if (1) - false and (2) - true ==> a[j+1] => a[j] (a[j] > a[j+1] == false)
        // 4) if a[1..j] - sorted ===> for any -1 < l, r < j a[l..r] - sorted
        //             proof: a[1..j] - sorted <===> a[1] < a[2] < .. < a[j] for any number = 1..j <==> a[1] < .. <a[l] < .. <a[r]<...<a[j] <==> a[l] < ... <a[r] <===> a[l..r] - sorted
        // 5) a[1] - is sorted
        // 6) let a[1..j] - sorted
        // 7) let insert() { while (a[j+1] >= a[j]) { swap(a[j+1], a[j])
        public void ins_s(int[] a) {
             for (int i = 0; i < a.length; i++) {
                 int j = i;
                 while (a[i] < a[j]) {

                 }
             }
        }


        public static void main (String[] args){
            Random r = new Random();
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < a.length; i++) {
                a[i] = r.nextInt();
                System.out.println(a[i]);
            }
            Search s = new Search();
            System.out.println();
            s.k_search1(a, 3);
        }

        // while can quit at r = l - 1; l = r + 1;
        // if r = j ( j < r.init-1) ==> a[r.init-1..j] > pivot
        // proof: let r.init > k > j and a[k] < pivot
        //  while starts from r = r.init
        //
        // proof: the last iter of while ==>
        public int partitition(int[] a, int l, int r, int x_ind) {
             int pivot = a[x_ind];
             r--;
             while (r > l) {
                 while (a[l] < pivot) {
                     l++;
                 }
                 while (a[r] > pivot) {
                     r--;
                 }
                 int t = a[l];
                 a[l] = a[r];
                 a[r] = t;
             }

             a[r] = a[l];
             a[l] = pivot;
             return l;
        }
    }

