package 최소신장트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 백준_21924 {

    static class Load implements Comparable<Load>{
        int x,y;
        long c;

        public Load(int x, int y, long c) {
            this.x = x;
            this.y = y;
            this.c = c;
        }

        @Override
        public int compareTo(Load o) {
            if(this.c - o.c > 0){
                return 1;
            }else if(this.c - o.c < 0){
                return -1;
            }else{
                return 0;
            }
        }
    }
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long total = 0;
        long answer = 0;
        // 3 <= N <= 100,000
        int N = Integer.parseInt(st.nextToken());
        // 2 <= N <= 500,000
        int M = Integer.parseInt(st.nextToken());

        parents = new int[N+1];
        Arrays.fill(parents, -1);
        PriorityQueue<Load> pq = new PriorityQueue<>();

        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            pq.offer(new Load(a,b,c));
            total += c;
        }



        while(!pq.isEmpty()){
            Load load = pq.poll();
            if(union(load.x, load.y)){
                answer += load.c;
            }
        }


        int count = 0;
        for(int i = 2 ; i <= N ; i++){
            if(parents[i] < 0){
                count++;
            }
        }

        if(count >= 2){
            System.out.println(-1);
        }else{
            System.out.println(total - answer);
        }
    }

    public static int find(int value){
        if(parents[value] < 0){
            return value;
        }
        return parents[value] = find(parents[value]);
    }

    public static boolean union(int x, int y){
        int px = find(x);
        int py = find(y);

        if(px == py){
            return false;
        }

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
