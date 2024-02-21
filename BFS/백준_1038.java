package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 백준_1038 {
    static List<Long> lst = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if(N < 10){
            System.out.println(N);
        }else{
            lst.add(0l);
            for(int i = 1 ; i < 10 ; i++){
                create(i, 0);
            }
            if(lst.size() <= N){
                System.out.println(-1);
            }else{
                Collections.sort(lst);
                System.out.println(lst.get(N));
            }
        }
    }

    private static void create(long num, int idx) {
        if(idx > 10) return;

        lst.add(num);

        for(int i = 0 ; i < num % 10 ; i++){
            create(num * 10 + i, idx + 1);
        }

    }
}
