package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_14921 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] a = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        int b,c,d = 1;
        
        int s = 0;
        int e = N - 1;;
        int answer = 200000001;
        while(s < e){
            int first = a[s];
            int second = a[e];

            int sum = first + second;
            if(Math.abs(sum) < Math.abs(answer)){
                answer = sum;
            }

            if(first + second > 0){
                e--;
            }else {
                s++;
            }
        }
        System.out.println(answer);
    }
}
