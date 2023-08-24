public class 조합 {

    static int n;
    static int r;
    static int[] arr;
    static boolean[] check;
    public static void main(String[] args) {

        n = 5;
        r = 3;
        arr = new int[] {1,2,3,4,5};
        check = new boolean[5];


        조합함수(0,0);
    }

    private static void 조합함수(int idx, int count) {

        if (count == r) {
            for(int i = 0; i < n ; i++){
                if(check[i]) System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }


        for (int i = idx; i < n; i++) {
            if (!check[i]) {
                check[i] = true;
                조합함수(i + 1, count + 1);
                check[i] = false;
            }
        }

    }
}
