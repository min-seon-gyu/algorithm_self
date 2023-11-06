package 누적합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_2559 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int[] sum = new int[N-K+1];

        st = new StringTokenizer(br.readLine());

        for(int i = 0 ; i < N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0 ; i < K ; i++){
            sum[0] += arr[i];
        }

        int start = 0;

        int idx = 1;
        for(int i = K ; i < N ; i++){
            sum[idx] = sum[idx - 1] + arr[i] - arr[start];
            idx++;
            start++;
        }


        int answer = Integer.MIN_VALUE;
        for(int i = 0 ; i < sum.length ; i++){
            if(answer < sum[i]) answer = sum[i];
        }

        System.out.println(answer);
    }
}
