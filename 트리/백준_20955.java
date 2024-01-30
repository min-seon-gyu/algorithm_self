package 트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 백준_20955 {
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parents = new int[N+1];
        Arrays.fill(parents, -1);

        int count = 0;
        while(M-- > 0){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if(!union(x, y)) count++;

        }

        HashSet<Integer> hs = new HashSet<>();

        for(int i = 1 ; i <= N ; i++){
            int parent = parent(i);
            if(hs.contains(parent)) continue;

            hs.add(parent);
        }

        System.out.println(count += hs.size() - 1);;
    }
    public static int parent(int number){
        if(parents[number] < 0){
            return number;
        }
        return parents[number] = parent(parents[number]);
    }

    public static boolean union(int num1, int num2){
        int p1 = parent(num1);
        int p2 = parent(num2);

        if(p1 == p2) return false;

        if(p1 < p2){
            parents[p1] += parents[p2];
            parents[p2] = p1;
        }else{
            parents[p2] += parents[p1];
            parents[p1] = p2;
        }

        return true;
    }
}
