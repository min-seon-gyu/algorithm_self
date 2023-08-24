package 그래프;

import java.util.*;

public class 그래프 {

    public static class Node{
        int idx;

        int value;
        int type;
        List<Integer> lst;

        public Node(int idx, int type, List<Integer> lst, int value) {
            this.idx = idx;
            this.type = type;
            this.lst = lst;
            this.value = value;
        }

        public Node(int idx, int type) {
            this.idx = idx;
            this.type = type;

        }


    }


    public static void main(String[] args) {

        List<Node>[] arr = new ArrayList[5];
        StringBuilder sb = new StringBuilder();
        int[] values = {10, 5, 7, 6, 8};
        for(int i = 0; i < arr.length  ; i++){
            arr[i] = new ArrayList<>();
        }

        arr[0].add(new Node(1, 0));
        arr[0].add(new Node(2, 0));
        arr[0].add(new Node(4, 0));
        arr[1].add(new Node(0, 0));
        arr[1].add(new Node(3, 0));
        arr[2].add(new Node(0, 0));
        arr[2].add(new Node(3, 0));
        arr[3].add(new Node(1, 0));
        arr[3].add(new Node(2, 0));
        arr[3].add(new Node(4, 0));
        arr[4].add(new Node(0, 0));
        arr[4].add(new Node(3, 0));

        boolean[] check = new boolean[5];

        Stack<Node> s = new Stack<>();
        s.push(new Node(0, -1, new ArrayList<>(), values[0]));

        int answer = values[0];

        while(!s.empty()){
            Node node = s.pop();
            int idx = node.idx;
            List<Integer> lst = node.lst;
            int type = node.type;
            int value = node.value;
            lst.add(idx);

            if(type == 0){
                value -= values[idx];
            }else if(type == 1){
                value += values[idx];
            }else if(type == 2){
                value *= values[idx];
            }

            answer = Math.max(answer, value);

            for(Node n : arr[idx]){
                int idx1 = n.idx;
                int type1 = n.type;
                if(!lst.contains(idx1)){
                    List<Integer> lst1 = new ArrayList<>();
                    for(int data : lst){
                        lst1.add(data);
                    }
                    s.push(new Node(idx1, type1, lst1, value));
                }
            }
        }

        System.out.println(answer);
    }
}
