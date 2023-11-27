package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 백준_1911 {
    public static class Water implements Comparable<Water>{
        int s,e;

        public Water(int s, int e) {
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(Water o) {
            return this.s - o.s;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        PriorityQueue<Water> pq = new PriorityQueue<>();

        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            pq.offer(new Water(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        int answer = 0;
        int max = -1;

        while(!pq.isEmpty()){
            Water poll = pq.poll();
            for(int i = poll.s ; i < poll.e ; i++){
                if(i > max){
                    answer++;
                    i += (L-1);
                    max = i;
                }
            }
        }
        System.out.println(answer);
    }
}
