package 최소신장트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 백준_14621 {
    static class Univ implements Comparable<Univ>{
        int u,v,d;
        public Univ(int u, int v, int d) {
            this.u = u;
            this.v = v;
            this.d = d;
        }

        @Override
        public int compareTo(Univ o) {
            return this.d - o.d;
        }
    }
    static int[] parents;
    static String[] types;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        PriorityQueue<Univ> pq = new PriorityQueue<>();
        parents = new int[N+1];
        types = new String[N+1];

        st = new StringTokenizer(br.readLine());

        for(int i = 1 ; i <= N ; i++){
            types[i] = st.nextToken();
            parents[i] = -1;
        }

        for(int i = 1 ; i <= M ; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            pq.offer(new Univ(u,v,d));
        }

        while(!pq.isEmpty()){
            Univ univ = pq.poll();
            if(types[univ.u].equals(types[univ.v])) continue;
            if(union(univ.v, univ.u)) answer += univ.d;
        }

        int parentCount = 0;
        for(int i = 1 ; i <= N ; i++){
            if(parents[i] < 0) parentCount++;
        }

        if(parentCount > 1) System.out.println(-1);
        else System.out.println(answer);
    }

    static int find(int x){
        if(parents[x] < 0){
            return x;
        }

        return parents[x] = find(parents[x]);
    }

    static boolean union(int x, int y){
        int px = find(x);
        int py = find(y);

        if(px == py) return false;

        if(parents[px] < parents[py]){
            parents[px] += parents[py];
            parents[py] = px;
        }else{
            parents[py] += parents[px];
            parents[px] = py;
        }

        return true;
    }
}
