package 최소신장트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 백준_16398 {

    public static class Node implements Comparable<Node>{
        int v1;
        int v2;
        int value;

        public Node(int v1, int v2, int value) {
            this.v1 = v1;
            this.v2 = v2;
            this.value = value;
        }
        @Override
        public int compareTo(Node n){
            return this.value - n.value;
        }
    }

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        parent = new int[N];

        PriorityQueue<Node> pq = new PriorityQueue<>();

        for(int i = 0; i < N ; i++){
            parent[i] = -1;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j< N ; j++){
                int value = Integer.parseInt(st.nextToken());
                if(i < j){
                    pq.offer(new Node(i, j, value));
                }
            }
        }

        int count = 0;
        long answer = 0;

        for(int i = 0 ; i < pq.size(); i++){
            if(count == N - 1) break;

            Node node = pq.poll();

            if(isSame(node.v1, node.v2)) continue;

            union(node.v1, node.v2);
            answer += node.value;
            count++;
        }
        System.out.println(answer);
    }

    public static boolean isSame(int v1, int v2){
        return find(v1) == find(v2);
    }
    public static int find(int v1){
        if(parent[v1] < 0){
            return v1;
        }

        return parent[v1] = find(parent[v1]);
    }

    public static void union(int v1, int v2){
        v1 = find(v1);
        v2 = find(v2);


        if(parent[v1] < parent[v2]){
            parent[v1] += parent[v2];
            parent[v2] = v1;
        }else{
            parent[v2] += parent[v1];
            parent[v1] = v2;
        }
    }
}