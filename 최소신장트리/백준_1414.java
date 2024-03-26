package 최소신장트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class 백준_1414 {
    static class Computer implements Comparable<Computer>{
        int idx1, idx2, len;

        public Computer(int idx1, int idx2, int len) {
            this.idx1 = idx1;
            this.idx2 = idx2;
            this.len = len;
        }

        @Override
        public int compareTo(Computer o) {
            return this.len - o.len;
        }
    }

    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        parents = new int[N+1];
        Arrays.fill(parents, -1);
        int total = 0;

        PriorityQueue<Computer> pq = new PriorityQueue<>();

        for(int i = 1 ; i <= N ; i++){
            String str = br.readLine();
            for(int j = 1 ; j <= N ; j++){
                if(str.charAt(j-1) == '0') continue;
                int score = score(str.charAt(j-1));
                pq.offer(new Computer(i, j, score));
                total += score;
            }
        }

        int count = 0;
        while(!pq.isEmpty()){
            Computer computer = pq.poll();
            if(union(computer.idx1, computer.idx2)){
                total -= computer.len;
                count++;
            }
        }
        if(count == N-1) System.out.println(total);
        else System.out.println(-1);
    }

    public static int parent(int x){
        if(parents[x] < 0) return x;
        return parents[x] = parent(parents[x]);
    }

    public static boolean union(int x, int y){
        int px = parent(x);
        int py = parent(y);

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

    public static int score(char c){
        if(Character.isUpperCase(c)){
            return c - 38;
        }else{
            return c - 96;
        }
    }
}
