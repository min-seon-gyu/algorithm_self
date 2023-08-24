package 정렬;

import java.io.*;
import java.util.*;

public class 백준_1427 {
    public static void start() throws IOException {
/*        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        int[] arr = new int[10];

        for(int i = 0; i < str.length(); i++){
            arr[str.charAt(i) - '0']++;
        }

        for(int i = 9 ; i >= 0 ; i--){
            for(int j = 0; j < arr[i]; j++){
                sb.append(i);
            }
        }
        System.out.println(sb);*/

        Scanner sc = new Scanner(System.in);

        String N = sc.nextLine();

        int[] arr = new int[N.length()];

        for(int i = 0; i < arr.length ; i++){
            arr[i] = Character.getNumericValue(N.charAt(i));
        }

        for(int i = 0; i < arr.length - 1 ; i++){
            int max = 0;
            int index = 0;

            for(int j = i; j < arr.length ; j++){

                if(arr[j] > max){
                    max = arr[j];
                    index = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;

        }

        for(int i = 0; i < arr.length ; i++){
            System.out.print(arr[i]);
        }




    }
}
