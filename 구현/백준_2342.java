package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 백준_2342 {
    static List<Integer> lst = new ArrayList<>();

    //점화식 = check[i][j][k] (i 개의 수열 수행한 후에 왼발의 위치가 j, 오른발의 위치가 k 일때 최소 누적 힘)
    static int[][][] check;

    //[i][j] = 움직이는 발의 위치가 i에서 j로 갈때 들어가는 힘
    static int[][] plus = {{0,2,2,2,2}, {2,1,3,4,3}, {2,3,1,3,4}, {2,4,3,1,3}, {2,3,4,3,1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        while(st.hasMoreTokens()){
            lst.add(Integer.parseInt(st.nextToken()));
        }

        check = new int[lst.size() + 1][5][5];

        //최소값을 큰 수로 초기화
        for(int i = 0 ; i < lst.size() + 1 ; i++ ){
            for(int j = 0 ; j < 5 ; j++){
                for(int k = 0 ; k < 5 ; k++){
                    check[i][j][k] = 1000000;
                }
            }
        }
        //시작점 초기화
        check[0][0][0] = 0;

        /*
        로직 설명
        만약 현재 수열에 세번째 항이 4라고 가정하면 4를 왼발로 밟을지(check[3][4][j]) / 오른발로 밟을지(check[3][i][4]) 상관없음
        왼발로만 예시로 들었을 때는 check[3][4][j]에 들어가는 값은
        check[2][i][j] + plus[i][4] 의 모든 케이스 중 가장 작은 값인데 주의할 점은 j != 4이다.(같은 발 위치 불가능 i가 4로 갈거니까)
        초기에 1,000,000 으로 초기화 했으며 실제로 밟았던 케이스만 새로운 값이 할당되었으니 가장 작은 값은 새로들어온 값 중에 최소값임을 보장
        */

        //수열의 첫번째 항 부터 마지막 항까지 반복문
        for(int idx = 1 ; idx < lst.size() ; idx++){

            // 수열이 0일 경우 반복문 탈출
            if(lst.get(idx - 1) == 0) break;

            //오른발을 움직일 때 왼발을 우선 고정
            for(int i = 0 ; i < 5 ; i++){
                //왼발이 오른발이 가야할 위치에 있으면 continue
                if(i == lst.get(idx-1)) continue;
                for(int j = 0 ; j < 5 ; j++){
                    check[idx][i][lst.get(idx-1)] = Math.min(check[idx][i][lst.get(idx-1)], check[idx-1][i][j] + plus[j][lst.get(idx-1)]);
                }
            }

            //왼발을 움직일 때 오른발을 우선 고정
            for(int j = 0 ; j < 5 ; j++){
                //오른발이 왼발이 가야할 위치에 있으면 continue
                if(j == lst.get(idx-1)) continue;
                for(int i = 0 ; i < 5 ; i++){
                    check[idx][lst.get(idx-1)][j] = Math.min(check[idx][lst.get(idx-1)][j], check[idx-1][i][j] + plus[i][lst.get(idx-1)]);
                }
            }
        }


        //수열에 마지막 행 전이 최종 값이므로 그 구간에 최소값을 리턴
        int answer = Integer.MAX_VALUE;
            for(int i = 0 ; i < 5 ; i++) {
                for (int j = 0; j < 5; j++) {
                    answer = Math.min(answer, check[lst.size() - 1][i][j]);
                }
            }
        System.out.println(answer);
    }
}
