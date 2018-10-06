public class BinHeap {

    int size;
    int[] a;

    public BinHeap(int size) {
        this.size = size;
        a = new int[size];
    }

    public int getParent(int index) {   //O(1)
        if ( index == 0) {
            System.out.println("root");
            return -1;
        } else {
            return (index-1)/2;
        }
    }

    public int getSon(int index) {   //O(1)
        try {
            int t = a[index*2+1];
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("None");
            return -1;
        }
        finally {return index*2+1;}
    }

    public void heapify(int i) {  //zamena v h[i]            //O(logn)
        int l = 2*i+1;
        int r = 2*i+2;
        int lar = i;
        if (l < size) {
            if (a[lar] < a[l]) {
                lar = l;
            }
        }
        if (r < size) {
            if (a[lar] < a[r]) {
                lar  = r;
            }
        }
        if (lar != i) {
            int t = a[lar];
            a[lar] = a[i];
            a[i] = t;
            heapify(lar);
        }
    }

    public void add (int v, int i) {   //O(nlogn)
        a[i] = v;
        for (int j = size-1; j >= 0; j--) {
            heapify(j);
        }
    }

    public void print() {  //O(n)
        for(int i = 0; i < size; i++) {
            System.out.println(a[i]);
        }
    }

    }


