package 재귀;

public class Test {
    static int N = 4;
    static int R = 2;
    static int[] 배열;
    static boolean[] 조합체크;
    static boolean[] 부분집합체크;
    static boolean[] 순열체크;

    public static void main(String[] args) {
        테스트();
    }


    public static void 테스트(){

        배열 = new int[] {1, 2, 3, 4};
        조합체크 = new boolean[4];
        부분집합체크 = new boolean[4];
        순열체크 = new boolean[4];


        System.out.println("========================== 순열");
        순열(0);

        System.out.println("========================== 조합");
        조합(0, 0);

        System.out.println("========================== 부분집합");
        부분집합(0);
    }

    private static void 부분집합(int count) {

        if(count == N){
            for(int i = 0; i < N ; i++){
                if(부분집합체크[i]){
                    System.out.print(배열[i] + " ");
                }
            }
            System.out.println();
            return;
        }

        부분집합체크[count] = true;
        부분집합(count + 1);
        부분집합체크[count] = false;
        부분집합(count + 1);
    }

    private static void 조합(int start, int count) {
        if(count == R){
            for(int i = 0; i < N ; i++){
                if(조합체크[i]){
                    System.out.print(배열[i] + " ");
                }

            }
            System.out.println();
            return;
        }
        for(int i = start ; i < N ;i++){
            조합체크[i] = true;
            조합(i + 1 , count + 1);
            조합체크[i] = false;
        }
    }

    private static void 순열(int count) {

        if(count == R){
            for(int i = 0; i < N ; i++){
                if(순열체크[i]){
                    System.out.print(배열[i] + " ");
                }

            }
            System.out.println();
            return;
        }

        for(int i = 0 ; i < N ;i++){
            if(!순열체크[i]){
                순열체크[i] = true;
                순열(count + 1);
                순열체크[i] = false;
            }
        }
    }
}
