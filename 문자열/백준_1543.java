package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_1543 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String origin = br.readLine();
        String target = br.readLine();

        int answer = 0;
        int idx = 0;

        while(idx <= origin.length() - target.length()) {
            if (origin.startsWith(target, idx)) {
                answer++;
                idx += target.length();
            } else {
                idx++;
            }
        }

        System.out.println(answer);
    }
}
