package 트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_11725 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] answer = new int[N+1];
        ArrayList<Integer>[] arr = new ArrayList[N+1];

        for(int i = 1 ; i <= N ; i++){
            arr[i] = new ArrayList<>();
        }

        for(int i = 0; i < N - 1 ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V1 = Integer.parseInt(st.nextToken());
            int V2 = Integer.parseInt(st.nextToken());

            arr[V1].add(V2);
            arr[V2].add(V1);
        }


        Queue<Integer> q = new LinkedList<>();
        q.offer(1);

        while(!q.isEmpty()){
            int poll = q.poll();

            for(int value : arr[poll]){
                if(answer[poll] != value){
                    answer[value] = poll;
                    q.offer(value);
                }
            }
        }

        for(int i = 2; i <= N ; i++){
            System.out.println(answer[i]);
        }
    }
}
