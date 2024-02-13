package 백트랙킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_10597 {
    static boolean[] checked = new boolean[51];
    static String str;
    static int maxValue;
    static boolean flag = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        // N 구하기
        maxValue = getMaxValue();
        checked[0] = true;
        solve(0, "");
    }
    public static boolean check(){
        // 1 ~ N 까지 숫자가 다 나왔는지 확인
        for(int i = 1 ; i <= maxValue ; i++) {
            if (!checked[i]) return false;
        }
        return true;
    }

    public static int getMaxValue(){
        int length = str.length();
        if(length < 10){
            return length;
        }else{
            return (length - 9) / 2 + 9;
        }
    }
    private static void solve(int index, String result) {
        // 한 번이라도 출력했으면 전부 종료
        if(flag) return;

        // 출력하고 flag = true
        if(index == str.length()){
            System.out.println(result);
            flag = true;
            return;
        }

        // 한 자리 숫자
        int value1 = Character.getNumericValue(str.charAt(index));
        if(value1 <= maxValue && !checked[value1]){
            checked[value1] = true;
            solve(index + 1, result + value1 + " ");
            checked[value1] = false;
        }

        // 두 자리 숫자
        if(index + 1 < str.length()){
            int value2 = Character.getNumericValue(str.charAt(index)) * 10 + Character.getNumericValue(str.charAt(index+1));
            if(value2 <= maxValue && !checked[value2]){
                checked[value2] = true;
                solve(index + 2, result + value2 + " ");
                checked[value2] = false;
            }
        }
    }
}
