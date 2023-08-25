package 위상정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 백준_21276 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        HashMap<Integer, String> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        ArrayList<Integer>[] lst = new ArrayList[N];
        ArrayList<String>[] c = new ArrayList[N];
        int[] arr = new int[N];

        String[] split = br.readLine().split("\\s");
        Arrays.sort(split);

        for(int i = 0 ; i < split.length ; i++){
            map1.put(i, split[i]);
            map2.put(split[i], i);
            lst[i] = new ArrayList<>();
            c[i] = new ArrayList<>();
        }

        int M = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < M ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String V1 = st.nextToken();
            String V2 = st.nextToken();

            int idx1 = map2.get(V1);
            int idx2 = map2.get(V2);

            lst[idx2].add(idx1);
            arr[idx1]++;
        }


        ArrayList<String> p = new ArrayList<>();
        for(int i = 0 ; i < N ; i++){
            if(arr[i] == 0){
                String str = map1.get(i);
                p.add(str);
            }
        }
        String[] strArr = p.stream().toArray(String[]::new);
        Arrays.sort(strArr);

        sb.append(strArr.length).append("\n");
        for(String value : strArr){
            sb.append(value + " ");
        }
        sb.append("\n");

        for(int i = 0 ; i < strArr.length ; i++){
            Queue<Integer> q = new LinkedList<>();
            int idx = map2.get(strArr[i]);
            q.offer(idx);
            while(!q.isEmpty()){
                Integer poll = q.poll();
                for(int value : lst[poll]){
                    if(--arr[value] == 0){
                        q.offer(value);
                        c[poll].add(map1.get(value));
                    }
                }
            }
        }

        for(int i = 1; i < c.length; i++){
            sb.append(map1.get(i) + " ").append(c[i].size() + " ");
            Collections.sort(c[i]);
            for(String s : c[i]){
                sb.append(s + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
