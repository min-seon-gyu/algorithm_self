package 위상정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 백준_2056 {
    public static class Work implements Comparable<Work>{
        int next, time;

        public Work(int next, int time) {
            this.next = next;
            this.time = time;
        }

        @Override
        public int compareTo(Work o) {
            return this.time - o.time;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());


        int[] counts = new int[N+1];
        int[] times = new int[N+1];

        List<Integer>[] lst = new ArrayList[N+1];

        for(int i = 1 ; i <= N ; i++){
            lst[i] = new ArrayList<>();
        }

        for(int i = 1 ; i <= N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            times[i] = Integer.parseInt(st.nextToken());

            int count = Integer.parseInt(st.nextToken());

            while(count-- > 0){
                int work = Integer.parseInt(st.nextToken());
                lst[work].add(i);
                counts[i]++;
            }
        }

        int answer = 0;
        PriorityQueue<Work> q = new PriorityQueue<>();

        for(int i = 1 ; i <= N ; i++){
            if(counts[i] == 0){
                q.offer(new Work(i, times[i]));
            }
        }


        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0 ; i < size ; i++){
                Work work = q.poll();
                answer = Math.max(answer, work.time);
                for(int next : lst[work.next]){
                    counts[next]--;
                    if(counts[next] == 0){
                        q.offer(new Work(next, work.time + times[next]));
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
