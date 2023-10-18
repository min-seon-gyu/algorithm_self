package 누적합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_3020 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[] arr1 = new int[H + 1]; // 석순
        int[] arr2 = new int[H + 1]; // 종유석

        for(int i = 0 ; i < N / 2  ; i++){
            int a = Integer.parseInt(br.readLine());
            int b = Integer.parseInt(br.readLine());

            arr1[a]++;
            arr2[b]++;
        }

        for(int i = H - 1 ; i > 0 ; i--){
            arr1[i] += arr1[i + 1];
            arr2[i] += arr2[i + 1];
        }

        int[] answer = new int[H + 1];
        int min = Integer.MAX_VALUE;
        int cnt = 0;

        for(int i = 1 ; i <= H ; i++){
            answer[i] = arr1[i] + arr2[H - i + 1];
            if(min > answer[i]){
                min = answer[i];
                cnt = 1;
            }else if(min == answer[i]) cnt++;
        }

        System.out.println(min + " " + cnt);
    }
}
