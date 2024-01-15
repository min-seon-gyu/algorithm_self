package 수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 백준_9081 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //출력을 관리하는 객체
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < T ; i++){
            String str = br.readLine();
            //
            StringBuilder sb2 = new StringBuilder();
            PriorityQueue<Character> pq = new PriorityQueue<>();
            boolean flag = false;

            for(int j = str.length() - 2 ; j >= 0 ; j--){
                if(str.charAt(j) < str.charAt(j+1)){

                    for(int k = 0 ; k < j ; k++) sb2.append(str.charAt(k));

                    char next = 'z';
                    for(int k = j+1 ; k < str.length() ; k++){
                        if(str.charAt(j) < str.charAt(k) && next > str.charAt(k)){
                            next = str.charAt(k);
                        }
                    }

                    sb2.append(next);
                    boolean check = false;

                    for(int k = j ; k < str.length() ; k++){
                        if(next != str.charAt(k)){
                            pq.offer(str.charAt(k));
                        }else{
                            if(check){
                                pq.offer(str.charAt(k));
                            }
                            check = true;
                        }
                    }

                    while(!pq.isEmpty()) sb2.append(pq.poll());

                    sb.append(sb2).append("\n");
                    sb2.setLength(0);
                    flag = true;
                    break;
                }
            }
            if(flag) continue;;
            sb.append(str).append("\n");
        }

        System.out.println(sb.toString());
    }
}
