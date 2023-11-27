package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 백준_1963 {
    public static class Number{
        int value, cnt;

        public Number(int value, int cnt) {
            this.value = value;
            this.cnt = cnt;
        }
    }
    static List<Integer> lst = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        boolean[] checked = new boolean[10000];
        for(int i = 2 ; i * i < 10000 ; i++){
            if(!checked[i]){
                for(int j = i * i ; j < 10000 ; j = j + i){
                    checked[j] = true;
                }
            }
        }

        for(int i = 1000 ; i < 10000 ; i++){
            if(!checked[i]) lst.add(i);
        }

        for(int i = 0 ; i < N ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            boolean[] visited = new boolean[lst.size()];

            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            Queue<Number> q = new LinkedList<>();
            q.offer(new Number(num1, 0));
            visited[lst.indexOf(num1)] = true;
            int answer = -1;

            while (!q.isEmpty()) {
                Number number = q.poll();
                if(number.value == num2){
                    answer = number.cnt;
                    break;
                }

                int first = (number.value / 1) % 10;
                int second = (number.value / 10) % 10;
                int third = (number.value / 100) % 10;;
                int fourth = (number.value / 1000) % 10;


                for(int j = 0 ; j < 4 ; j++){
                    for(int k = 1 ; k <= 9 ; k++){
                        int newNumber = number.value + (k * (int)Math.pow(10, j));

                        if(j == 0 && first + k > 9){
                            newNumber -= 10;
                        }else if(j == 1 && second + k > 9){
                            newNumber -= 100;
                        }else if(j == 2 && third + k > 9){
                            newNumber -= 1000;
                        }else if(j == 3 && fourth + k > 9){
                            newNumber -= 10000;
                        }
                        if(lst.contains(newNumber) && !visited[lst.indexOf(newNumber)]){
                            visited[lst.indexOf(newNumber)] = true;
                            q.offer(new Number(newNumber, number.cnt +1));
                        }
                    }
                }

            }
            if (answer < 0) {
                sb.append("Impossible").append("\n");
            } else {
                sb.append(answer).append("\n");
            }
        }
        System.out.println(sb);
    }
}
