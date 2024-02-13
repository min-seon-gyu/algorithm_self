package 최소신장트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 백준_13418 {
    static class Node{
        int x,y,z;

        public Node(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
    static int[] parent;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        //오름차순
        PriorityQueue<Node> pq1 = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node n1, Node n2){
                return n1.z - n2.z;
            }
        });

        //내림차순
        PriorityQueue<Node> pq2 = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node n1, Node n2){
                return n2.z - n1.z;
            }
        });


        for(int i = 0; i <= M ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            pq1.offer(new Node(a,b,c));
            pq2.offer(new Node(a,b,c));
        }

        int answer1 = solve(pq1);
        int answer2 = solve(pq2);

        System.out.println(Math.abs(answer2 - answer1));
    }

    private static int solve(PriorityQueue<Node> pq) {
        parent = new int[N+1];
        int count = 0;
        Arrays.fill(parent, -1);

        while(!pq.isEmpty()){
            Node node = pq.poll();
            if(union(node.x, node.y)){
                if(node.z == 0) count++;
            }
        }
        return (int)Math.pow(count, 2);
    }

    public static int find(int v){
        if(parent[v] < 0){
            return v;
        }
        return parent[v] = find(parent[v]);
    }

    public static boolean union(int x, int y){
        int px = find(x);
        int py = find(y);

        if(px == py){
            return false;
        }

        if(parent[px] < parent[py]){
            parent[px] += parent[py];
            parent[py] = px;
        }else{
            parent[py] += parent[px];
            parent[px] = py;
        }

        return true;
    }
}
