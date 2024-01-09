
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 백준_1774 {
    static class Node implements Comparable<Node>{
        int x,y;
        double d;

        public Node(int x, int y, double w) {
            this.x = x;
            this.y = y;
            this.d = w;
        }

        @Override
        public int compareTo(Node n){
            if(this.d > n.d){
                return 1;
            }else{
                return -1;
            }
        }
    }

    static int[] parent;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N+1][2];
        parent = new int[N+1];

        for(int i = 1 ; i <= N ; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            parent[i] = -1;
        }

        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            union(x,y);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();

        for(int i = 1 ; i <= N ; i++){
            for(int j = i + 1 ; j <= N ; j++){
                int x1 = arr[i][0];
                int y1 = arr[i][1];
                int x2 = arr[j][0];
                int y2 = arr[j][1];

                pq.offer(new Node(i, j, dist(x1,y1,x2,y2)));
            }
        }

        double answer = 0;
        while(!pq.isEmpty()){
            Node node = pq.poll();
            if(union(node.x, node.y)){
                answer += node.d;
            }
        }
        System.out.println(String.format("%.2f", answer));
    }

    public static int find(int v){
        if(parent[v] < 0){
            return v;
        }

        return parent[v] = find(parent[v]);
    }

    public static boolean union(int x, int y){
        int parentX = find(x);
        int parentY = find(y);

        if(parentX == parentY){
            return false;
        }

        if(parent[parentX] < parent[parentY]){
            parent[parentX] += parent[parentY];
            parent[parentY] = parentX;
        }else{
            parent[parentY] += parent[parentX];
            parent[parentX] = parentY;
        }
        return true;
    }

    public static double dist(int x1, int y1, int x2, int y2){
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }
}
