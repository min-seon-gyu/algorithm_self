package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_2531 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int[] check = new int[d+1];
        for(int i = 0 ; i < N ; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int start = 0;
        int end = 0;
        check[c] = 1;
        int max = 0;
        int answer = 1;

        while(start < N){
            if(end - start >= k){
                check[arr[start]]--;
                if(check[arr[start]] == 0){
                    answer--;
                }
                start++;
            }

            int endData = end % N;

            check[arr[endData]]++;
            if(check[arr[endData]] == 1){
                answer++;
            }
            end++;

            if(end - start == k){
                max = Math.max(max ,answer);
            }

            if(answer == d){
                System.out.println(d);
                return;
            }
        }
        System.out.println(max);
    }
}
