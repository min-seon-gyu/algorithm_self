package 비트마스킹;

import java.io.*;
import java.util.*;

public class 백준_11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int M = Integer.parseInt(br.readLine());
        int S = 0;

        while(M-- > 0){
            st = new StringTokenizer(br.readLine());

            String command = st.nextToken();

            switch(command) {
                case "add" : {
                    int value = Integer.parseInt(st.nextToken());
                    S = S | (1 << value - 1);
                    break;
                }
                case "remove" : {
                    int value = Integer.parseInt(st.nextToken());
                    S = S & (~(1 << value - 1));
                    break;
                }
                case "check" : {
                    int value = Integer.parseInt(st.nextToken());
                    if((S & (1 << value - 1)) > 0){
                        sb.append(1).append("\n");
                    }
                    else {
                        sb.append(0).append("\n");
                    }
                    break;
                }
                case "toggle" : {
                    int value = Integer.parseInt(st.nextToken());
                    S = S ^ (1 << value - 1);
                    break;
                }
                case "all" : {
                    S = (1 << 21) - 1;
                    break;
                }
                case "empty" : {
                    S = 0;
                    break;
                }
            }
        }

        System.out.println(sb);
    }
}
