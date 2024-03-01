package 최소신장트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_17352 {
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        parents = new int[N+1];

        Arrays.fill(parents, -1);

        for(int i = 1 ; i <= N - 2 ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a,b);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1 ; i <= N ; i++){
            if(parents[i] < 0){
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb);
    }

    public static int parent(int value){
        if(parents[value] < 0){
            return value;
        }

        return parents[value] = parent(parents[value]);
    }

    public static boolean union(int a, int b){
        int aParent = parent(a);
        int bParent = parent(b);

        if(aParent == bParent) return false;

        if(parents[aParent] < parents[bParent]){
            parents[aParent] += parents[bParent];
            parents[bParent] = aParent;
        }else{
            parents[bParent] += parents[aParent];
            parents[aParent] = bParent;
        }

        return true;
    }
}
