package 수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.*;


//가장 작은 값부터 처리
//부족한 값은 가장 큰 값에서 가져오기

public class 백준_19539 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Integer> lst = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N ; i++){
            lst.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(lst);
        int[] arr = lst.stream().mapToInt(i->i).toArray();

        int s = 0;
        int e = N-1;

        while(s < N){
            if(arr[s] % 3 == 0){
                arr[s] = 0;
            }else{
                int value = arr[s] % 3 == 1 ? 2 : 1 ;
                for(int i = e ; i > s ; i--){
                    if(arr[i] >= value){
                        arr[i] -= value;
                        arr[s] = 0;
                        break;
                    }
                }
            }

            s++;
            if(arr[e] == 0) e--;
        }

        for(int value : arr){
            if(value != 0){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}
