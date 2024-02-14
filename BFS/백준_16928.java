package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 사다리 3 - 50  45 - 99
// 뱀 51 - 45
public class 백준_16928 {
    public static class Loc implements Comparable<Loc>{
        int x,c;

        public Loc(int x, int c) {
            this.x = x;
            this.c = c;
        }

        @Override
        public int compareTo(Loc o) {
            return this.c - o.c;
        }
    }
    static int max = 0;
    static int bit = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] map = new int[101];
        boolean[] visited = new boolean[101];


        for(int i = 0 ; i < N + M ; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map[x] = y;
        }

        PriorityQueue<Loc> pq = new PriorityQueue<>();
        pq.offer(new Loc(1, 0));

        while(!pq.isEmpty()){
            Loc loc = pq.poll();

            if(loc.x == 100){
                System.out.println(loc.c);
                return;
            }

            if(map[loc.x] == 0){
                for(int i = 1 ; i <= 6 ; i++){
                    int next = loc.x + i;
                    if(next > 100) continue;
                    if(!visited[next]){
                        visited[next] = true;
                        pq.offer(new Loc(next, loc.c+1));
                    }
                }
            }else{
                visited[map[loc.x]] = true;
                pq.offer(new Loc(map[loc.x], loc.c));
            }
        }
    }
}
