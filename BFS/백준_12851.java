package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class 백준_12851 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Deque<Integer> dq = new ArrayDeque<>();
        dq.offer(N);
        int[] visited = new int[100001];
        Arrays.fill(visited, 200000);
        visited[N] = 0;
        int count = 0;

        while(!dq.isEmpty()){
            Integer loc = dq.poll();
            if(loc == K){
                count++;
            }

            if(loc + 1 < 100001){
                if(visited[loc + 1] >= visited[loc] + 1){
                    visited[loc + 1] = visited[loc] + 1;
                    dq.offerLast(loc + 1);
                }
            }

            if(loc - 1 > -1){
                if(visited[loc - 1] >= visited[loc] + 1){
                    visited[loc - 1] = visited[loc] + 1;
                    dq.offerLast(loc - 1);
                }
            }

            if(loc * 2 < 100001){
                if(visited[loc * 2] >= visited[loc] + 1) {
                    visited[loc * 2] = visited[loc] + 1;
                    dq.offerFirst(loc * 2);
                }
            }
        }
        System.out.println(visited[K]);
        System.out.println(count);
    }
}
