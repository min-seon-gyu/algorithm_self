package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 백준_20207 {
    static class Schedule implements Comparable<Schedule>{
        int s, e;

        public Schedule(int s, int e) {
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(Schedule o) {
            if(this.s == o.s){
                int a = this.e - this.s;
                int b = o.e - o.s;
                return b - a;
            }
            return this.s - o.s;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Schedule> pq = new PriorityQueue<>();
        int N = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            pq.offer(new Schedule(S,E));
        }


        int[] days = new int[367];
        while(!pq.isEmpty()){
            Schedule schedule = pq.poll();
            int start = schedule.s;
            int end = schedule.e;
            for(int i = start ; i <= end ; i++){
                days[i]++;
            }
        }

        int start = 0;
        int height = 1;
        int answer = 0;
        for(int i = 1 ; i <= 366 ; i++){
            if(start == 0 && days[i] > 0){
                start = i;
            }

            if(start != 0 && days[i] == 0){
                answer += (i - start) * height;

                start = 0;
                height = 1;
            }

            if(start != 0){
                height = Math.max(height, days[i]);
            }
        }
        System.out.println(answer);
    }
}
