package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 백준_1644 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if(N == 1){
            System.out.println(0);
            return;
        }

        boolean[] check = new boolean[N+1];
        Arrays.fill(check, true);
        List<Integer> lst = new ArrayList<>();

        for(int i = 2 ; i * i <= N ; i++ ){
            if(!check[i]) continue;
            for(int j = i * i ; j <= N ; j += i){
                check[j] = false;
            }
        }

        for(int i = 2 ; i<check.length ; i++){
            if(check[i]) lst.add(i);
        }

        int[] arr = lst.stream().mapToInt(i->i).toArray();

        int s = 0;
        int e = 0;
        int cnt = 0;
        int sum = 0;

        while(s <= arr.length && e <= arr.length){

            if(sum > N){
                if(s == arr.length) break;
                sum -= arr[s];
                s++;
            }else {
                if(e == arr.length) break;
                sum += arr[e];
                e++;
            }
            if(sum == N){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
