public class 부분집합 {

    static int n;
    static int r;
    static int[] arr;
    static int[] ans;
    static boolean[] check;
    public static void main(String[] args) {

        n = 5;
        r = 3;
        arr = new int[] {1,2,3,4,5};
        ans = new int[3];
        check = new boolean[5];


        부분집합함수(0,0);
    }

    private static void 부분집합함수(int idx, int count) {

        if (count == n) {
            for(int i = 0; i < n ; i++){
                if(check[i]) System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }


        check[idx] = false;
        부분집합함수(idx + 1, count + 1);
        check[idx] = true;
        부분집합함수(idx + 1, count + 1);


    }
}
