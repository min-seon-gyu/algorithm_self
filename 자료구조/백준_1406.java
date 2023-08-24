package 자료구조;

import java.io.*;
import java.util.*;

public class 백준_1406 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        String str = br.readLine();
        Stack<Character> front = new Stack<>();
        Stack<Character> back = new Stack<>();

        for(int i = 0; i < str.length(); i++){
            front.push(str.charAt(i));
        }

        int T = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < T ; i++){

            StringTokenizer st = new StringTokenizer(br.readLine());
            String keyword = st.nextToken();

            if(keyword.equals("L")){
                if(!front.empty()){
                    back.push(front.pop());
                }
            }
            else if(keyword.equals("D")){
                if(!back.empty()){
                    front.push(back.pop());
                }
            }
            else if(keyword.equals("B")){
                if(!front.empty()){
                    front.pop();
                }
            }
            else if(keyword.equals("P")){
                front.push(st.nextToken().charAt(0));
            }

        }

        Iterator<Character> iterator = front.iterator();

        while(iterator.hasNext()){
            sb.append(iterator.next());
        }

        while(!back.empty()){
            sb.append(back.pop());
        }

        System.out.println(sb);
    }
}
