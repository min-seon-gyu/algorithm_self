package 자료구조;

import java.io.*;
import java.util.*;
import java.util.LinkedList;

public class 백준_2346 {
    public static class Node{
        int idx, value;

        public Node(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Deque<Node> dq = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 1 ; i <= N ; i++){
            int value = Integer.parseInt(st.nextToken());
            dq.offer(new Node(i, value));
        }

        while(dq.size() > 1){
            Node node = dq.poll();
            int idx = node.idx;
            int value = node.value;

            if(value > 0 ){
                value--;
                for(int i = 0 ; i < value ; i++){
                    dq.offer(dq.poll());
                }
            }else{
                value = Math.abs(value);
                for(int i = 0 ; i < value ; i++){
                    dq.offerFirst(dq.pollLast());
                }
            }
            sb.append(idx + " ");
        }
        sb.append(dq.poll().idx);
        System.out.println(sb);
    }

}
