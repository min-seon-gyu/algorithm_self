package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 백준_2251 {
    static boolean[][][] visited;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static int A;
    static int B;
    static int C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        visited = new boolean[A+1][B+1][C+1];
        solve(0,0, C);

        while(!pq.isEmpty()){
            sb.append(pq.poll() + " ");
        }
        System.out.println(sb);
    }

    private static void solve(int a, int b, int c) {
        if (visited[a][b][c]) {
            return;
        }

        if (a == 0) {
            pq.offer(c);
        }

        visited[a][b][c] = true;

        if(a > 0){
            //A -> B
            solve(Math.max(a-(B-b), 0), Math.min(a+b,B), c);
            //A -> C
            solve(Math.max(a-(C-c), 0), b, Math.min(a+c,C));
        }

        if(b > 0){
            //B -> A
            solve(Math.min(a+b, A), Math.max(b-(A-a), 0), c);
            //B -> C
            solve(a, Math.max(b-(C-c), 0), Math.min(b+c, C));
        }

        if(c > 0){
            //C -> A
            solve(Math.min(a+c, A), b, Math.max(c-(A-a), 0));
            //C -> B
            solve(a, Math.min(b+c, B), Math.max(c-(B-b), 0));
        }
    }
}
