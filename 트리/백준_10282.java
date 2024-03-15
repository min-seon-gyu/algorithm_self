package 트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 백준_10282 {
    static class Computer implements Comparable<Computer>{
        int number, time;

        public Computer(int number, int time) {
            this.number = number;
            this.time = time;
        }

        @Override
        public int compareTo(Computer o) {
            return this.time - o.time;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < T ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            ArrayList<Computer>[] arr = new ArrayList[n+1];
            for(int j = 1; j <= n ; j++){
                arr[j] = new ArrayList<>();
            }

            for(int j = 0 ; j < d ; j++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());

                arr[b].add(new Computer(a,s));
            }

            boolean[] visited = new boolean[n+1];
            visited[c] = true;
            PriorityQueue<Computer> q = new PriorityQueue<>();
            q.offer(new Computer(c, 0));
            int count = 0;
            int time = 0;

            while(!q.isEmpty()){
                Computer computer = q.poll();
                if(visited[computer.number]) continue;
                count++;
                visited[computer.number] = true;
                time = Math.max(time, computer.time);
                for(Computer next : arr[computer.number]){
                    q.offer(new Computer(next.number, computer.time + next.time));
                }
            }
            sb.append(count).append(" ").append(time).append("\n");
        }
        System.out.println(sb);
    }
}
