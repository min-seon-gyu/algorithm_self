package 다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 백준_21278 {
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

        ArrayList<Integer>[] arr = new ArrayList[N+1];

        for(int i = 1 ; i <= N ; i++){
            arr[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a].add(b);
            arr[b].add(a);
        }

        int[][] dijkstra = new int[N+1][N+1];

        for(int i = 1 ; i <= N ; i++){
            Arrays.fill(dijkstra[i], Integer.MAX_VALUE);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();

        for(int i = 1 ; i <= N ; i++){
            dijkstra[i][i] = 0;
            pq.offer(new Node(i, 0));

            while(!pq.isEmpty()){
                Node node = pq.poll();
                if(node.cost != dijkstra[i][node.idx]) continue;
                for(int next : arr[node.idx]){
                    if(dijkstra[i][next] > node.cost + 2){
                        pq.offer(new Node(next, node.cost + 2));
                        dijkstra[i][next] = node.cost + 2;
                    }
                }
            }
        }


        /*
        조합 두개 뽑기

         */

        //100 * 99 / 2 * 100 * 4950 = 24,502,500
        for(int i = 1 ; i <= N ; i++){
            for(int j = i+1 ; j <= N ; j++){
                //코드~ dfs
                //N = 100
                //M = 100*99/2

            }
        }

        int first = 0;
        int second = 0;
        int answer = Integer.MAX_VALUE;

        for(int i = 1 ; i <= N ; i++){
            for(int j = i+1 ; j <= N ; j++){
                int sum = 0;
                for(int k = 1 ; k <= N ; k++){
                    sum += Math.min(dijkstra[i][k],dijkstra[j][k]);
                }
                if(sum < answer){
                    answer = sum;
                    first = i;
                    second = j;
                }
            }
        }
        System.out.println(first + " " + second + " " + answer);
    }
}
