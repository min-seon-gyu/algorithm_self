package 이진트리검색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 백준_21939 {

    public static class Prob implements Comparable<Prob>{
        int n;
        int l;

        public Prob(int n, int l) {
            this.n = n;
            this.l = l;
        }

        @Override
        public int compareTo(Prob o) {
            if(this.l > o.l){
                return -1;
            }else if(this.l < o.l){
                return 1;
            }else{
                if(this.n > o.n){
                    return -1;
                }
                else if(this.n == o.n){
                        return 0;
                }
                else{
                    return 1;
                }
            }
        }
    }



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        TreeSet<Prob> set = new TreeSet<Prob>();
        HashMap<Integer,Prob> map = new HashMap<>();

        int N = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            int level = Integer.parseInt(st.nextToken());
            Prob prob = new Prob(number, level);
            set.add(prob);
            map.put(number, prob);
        }

        int M = Integer.parseInt(br.readLine());

        for(int i = 0; i < M ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();

            if(str.equals("add")){
                int number = Integer.parseInt(st.nextToken());
                int level = Integer.parseInt(st.nextToken());
                Prob prob = new Prob(number, level);
                set.add(prob);
                map.put(number, prob);

            }else if(str.equals("recommend")){
                if(Integer.parseInt(st.nextToken()) > 0){
                    sb.append(set.first().n).append("\n");
                }else{
                    sb.append(set.last().n).append("\n");
                }
            }else{
                int number = Integer.parseInt(st.nextToken());
                set.remove(map.get(number));
                map.remove(number);
            }
        }


        System.out.println(sb);
    }
}
