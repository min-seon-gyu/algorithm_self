package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class 백준_1744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq1 = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();

        int count = 0;

        for(int i = 0 ; i < N ; i++){
            int value = Integer.parseInt(br.readLine());
            if(value > 0){
                pq1.offer(value);
            }else if(value < 0){
                pq2.offer(value);
            }else{
                count++;
            }

        }

        int answer = 0;

        while(pq1.size() > 1){
            Integer first = pq1.poll();
            Integer second = pq1.poll();

            answer += Math.max(first * second , first + second);
        }

        if(!pq1.isEmpty()){
            answer += pq1.poll();
        }

        while(pq2.size() > 1){
            Integer first = pq2.poll();
            Integer second = pq2.poll();

            answer += Math.max(first * second , first + second);
        }

        if(!pq2.isEmpty()){
            if(count == 0){
                answer += pq2.poll();
            }
        }
        System.out.println(answer);
    }
}
