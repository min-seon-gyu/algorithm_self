package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 백준_16437 {
    static long[] animal;
    static ArrayList<Integer>[] arr;
    static long answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        animal = new long[N + 1];
        arr = new ArrayList[N + 1];

        for (int i = 1; i < N + 1; i++) {
            arr[i] = new ArrayList<>();
        }

        //123456
        for (int i = 2; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String type = st.nextToken();
            long count = Long.parseLong(st.nextToken());
            int number = Integer.parseInt(st.nextToken());
            if (type.equals("S")) {
                animal[i] = count;
            } else {
                animal[i] = count * -1;
            }
            arr[number].add(i);
        }

        dfs(1,-1);
        System.out.println(animal[1]);
    }

    public static void dfs(int now, int before) {
        for (Integer next : arr[now]) {
            dfs(next, now);
        }

        if (before != -1) {
            if (animal[now] > 0) {
                animal[before] += animal[now];
            }
        }
    }
}
