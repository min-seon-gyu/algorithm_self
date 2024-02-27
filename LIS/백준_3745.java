package LIS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_3745 {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));){
            String str = "";
            while((str = br.readLine()) != null){
                str = str.trim();
                if (str == "" || str.length() == 0) {
                    break;
                }

                int n = Integer.parseInt(str);
                StringTokenizer st = new StringTokenizer(br.readLine());

                int[] arr = new int[n];
                for(int i = 0 ; i < n ; i++){
                    arr[i] = Integer.parseInt(st.nextToken());
                }
                int idx = 0;
                int[] dp = new int[n];
                Arrays.fill(dp, 100001);

                for(int i = 0 ; i < n ; i++){
                    if(idx == 0){
                        dp[idx] = arr[i];
                        idx++;
                    }else{
                        if(dp[idx-1] < arr[i]){
                            dp[idx] = arr[i];
                            idx++;
                        }else{
                            int findIdx = Arrays.binarySearch(dp, arr[i]);
                            if(findIdx < 0){
                                findIdx = (findIdx+1) * -1;
                            }
                            dp[findIdx] = arr[i];
                        }
                    }

                }
                sb.append(idx).append("\n");
            }
        }catch (Exception e){

        }finally {
            System.out.println(sb);
        }


    }
}
