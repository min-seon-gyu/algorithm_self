package 벨만포드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_11657 {
    public static class Bus{
        int e,t;

        public Bus(int e, int t) {
            this.e = e;
            this.t = t;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Bus>[] arr = new ArrayList[N+1];

        for(int i = 1 ; i < N+1; i++){
            arr[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            arr[s].add(new Bus(e,t));
        }

        long[] dist = new long[N+1];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[1] = 0;

        for(int i = 0 ; i <= N ; i++){
            for(int j = 1 ; j < N+1 ; j++){
                if(dist[j] == Long.MAX_VALUE) continue;
                for(Bus bus : arr[j]){
                    if(dist[bus.e] > dist[j] + bus.t){
                        if(i == N){
                            System.out.println(-1);
                            return;
                        }
                        dist[bus.e] = dist[j] + bus.t;
                    }
                }
            }
        }


        for(int i = 2 ; i < N+1 ; i++){
            if(dist[i] == Long.MAX_VALUE) System.out.println(-1);
            else System.out.println(dist[i]);
        }


    }
}
