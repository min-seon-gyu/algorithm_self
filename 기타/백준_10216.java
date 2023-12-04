package 기타;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_10216 {
    public static class Base{
        int x,y,r;

        public Base(int x, int y, int r) {
            this.x = x;
            this.y = y;
            this.r = r;
        }
    }
    static int[] parent;
    static Base[] base;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());


        for(int i = 0 ; i < T ; i++){
            int N = Integer.parseInt(br.readLine());
            int count = 0;

            base = new Base[N+1];
            parent = new int[N+1];
            Arrays.fill(parent, -1);

            for(int j = 1 ; j <= N ; j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                base[j] = new Base(x,y,r);
            }

            for(int j = 1 ; j <= N ; j++){
                for(int k = j+1 ; k <= N ; k++){
                    if(j == k) continue;
                    if ((base[j].x - base[k].x) * (base[j].x - base[k].x)
                            + (base[j].y - base[k].y) * (base[j].y - base[k].y) <= (base[j].r + base[k].r) * (base[j].r + base[k].r)) {
                        union(j, k);
                    }
                }
            }
            for(int j = 1 ; j <= N ; j++){
                if(parent[j] < 0){
                    count++;
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }

    public static boolean union(int v1, int v2){
        v1 = find(v1);
        v2 = find(v2);

        if(v1 == v2) return false;

        if(parent[v1] < parent[v2]){
            parent[v1] += parent[v2];
            parent[v2] = v1;
        }else{
            parent[v2] += parent[v1];
            parent[v1] = v2;
        }

        return true;
    }

    public static int find(int v){
        if(parent[v] < 0){
            return v;
        }

        return parent[v] = find(parent[v]);
    }
}
