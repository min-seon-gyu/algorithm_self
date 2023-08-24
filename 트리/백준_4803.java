package 트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_4803 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int idx = 1;

        while(true){


            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            boolean[] visit = new boolean[n+1];
            int[] p = new int[n+1];
            ArrayList<Integer>[] arr = new ArrayList[n+1];

            for(int i = 1 ; i <= n ; i++ ){
                arr[i] = new ArrayList<>();
            }

            if(n == 0 & m == 0) break;

            for(int i = 0; i < m ; i++){
                st = new StringTokenizer(br.readLine());
                int V1 = Integer.parseInt(st.nextToken());
                int V2 = Integer.parseInt(st.nextToken());

                arr[V1].add(V2);
                arr[V2].add(V1);
            }

            int count = 0;
            for(int i = 1 ; i<= n ; i++) {
                if (!visit[i]) {
                    count++;
                    visit[i] = true;
                    Queue<Integer> q = new LinkedList<>();
                    q.offer(i);

                    while (!q.isEmpty()) {
                        Integer poll = q.poll();
                        for (int value : arr[poll]) {
                            if(p[poll] == value) continue;

                            if (!visit[value]) {
                                visit[value] = true;
                                p[value] = poll;
                                q.offer(value);
                            }else{
                                q.clear();
                                count--;
                                break;
                            }
                        }
                    }
                }
            }

            if(count <= 0){
                sb.append("Case " + idx + ": No trees.").append("\n");
            }else if(count == 1){
                sb.append("Case " + idx +": There is one tree.").append("\n");
            }else{
                sb.append("Case "+ idx + ": A forest of " + count + " trees.").append("\n");
            }
            idx++;
        }

        System.out.println(sb);
    }
}
