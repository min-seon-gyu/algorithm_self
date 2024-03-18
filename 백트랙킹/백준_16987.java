package 백트랙킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_16987 {
    static class Egg{
        int s, w;

        public Egg(int s, int w) {
            this.s = s;
            this.w = w;
        }

        public void setS(int s) {
            this.s = s;
        }

        public void setW(int w) {
            this.w = w;
        }

        public int getS() {
            return s;
        }

        public int getW() {
            return w;
        }
    }

    static int N;
    static int answer = 0;
    static Egg[] eggs;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        eggs = new Egg[N];

        for(int i = 0 ; i < N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            eggs[i] = new Egg(s, w);
        }
        solve(0,0);
        System.out.println(answer);
    }

    public static void solve(int idx, int count){
        if(idx == N){
            answer = Math.max(count, answer);
            return;
        }

        Egg egg = eggs[idx];

        if(egg.getS() < 1 || N -1 == count){
            solve(idx + 1, count);
            return;
        }

        for(int i = 0 ; i < N ; i++){
            if(i == idx) continue;
            if(eggs[i].getS() < 1) continue;
            int c = count;

            Egg target = eggs[i];
            egg.setS(egg.getS() - target.getW());
            target.setS(target.getS() - egg.getW());

            if(egg.getS() < 1){
                c++;
            }

            if(target.getS() < 1){
                c++;
            }

            solve(idx + 1, c);

            egg.setS(egg.getS() + target.getW());
            target.setS(target.getS() + egg.getW());
        }


    }
}
