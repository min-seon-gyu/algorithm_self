package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 백준_2304 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        int[][] map = new int[N][2];

        List<Integer> lst = new ArrayList<>();
        int maxH = 0;

        for(int i = 0 ; i < N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());
            map[i][0] = L;
            map[i][1] = H;

            if(H > maxH){
                maxH = H;
                lst.clear();
                lst.add(L);
            }else if(H == maxH){
                lst.add(L);
            }
        }

        Collections.sort(lst);
        if(lst.size() > 1){
            answer += (lst.get(lst.size()-1) - lst.get(0) + 1) * maxH;
        }else{
            answer += maxH;
        }

        Arrays.sort(map, (o1, o2) -> {return o1[0]-o2[0];});

        int L = map[0][0];
        int H = map[0][1];

        for(int i = 1 ; i <= N ; i++){
            if(H == maxH) break;

            int nextL = map[i][0];
            int nextH = map[i][1];

            if(nextH >= H){
                answer += (nextL - L) * H;
                L = nextL;
                H = nextH;
            }
        }

        L = map[N-1][0];
        H = map[N-1][1];

        for(int i = N-2 ; i >= 1 ; i--){
            if(H == maxH) break;

            int nextL = map[i][0];
            int nextH = map[i][1];

            if(nextH >= H) {
                answer += (L - nextL) * H;
                L = nextL;
                H = nextH;
            }
        }

        System.out.println(answer);
    }
}
