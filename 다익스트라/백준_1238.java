package 다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 백준_1238 {
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

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[][] answer = new int[N+1][N+1];
        ArrayList<Node>[] lst = new ArrayList[N+1];

        for(int i = 1 ; i <= N ; i++){
            Arrays.fill(answer[i], Integer.MAX_VALUE);
            lst[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            lst[s].add(new Node(e, c));
        }

        for(int i = 1 ; i <= N ; i++) {
            PriorityQueue<Node> pq = new PriorityQueue<>();
            answer[i][i] = 0;
            pq.offer(new Node(i, 0));
            while (!pq.isEmpty()) {
                Node cur = pq.poll();
                if (answer[i][cur.idx] != cur.cost) continue;
                for (Node next : lst[cur.idx]) {
                    if (answer[i][next.idx] > answer[i][cur.idx] + next.cost) {
                        answer[i][next.idx] = answer[i][cur.idx] + next.cost;
                        pq.offer(new Node(next.idx, answer[i][next.idx]));
                    }
                }
            }
        }

        int max = 0;
        for(int i = 1; i <= N ;i++){
            int sum = answer[i][X] + answer[X][i];
            max = Math.max(max, sum);
        }
        System.out.println(max);
    }
}
