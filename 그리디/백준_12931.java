package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_12931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        while(!check(arr)){
            while(!evenCheck(arr)){
                answer++;
            }

            if(check(arr)) break;

            for(int i = 0 ; i < arr.length ; i++){
                arr[i] /= 2;
            }
            answer++;
        }
        System.out.println(answer);
    }

    private static boolean evenCheck(int[] arr) {
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] % 2 != 0) {
                arr[i]--;
                return false;
            }
        }
        return true;
    }

    private static boolean check(int[] arr) {
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] > 0) return false;
        }
        return true;
    }
}
