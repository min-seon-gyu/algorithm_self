package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_2660 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] arr = new ArrayList[V+1];

        for (int i = 1 ; i <= V ; i++){
            arr[i] = new ArrayList<>();
        }

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V1 = Integer.parseInt(st.nextToken());
            int V2 = Integer.parseInt(st.nextToken());

            if(V1 == -1 && V2 == -1){
                break;
            }

            arr[V1].add(V2);
            arr[V2].add(V1);
        }

        int[] score = new int[V+1];

        Queue<Integer> q = new LinkedList<>();

        for(int i = 1 ; i <= V ; i++){
            int[] visit = new int[V+1];
            visit[i] = 0;
            q.offer(i);

            while(!q.isEmpty()){
                Integer poll = q.poll();

                for(int value : arr[poll]){
                    if(visit[value] == 0 && value != i){
                        visit[value] = visit[poll] + 1;
                        q.offer(value);
                    }
                }
            }

            int max = 0;
            for(int value : visit){
                max = Math.max(max, value);
            }
            score[i] = max;
        }

        int min = score[1];
        int count = 1;
        ArrayList<Integer> number = new ArrayList<>();

        for(int i = 1 ; i <= V ; i++){
            if(min > score[i]){
                min = score[i];
                count = 1;
                number.clear();
                number.add(i);
            }else if(min == score[i]){
                count++;
                number.add(i);
            }
        }
        System.out.println(min + " " + count);
        for(int value : number){
            System.out.print(value + " ");
        }
    }
}
