package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class 백준_7785 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        HashSet<String> hs = new HashSet<>();

        for(int i = 0; i < N ; i++){
            String str = br.readLine();
            String[] arr = str.split("\\s");

            String name = arr[0];
            String status = arr[1];

            if(status.equals("enter")){
                hs.add(name);
            }else{
                hs.remove(name);
            }
        }

        Iterator<String> iterator = hs.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
