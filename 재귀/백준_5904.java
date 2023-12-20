package 재귀;

import java.util.Scanner;

public class 백준_5904 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N  = sc.nextInt();

        int idx = 0;
        int length = 3;

        while(length < N){
            idx++;
            length = length * 2 + idx + 3;
        }

        while(length > 3){
            int nextLength = (length - (idx + 3)) / 2;
            if(N <= nextLength){
                length = nextLength;
                idx--;
            }else{
                if(N <= nextLength + idx + 3){
                    if(N == nextLength + 1){
                        System.out.println('m');
                    }else{
                        System.out.println('o');
                    }
                    return;
                }else{
                    N -= nextLength + idx + 3;
                    length = nextLength;
                    idx--;
                }
            }
        }

        if(N == 1){
            System.out.println('m');
        }else{
            System.out.println('o');
        }
    }
}
