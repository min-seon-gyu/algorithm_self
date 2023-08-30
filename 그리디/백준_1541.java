package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 백준_1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        String[] split = str.split("-");
        ArrayList<Integer> arr = new ArrayList<>();

        for(int i = 0 ; i < split.length ; i++){
            String[] s = split[i].split("\\+");
            int sum = 0;
            for(int j = 0; j < s.length ; j++){
                sum += Integer.parseInt(s[j]);
            }
            arr.add(sum);
        }

        int answer = arr.get(0);
        for(int i = 1 ; i < arr.size(); i++){
            answer -= arr.get(i);
        }

        System.out.println(answer);
    }
}
