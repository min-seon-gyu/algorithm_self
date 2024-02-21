package 세그먼트트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_11505 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int value = 1000000007;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int height = (int)Math.ceil(Math.log(N) / Math.log(2));
        int size = (int)Math.pow(2, height + 1);

        long[] tree = new long[size];
        int startIndex = (int)Math.pow(2, height);
        Arrays.fill(tree, 1);

        for(int i = 0 ; i < N ; i++){
            tree[startIndex + i] = Integer.parseInt(br.readLine());
        }

        for(int i = startIndex - 1 ; i>= 1 ; i--){
            tree[i] = (tree[i * 2] % value * tree[i * 2 + 1] % value) % value;
        }

        for(int i = 0 ; i < M + K ; i++){
            st = new StringTokenizer(br.readLine());
            int a= Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            long answer = 1;

            if(a==1){
                b = startIndex + b - 1;
                tree[b] = c % value;
                while(b > 1){
                    b = b/2;
                    tree[b] = (tree[b * 2] % value * tree[b * 2 + 1] % value) % value;
                }
            }else{
                b = startIndex + b - 1;
                c = startIndex + c - 1;
                while(b <= c){
                    if(b % 2 == 1) answer = answer * tree[b] % value;
                    if(c % 2== 0) answer = answer * tree[c] % value;
                    b = (b+1) / 2;
                    c = (c-1) / 2;
                }
                sb.append(answer).append("\n");
            }
        }
        System.out.println(sb);
    }
}
