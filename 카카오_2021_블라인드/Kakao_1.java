package 카카오_2021_블라인드;

import java.util.*;

public class Kakao_1 {
    public static class Order implements Comparable<Order>{
        int count;
        String comb;
        int length;
        
        public Order(int count, String comb){
            this.count = count;
            this.comb = comb;
            this.length = comb.length();
        }
        
        @Override
        public int compareTo(Order o){
            return o.count - this.count;
        }
        
    }
    static HashMap<String, Integer> hm = new HashMap<>();
    
    public String[] solution(String[] orders, int[] course) {
        List<Order> lst = new ArrayList<>();
        
        for(int i = 0 ; i < orders.length ; i++){
            
            //PriorityQueue<Character> pq = new PriorityQueue(Collections.reverseOrder());
            PriorityQueue<Character> pq = new PriorityQueue();
            for(int k = 0 ; k < orders[i].length(); k++){
                pq.offer(orders[i].charAt(k));
            }
            
            String str = "";
            while(!pq.isEmpty()){
                str += pq.poll();
            }
            
            for(int j = 0 ; j < course.length ; j++){
                if(course[j] > str.length()) continue;                
                boolean[] checked = new boolean[str.length()];
                조합(str, course[j], 0, 0, checked);
            }
        }
        
        
        for(String key : hm.keySet()){            
            if(hm.get(key) >= 2){
                lst.add(new Order(hm.get(key), key));
            }
        }

        Collections.sort(lst);
        
        
        List<String> answer = new ArrayList<>();
        int[] count = new int[11]; 
        for(int i = 0 ; i < lst.size(); i++){
            Order o = lst.get(i);
            count[o.length] = Math.max(count[o.length], o.count);
        }
        
        for(int i = 2 ; i < count.length; i++){
            System.out.println(count[i]);
        }
        
        
        for(int i = 1 ; i < 11 ; i++){
            if(count[i] == 0) continue;
            for(int j = 0 ; j < lst.size() ; j++){
                Order o = lst.get(j);
                if(o.length == i && o.count == count[i]) answer.add(o.comb);
            }
        }
        
        
        Collections.sort(answer);
        
        return answer.stream().toArray(String[]::new);
    }

    
    
    static void 조합(String str, int N, int c, int idx, boolean[] checked){
        if(c == N){
            String result = "";
            for(int i = 0 ; i < checked.length ; i++){
                if(checked[i]) result += str.charAt(i);
            }    
            

            if(hm.containsKey(result)){
                hm.put(result, hm.get(result) + 1);
            }else{
                hm.put(result, 1);
            }
            return;
        }
        
        for(int i = idx; i < str.length(); i++){
            if(!checked[i]){
                checked[i] = true;
                조합(str, N, c+1, i+1, checked);
                checked[i] = false;
            }
        }
    }
}