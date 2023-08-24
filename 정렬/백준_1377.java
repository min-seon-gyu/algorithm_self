package 정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 백준_1377 {
    public static void start() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());

        Node[] arr = new Node[N];

        for(int i = 0; i < N ; i++){
            arr[i] = new Node(Integer.valueOf(br.readLine()), i);
        }

        int max = 0;
        Arrays.sort(arr);

        for(int i = 0; i < N ; i++){
            int value = arr[i].index - i;
            if(max < value){
                max = value;
            }
        }

        System.out.println(max+1);

    }
    public static class Node implements Comparable<Node>{
        public int value;
        public int index;

        public Node(int value, int index){
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo(Node o) {

            if(this.value - o.value > 0){
                return 1;
            }
            else if(this.value - o.value == 0){
                return 0;
            }
            else{
                return -1;
            }
        }
    }

}



