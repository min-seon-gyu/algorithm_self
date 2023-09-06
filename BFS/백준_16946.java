package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 백준_16946 {
    public static class Node{
        int x,y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int N;
    static int M;
    static int[][] group;
    static HashMap<Integer, Integer> hash = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];

        group = new int[N][M];

        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for(int j = 0 ; j < M ; j++){
                map[i][j] = str.charAt(j) - '0';
            }
        }
        int g = 1;

        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                if(map[i][j] == 0 && group[i][j] == 0){
                    bfs(map, i, j, g++);
                }
            }
        }

        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                if(map[i][j] == 1){
                    HashSet<Integer> set = new HashSet<>();
                    int answer = 1;
                    for(int k = 0 ; k < 4; k++){
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if(nx >= 0 && nx < N && ny >= 0 && ny < M && group[nx][ny] != 0){
                            if(!set.contains(group[nx][ny])){
                                answer += hash.get(group[nx][ny]);
                                set.add(group[nx][ny]);
                            }
                        }
                    }
                    sb.append(answer % 10);
                }else{
                    sb.append(0);
                }
            }
            sb.append("\n");
        }



        System.out.println(sb);
    }

    private static void bfs(int[][] map, int i, int j, int g) {
        group[i][j] = g;
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(i, j));
        int answer = 1;

        while(!q.isEmpty()){
            Node node = q.poll();
            for(int k = 0 ; k < 4 ; k++){
                int nx = node.x + dx[k];
                int ny = node.y + dy[k];
                if(nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == 0){
                    if(group[nx][ny] == 0){
                        q.offer(new Node(nx, ny));
                        group[nx][ny] = g;
                        answer++;
                    }
                }
            }
        }
        hash.put(g, answer);
    }
}
