package 세그먼트트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_2042 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int height = (int)Math.ceil(Math.log(N) / Math.log(2));
        int size = (int)Math.pow(2, height + 1);

        long[] tree = new long[size];
        int startIndex = (int)Math.pow(2, height);

        for(int i = 0 ; i < N ; i++){
            tree[startIndex + i] = Long.parseLong(br.readLine());
        }

        for(int i = startIndex - 1 ; i>= 1 ; i--){
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
        }

        for(int i = 0 ; i < M + K ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            long answer = 0;

            if(a == 1){
                b = startIndex + b - 1;

                long value = c - tree[b];
                tree[b] = c;
                while(b > 0){
                    b = b / 2;
                    tree[b] += value;
                }
            }else{

                b = startIndex + b - 1;
                c = startIndex + c - 1;

                while(b<=c){
                    if(b % 2 == 1) answer += tree[b];
                    if(c % 2 == 0) answer += tree[(int)c];
                    b = (b + 1) / 2;
                    c = (c - 1) / 2;
                }
                sb.append(answer).append("\n");
            }
        }
        System.out.println(sb);
    }
}
