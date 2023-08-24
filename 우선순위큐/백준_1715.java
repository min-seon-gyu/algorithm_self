package 우선순위큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 백준_1715 {

    public static void main(String[] args) throws IOException {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        LinkedHashMap<String, String> a = new LinkedHashMap<>();

        Iterator<String> iterator = a.keySet().iterator();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T ; i++){
            pq.offer(Integer.parseInt(br.readLine()));
        }

        int answer = 0;

        while(pq.size() > 1){
            int first = pq.poll();
            int second = pq.poll();
            int sum = first + second;
            answer += sum;
            pq.offer(sum);
        }

        System.out.println(answer);
    }
}
