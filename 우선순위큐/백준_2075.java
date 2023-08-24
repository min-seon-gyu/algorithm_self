package 우선순위큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 백준_2075 {

    public static void main(String[] args) throws IOException {

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < T ; j++)
            pq.offer(Integer.parseInt(st.nextToken()));
        }

        for(int i = 1; i < T ; i++){
            pq.poll();
        }

        System.out.println(pq.poll());
    }
}
