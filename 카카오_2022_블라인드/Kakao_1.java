package 카카오_2022_블라인드;

import java.util.*;

public class Kakao_1 {

    public static void main(String[] args) {
        int[] solution = solution(new String[]{"muzi", "frodo", "apeach", "neo"}, new String[]{"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"}, 2);
        for(int i : solution){
            System.out.println(i);
        }

    }

    public static int[] solution(String[] id_list, String[] report, int k) {

        int[] answer = new int[id_list.length];

        // 신고 피드백 횟수 데이터
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();
        // 해당유저를 신고한 유저 리스트 데이터
        HashMap<String, HashSet<String>> hashMap = new HashMap<>();

        for(int i = 0; i < id_list.length ; i++){
            String name = id_list[i];
            //신고 피드백 횟수 초기화
            linkedHashMap.put(name, 0);
            //해당유저를 신고한 유저 초기화
            hashMap.put(name, new HashSet<>());
        }

        for(int i = 0; i < report.length ; i++){
            String[] split = report[i].split("\\s");
            //신고자
            String str1 = split[0];
            //신고 대상
            String str2 = split[1];

            //해당 유저를 신고한 유저에 추가 HashSet 자료구조이므로 동일 인물 중복 저장 X
            hashMap.get(str2).add(str1);
        }

        Iterator<String> hashMapIterator = hashMap.keySet().iterator();

        while(hashMapIterator.hasNext()){
            String key = hashMapIterator.next();
            HashSet<String> value = hashMap.get(key);

            // 해당 유저를 신고한 유저 수가 K이상 인지 확인
            if(value.size() >= k){
                Iterator<String> hashSetIterator = value.iterator();
                while(hashSetIterator.hasNext()){
                    String str = hashSetIterator.next();
                    // K이상 이였을 경 우 이 유저를 신고한 유저에게 피드백을 + 1
                    linkedHashMap.put(str, linkedHashMap.get(str) + 1);
                }
            }
        }

        int idx = 0;
        Iterator<String> linkedHashMapIterator = linkedHashMap.keySet().iterator();
        while(linkedHashMapIterator.hasNext()){
            String key = linkedHashMapIterator.next();
            answer[idx] = linkedHashMap.get(key);
            idx++;
        }

        return answer;
    }
}
