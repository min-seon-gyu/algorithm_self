package 해시;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 백준_13414 {

    public static class Student implements Comparable<Student>{
        String number;
        int time;

        public Student(String number, int time) {
            this.number = number;
            this.time = time;
        }

        @Override
        public int compareTo(Student o) {

            return this.time - o.time;
        }
    }

    public static void main(String[] args) throws IOException {

        HashMap<String, Integer> map = new HashMap<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        for(int i = 0; i < L ; i++){
            map.put(br.readLine() , i);
        }

        TreeSet<Student> set = new TreeSet<>();

        Iterator<String> iterator = map.keySet().iterator();
        while(iterator.hasNext()){
            String number = iterator.next();
            set.add(new Student(number, map.get(number)));
        }

        for(int i = 0; i < K ; i++){
            if(!set.isEmpty()){
                System.out.println(set.pollFirst().number);
            }
        }
    }
}
