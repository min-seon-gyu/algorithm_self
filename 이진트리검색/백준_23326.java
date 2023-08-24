package 이진트리검색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Optional;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class 백준_23326 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        TreeSet<Integer> set = new TreeSet<>();

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        int pos = 1;

        st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= N ;i++){
            int value = Integer.parseInt(st.nextToken());
            if(value == 1) {
                set.add(i);
            }
        }

        for(int i = 0; i < Q ; i++){
            st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());

            if(number == 1){
                int idx = Integer.parseInt(st.nextToken());
                if(set.contains(idx)){
                    set.remove(idx);
                }else{
                    set.add(idx);
                }
            }else if(number == 2){
                int move = Integer.parseInt(st.nextToken()) % N;
                pos += move;
                while(pos > N){
                    pos %= N;
                }
            }else{
                if(set.isEmpty()){
                    sb.append("-1").append("\n");
                    continue;
                }

                if(set.contains(pos)){
                    sb.append(0).append("\n");
                    continue;
                }

                Integer front = set.higher(pos);
                Integer back = set.higher(0);

                if(front != null){
                    sb.append(front-pos).append("\n");
                }else{
                    sb.append(N-pos+back).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}
