public class 순열 {

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


        순열함수(0);
    }

    private static void 순열함수(int count) {

        if(count == r){
            for(int i : ans) System.out.print(i + " ");
            System.out.println();
            return;
        }


        for(int i = 0; i < n ; i++){
            if(!check[i]){
                check[i] = true;
                ans[count] = arr[i];
                순열함수(count + 1);
                check[i] = false;
            }
        }
    }
}
