package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 백준_20055 {

    public static class Belt {
        int durability;
        boolean status;

        public Belt(int durability, boolean status) {
            this.durability = durability;
            this.status = status;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = 0;
        int answer = 1;

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        LinkedList<Belt> line = new LinkedList<>();

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N * 2; i++) {
            int durability = Integer.parseInt(st.nextToken());
            line.offer(new Belt(durability, false));
            if (durability == 0) {
                count++;
            }
        }

        while (true) {




            //1. 벨트가 각 칸 위에 있는 로봇과 함께 한 칸 회전한다.
            line.offerFirst(line.pollLast());
            line.get(N - 1).status = false;


            //2. 가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한 칸 이동할 수 있다면 이동한다. 만약 이동할 수 없다면 가만히 있는다.
            //로봇이 이동하기 위해서는 이동하려는 칸에 로봇이 없으며, 그 칸의 내구도가 1 이상 남아 있어야 한다.
            for (int i = line.size() / 2; i > 0; i--) {
                Belt belt = line.get(i);
                if (belt.status) {
                    Belt targetBelt = line.get(i + 1);
                    if (targetBelt.status == false && targetBelt.durability > 0) {
                        targetBelt.status = true;
                        targetBelt.durability -= 1;
                        if (targetBelt.durability == 0) {
                            count++;
                        }
                        belt.status = false;
                        if (i + 1 == N - 1) {
                            targetBelt.status = false;
                        }
                    }
                }
            }


            //3. 올리는 위치에 있는 칸의 내구도가 0이 아니면 올리는 위치에 로봇을 올린다.
            Belt belt = line.get(0);
            if (belt.durability > 0) {
                belt.status = true;
                belt.durability -= 1;
                if (belt.durability == 0) {
                    count++;
                }
            }

            //4. 내구도가 0인 칸의 개수가 K개 이상이라면 과정을 종료한다. 그렇지 않다면 1번으로 돌아간다.
            if (count >= K) {
                break;
            }

            answer++;
        }

        System.out.println(answer);
    }
}
