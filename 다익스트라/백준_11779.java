package 다익스트라;

import java.io.*;
import java.util.*;

public class 백준_11779 {

    public static class Node{
        int idx, cost;

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        ArrayList<Node>[] lst = new ArrayList[n+1];

        for(int i = 1 ; i <= n ; i++){
            lst[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for(int i = 0; i < m ; i++){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            lst[v1].add(new Node(v2, cost));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int[] answer = new int[n+1];
        int[] pre = new int[n+1];
        Arrays.fill(answer, Integer.MAX_VALUE);
        answer[start] = 0;

        PriorityQueue<Node> q = new PriorityQueue<>(new Comparator<Node>(){
            @Override
            public int compare(Node n1, Node n2){
                return n1.cost - n2.cost;
            }
        });
        q.offer(new Node(start , 0));

        while(!q.isEmpty()){
            Node cur = q.poll();
            int cost = cur.cost;
            int idx = cur.idx;

            if(cost == answer[idx]) {
                for (Node next : lst[idx]) {
                    if(answer[next.idx] > next.cost + answer[idx]){
                        pre[next.idx] = idx;
                        answer[next.idx] = next.cost + answer[idx];
                        q.offer(new Node(next.idx, answer[next.idx]));
                    }
                }
            }
        }



        ArrayList<Integer> list = new ArrayList<>();
        int idx = end;
        list.add(idx);
        int count = 1;

        while(true){
            count++;
            idx = pre[idx];
            list.add(idx);
            if(idx == start) break;
        }
        bw.write(answer[end]+"\n");
        bw.write(count+"\n");

        for(int i = list.size()-1 ; i >= 0 ; i--){
            bw.write(list.get(i) + " ");
        }
        bw.flush();
        bw.close();
    }
}
