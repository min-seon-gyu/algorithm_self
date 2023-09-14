package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 백준_2473 {
    public static class Value{
        int v1,v2;

        public Value(int v1, int v2) {
            this.v1 = v1;
            this.v2 = v2;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<Integer, Value> map = new HashMap<>();

        long[] arr = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++){
            arr[i] = Long.parseLong(st.nextToken());
        }


        Arrays.sort(arr);

        long answer1 = 0;
        long answer2 = 0;
        long answer3 = 0;
        long min = Long.MAX_VALUE;

        for(int i = 0 ; i < N ; i++){
            int startIndex = i + 1;
            int endIndex = N - 1;

            while(startIndex < endIndex){
                long abs = Math.abs(arr[i] + arr[startIndex] + arr[endIndex]);
                if(abs < min){
                    min = abs;
                    answer1 = arr[i];
                    answer2 = arr[startIndex];
                    answer3 = arr[endIndex];
                }

                if(arr[i] + arr[startIndex] + arr[endIndex] > 0){
                    endIndex--;
                }else {
                    startIndex++;
                }
            }
        }





        System.out.println(answer1 + " " + answer2 + " " + answer3);
    }
}
