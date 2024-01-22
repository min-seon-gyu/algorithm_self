package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 백준_1043 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 진실을 아는 사람 리스트
        Queue<Integer> q = new LinkedList<>();

        // 누가 어디파티에 참석하는지
        List<Integer>[] arr1 = new ArrayList[N+1];
        for(int i = 1 ; i <= N ; i++){
            arr1[i] = new ArrayList<>();
        }
        // 파티에 누가 참석하는지
        List<Integer>[] arr2 = new ArrayList[M+1];
        for(int i = 1 ; i <= M ; i++){
            arr2[i] = new ArrayList<>();
        }

        //사람체크용도 -> true인 인덱스는 진실을 아는 사람번호
        boolean[] visited = new boolean[N+1];
        //파티체크용도
        boolean[] check = new boolean[M+1];

        st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i < C ; i++){
            int idx = Integer.parseInt(st.nextToken());
            q.offer(idx);
            visited[idx] = true;
        }

        for(int i = 1 ; i <= M ; i++){
            st = new StringTokenizer(br.readLine());
            C = Integer.parseInt(st.nextToken());
            for(int j = 0 ; j < C ; j++){
                int idx = Integer.parseInt(st.nextToken());
                arr1[idx].add(i);
                arr2[i].add(idx);
            }
        }

        //q에는 진실을 아는 사람
        //arr1 ->  누가 어디파티에 참석하는지
        //arr2 ->  파티에 누가 참석하는지
        //50
        while(!q.isEmpty()){
            int poll = q.poll();
            //50
            for(int i = 0 ; i < arr1[poll].size() ; i++){
                int partyNumber = arr1[poll].get(i);
                check[partyNumber] = true;
                //50
                for(int j = 0 ; j < arr2[partyNumber].size() ; j++){
                    //50
                    int humanNumber = arr2[partyNumber].get(j);
                    if(!visited[humanNumber]){
                        visited[humanNumber] = true;
                        q.offer(humanNumber);
                    }
                }
            }
        }



        int answer = 0;
        for(int i = 1 ; i <= M ; i++){
            if(!check[i]) answer++;
        }
        System.out.println(answer);
    }
}
