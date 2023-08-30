package 다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 백준_1504 {
    public static class Node implements Comparable<Node>{
        int idx, cost;

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int INF = Integer.MAX_VALUE;

        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int[][] answer = new int[N+1][N+1];
        ArrayList<Node>[] lst = new ArrayList[N+1];

        for(int i = 1 ; i <= N ; i++){
            Arrays.fill(answer[i], INF);
            lst[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < E ; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            lst[s].add(new Node(e, c));
            lst[e].add(new Node(s, c));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(v1);
        list.add(v2);
        list.add(N);

        for(int i = 0 ; i <list.size() ; i++){
            int idx = list.get(i);
            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.offer(new Node(idx, 0));
            answer[idx][idx] = 0;

            while(!pq.isEmpty()){
                Node cur = pq.poll();

                if(cur.cost != answer[idx][cur.idx]) continue;

                for(Node next : lst[cur.idx]){
                    if(answer[idx][next.idx] > answer[idx][cur.idx] + next.cost){
                        answer[idx][next.idx] = answer[idx][cur.idx] + next.cost;
                        pq.offer(new Node(next.idx, answer[idx][next.idx]));
                    }
                }
            }
        }

        long sum1 = (long)answer[1][v1] + (long)answer[v1][v2] + (long)answer[v2][N];
        long sum2 = (long)answer[1][v2] + (long)answer[v2][v1] + (long)answer[v1][N];

        if(sum1 >= INF && sum2 >= INF){
            System.out.println(-1);
        }else{
            System.out.println(Math.min(sum1, sum2));
        }
    }
}
