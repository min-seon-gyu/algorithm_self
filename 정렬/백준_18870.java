package 정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 백준_18870 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr2 = new int[N];
        int[] arr = new int[N];
        List<Integer> answer = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N ; i++){
            int data = Integer.parseInt(st.nextToken());
            arr[i] = data;
            arr2[i] = data;
        }

        Arrays.sort(arr);

        int data = arr[0];
        answer.add(arr[0]);

        for(int i = 1; i < N ; i++){
            if(data == arr[i]) continue;

            answer.add(arr[i]);
            data = arr[i];
        }

        int[] result = answer.stream().mapToInt(i -> i).toArray();

        for(int data1 : arr2){
            int i = Arrays.binarySearch(result, data1);
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}
