package 자료구조;

import java.io.*;
import java.util.*;
import java.util.LinkedList;

public class 백준_11003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        Deque<Integer> pq = new ArrayDeque<>();
        int[] arr= new int[N+1];
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int idx = 1;
        st = new StringTokenizer(br.readLine());
        while(idx <= N){
            arr[idx] = Integer.parseInt(st.nextToken());


            while(!pq.isEmpty() && arr[pq.peekLast()] >= arr[idx]){
                pq.pollLast();
            }

            pq.offer(idx);
            int start = idx - L + 1 <= 0 ? 0 : idx - L + 1;

            while(pq.peek() < start){
                pq.pollFirst();
            }

            bw.write(arr[pq.peek()] + " ");
            idx++;
        }
        bw.flush();
        bw.close();
    }
}
