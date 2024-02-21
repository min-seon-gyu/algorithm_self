package 세그먼트트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class 백준_1306 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int height = (int)Math.ceil(Math.log(N) / Math.log(2));
        int size = (int)Math.pow(2, height + 1);

        int[] tree = new int[size];
        int startIndex = (int)Math.pow(2, height);

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i< N ; i++){
            tree[startIndex + i] = Integer.parseInt(st.nextToken());
        }

        for(int i = startIndex - 1 ; i >= 1 ; i--){
            int first = tree[i * 2];
            int second = tree[i * 2 + 1];
            tree[i] = Math.max(first, second);
        }

        StringBuilder sb = new StringBuilder();


        int idx = M;
        while(idx <= N - M + 1){
            int s = idx - M + 1 + startIndex - 1;
            int e = idx + M - 1 + startIndex - 1;

            int answer = 0;
            while(s <= e){
                if(s % 2 == 1) answer = Math.max(tree[s], answer);
                if(e % 2 == 0) answer = Math.max(tree[e], answer);
                s = (s + 1) / 2;
                e = (e - 1) / 2;
            }

            sb.append(answer + " ");
            idx++;
        }
        System.out.println(sb);
    }
}
