package 최소신장트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 백준_1197_크루스칼 {

    public static class Node{
        int v1;
        int v2;
        int value;

        public Node(int v1, int v2, int value) {
            this.v1 = v1;
            this.v2 = v2;
            this.value = value;
        }
    }

    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        parent = new int[V+1];
        PriorityQueue<Node> pq = new PriorityQueue<>((p1, p2) -> p1.value - p2.value);


        for(int i = 1 ; i <= V ; i++){
            parent[i] = -1;
        }

        for(int i = 0 ; i < E ; i++){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            pq.offer(new Node(v1,v2,value));
        }

        int count = 0;
        int answer = 0;

        while(true){

            if(count == V - 1){
                break;
            }

            Node node = pq.poll();

            if(isSame(node.v1, node.v2)) continue;

            union(node.v1, node.v2);
            count++;
            answer += node.value;


        }
        System.out.println(answer);

    }

    public static int find(int value){
        if(parent[value] < 0){
            return value;
        }

        return parent[value] = find(parent[value]);
    }

    public static void union(int a, int b){
        a = find(a);
        b= find(b);


        if(a < b){
            parent[a] += parent[b];
            parent[b] = a;
        }else{
            parent[b] += parent[a];
            parent[a] = b;
        }
    }

    public static boolean isSame(int a, int b){
        return find(a) == find(b);
    }
}
