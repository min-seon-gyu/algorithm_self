package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 백준_21611 {
    static int[][] map;
    static int answer = 0;
    static int center, N;
    static ArrayList<Integer> moveList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        center = N/2;

        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            magic(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            move();
            change();
        }

        System.out.println(answer);
    }

    private static void magic(int d, int s) {
        for(int i = 1 ; i <= s ; i++) {
            if (d == 1 && center - i >= 0) {
                map[center - i][center] = 0;
            } else if (d == 2 && center + i < N) {
                map[center + i][center] = 0;
            } else if (d == 3 && center - i >= 0) {
                map[center][center - i] = 0;
            } else if (d == 4 && center + i < N) {
                map[center][center + i] = 0;
            }
        }
    }

    private static void move() {

        ArrayList<Integer> lst = new ArrayList<>();

        int startX = center;
        int startY = center;
        double size = 0.5;
        int d = 0;

        while(true){
            if(startX < 0 || startX >= N || startY < 0 || startY >= N) break;
            for(int i = 0 ; i < size ; i++){
                if(d == 0 && --startY >= 0 && map[startX][startY] != 0){
                    lst.add(map[startX][startY]);
                }
                else if(d == 1 && ++startX < N && map[startX][startY] != 0){
                    lst.add(map[startX][startY]);
                }
                else if(d == 2 && ++startY < N && map[startX][startY] != 0){
                    lst.add(map[startX][startY]);
                }
                else if(d == 3 && --startX >= 0 && map[startX][startY] != 0){
                    lst.add(map[startX][startY]);
                }
            }
            size += 0.5;
            if(++d == 4) d = 0;
        }

        while(lst.size() > 0){
            boolean flag = false;
            moveList = new ArrayList<>();
            int number = lst.get(0);
            int count = 1;
            for(int i = 1 ; i < lst.size(); i++){
                int getNumber = lst.get(i);
                if(number == getNumber){
                    count++;
                }else{
                    if(count < 4){
                        for(int j = 0 ; j < count ; j++) moveList.add(number);
                    }else{
                        flag = true;
                        answer += count * number;
                    }
                    number = getNumber;
                    count = 1;
                }
            }

            if(count < 4){
                for(int j = 0 ; j < count ; j++) moveList.add(number);
            }else{
                answer += count * number;
            }

            if(!flag) break;
            lst = moveList;
        }
    }

    private static void change() {
        Queue<Integer> q = new LinkedList<>();
        if(moveList != null && moveList.size() > 0){
            int number = moveList.get(0);
            int count = 1;
            for(int i = 1 ; i < moveList.size(); i++){
                int getNumber = moveList.get(i);
                if(number == getNumber){
                    count++;
                }else{
                    q.add(count);
                    q.add(number);
                    number = getNumber;
                    count = 1;
                }
            }
            q.add(count);
            q.add(number);
        }

        int startX = center;
        int startY = center;
        double size = 0.5;
        int d = 0;

        for(int i = 0 ; i < N ; i++){
            Arrays.fill(map[i], 0);
        }

        while(true){
            if(startX < 0 || startX >= N || startY < 0 || startY >= N || q.isEmpty()) break;
            for(int i = 0 ; i < size ; i++){
                if(d == 0 && --startY >= 0 && !q.isEmpty()){
                    map[startX][startY] = q.poll();
                }
                else if(d == 1 && ++startX < N && !q.isEmpty()){
                    map[startX][startY] = q.poll();
                }
                else if(d == 2 && ++startY < N && !q.isEmpty()){
                    map[startX][startY] = q.poll();
                }
                else if(d == 3 && --startX >= 0 && !q.isEmpty()){
                    map[startX][startY] = q.poll();
                }
            }
            size += 0.5;
            if(++d == 4) d = 0;
        }
    }
}
