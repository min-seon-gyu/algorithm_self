package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_2467 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0 ; i < N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int startIndex = 0;
        int endIndex = N - 1;
        int answer1 = 0;
        int answer2 = 0;
        int min = Integer.MAX_VALUE;

        while(startIndex < endIndex){

            int v1 = arr[startIndex];
            int v2 = arr[endIndex];

            int abs = Math.abs(v1+v2);
            if(abs < min){
                min = abs;
                answer1 = v1;
                answer2 = v2;
            }

            if(v1 + v2 > 0){
                endIndex--;
            }else {
                startIndex++;
            }

        }
        System.out.println(answer1 + " " + answer2);
    }
}
