package 정렬;

public class MergeSort {
    static int[] tmp;
    static int[] arr;
    public static void run(){

        arr = new int[]{5, 2, 3, 1, 6, 7, 4};
        tmp = new int[arr.length];

        print(arr);
        mergeSort(0, arr.length -1);
        print(arr);

    }

    private static void mergeSort(int start, int end) {

        if(start < end){

            int mid = (start + end) / 2;

            mergeSort(start, mid);
            mergeSort(mid + 1, end);


            int p = start;
            int q = mid + 1;
            int idx = p;

            while (p<=mid && q<=end) {
                if (arr[p]<arr[q]) {
                    tmp[idx++] = arr[p++];
                } else {
                    tmp[idx++] = arr[q++];
                }
            }

            if(p > mid){
                while(q <= end){
                    tmp[idx++] = arr[q++];
                }

            }else if(q > end){
                while(p <=mid){
                    tmp[idx++] = arr[p++];
                }
            }

            for (int i=start;i<=end;i++) {
                arr[i]=tmp[i];
            }

        }
    }

    private static void print(int[] arr) {
        System.out.println("시작");
        for(int data : arr){
            System.out.print(data + " ");
        }
        System.out.println();
        System.out.println("종료");
    }
}
