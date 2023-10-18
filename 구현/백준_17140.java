package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 백준_17140 {

    public static class Number implements Comparable<Number>{
        int value, count;

        public Number(int value, int count) {
            this.value = value;
            this.count = count;
        }

        @Override
        public int compareTo(Number o) {
            if(this.count == o.count){
                return this.value - o.value;
            }
            return this.count - o.count;
        }
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] arr = new int[100][100];

        for(int i = 0 ; i < 3 ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < 3 ; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        int rLength = 3;
        int cLength = 3;
        while(answer < 101){
            if(arr[r-1][c-1] == k){
                System.out.println(answer);
                return;
            }

            if(rLength >= cLength){
                cLength = 0;
                for(int i = 0 ; i < rLength ; i++){
                    PriorityQueue<Number> pq = new PriorityQueue();
                    int[] check = new int[101];
                    for(int j = 0; j < arr[i].length ; j++){
                        if(arr[i][j] != 0) check[arr[i][j]]++;
                    }

                    for(int j = 1; j < 101 ; j++){
                        if(check[j] != 0) pq.offer(new Number(j, check[j]));
                    }

                    int index = 0;
                    while(!pq.isEmpty()){
                        Number poll = pq.poll();
                        arr[i][index] = poll.value;
                        arr[i][index + 1] = poll.count;
                        index += 2;
                    }
                    for(int j = index ; j < 100 ; j++){
                        arr[i][j] = 0;
                    }
                    cLength = Math.max(index, cLength);
                }
            }else{
                rLength = 0;
                for(int i = 0 ; i < cLength ; i++){
                    PriorityQueue<Number> pq = new PriorityQueue();
                    int[] check = new int[101];
                    for(int j = 0; j < arr.length ; j++){
                        if(arr[j][i] != 0) check[arr[j][i]]++;
                    }

                    for(int j = 1; j < 101 ; j++){
                        if(check[j] != 0) pq.offer(new Number(j, check[j]));
                    }

                    int index = 0;
                    while(!pq.isEmpty()){
                        Number poll = pq.poll();
                        arr[index][i] = poll.value;
                        arr[index+1][i] = poll.count;
                        index += 2;
                    }
                    for(int j = index ; j < 100 ; j++){
                        arr[j][i] = 0;
                    }
                    rLength = Math.max(index, rLength);
                }
            }
            answer++;
        }
        System.out.println(-1);
    }
}
