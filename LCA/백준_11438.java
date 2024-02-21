package LCA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 백준_11438 {
    static int[] depth;
    static int[][] parent;
    static boolean[] root;
    static List<Integer>[] arr;
    static int N, H;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        H = (int) Math.ceil(Math.log(N)/Math.log(2)) + 1;
        arr = new ArrayList[N+1];
        depth = new int[N+1];
        root = new boolean[N+1];
        parent = new int[N+1][H];

        for(int j = 1;  j <= N ; j++) arr[j] = new ArrayList<>();

        for(int j = 0 ; j < N - 1 ; j++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[p].add(c);
            arr[c].add(p);
        }

        init(1,1,0);
        fillParent();

        int M = Integer.parseInt(br.readLine());
        for(int j = 0 ; j < M ; j++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            sb.append(LCA(first, second)).append("\n");
        }

        System.out.println(sb);
    }

    private static int LCA(int first, int second) {
        int firstDepth = depth[first];
        int secondDepth = depth[second];

        if(firstDepth < secondDepth){
            int temp = first;
            first = second;
            second = temp;
        }

        for (int i=H-1; i>=0; i--) {
            if(Math.pow(2, i) <= depth[first] - depth[second]){
                first = parent[first][i];
            }
        }

        if(first == second){
            return first;
        }

        for (int i=H-1; i>=0; i--) {
            if(parent[first][i] != parent[second][i]) {
                first = parent[first][i];
                second = parent[second][i];
            }
        }

        return parent[first][0];
    }

    private static void fillParent() {
        for(int i = 1 ; i < H ; i++){
            for(int j = 1 ; j <= N ; j++){
                parent[j][i] = parent[parent[j][i-1]][i-1];
            }
        }
    }

    private static void init(int cur, int h, int p) {
        depth[cur] = h;
        for(int next : arr[cur]){
            if(next != p){
                init(next, h+1, cur);
                parent[next][0] = cur;
            }
        }
    }
}
